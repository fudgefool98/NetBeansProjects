/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integerplay2;

/**
 *
 * @author Professor Wergeles
 */
public class IntegerPlay2 {

    /**
     * @notes 
     * 
     *  There are 3 Integer Objects, we performing some simple additions
     *  it is proven a new object is created whenever any manipulation
     *  is done to the variable since Integer object is immutable
     */
    public static void main(String[] args) {
        // 'a' holds an address to the Integer Object created here
        Integer a = 5;
        // we copy 'a''s address to 'b'. a and b are pointing to the same object
        Integer b = a;
        // 'c' holds an address to the Integer Object created below
        Integer c = 8;
        
        System.out.println("a " + System.identityHashCode(a) + " " + a.toString());
        System.out.println("b " + System.identityHashCode(b) + " " + b.toString());
        System.out.println("c " + System.identityHashCode(c) + " " + c.toString());
        
        
        a = a + 3;
  
        System.out.println("a " + System.identityHashCode(a) + " " + a.toString());
        System.out.println("b " + System.identityHashCode(b) + " " + b.toString());
        System.out.println("c " + System.identityHashCode(c) + " " + c.toString());
  
                
        
        if (a.equals(b)) {
            
            System.out.println("a equals b"); 
            
        } else {

            System.out.println("a DOES NOT equal b"); 
            
        }
    }
    
}
