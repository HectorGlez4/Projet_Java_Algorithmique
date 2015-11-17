/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Document;
import Model.Newspaper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author hecto
 */
public class NewspaperController implements ISorting, Comparator<Newspaper> {

    @Override
    public  ArrayList sortDocs(ArrayList docs) {
        Collections.sort(docs,this);
        return docs;
    }

    @Override
    public int compare(Newspaper o1, Newspaper o2) {
        if (o1.getTitle().compareTo(o2.getTitle()) > 0)
            return 1;
        else if (o1.getTitle().compareTo(o2.getTitle()) < 0)
            return -1;
        else{
            if(o1.getPublicationDate().compareTo(o2.getPublicationDate()) > 0)
                return 1;
            else
                return -1;
        }
    }

    
    
}
