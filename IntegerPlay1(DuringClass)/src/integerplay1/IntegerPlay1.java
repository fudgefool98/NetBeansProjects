/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integerplay1;

/**
 *
 * @author Professor Wergeles
 */
public class IntegerPlay1 {

    /**
     * @notes 
     * 
     * we are creating an Integer Object. We are using Hash FUnction to return
     * the same result if the same object is passed to it. Once we increment or decrement a,
     * a new object is created.
     * 
     */
    public static void main(String[] args) {
   // Integer with a capital I is an immutable object (cannot change the object must be destroyed)`q1fd
   
        Integer a = 1;
        //increment 'a' and a new object is created
        a++;
        System.out.println("a: " + a + " ("+System.identityHashCode(a)+")");
        // decrement 'a' and a new object is created
        a--;
        System.out.println("a: " + a + " ("+System.identityHashCode(a)+")");
    }
    
}
