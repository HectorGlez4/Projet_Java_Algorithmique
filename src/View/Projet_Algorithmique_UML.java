/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Model.*;
/**
 *
 * @author hecto
 */
public class Projet_Algorithmique_UML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Shelf s = new Shelf<Book>();
        s.addDoc(new Book("Book1", "editor", 4, "isbn", "cat", true, "author"));
        s.addDoc(new Book("Book2", "editor", 4, "isbn", "cat", true, "author"));
        s.addDoc(new Book("Book3", "editor", 4, "isbn", "cat", true, "author"));
        s.addDoc(new Book("Book4", "editor", 4, "isbn", "cat", true, "author"));
        System.out.println(s.toString());
    }
    
}
