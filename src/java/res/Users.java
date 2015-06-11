/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author guylangford-lee
 */
@Stateless
public class Users {

  ArrayList<String> users = new ArrayList<>();
  
  public String addUser(String ip){
      if(users.contains(ip)){
          return "{'Success': 'false'}";
      }
      users.add(ip);
      return "{'Success': 'true'}";

  }
  public String getUsers(){
      Gson g = new Gson();  
      return g.toJson(this) ;
  }
  public void removeUser(String ip){
      users.remove(ip);
  }
  
}
