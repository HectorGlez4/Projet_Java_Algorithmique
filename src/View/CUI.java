/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Librarian;
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
    private static ArrayList shelfs;
    private static String path ;

    public CUI(){
        try
        {
            this.path = new File(".").getCanonicalPath();
            File f = new File(path +  "\\shelfs.txt");
            if(f.exists() && !f.isDirectory()) {
                FileInputStream fis = new FileInputStream("cool_file.tmp");
                ObjectInputStream ois = new ObjectInputStream(fis);
                shelfs = (ArrayList) ois.readObject();
                ois.close();
            }
            else
            {
                shelfs = new ArrayList();
            }
            
        }
        catch(IOException e)
        {
            System.out.println("Fatal error: cant read system files");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getException().getMessage());
        }

            
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CUI cui = new CUI();
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
                System.out.println("[B]: to enter book's menu");
                System.out.println("[N]: to enter newspaper's menu");
                System.out.println("[M]: to enter magazine's");
                System.out.println("[A]: to arrange a shelf");
                System.out.println("[L]: to look for a document");
                System.out.println("[E]: to exit");
                String option = s.next().toUpperCase();
                switch (option)
                {
                    case "E":
                        break librarianLoop;
                    case "L":
                        break;
                    }
                }
    }
    
}
