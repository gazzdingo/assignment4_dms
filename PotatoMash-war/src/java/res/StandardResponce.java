/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res;

/**
 *
 * @author guylangford-lee
 */
public class StandardResponce {
    
    private boolean success;
    private Object data; 
    
    StandardResponce(boolean success,Object data){
        this.data = data;
        this.success = success;
    }
}
