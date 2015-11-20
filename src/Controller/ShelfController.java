/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Shelf;
import java.util.ArrayList;
/**
 *
 * @author hecto
 */
public class ShelfController {
    public static String shelfsList(ArrayList<Shelf> shelfs)
    {
        String output = "\n\n List of shelfs:\n";
        for(Shelf s : shelfs)
        {
            output += s.toString()+ "\n";
        }
        return output;
    }
   
    public static ArrayList<Shelf> docuentShelfs(ArrayList<Shelf> shelfs , String doc)
    {
        ArrayList<Shelf> output =  new ArrayList<Shelf>();
        for(Shelf sh : shelfs)
        {
            ArrayList docs =  sh.getDocs();
            if(docs == null)
            {
                
            }
        }
        return output;
    }
}
