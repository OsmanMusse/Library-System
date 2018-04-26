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


public class Book implements Serializable {
    private int isbn;
    private String title;
    private String author;
    private double price;

public Book(int isbn, String title, String author, double price){
this.isbn = isbn;
this.title = title;
this.author = author;
this.price = price;
}
@Override
public String toString(){
    return " \nTitle  " + title + " \nAuthor:  \n" + author +
            " \nISBN: " + isbn + " \nPrice: " + price;
}

}