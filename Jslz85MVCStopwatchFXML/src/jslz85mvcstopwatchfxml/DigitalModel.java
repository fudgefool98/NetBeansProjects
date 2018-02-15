/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jslz85mvcstopwatchfxml;

import static java.lang.String.format;
import javafx.animation.Timeline;
import javafx.scene.control.Label;

/**
 *
 * @author Jordan
 */
public class DigitalModel {
    Timeline timeline;
    FXMLDocumentController controller;
    public DigitalModel (FXMLDocumentController controller){
        this.controller = controller; 
    }
    
    //digital vars
//    public int s1 = 0;
//    public int s0 = 0;
//    public int m1 = 0;
//    public int m0 = 0;
//    public int h1 = 0;
//    public int h0 = 0;
    //end digital vars
    //public String clock = m1 + m0 + ":" + s1 + s0 + ":" + h1 + h0 ;
    
    
    public void reset(){
        controller.digital.setText("00:00:00");
//    s1 = 0;
//    s0 = 0;
//    m1 = 0;
//    m0 = 0;
//    h1 = 0;
//    h0 = 0;
    }
    public void lap(){
       // controller.digital.setText("00:00:00");  
//    s1 = 0;
//    s0 = 0;
//    m1 = 0;
//    m0 = 0;
//    h1 = 0;
//    h0 = 0;
    }
    public void update(double secondsElapsed){
        int minutes;
        minutes = (int)(secondsElapsed /60)%60;
        double secondsAndHundreths;
        secondsAndHundreths = (double)(secondsElapsed)%60;

        String display;
        if(secondsAndHundreths>10){
        display = (format("%2d:%.02f)",minutes,secondsAndHundreths));}
        else{
        display = (format("%d:0%.02f)",minutes,secondsAndHundreths));} 
        
        controller.digital.setText(display);
        
        
        //here's where we logic the shit out of it
            //increment hundreths
//            if(h0==9){
//                h0 = 0;
//                h1+=1;
//             
//           // h0++;
//            }
//            else{
//                ++h0;
//            }
//          
//            //increment tens of hundreths
//            if(h1==9){
//             s0+=1;
//             h1 = 0;
//            
//            }
//            else if (h1 == 0 && h0==9){
//                h1++;
//                
//            }
//            //increment seconds
//            if(s0==9){
//             s1+=1;
//             s0 = 0;
//            
//            }
//            else if (s0 == 0 && h1==9){
//                s0++;
//            }
//            //increment tens of seconds
//            if(s1==5){
//             m0+=1;
//             s1 = 0;
//            
//            }
//            else if (s1 == 0 && s0==9){
//                s1++;
//            }
//            //increment minutes
//            if(m0==9){
//             m1+=1;
//             m0 = 0;
//            
//            }
//            else if (m0 == 0 && s1==9){
//                m0++;
//            }
//            //increment tens of minutes
//            if(m1==5){
//             h0 = 0;
//             h1 =0;
//             s0=0;
//             s1=0;
//             m0=0;
//             m1=0;
//             
//            }
//            clock = m1 + m0 + ":" + s1 + s0 + ":" + h1 + h0 ;
//            controller.digital.setText( clock);
    }
}
