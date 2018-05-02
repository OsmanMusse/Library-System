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

        // This is an indefinite loop tells the program to keep on running
        while (running) {

            System.out.println(""
                    + "+-----------------------------------------------\n"
                    + "|           Enter 0 to load a Library           |\n"
                    + "+-----------------------------------------------       \n");
            System.out.println(""
                    + "+-----------------------------------------------\n"
                    + "|      Enter 1 to save and quit the Library    |\n"
                    + "+-----------------------------------------------       \n");
            System.out.println(""
                    + "+--------------------------------------------------\n"
                    + "|  Enter 2 for listing all the book in the Library |\n"
                    + "+--------------------------------------------------       \n");
            System.out.println(""
                    + "+-----------------------------------------------\n"
                    + "|  Enter 3 for adding a new Book to the Library |\n"
                    + "+-----------------------------------------------       \n");
            System.out.println(""
                    + "+-----------------------------------------------\n"
                    + "|  Enter 4 for finding a book in the Library    |\n"
                    + "+-----------------------------------------------       \n");
            System.out.println("|-------------------------------------------------------------|");
            System.out.println("            Enter one of the following above                       ");
            System.out.println("|-------------------------------------------------------------|");

            // Holds the input for the answer the user enters
            //Creating A Switch Statement
            int answer = in.nextInt();
            switch (answer) {

                case 0:

                    System.out.println(""
                            + "+------------------------------------------------------\n"
                            + "|           Enter the file name to load                |\n"
                            + "+------------------------------------------------------       \n");
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

        // This creates a new file name with an extension of Ser
        // Meaning that it is a serialized object
        File firstFile = new File(fileName + ".ser");
        if (firstFile.exists()) {

            // Try and Catch statement below Checking for a certain expression to be evaluated 
            try {
                ObjectInputStream ois;
                try (FileInputStream firstInput = new FileInputStream(firstFile)) {
                    ois = new ObjectInputStream(firstInput);
                    bookLib = (Library) ois.readObject();
                }
                ois.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(LibrartySystem.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("File not found");

            } catch (IOException ex) {
                Logger.getLogger(LibrartySystem.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("File not found");
            }
        } else {
            // do the following if the file doesn't exist
            System.out.println("|-------------------------------------|");
            System.out.println("            File not found!            ");
            System.out.println("|-------------------------------------|");
        }

    }

    // This method writes the object into the file
    private static void saveAndQuit() {
        System.out.println("|------------------------|");
        System.out.println("     Enter file name     ");
        System.out.println("|------------------------|");

        fileName = in.next() + ".ser";
        running = false;

        try {
            FileOutputStream fos = null;
            ObjectOutputStream out = null;
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

    // This method is static and allows users to add new books into the library
    private static void addBook() {
        Boolean finding = true;
        Boolean notFound = false;
        int isbn;
        String title;
        String author;
        double price;

        // Indefinite Loop this loop checks if there are any existing file 
        // If there are any files found in will run the options avaiable
        if (finding == true || notFound) {

            // Run the program
            System.out.println("|-------------------------------------|");
            System.out.println("      Enter the title of the book     ");
            System.out.println("|------------------------------------|");

            title = in.next();

            System.out.println("|-------------------------------------|");
            System.out.println("      Enter the ISBN Number     ");
            System.out.println("|------------------------------------|");
            isbn = in.nextInt();

            System.out.println("|-------------------------------------|");
            System.out.println("      Enter the Price   ");
            System.out.println("|------------------------------------|");
            price = in.nextDouble();

            System.out.println("|-------------------------------------|");
            System.out.println("      Enter the Author of the book     ");
            System.out.println("|------------------------------------|");
            author = in.next();

            // Creating new instance of a book
            Book newBook = new Book(isbn, title, author, price);
            bookLib.addBook(newBook);

        }

    }

}
