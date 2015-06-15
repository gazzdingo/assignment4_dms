package res;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
        StandardResponce sr = new StandardResponce(true, this);
        return new Gson().toJson(sr);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public String addWinner(String user,String score) {
        boolean success = winners.add(new Score<>(user,score));
        StandardResponce sr = new StandardResponce(success, this);
        return new Gson().toJson(sr);
        
        
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
