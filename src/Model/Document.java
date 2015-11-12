/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author hecto
 */
public abstract class Document {
    private String title;
    private String editor;
    private int numberPages;
    private String category;
    private Boolean available;
    private Date publicationDate;

    public String getTitle() {
        return title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Document(String title, String editor, int numberPages, String category, Boolean available) {
        this.title = title;
        this.editor = editor;
        this.numberPages = numberPages;
        this.category = category;
        this.available = available;
    }
    
    public String toString()
    {
        return this.title;
    }
    
    
	
}
