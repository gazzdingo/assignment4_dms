package res;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 *
 * @author guylangford-lee
 */
@Singleton
@LocalBean
public class Games {
    
    ArrayList<String> games = new ArrayList<>();
    
    public String getGames() {
        StandardResponce sr = new StandardResponce(true, this);

        return new Gson().toJson(sr);
    }
    
    public String addGame(String ip){
        if(games.contains(ip)){
            StandardResponce sr = new StandardResponce(false, this);
        return new Gson().toJson(sr);
        }
        
        boolean success = games.add(ip);
        StandardResponce sr = new StandardResponce(success, this);
        return new Gson().toJson(sr);
    }
    
    public String remove(String ip){
        if(!games.contains(ip)){
            StandardResponce sr = new StandardResponce(false, this);
        return new Gson().toJson(sr);
        }
        boolean success = games.remove(ip);
        StandardResponce sr = new StandardResponce(success, this);
        return new Gson().toJson(sr);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
