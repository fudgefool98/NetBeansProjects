/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;
//* = all
// could have made two import statments one for male one for female
import static petstore.Gender.*;
/**
 *
 * @author Jordan
 */
public class PetStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //new keyword, creates an instance of the class Pet
        //a place in the memory is made available to store states and behaviors
        Pet pet = new Pet();
        
        pet.name = "Jackie";
        pet.age = 3;
        pet.gender = FEMALE;
        //bellow would be a one time use "import" (doesn't use the keyword)but you get it
        pet.gender = Gender.FEMALE;
        
       Pet pet2      
    }
    
}
