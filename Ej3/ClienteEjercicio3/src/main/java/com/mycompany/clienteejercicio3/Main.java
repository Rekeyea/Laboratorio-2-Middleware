/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clienteejercicio3;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Emiliano
 */
public class Main {
    public static void ObtenerTodos(BufferedReader reader){
        try{
            List<Persona> l = ClientePersona.GetPersona();
            for(Persona p: l){
                System.out.println(p.toString());
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public static Persona ObtenerUna(BufferedReader reader){
        try{
            System.out.println("Escriba el Id de la persona cuyos datos quiere obtener.");
            int id = Integer.parseInt(reader.readLine());
            Persona p = ClientePersona.GetPersona(id);
            System.out.println(p.toString());
            return p;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public static Persona RecavarDatos(BufferedReader reader) throws Exception{
        Persona p = new Persona();
        System.out.println("Indique los valores de las propiedades que quiere actualizar. Si deja en blanco la propiedad mantiene su valor.");
        System.out.println("Indique el nombre");
        String nombre = reader.readLine();
        System.out.println("Indique el apellido");
        String apellido = reader.readLine();
        System.out.println("Indique el tipo de documento");
        String StipoDocumento = reader.readLine();
        System.out.println("Indique el numero de documento");
        String documento = reader.readLine();
        System.out.println("Indique el codigo del pais");
        String codigo = reader.readLine();
        System.out.println("Indique el genero");
        String Sgenero = reader.readLine();
        System.out.println("Indique la fecha de nacimiento");
        //Date fechaNacimiento = Date.valueOf(reader.readLine());
        String fechaNacimiento = reader.readLine();
        if(!nombre.isEmpty()){
            p.Nombre = nombre;
        }
        if(!apellido.isEmpty()){
            p.Apellido = apellido;
        }
        char tipoDocumento;
        if(!StipoDocumento.isEmpty()){
            tipoDocumento = StipoDocumento.charAt(0);
        }else{
            tipoDocumento = 'X';
        }
        p.TipoDocumento = tipoDocumento;
        if(!documento.isEmpty()){
            p.NumeroDocumento = documento;
        }
        if(!codigo.isEmpty()){
            p.DocumentoPais = codigo;
        }
        byte genero;
        if(!Sgenero.isEmpty()){
            genero = Byte.parseByte(Sgenero);
        }else{
            genero = -1;
        }
        p.Genero = genero;
        if(fechaNacimiento.isEmpty()){
            fechaNacimiento = "1900-01-01";
        }
        p.FechaNacimiento = Date.valueOf(fechaNacimiento);
        return p;
    }
    
    public static void ActualizarUna(BufferedReader reader){
        try{
            System.out.println("Para ver las posibles personas a actualizar presione ENTER ... ");
            reader.readLine();
            ObtenerTodos(reader);
            Persona p = ObtenerUna(reader);
            if(p != null){
                Persona p2 = RecavarDatos(reader);
                System.out.println(p2.toString());
                p.Nombre = p2.Nombre == null ? p.Nombre : p2.Nombre;
                p.Apellido = p2.Apellido == null ? p.Apellido : p2.Apellido;
                p.NumeroDocumento = p2.NumeroDocumento == null ? p.NumeroDocumento : p2.NumeroDocumento;
                p.DocumentoPais = p2.DocumentoPais == null ? p.DocumentoPais : p2.DocumentoPais;
                p.Genero = p2.Genero == -1 ? p.Genero : p2.Genero;
                p.TipoDocumento = p2.TipoDocumento == 'X' ? p.TipoDocumento : p2.TipoDocumento;
                p.FechaNacimiento = p2.FechaNacimiento.equals(Date.valueOf("1900-01-01")) ? p.FechaNacimiento : p2.FechaNacimiento;
                //Ahora mando a actualizar
                p = ClientePersona.PutPersona(p);
                System.out.println(p.toString());
            }else{
                throw new Exception("Error al obtener la persona");
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public static void CrearUna(BufferedReader reader){
        try{
            Persona p = RecavarDatos(reader);
            p = ClientePersona.PostPersona(p);
            System.out.println(p.toString());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public static void BorrarTodass(BufferedReader reader){
        try{
            ClientePersona.DeletePersona();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public static void BorrarUna(BufferedReader reader){
        try{
            Persona p = ObtenerUna(reader);
            ClientePersona.DeletePersona(p);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    public static void main(String[] agrs) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String comando = "";
        System.out.println("BIENVENIDO AL CLIENTE DE PRUEBA DEL EJERCICIO 3");
        while (! comando.equalsIgnoreCase("salir")){
            System.out.println("Escriba alguno de los siguientes comandos: ");
            System.out.println("A -> Obtiene todas las personas.");
            System.out.println("O -> Obtiene una persona en particular.");
            System.out.println("U -> Actualiza la infomación de una persona.");
            System.out.println("N -> Crea una nueva persona.");
            System.out.println("D -> Elimina todas las personas.");
            System.out.println("R -> Elimina una persona en particular.");
            System.out.println("SALIR -> Termina el cliente.");
            comando = reader.readLine();
            if(comando.equals("A")){
                ObtenerTodos(reader);
            }else if(comando.equals("O")){
                ObtenerUna(reader);
            }else if(comando.equals("U")){
                ActualizarUna(reader);
            }else if(comando.equals("N")){
                CrearUna(reader);
            }else if(comando.equals("D")){
                BorrarTodass(reader);
            }else if(comando.equals("R")){
                BorrarUna(reader);
            }
        }
        /*List<Persona> p = ClientePersona.GetPersona();
        for(Persona l:p){
            System.out.println(l.NumeroDocumento);
        }
        Persona p2 = ClientePersona.GetPersona(3);
        System.out.println(p2.NumeroDocumento);
        Persona p3 = new Persona();
        p3.Apellido = "Fraga";
        p3.Nombre = "Andrea";
        p3.DocumentoPais = "UYU";
        p3.FechaNacimiento = Date.valueOf("1991-01-02");
        p3.Genero = 1;
        p3.NumeroDocumento = "11111111";
        p3.TipoDocumento = '1';
        p3 = ClientePersona.PostPersona(p3);
        System.out.println("Id de la persona: "+p3.Id);
        p3.Apellido = "Fraga Arreglado";
        Persona p4 = ClientePersona.PutPersona(p3);
        System.out.println("El nuevo apellido es: "+p4.Apellido);
        boolean b = ClientePersona.DeletePersona(p4);
        System.out.println("Eliminacion Correcta: "+b);*/
    }
}
