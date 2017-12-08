/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Users;

/**
 * REST Web Service
 *
 * @author kasettilameri
 */
@Path("service")
public class DBservice {
    
    @EJB
    private DBcontrol dbc;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DBservice
     */
    public DBservice() {
    }

    /**
     * Retrieves representation of an instance of controller.DBservice
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getJson() {
        return dbc.getAll();
    }
    
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Users getUsersFromID(/*here should be some param*/) {
//        //here call the find by id from the Stateless bean 
//        //in this example, it just return a new instance. 
//        //return new Users();
//    }

    /**
     * PUT method for updating or creating an instance of DBservice
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Users post(@FormParam("val") String username) {
        Users u = new Users();
        u.setUsername(username);
        return dbc.insert(u);
    }
}
