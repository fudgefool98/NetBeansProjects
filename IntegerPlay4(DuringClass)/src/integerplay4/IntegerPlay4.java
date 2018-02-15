/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integerplay4;

/**
 *
 * @author Professor Wergeles
 */
public class IntegerPlay4 {

    /**
     * @notes 
     * show the range (-128 - 127) and al the possibilites where '==' will break
     * if objects go out of range code will have gubs with '=='
     * therefore we always use .equals() when comparing values of objects
     * 
     * 
     * 
     * for the TEST difference between primitive types and immutable objects(all objects are immutable)
     * 
     */
    public static void main(String[] args) {
         
        
        Integer a = -140;
        
        Integer b = -140;
        
        int c = -140;
        
        int d = -140;
        
        for(int step = 0; step<300;step++){
            
            
        // increment by 1 will created a new object and store a reference back in a
        a++;
        
        // increment by 1 and stroe a reference to b
        b++;
        
        // primative data type will store value and will simply increment that value
        c++;
        
        // primitive data tye where 'd' stores the value
        d++;
        
            
            
            System.out.println("a: " + a + " ("+System.identityHashCode(a)+")");
            System.out.println("b: " + b + " ("+System.identityHashCode(b)+")");
            System.out.println("c: " + c + " ("+System.identityHashCode(c)+")");
            System.out.println("d: " + d + " ("+System.identityHashCode(d)+")");
            
            
            if (a == b) System.out.println("a == b");
            else  System.out.println("a != b");
            
            
            if (a == c) System.out.println("a == c");
            else  System.out.println("a != c");
            
            
            if (a == d) System.out.println("a == d");
            else  System.out.println("a != d");
            
            
            System.out.println("----------------------");
       
        }
    }
}
