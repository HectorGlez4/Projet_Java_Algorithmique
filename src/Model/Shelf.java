/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author hecto
 */
public class Shelf<T> {
    private ArrayList<T> docs;

    public ArrayList<T> getType() {
        return docs;
    }

    public void setType(ArrayList<T> docs) {
        this.docs = docs;
    }

    public Shelf() {
        this.docs = new ArrayList<T>();
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
    
}
