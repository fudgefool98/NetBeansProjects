/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package jslz85languagebasics;

/**
 *
 * @author Jordan
 */
public class Jslz85LanguageBasics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        byte sample1 = 0x64;
        byte sample2 = 100;
        short heartRate = 85;
        long deposits = 135002766;
        float acceleration = (float)9.584;
        float mass = (float)14.6;
        double distance = 129.763001;
        boolean lost = true;
        boolean expensive = true;
        int month = 10;
        int day = 5;
        char integral = '\u222B';
        char letter1 = 'a';
        char letter2 = 97;
        String greeting = "Hello";
        String myPawprint = "Jslz85";
        
        if(sample1 == sample2){
            System.out.println("The samples are equal.");
        }
        else{
                        System.out.println("The samples are not equal.");
        }
        
        if( heartRate >= 40 && heartRate<= 80){
            System.out.println("Heart rate is normal.");
        }
        else{
            System.out.println("Heart rate is not normal.");
        }
        
        if(deposits >=100000000){
            System.out.println("I'm rich!");
        }
        else{
            System.out.println("I'm poor");
        }
        
        float force = mass*acceleration;
        System.out.println("force = " + force);
        
        System.out.println(distance + " is the distance");
        
        if(lost == true && expensive == true){
            System.out.println("I am really sorry! I will get the manager.");
        }
        else if(lost==true && expensive != true){
            System.out.println("Here is coupon for 10% off.");    
        }
        
        switch (month){
            case 1: System.out.println("The date is January " + day);
                    break;
            case 2: System.out.println("The date is February " + day);
                    break;
            case 3: System.out.println("The date is March " + day);
                    break;
            case 4: System.out.println("The date is April " + day);
                    break;
            case 5: System.out.println("The date is May " + day);
                    break;
            case 6: System.out.println("The date is June " + day);
                    break;
            case 7: System.out.println("The date is July " + day);
                    break;
            case 8: System.out.println("The date is August " + day);
                    break;
            case 9: System.out.println("The date is September " + day);
                    break;        
            case 10: System.out.println("The date is October " + day);
                    break;
            case 11: System.out.println("The date is November " + day);
                    break;
            case 12: System.out.println("The date is December " + day);
                    break;        
            default: System.out.println("You made an unknown choice.");
                    break;
                    
        }
        
        System.out.println(integral + " is an integral");
        if(letter1 == letter2){
            System.out.println(letter1 + " and " + letter2 + " are the same");
                    
        }
        else{
            System.out.println(letter1 + " and " + letter2 + "are not the same");
        }
        int i;
        for(i=10;i<13;i++){
            System.out.println("i = " + i);
        }
        int age = 0;
        while(age<4){
            System.out.println("age = "+age);
            age++;
        }
        
        System.out.println(greeting + ", myPawprint is " + myPawprint);
        
        }
    
}
