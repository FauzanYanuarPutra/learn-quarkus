package org.acme.rest;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.acme.dto.UserData;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("users")
public class UserResource {
    private Map<String, UserData> users = new HashMap<>();

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        return Response.ok(users.values()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserData user) {
        users.put(user.getEmail(), user);
        return Response.created(URI.create("/users/" + user.getEmail())).build();
    }

    @GET
    @Path("{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUser(@PathParam("email") String email) {
        UserData user = users.get(email);
        if (user != null) {
            return Response.ok(user).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PATCH
    @Path("{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("email") String email, UserData newUser) {
        UserData user = users.get(email);
        if (user != null) {
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            users.put(email, user);

            return Response.ok(user).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
