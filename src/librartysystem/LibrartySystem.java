/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librartysystem;

import java.io.File;
import java.util.*;
import java.io.FileInputStream;




/**
 *
 * @author mezut
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LibrartySystem {

    /**
     * @param args the command line arguments
     */
    
    static String fileName = null;
    static Library bookLib = new Library();
    static Scanner in = new Scanner(System.in); // Takes User Input
    static Boolean running = true;
    
    
   
    //Adding the Library Class
    
    
    
    public static void main(String[] args) throws ClassNotFoundException {
        
              while(running){
     
       System.out.println("\nEnter 0 for Loading the Library.");
       System.out.println("\nEnter 1 to save and quit the Library.");
       System.out.println("\nEnter 2 for Listing all the Books in the Library.");
       System.out.println("\nEnter 3 for Adding a Book to the Library");
       System.out.println("\nEnter one of the numbers listed above:");
     
         // Holds the input for the answer the user enters
       
         int answer = in.nextInt();
         
     
       
       //Creating A Switch Statement
       switch(answer){
           case 0:
            
          
             System.out.println("Enter the file name to load");
             fileName = in.next();
             loadScript(fileName);
             
           break;
           
           case 1:
             saveAndQuit();
                 
           break;
           
           case 2:
             //Do the following
               System.out.println(bookLib.toString());
           break;
           
           case 3:
             //Do the following
               addBook();
           break;
                 
       }
         
      } // while loop closes
        //If while Loop value equals false do the following
        
        System.exit(0);
         
              
    }     

    private static void loadScript(String fileName) throws ClassNotFoundException {
             FileInputStream firstInput = null;
             ObjectInputStream in = null;
             
             
             File firstFile = new File(fileName + ".ser");
             if(firstFile.exists()){
                     
          
           try {
               firstInput = new FileInputStream(firstFile);
               in = new ObjectInputStream(firstInput);
                bookLib = (Library) in.readObject();
                firstInput.close();
                in.close();
            } catch (FileNotFoundException ex) {
               Logger.getLogger(LibrartySystem.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("File not found");
           
            } catch (IOException ex) {
                  Logger.getLogger(LibrartySystem.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("File not found");
              }
           } else {
                 // do the following if the file doesn't exist
                 System.out.println("|------------------------|");
                 System.out.println("      File not found!     ");
                 System.out.println("|------------------------|");
                 
             }
    }

    private static void saveAndQuit() {
        System.out.println("Enter file name: ");
            fileName = in.next() + ".ser";
            running = false;
            FileOutputStream fos = null;
            ObjectOutputStream out = null;
            
        try {
             fos = new FileOutputStream(fileName);
             out = new ObjectOutputStream(fos);
             out.writeObject(bookLib);
             fos.close();
             out.close();
             
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LibrartySystem.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("File not found");
        } catch (IOException ex) {
            Logger.getLogger(LibrartySystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void addBook() {
       int isbn;
     String title;
     String author;
     double price;
     
     System.out.println("Enter Title of Book: ");
     title = in.next();
     
     System.out.println("Enter ISBN Number: ");
     isbn = in.nextInt();
     
     System.out.println("Enter Price: ");
     price = in.nextDouble();
     
     
     System.out.println("Enter Author: ");
     author = in.next();
     
     // Creating new instance of a book
     Book newBook = new Book(isbn, title, author, price);
     bookLib.addBook(newBook);
     
     
     
    }
       
    }
    

