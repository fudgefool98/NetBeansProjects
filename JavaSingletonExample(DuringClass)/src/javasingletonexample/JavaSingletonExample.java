/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasingletonexample;

/**
 *
 * @author Professor Wergeles
 */
public class JavaSingletonExample {
    
    public static void main(String[] args) {
        //SingleThing s1 = new SingleThing();
        SingleThing s1 = SingleThing.getInstance();
        SingleThing s2 = SingleThing.getInstance();
        
        Example ex = new Example();
        
        if(s1 == s2){
            System.out.println("same object (s1==s2)");
        }
        
        if(ex.s3 == s1){
            System.out.println("Same object (Example.s3 == s1");
        }
        
        s1.setName("MyFile.txt");
        
        System.out.println("s1 filename:  " + s1.getName());
        System.out.println("s2 filename:  " + s2.getName());
        System.out.println("ex.s3 filename:  " + ex.s3.getName());
                
                
    }
}