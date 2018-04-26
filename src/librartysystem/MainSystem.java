/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librartysystem;

import java.util.Scanner;

/**
 *
 * @author mezut
 */
public class MainSystem {
    
    static String fileName = null;
    static Library lib = new Library();
    static Scanner in = new Scanner(System.in); // Takes User Input
    static Boolean running = true;
    
    public static  void main(String[] args) {
      while(running){
          
       System.out.println("Enter 0 for Loading the Library.");
       System.out.println("Enter 1 for Loading the Library.");
       System.out.println("Enter 2 for Listing all the Books in the Library.");
       System.out.println("Enter 3 for Adding a Book to the Library");
       
       int answer = in.nextIn();
       //Creating A Switch Statement
       switch(answer){
           case 0;
           //Do the following
           break;
           
           case 1;
             //Do the following
           break;
           
           case 2;
             //Do the following
           break;
           
             case 3;
             //Do the following
           break;
                 
       }
         
      }
}
}