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
public class Magazine extends Document {
    private String editionNumber;

    public Magazine(String title, String editor, int numberPages, 
            String category, Boolean available, String editionNumber) {
        super(title, editor, numberPages, category, available);
        this.editionNumber = editionNumber;
    }

    public String getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(String editionNumber) {
        this.editionNumber = editionNumber;
    }
    
}
