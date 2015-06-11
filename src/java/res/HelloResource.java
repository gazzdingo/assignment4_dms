/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import com.google.gson.*;
import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

/**
 * REST Web Service
 *
 * @author guylangford-lee
 */
@Path("hello")
public class HelloResource {

    @Context
    private UriInfo context;
    @EJB Highscore highscore;
    @EJB Users users;
    @EJB Games games;
    /**
     * Creates a new instance of HelloResource
     */
    public HelloResource() {
        users = new Users();
        highscore = new Highscore();
        games = new Games();
    }
    @GET
    @Path("join-game/{ip}")
    @Produces("application/json")
    public String joinGame(@PathParam("ip") String ip){
        Gson g = new Gson();
        return g.toJson(new test()) ;
    }
    
    @GET
    @Path("highscore")
    @Produces("application/json")
    public String highScore(){
     return highscore.getTopTen();
    }
    
    @POST
    @Path("winner")
    public void addWinner(@FormParam("user") String user,@FormParam("score") String score) {
        highscore.addWinner(user,score);
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
    public void createGame(@PathParam("ip") String ip){
     
        games.addGame(ip);
    }
    @GET
    @Path("disconnect/{ip}")
    @Produces("application/json")
    public void disconnect(@PathParam("ip") String ip){
         users.removeUser(ip);
    }
    @GET
    @Path("add-user/{ip}")
    @Produces("application/json")
    public void addUser(@PathParam("ip") String ip){
         users.addUser(ip);
    }
    
    


}
