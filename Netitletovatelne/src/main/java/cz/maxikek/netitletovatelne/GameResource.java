package cz.maxikek.netitletovatelne;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Produces(MediaType.APPLICATION_JSON)
@Path("games")

public class GameResource {

    @Inject
    private Manager manager;


    @GET
    public Response getAll() {
        return Response.ok(manager.getGames()).build();
    }

    @GET
    @Path("{id}")
    public Response getGame(@PathParam("id") int id) {
        return  Response.ok(manager.getGame(id)).build();
    }

    @POST
    public Response createGame(GameDetail game){
        if(!manager.create(game))
            return Response.status(400).build();

        return Response.ok(game).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteGame(@PathParam("id") int id) {
        if(manager.removeGame(id)){
            return Response.ok("The game has been removed. ").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
