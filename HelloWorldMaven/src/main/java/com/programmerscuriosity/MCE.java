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
        addEmployee(374955,"{\"name\": \"Sloboda, Oliver\", \"email\": \"Oliver.Sloboda@cognizant.com\"}");
        addEmployee(678323,"{\"name\": \"Perevalova, Olga\", \"email\": \"Olga.Perevalova@cognizant.com\"}");
        addEmployee(499368,"{\"name\": \"Haidar, Samer\", \"email\": \"Samer.Haidar@cognizant.com\"}");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String helloWorld() {
        String ret = "<html>\n" +
                "<head>\n" +
                "<title>Einarbeitungsprojekt MCE Teil 1</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>Hello World\n" +
                "<p><a href=\"mce_project_1/query?id=678323\">Example look-up for id=678323</a>\n" +
                "<body>\n" +
                "</html>";

        return ret;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/query")
    public Response getPerson(@QueryParam("id") int id) {
        addEmployees();
        String output;
        int status = 0;

        if (person.containsKey(id)) {
            output = person.get(id);
            status = 200;
        }
        else {
            output = "{\"Error\": \"ID not found\"}";
            status = 666;
        }

        return Response.status(status).entity(output).build();
    }
}

