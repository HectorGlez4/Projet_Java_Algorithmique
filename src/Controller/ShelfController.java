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
        String output = "";
        for(Shelf s : shelfs)
        {
            output += s.getShelfID() + "\n";
        }
        return output;
    }
}
