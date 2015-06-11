/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res;

import java.util.HashMap;
import java.util.stream.IntStream;

/**
 *
 * @author guylangford-lee
 */
public class test {
    private String hello = "hello";
    private String hello1 = "hello";
    private String hello2 = "hello";
    private String hello3 = "hello";
    private HashMap<String, int[]> value = new HashMap<>();

    public test() {
        int[] ir = IntStream.rangeClosed(0,100000).toArray();
        
      
        
        for(int i =0 ; i < 10 ; i++){
            value.put(""+i,  ir);
        }
    }
   
    

                
}
