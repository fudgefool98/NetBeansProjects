/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textforspongebobbirdmeme;

/**
 *
 * @author Jordan
 */
public class TextForSpongeBobBirdMeme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean on = true;
        String before = "its clear once they see you because of the height and then they're like shit that little boy has a beard";
                
        String after = new String();
        for(int i=0;i<before.length();i++){
            if(!on){
                after += Character.toUpperCase( before.charAt(i));
           
                    on = true;
                    System.out.println("bet");
                    }
            else{
                on = false;
                after += Character.toLowerCase( before.charAt(i));
                                    System.out.println("2bet");

            }
        }
        System.out.println(after);
    }
    
}
