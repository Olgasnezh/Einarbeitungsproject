package com.programmerscuriosity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.QueryParam;

/**
 * Created on 17/05/18.
 */

@Path("mce_project_1")

public class MCE {

    private Map<Integer, String> person= new HashMap();

    public void addEmployee(int ID, String employee){
        person.put(ID, employee);
    }

    private void addEmployees(){
        addEmployee(374955,"name: Sloboda, Oliver, email: Oliver.Sloboda@cognizant.com");
        addEmployee(678323,"name: Perevalova, Olga, email: Olga.Perevalova@cognizant.com");
        addEmployee(499368,"name: Haidar, Samer, email: Samer.Haidar@cognizant.com");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {

        return "Hello World!";
    }

    @GET
    @Path("/query")
    public Response getPerson(@QueryParam("id") int id) {

        addEmployees();
        String output;

        if (person.containsKey(id)) output = person.get(id);
        else output = "ID not found";

        return Response.status(200).entity(output).build();
    }
}

