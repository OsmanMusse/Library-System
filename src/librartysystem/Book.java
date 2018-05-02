/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librartysystem;

import java.io.Serializable;

/**
 *
 * @author mezut
 */
// Implementing the serializable keywords indicates  
public class Book implements Serializable {

    private final int isbn;
    public String title;
    private final String author;
    private final double price;

    // This is a constructor which defines all the characteristics of the book
    // For instance Title,Isbn,Author and the price of the book
    public Book(int isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getters to retrieve the title of the book
    public String getTitle() {
        return title;
    }

    // This method returns a string representation of the Book Object above
    @Override
    public String toString() {
        return "\n +----------------------------------------------------+  \n"
                + "|                Title: " + title + "                    |\n"
                + "|                  Author: " + author + "                       |\n"
                + "|                  Isbn: " + isbn + "                          |\n"
                + "|                  Price: " + price + "                         |\n"
                + " +----------------------------------------------------+"
                + "\n\n\n\n";

    }

}
