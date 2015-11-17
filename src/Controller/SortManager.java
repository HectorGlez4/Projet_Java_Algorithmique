/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Book;
import Model.Document;
import Model.Shelf;
import java.util.ArrayList;
/**
 *
 * @author hecto
 */
public class SortManager {
    
    private static SortManager instance;
    private SortManager() {
        super();
    }
    public static SortManager getInstance()
    {
        if(instance == null)
        {
            instance = new SortManager();
        }
        return instance;
    }
    
    public static ISorting sortStrategy(Shelf shelf)
    {
        ArrayList docs = shelf.getDocs();
        if (docs.isEmpty())
            return null;
        else if(docs.get(0).getClass().getCanonicalName().equals("Model.Book"))
        {
            BookController bs = new BookController();
            return bs;
        }
        else if(docs.get(0).getClass().getCanonicalName().equals("Model.Newspaper"))
        {
            NewspaperController ns = new NewspaperController();
            return ns;
        }
        else if(docs.get(0).getClass().getCanonicalName().equals("Model.Magazine"))
        {
            MagazineController ms = new MagazineController();
            return ms;
        }
        return null;
    }
    
    
    
}
