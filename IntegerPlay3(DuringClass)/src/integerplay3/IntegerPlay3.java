/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integerplay3;

/**
 *
 * @author Professor Wergeles
 */
public class IntegerPlay3 {

    /**
     * @notes 
     *  we have objects, both at the end of the range both if statements will execute. why?
     * 
     * since we increment -128 into the range (-128 to 127)
     * '==' will work. this happens because of the keyword called 'Object Interning'.
     * 
     *  however, it is never recommended to use the '==' whenever you compare objects
     * 
     * 
     */
    public static void main(String[] args) {
        
        Integer x = -129;
        
        Integer y = -130;
        
        System.out.println("x " + System.identityHashCode(x) + " " + x.toString());
        System.out.println("y " + System.identityHashCode(y) + " " + y.toString());

        
        y = y + 1;
        
        System.out.println("x " + System.identityHashCode(x) + " " + x.toString());
        System.out.println("y " + System.identityHashCode(y) + " " + y.toString());

        
        if (x == y) {
            System.out.println("They are the same object"); 
        } else {
            System.out.println("They are different objects"); 
        }
        
        
        if (x.equals(y)) {
            System.out.println("They are the same value"); 
        } else {
            System.out.println("They are the different values");
        }
    }
    
}
