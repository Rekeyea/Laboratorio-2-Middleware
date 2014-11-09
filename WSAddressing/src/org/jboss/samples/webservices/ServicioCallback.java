package org.jboss.samples.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;

@WebService()
public class ServicioCallback {

	@WebMethod()
	@RequestWrapper(localName = "entradaWS2", targetNamespace = "http://webservices.samples.jboss.org/")
	public Mensaje callback(@WebParam(name = "respuesta") Mensaje param) {
	    System.out.println("El segundo servicio llego: " + param.getMensaje());
	    return null;
	}
}
