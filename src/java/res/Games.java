/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author guylangford-lee
 */
@Stateless
@LocalBean
public class Games {
    
    ArrayList<String> games = new ArrayList<>();
    
    public String getGames() {
                games.add("1231231231r31k24l321");

        return new Gson().toJson(this);
    }
    
    public void addGame(String ip){
        games.add(ip);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
