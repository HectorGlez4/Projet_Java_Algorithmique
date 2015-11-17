/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Book;
import Model.Document;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author hecto
 */
public class BookController implements ISorting, Comparator<Book> {


    @Override
    public ArrayList sortDocs(ArrayList docs) {
        
        Collections.sort(docs,this);
        return docs;
    }

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
    
}
