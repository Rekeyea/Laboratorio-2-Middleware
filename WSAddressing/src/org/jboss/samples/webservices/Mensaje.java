package org.jboss.samples.webservices;


import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Mensajes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Mensaje {
	
	public String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
}
