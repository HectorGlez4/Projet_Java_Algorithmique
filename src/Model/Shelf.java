/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.ISorting;
import Controller.SortManager;
import java.util.ArrayList;

/**
 *
 * @author hecto
 * @param <T>
 */
public class Shelf<T extends Document> {
    private ArrayList<T> docs;
    private String type;
    private int shelfNumber;

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }
    
    /**
     *
     * @return
     */
    public ArrayList getDocs() {
        return docs;
    }

    public void setDocs(ArrayList<T> docs) {
        this.docs = docs;
    }

    public Shelf() {
        this.docs = new ArrayList<>();
    }
    
    @Override
    public String toString(){
        String output = "";
        for(T doc : docs)
        {
            output += doc.toString() + "\n"; 
        }
        return output;
    }
    
    public void  addDoc(T doc)
    {
        docs.add(doc);
    }
    
    public void sort()
    {
        ISorting smethod = SortManager.sortStrategy(this);
        this.setDocs(smethod.sortDocs(this.getDocs()));
    }
    
}
