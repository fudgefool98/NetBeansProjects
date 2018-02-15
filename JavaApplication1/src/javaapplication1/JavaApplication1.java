/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Jordan
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {1, 0, 0, 0, 0};

for (int i = 2; i < nums.length; i++) {
 nums[i] = nums[i-1] + nums[i-2];
}
System.out.println(nums[0]);
System.out.println(nums[1]);
System.out.println(nums[2]);
System.out.println(nums[3]);
System.out.println(nums[4]);

    }
    
}
