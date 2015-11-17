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
public class Shelf<T extends Document> implements java.io.Serializable {
    private ArrayList<T> docs;
    private String type;
    private String shelfID;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShelfID() {
        return shelfID;
    }

    public void setShelfID(String shelfID) {
        this.shelfID = shelfID;
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

    public Shelf(String shelfID) {
        this.docs = new ArrayList<>();
        this.shelfID = shelfID;
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
