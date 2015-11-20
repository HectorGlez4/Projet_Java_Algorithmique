/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Librarian;
import Controller.ShelfController;
import Model.Book;
import Model.Document;
import Model.Magazine;
import Model.Newspaper;
import Model.Shelf;
import java.awt.SystemColor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hecto
 */
public class CUI {
    private static ArrayList<Shelf> shelfs;
    private static String path ;
    private static CUI instance;

    private CUI(){
        try
        {
            CUI.path = new File(".").getCanonicalPath();
            File f = new File(path +  "\\shelfs.txt");
            if(f.exists() && !f.isDirectory()) {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                shelfs = (ArrayList<Shelf>) ois.readObject();
                ois.close();
            }
            else
            {
                shelfs = new ArrayList();
            }
            
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getException().getMessage());
        }

            
    }
    public void saveChanges()
    {
        try{
            FileOutputStream fout = new FileOutputStream(path + "\\shelfs.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this.shelfs);
        }catch(Exception ex)
        {
            
        }
    }
    
    public static CUI getInstance()
    {
        if(instance == null)
        {
            instance = new CUI();
        }
        return instance;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CUI cui = CUI.getInstance();
        while(true)
        {
            Scanner s = new Scanner(System.in);
            System.out.println("Welcome to the library administration sistem please login");
            System.out.print("username: ");
            String username = s.next();
            System.out.print("password: ");
            String password = s.next();
            if(username.equals(Librarian.getUsername()) && password.equals(Librarian.getPassword()))
            {
                cui.LibrarianMenu(s);
            }    
        }
    }
    
    public void LibrarianMenu(Scanner s)
    {
        System.out.print("\n");
        System.out.println("Hi librarian!");
        librarianLoop : while(true)
        {
            System.out.println("What do you want to do?");
            System.out.println("Enter:");
            System.out.println("[S]: to enter shelve's menu");
            System.out.println("[L]: to look for a document");
            System.out.println("[E]: to exit");
            String option = s.next().toUpperCase();
            switch (option)
            {
                case "E":
                    break librarianLoop;
                case "S":
                {
                    CUI cui = CUI.getInstance();
                    cui.ShelfMenu(s);
                    break;
                }
                default:
                    break;
            }
        }
    }
    
    public void ShelfMenu(Scanner s)
    {
        System.out.print("\n");
        System.out.println("Shelf Menu:");
        shelfLoop : while(true)
        {
            System.out.println("What do you want to do?");
            System.out.println("Enter:");
            System.out.println("[N]: to add a new shelf");
            System.out.println("[R]: to remove a shelf");
            System.out.println("[L]: to print the list of shelfs");
            System.out.println("[P]: to print the list of documents in a shelf");
            System.out.println("[A]: to add a new document to a shelf");
            System.out.println("[S]: to sort a shelf");
            System.out.println("[E]: to exit shelf menu ");
            String option = s.next().toUpperCase();
            switch (option)
            {
                case "E":
                    break shelfLoop;
                case "N":
                {
                    newShelf(s);
                    break;
                }
                case "R":
                {
                    removeShelf(s);
                    break;
                }
                case "L":
                {
                    System.out.println(ShelfController.shelfsList(shelfs));
                    break;
                }
                case "P":
                {
                    System.out.println(ShelfController.shelfsList(shelfs));
                    break;
                }
                default:
                    break;
            }
        }
    }
    
    public void newShelf(Scanner s)
    {
        newShelfLoop : while(true)
        {
            System.out.println("Enter shelf id:");
            String sid = s.next().toUpperCase();
            System.out.println("Enter shelf type: [B]ooks, [M]agazine, [N]ewspaper or [E]xit");
            String option = s.next().toUpperCase();
            switch(option)
            {
                case "B":
                {
                    this.shelfs.add(new ArrayList<Book>,new Shelf<Book>(sid), option);
                    break newShelfLoop;
                }
                case "M":
                {
                    this.shelfs.add(new Shelf<Magazine>(sid));
                    break newShelfLoop;
                }
                case "N":
                {
                    this.shelfs.add(new Shelf<Newspaper>(sid));
                    break newShelfLoop;
                }
                case "E":
                {
                    break newShelfLoop;
                }
                
            }
            System.out.println("Input error! Try Again");
        }
        this.saveChanges();
    }
    
    public void removeShelf(Scanner s)
    {
        System.out.println("Enter shelf id:");
        String sid = s.next().toUpperCase();
        Shelf rs = searchShelf(sid);
        if(rs != null)
        {
            CUI c = CUI.getInstance();
            c.shelfs.remove(rs);
        }
        this.saveChanges();
    }
    
    public Shelf searchShelf(String sid)
    {
        CUI c = CUI.getInstance();
        for (Shelf sh : c.shelfs)
        {
            if(sid.equals(sh.getShelfID()))
            {
                shelfs.remove(sh);
                return sh;
            }
            
        }
        return null;
    }
    
    public void printShelfDocs(Scanner s)
    {
        System.out.println("Enter shelf id:");
        String sid = s.next().toUpperCase();
        Shelf ps = searchShelf(sid);
        System.out.println(ps.toString());
    }
    
}

