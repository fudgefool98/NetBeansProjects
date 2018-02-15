/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ainterview.practice;

/**
 *
 * @author Jordan
 */
public class AInterviewPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] stringOfChars = {1,2,3,4,5,6,7,8,9,0,1};
        boolean result = a(stringOfChars);
        
        System.out.println(result);
        
    }
    public static boolean a(int[] string){
    
        for(int i =0; i<string.length;i++){
            for(int j =0; j<string.length;j++){
                if(string[i+1] == string[j]){
                    return false;
                }
            }
        }
        return true;
    }

    
}


