/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jslz85documents;

/**
 *
 * @author Jordan
 */
public class Jslz85Documents {

    
    public static void main(String[] args) {
        // TODO code application logic here
        Document document1 = new Document("Another Life", "Sally Smith");
        Document document2 = new Document("Final Word", "Karen Jones", "We should plan for the worst and hope for the best.");
        
        document1.setBody("The grass is always greener on the  other side.");
        
        document2.setTitle("Final Word");
        
        System.out.println("document1: ");
        System.out.println("title: "+document1.getTitle());
        System.out.println("author: "+ document1.getAuthor());
        System.out.println("body: "+ document1.getBody());
        System.out.println("version: " +document1.getVersion());
        System.out.println();
        System.out.println();
        System.out.println("document2: ");
        System.out.println("title: "+document2.getTitle());
        System.out.println("author: "+ document2.getAuthor());
        System.out.println("body: "+ document2.getBody());
        System.out.println("version: " +document2.getVersion());

        
    }
    
}