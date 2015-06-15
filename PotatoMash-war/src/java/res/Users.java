package res;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
         StandardResponce sr = new StandardResponce(false, this);
      return new Gson().toJson(sr);
      }
       boolean success =  users.add(ip);

     StandardResponce sr = new StandardResponce(success, this);
      return new Gson().toJson(sr);

  }
  public String getUsers(){
      
   StandardResponce sr = new StandardResponce(true, this);
      return new Gson().toJson(sr);
  }
  public String  removeUser(String ip){   
         boolean success =  users.remove(ip);

      StandardResponce sr = new StandardResponce(success, this);
      return new Gson().toJson(sr);
  }
  
}
