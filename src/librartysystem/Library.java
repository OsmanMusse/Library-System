/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librartysystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mezut
 */
public class Library extends Object implements Serializable {

    private final List<Book> collection;

    public Library() {
        collection = new ArrayList<>();
    }

    public void addBook(Book book) {
        collection.add(book);

    }

    @Override
    public String toString() {
        String total = "\n";
// Using the enhance loop to loop through the arraylist
        for (Book b : collection) {
            total = total + b.toString();
        }
        return total;

    }

}
