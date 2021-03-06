package Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Emiliano
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
public class DataPersonas {
    private static final String url = "jdbc:mysql://localhost:3306/ejercicio3";
    private static final String user = "root";
    private static final String pass = "root";
    private static final String select = "SELECT * FROM persona";
    private static final String insert = "INSERT INTO persona (Nombre,Apellido,TipoDocumento,NumeroDocumento,DocumentoPais,"+
                                        "Genero,FechaNacimiento) VALUES (?,?,?,?,?,?,?)";
    private static final String selectLast = "SELECT * FROM persona HAVING Id >= ALL(Select Id From persona)";
    private static final String find = "SELECT * FROM persona WHERE Id = ?";
    private static final String delete = "DELETE FROM persona WHERE Id = ?";
    private static final String deleteAll = "DELETE FROM persona";
    private static final String update = "UPDATE persona SET Nombre=?, Apellido=?, TipoDocumento=?, "+
                                        "NumeroDocumento=?, DocumentoPais=?, Genero=?, FechaNacimiento=? "+
                                        "WHERE Id = ?";
    
    public static ArrayList<Persona> GetPersonas() throws Exception{
        ArrayList<Persona> res = new ArrayList<Persona>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            con = DriverManager.getConnection(url,user,pass);
        }catch(SQLException e){
            throw new Exception("Error al obtener la conexion: "+e.getMessage()+" - "+e.getSQLState()+" - "+e.getErrorCode());
        }
        try{
            st = con.createStatement();
        }catch(Exception e){
            throw new Exception("Error al crear el Statement");
        }
        try{
            rs = st.executeQuery(select);
            while(rs.next()){
                Persona p = new Persona(rs.getInt("Id"),rs.getString("Nombre"),rs.getString("Apellido"),
                        rs.getString("TipoDocumento").charAt(0),rs.getString("NumeroDocumento"),rs.getString("DocumentoPais"),
                        rs.getByte("Genero"),rs.getDate("FechaNacimiento"));
                res.add(p);
            }
            return res;   
        }catch(Exception e){
            throw new Exception("Error con el resultset");
        }
    }
    
    public static Persona GetPersona(int id) throws Exception{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DriverManager.getConnection(url,user,pass);
            st = con.prepareStatement(find);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                Persona p = new Persona(rs.getInt("Id"),rs.getString("Nombre"),rs.getString("Apellido"),
                        rs.getString("TipoDocumento").charAt(0),rs.getString("NumeroDocumento"),rs.getString("DocumentoPais"),
                        rs.getByte("Genero"),rs.getDate("FechaNacimiento"));
                return p;
            }else{
                throw new Exception("Persona no encontrada.");
            }
        }catch(SQLException ex){
            throw ex;
        }finally{
            con.close();
        }
    }
    
    public static Persona AddPersona(HashMap<String,Object> propiedades) throws Exception{
        String nombre = propiedades.get("Nombre").toString();
        String apellido = propiedades.get("Apellido").toString();
        char TipoDocumento = propiedades.get("TipoDocumento").toString().charAt(0);
        String NumeroDocumento = propiedades.get("NumeroDocumento").toString();
        String DocumentoPais = propiedades.get("DocumentoPais").toString();
        byte genero = Byte.parseByte(propiedades.get("Genero").toString());
        //Hago la magia con SQL
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DriverManager.getConnection(url,user,pass);
            //primero reviso que se encuentre dentro de los codigos
            st = con.prepareStatement("SELECT CodigoPais FROM codigopais");
            ResultSet aux = st.executeQuery();
            List<String> codigos = new LinkedList<String>();
            while(aux.next()){
                codigos.add(aux.getString("CodigoPais"));
            }
            if(!codigos.contains(DocumentoPais)){
                throw new Exception("Pais del Documento no Válido");
            }
            st = con.prepareStatement(insert);
            st.setString(1, nombre);
            st.setString(2, apellido);
            st.setString(3, String.valueOf(TipoDocumento));
            st.setString(4, NumeroDocumento);
            st.setString(5, DocumentoPais);
            st.setByte(6, genero);
            //st.setDate(7, Date.valueOf(propiedades.get("FechaNacimiento").toString()));
            st.setString(7, propiedades.get("FechaNacimiento").toString());
            int res = st.executeUpdate();
            if(res == 1){
                st = con.prepareStatement(selectLast);
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    Persona p = new Persona(rs.getInt("Id"),rs.getString("Nombre"),rs.getString("Apellido"),
                        rs.getString("TipoDocumento").charAt(0),rs.getString("NumeroDocumento"),rs.getString("DocumentoPais"),
                        rs.getByte("Genero"),rs.getDate("FechaNacimiento"));
                    return p;
                }else{
                    throw new Exception("No se pudo obtener la persona.");
                }
            }else{
                throw new Exception("No se pudo insertar.");
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            con.close();
        }
    }

    public static boolean DeletePersona(int id) throws Exception{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DriverManager.getConnection(url,user,pass);
            st = con.prepareStatement(delete);
            st.setInt(1, id);
            int res = st.executeUpdate();
            if(res == 1){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            throw e;
        }finally{
            con.close();
        }
    }
    
    public static boolean DeletePersonas() throws Exception{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DriverManager.getConnection(url,user,pass);
            st = con.prepareStatement(deleteAll);
            int res = st.executeUpdate();
            if(res > 0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            throw e;
        }finally{
            con.close();
        }
    }
    
    public static Persona UpdatePersona(HashMap<String,Object> propiedades) throws Exception{
        int id = Integer.parseInt(propiedades.get("Id").toString());
        String nombre = propiedades.get("Nombre").toString();
        String apellido = propiedades.get("Apellido").toString();
        char TipoDocumento = propiedades.get("TipoDocumento").toString().charAt(0);
        String NumeroDocumento = propiedades.get("NumeroDocumento").toString();
        String DocumentoPais = propiedades.get("DocumentoPais").toString();
        byte genero = Byte.parseByte(propiedades.get("Genero").toString());
        try{
            Persona p = GetPersona(id);
            Connection con = null;
            PreparedStatement st = null;
            //como existe puedo seguir
            try{
                con = DriverManager.getConnection(url,user,pass);
                //primero valido
                st = con.prepareStatement("SELECT CodigoPais FROM codigopais");
                ResultSet aux = st.executeQuery();
                List<String> codigos = new LinkedList<String>();
                while(aux.next()){
                    codigos.add(aux.getString("CodigoPais"));
                }
                if(!codigos.contains(DocumentoPais)){
                    throw new Exception("Pais del Documento no Válido");
                }
                //
                st = con.prepareStatement(update);
                st.setString(1, nombre);
                st.setString(2, apellido);
                st.setString(3, String.valueOf(TipoDocumento));
                st.setString(4, NumeroDocumento);
                st.setString(5, DocumentoPais);
                st.setByte(6, genero);
                st.setDate(7, Date.valueOf(propiedades.get("FechaNacimiento").toString()));
                st.setInt(8, id);
                int res = st.executeUpdate();
                if(res == 1){
                    return new Persona(id,nombre,apellido,TipoDocumento,NumeroDocumento,DocumentoPais,genero,Date.valueOf(propiedades.get("FechaNacimiento").toString()));
                }else{
                    throw new Exception("No se pudo actualizar.");
                }
            }catch(Exception ex){
                throw ex;
            }finally{
                con.close();
            }
        }catch(Exception e){
            throw e;
        }
    }
}
