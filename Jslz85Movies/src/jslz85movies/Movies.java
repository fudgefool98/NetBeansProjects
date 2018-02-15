/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jslz85movies;

/**
 *
 * @author Jordan
 */
public class Movies {
    
    //variable declaration
    private String name;
    private String director;
    private String summary;
    private float rating;
    private int version;
    //begin constructors
    public Movies(String name,String director){
        this.version = 0;
        this.name = name;
        this.director = director;
        
    }
    public Movies(String name, String director, String summary){
        this.version = 1;
        this.name = name;
        this.director = director;
        this.summary = summary;
    }
    //begin setting
    public void setName(String name){
        this.name = name;
    }
    public void setDirector(String director){
        this.director = director;
    }
    public void setSummary(String summary){
        this.summary = summary;
    }
    public void setRating(float rating){
        this.rating = rating;
    }
    //begin getting
    public String getName(){
        return this.name;
    }
    public String getDirector(){
        return this.director;
    }
    public String getSummary(){
        return this.summary;
    }
    public float getRating(){
        return this.rating;
    }
    public int getVersion(){
        return this.version;
    }
           
           
            
}
