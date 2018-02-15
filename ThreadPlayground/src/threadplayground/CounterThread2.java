/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadplayground;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

/**
 *
 * @author Coy Schroder
 */
public class CounterThread2 extends Thread {
    
    public Boolean stop = false;
    
    private Integer countTo = 0;
    private TextArea textArea;
    
    public CounterThread2(Integer countTo, TextArea textArea){
        this.countTo = countTo;
        this.textArea = textArea;
    }
    
    //always need the run function
    @Override
    public void run(){
        for(int k = 0; k < countTo; k++){
            String message = "K = " + k;
            
            //need to run this thread on the main thread if we want to update the interface.
            //whatever is in runLater will be ran in the main thread
            Platform.runLater(() -> {
                textArea.appendText(message + "\n");
            });
            
            if(stop){
                return;
            }
            
            try {
                //can tell the thread to slow down, maybe to wait for resources or something to download
                Thread.sleep(2000); //milliseconds
            } catch (InterruptedException ex) {
                Logger.getLogger(CounterThread2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
