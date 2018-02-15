/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcexample;

import java.util.ArrayList;

/**
 *
 * @author Jordan
 */
public class MVCExampleModel {
    private ArrayList<String> people;
    public MVCExampleModel(){
        people = new ArrayList<String>();
        
    }
    
    public boolean addPerson(String person){
//        if(people.add(person)){
//            return true;
//        }
          return  people.add(person);
        //same logic because people.add() returns bool
    }
    public ArrayList<String> getEveryone(){
        return people;
    }
    public boolean deleteEveryone(){
        people.clear();
        
        return people.isEmpty();
    }
   //use returns to comunicate between the model and the controller(notify)
    
}
