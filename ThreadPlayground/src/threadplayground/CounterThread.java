/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadplayground;

import javafx.scene.control.TextArea;

/**
 *
 * @author Coy Schroder
 */

//first way to create a thread, extend the Thread superclass.
//this class is made for a simple approach since this class can only extend one superclass
public class CounterThread extends Thread {
    
    public Boolean stop = false;
    
    private Integer countTo = 0;
    
    public CounterThread(Integer countTo){
        this.countTo = countTo;
    }
    
    //need to define the run function within the thread, most important thread function
    //needs to be overridden
    @Override
    public void run(){
        for(int i = 0; i < countTo; i++){
            System.out.println("CounterThread i = " + i);
            
        }
        if(stop){
            return;
        }
    }
    
 
}
