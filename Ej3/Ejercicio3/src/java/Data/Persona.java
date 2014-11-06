package Data;

import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Emiliano
 */
public class Persona {
    public int Id;
    public String Nombre;
    public String Apellido;
    public char TipoDocumento;
    public String NumeroDocumento;
    public String DocumentoPais;
    public byte Genero;
    public Date FechaNacimiento;
    
    public Persona(int p1, String p2, String p3, char p4, String p5, String p6, byte p7, Date p8) throws Exception{
        Id = p1;
        if(p2.length() > 50){
            throw new Exception("Nombre demasiado largo.");
        }
        Nombre = p2;
        if(p3.length() > 50){
            throw new Exception("Apellido demasiado largo.");
        }
        Apellido = p3;
        if(!(p4=='1' || p4=='2' || p4=='3')){
            throw new Exception("Tipo de documento incorrecto.");
        }
        TipoDocumento = p4;
        if(p5.length() > 20){
            throw new Exception("Numero de documento demasiado largo.");
        }
        NumeroDocumento = p5;
        if(p6.length() > 3){
            throw new Exception("Caracteristica del pais demasiado larga.");
        }
        DocumentoPais = p6;
        if(p7>2){
            throw new Exception("Genero incorrecto.");
        }
        Genero = p7;
        if(p8.after(new Date((new java.util.Date().getTime())))){
            throw new Exception("Fecha de Nacimiento debe ser anterior a la fecha actual.");
        }
        FechaNacimiento = p8;
    }
}
