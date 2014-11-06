/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clienteejercicio3;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import java.util.List;
import javax.ws.rs.core.GenericType;


/**
 *
 * @author Emiliano
 */
public class ClientePersona {
    public static String URLGetAll = "http://localhost:8080/Ejercicio3/api/persona";
    public static String URLGetOne = "http://localhost:8080/Ejercicio3/api/persona/";
    
    public static List<Persona> GetPersona() throws Exception{
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URLGetAll);
        Response response = target.request().get();
        if(response.getStatus()!= 200){
            throw new Exception(response.readEntity(String.class));
        }
        List<Persona> l = response.readEntity(new GenericType<List<Persona>>(){});
        response.close();
        return l;
    }
    
    public static Persona GetPersona(int id) throws Exception{
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URLGetOne+id);
        Response response = target.request().get();
        if(response.getStatus()!= 200){
            throw new Exception(response.readEntity(String.class));
        }
        Persona p = response.readEntity(Persona.class);
        response.close();
        return p;
    }
    
    public static Persona PostPersona(Persona p) throws Exception{
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URLGetAll);
        Response response = target.request().post(Entity.entity(p, MediaType.APPLICATION_JSON));
        if(response.getStatus()!= 200){
            throw new Exception(response.readEntity(String.class));
        }
        Persona p2 = response.readEntity(Persona.class);
        response.close();
        return p2;
    }
    
    public static Persona PutPersona(Persona p) throws Exception{
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URLGetAll);
        Response response = target.request().put(Entity.entity(p, MediaType.APPLICATION_JSON));
        if(response.getStatus()!= 200){
            throw new Exception(response.readEntity(String.class));
        }
        Persona p2 = response.readEntity(Persona.class);
        response.close();
        return p2;
    }
    
    public static boolean DeletePersona() throws Exception{
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URLGetAll);
        Response response = target.request().delete();
        if(response.getStatus()!= 200){
            throw new Exception(response.readEntity(String.class));
        }
        return true;
    }
    
    public static boolean DeletePersona(Persona p) throws Exception{
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URLGetOne+p.Id);
        Response response = target.request().delete();
        if(response.getStatus()!= 200){
            throw new Exception(response.readEntity(String.class));
        }
        return true;
    }
    
    
            
}
