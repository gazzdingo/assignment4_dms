/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res;

import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author guylangford-lee
 */
@Path("potato")
public class PotatoResource {

    @Context
    private UriInfo context;
    @EJB Highscore highscore;
    @EJB Users users;
    @EJB Games games;
    /**
     * Creates a new instance of HelloResource
     */
    public PotatoResource() {
        users = new Users();
        highscore = new Highscore();
        games = new Games();
     
    }
    @GET
    @Path("join-game/{ip}")
    @Produces("application/json")
    public String joinGame(@PathParam("ip") String ip){
         return games.remove(ip);
    }
    
    @GET
    @Path("highscore")
    @Produces("application/json")
    public String highScore(){
     return highscore.getTopTen();
    }
    
    @POST
    @Path("winner")
    @Produces("application/json")
    public String addWinner(@FormParam("user") String user,@FormParam("score") String score) {
       return highscore.addWinner(user,score);
    }
    
    @GET
    @Path("get-games")
    @Produces("application/json")
    public String getGames(){
        return games.getGames();
    }
    
    @GET
    @Path("get-users")
    @Produces("application/json")
    public String getUsers(){
        return users.getUsers();
    }

    @GET
    @Path("create-game/{ip}")
    @Produces("application/json")
    public String createGame(@PathParam("ip") String ip){
     
        return games.addGame(ip);
        
    }
    @GET
    @Path("disconnect/{ip}")
    @Produces("application/json")
    public String disconnect(@PathParam("ip") String ip){
         return users.removeUser(ip);
    }
    @GET
    @Path("add-user/{ip}")
    @Produces("application/json")
    public String addUser(@PathParam("ip") String ip){
        return users.addUser(ip);
    }
    
    


}
