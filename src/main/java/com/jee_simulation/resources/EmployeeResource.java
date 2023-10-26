package com.jee_simulation.resources;

import com.jee_simulation.services.EmployeeService;

import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/employees")
public class EmployeeResource {
    
    @Inject
    private EmployeeService employeeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesList() {

        return Response.ok()
                        .entity(employeeService.getAllAsJson())
                        .build();
                        
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee(@PathParam("id") int employeeId) {

        JsonObject foundedEmployee = employeeService.findAsJson(employeeId);
        if(foundedEmployee == null)
            Response.status(404).build();
        return Response.ok()
                       .entity(foundedEmployee)
                       .build();

    }


}
