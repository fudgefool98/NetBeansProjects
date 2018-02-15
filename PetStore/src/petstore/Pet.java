/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;

/**
 *
 * @author Jordan
 */
public class Pet {
    public String type;
    public String name;
    public int age;
    //capital G that is referencing an object
    public Gender gender;
    //default constructor, it is used to create an instance of a class
    public Pet(){
    }
    public Pet(String type, String name, int age,Gender gender){
    this.type = type;
    this.name = name;
    this.age = age;
    this.gender = gender;
    
    }
    
}
