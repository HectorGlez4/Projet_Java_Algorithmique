/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Document;
import java.util.ArrayList;
/**
 *
 * @author hecto
 */
public interface ISorting {
    public ArrayList<Document> sortDocs(ArrayList<Document> docs);
}
