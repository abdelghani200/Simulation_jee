package com.jee_simulation.resources;

import com.jee_simulation.services.ClientService;

import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clients")
public class ClientResource {

    @Inject
    private ClientService clientService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        return Response.ok()
                        .entity(clientService.getAllAsJson())
                        .build();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") int clientId) {

        JsonObject foundedClient = clientService.findAsJson(clientId);
        if(foundedClient == null)
            return Response.status(404).build();
        return Response.ok()
                        .entity(foundedClient)
                        .build();
                        
    }


}
