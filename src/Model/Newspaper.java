/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hecto
 */
public class Newspaper extends Document{

    public Newspaper(String title, String editor, int numberPages, String category, Boolean available) {
        super(title, editor, numberPages, category, available);
    }
    
}
