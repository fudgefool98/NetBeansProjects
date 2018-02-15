/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmapexample;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Jordan
 */
public class HashMapExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        
        hm.put("name","mary Smith");
        hm.put("role","Student");
        hm.put("age","20");
        hm.put("degree","cs");
        
        System.out.println(hm);
        
        for(Object key : hm.keySet()){
            System.out.println(key);
        }
        
        for(Object value : hm.values()){
            System.out.println(value);
        }                
        System.out.println("Value at index 1: "+ hm.get(1));
         
        for(Object entry : hm.entrySet()){
            HashMap.Entry e = (HashMap.Entry) entry;//must ahve explicit cast
            
            Object key = e.getKey();
            Object value = e.getValue();
            
            System.out.println(key + " => " + value);
        
        }
        
        Iterator it = hm.entrySet().iterator();
        while(it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry) it.next();
            System.out.println(pair.getKey()+ " => " + pair.getValue());
            it.remove();
        }
        System.out.println("after removing iterator");
        Iterator it2 = hm.entrySet().iterator();
        while(it2.hasNext()){
            HashMap.Entry pair = (HashMap.Entry) it2.next();
            System.out.println(pair.getKey()+ " => " + pair.getValue());
        }
    }
    
}
