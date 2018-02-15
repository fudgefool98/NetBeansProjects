/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superarraygenericsdemo;

/**
 *
 * @author Professor Wergeles
 */
public class SuperArrayGenericsDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Integer[] integerArray = {5,4,3,2,1};
       
       Double [] doubleArray = {2.3, 4.3, 6.3, 10.2, 4.0, 2.5};
       
       SuperArray<Integer> sIntegerArray = new SuperArray<>(integerArray);
         sIntegerArray.displayArray();
         
       SuperArray<Double> sDoubleArray = new SuperArray<>(doubleArray);
         sDoubleArray.displayArray();
         
         Character[] cArray = {'I','N','F','O','T','E','C','H'};
         String[] sArray = {"one","two","three"};
         
         SuperArray<Character> sCharacterArray = new SuperArray<>(cArray);
            sCharacterArray.displayArray();
            
         SuperArray<String> sStringArray = new SuperArray<>(sArray);
            sStringArray.displayArray();
            
        Thing[] thingArray = { new Thing("Tweety","bird"),
            new Thing("Roxy's","Downtown Columbia"),
            new Thing("Sams","Club"),
            new Thing("Maggie","Dog")};
        SuperArray<Thing> sThingArray = new SuperArray<>(thingArray);
        sThingArray.displayArray();
    }
    
}
