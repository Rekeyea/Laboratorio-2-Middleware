/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Emiliano
 */
import Data.DataPersonas;
import Data.Persona;
import Exception.CustomException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("api")
public class Servicio {
    @GET
    @Path("persona")
    @Produces("application/json")
    public Response GetPersonas() throws CustomException{
        try{
            return Response.ok().entity(DataPersonas.GetPersonas()).build();
        }catch(Exception e){
            throw new CustomException("{Error: "+e.getMessage()+"}");
        }
    }
    
    @GET
    @Path("persona/{id}")
    @Produces("application/json")
    public Response GetPersona(@PathParam("id") int id) throws CustomException{
        try{
            //return Response.ok().entity(id).build();
            return Response.ok().entity(DataPersonas.GetPersona(id)).build();
        }catch(Exception e){
            throw new CustomException("{Error: "+e.getMessage()+"}");
        }
    }
    
    @POST
    @Path("persona")
    @Produces("application/json")
    @Consumes("application/json")
    public Response AddPersona(Object p) throws CustomException{
        try{
            LinkedHashMap<String,Object> properties = (LinkedHashMap)p;
            return Response.ok().entity(DataPersonas.AddPersona(properties)).build();
        }catch(Exception e){
            throw new CustomException("{Error: "+e.getMessage()+"}");
        }
    }
    
    @DELETE
    @Path("persona/{id}")
    @Produces("application/json")
    public Response DeletePersona(@PathParam("id") int id) throws Exception{
        try{
            boolean res = DataPersonas.DeletePersona(id);
            return Response.ok().entity(res).build();
        }catch(Exception e){
            throw new CustomException("{Error: "+e.getMessage()+"}");
        }
    }
    
    @DELETE
    @Path("persona")
    @Produces("application/json")
    public Response DeletePersona() throws Exception{
        try{
            boolean res = DataPersonas.DeletePersonas();
            return Response.ok().entity(res).build();
        }catch(Exception e){
            throw new CustomException("{Error: "+e.getMessage()+"}");
        }
    }
    
    @PUT
    @Path("persona")
    @Produces("application/json")
    @Consumes("application/json")
    public Response UpdatePersona(Object p) throws Exception{
        try{
            LinkedHashMap<String,Object> properties = (LinkedHashMap)p;
            return Response.ok().entity(DataPersonas.UpdatePersona(properties)).build();
        }catch(Exception e){
            throw new CustomException("{Error: "+e.getMessage()+"}");
        }
    }
    
    
}


