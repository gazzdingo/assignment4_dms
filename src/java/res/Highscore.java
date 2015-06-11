/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res;

import com.google.gson.Gson;
import org.json.*;
import java.util.LinkedList;
import javax.ejb.Stateless;

/**
 *
 * @author guylangford-lee
 */
@Stateless
public class Highscore {
    LinkedList<Score<String,String>> winners = new LinkedList<>();

   public String getTopTen() {

        return new Gson().toJson(this);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void addWinner(String user,String score) {
        
                winners.add(new Score<>(user,score));
        
    }
    
    private class Score<K,V>{
        public K name;
        public V score;
        public Score(K key,V value){
            this.score = value;
            this.name = key;
        }
        
    } 
}
