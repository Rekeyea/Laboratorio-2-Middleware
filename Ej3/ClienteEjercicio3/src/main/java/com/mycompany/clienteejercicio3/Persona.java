/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clienteejercicio3;

import java.sql.Date;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Emiliano
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Persona")
public class Persona {
    private static final long serialVersionUID = 1L;
    
    @XmlAttribute(name = "Id")
    public int Id;
    @XmlAttribute(name = "Nombre")
    public String Nombre;
    @XmlAttribute(name = "Apellido")
    public String Apellido;
    @XmlAttribute(name = "TipoDocumento")
    public char TipoDocumento;
    @XmlAttribute(name = "NumeroDocumento")
    public String NumeroDocumento;
    @XmlAttribute(name = "DocumentoPais")
    public String DocumentoPais;
    @XmlAttribute(name = "Genero")
    public byte Genero;
    @XmlAttribute(name = "FechaNacimiento")
    public Date FechaNacimiento;
    
    @Override
    public String toString(){
        String res = "";
        res += "**************************************************\r\n";
        res += "Id: "+Id+"\r\n";
        res += "Nombre: "+Nombre+"\r\n";
        res += "Apellido: "+Apellido+"\r\n";
        res += "Tipo de Documento: "+TipoDocumento+"\r\n";
        res += "Número de Documento: "+NumeroDocumento+"\r\n";
        res += "Documento País: "+DocumentoPais+"\r\n";
        res += "Género: "+Genero+"\r\n";
        res += "Fecha de Nacimiento: "+FechaNacimiento+"\r\n";
        res += "**************************************************\r\n";
        return res;
    }
}
