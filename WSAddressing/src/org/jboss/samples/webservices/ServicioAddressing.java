package org.jboss.samples.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import javax.xml.ws.soap.Addressing;

@WebService()
@Addressing(enabled=true, required=true)
public class ServicioAddressing {

	@WebMethod()
	@RequestWrapper(localName = "params", targetNamespace = "http://webservices.samples.jboss.org/")
	@ResponseWrapper(localName = "entradaWS2", 
            targetNamespace = "http://webservices.samples.jboss.org/")
	@WebResult(name = "respuesta")
	public Mensaje llamadaDesacoplada(@WebParam(name = "paramMensaje")Mensaje param) {
		try{
			System.out.println("Al primer servicio llego: " + param.getMensaje());
		    Mensaje res= new Mensaje();
		    res.setMensaje(param.getMensaje() );
		     	 
		    Thread.currentThread();
			Thread.sleep(10000);//sleep for 10000 ms
			return res;
	    }
	    catch(InterruptedException ie){
	    	System.out.println("EXCPECION CAPTURADA: " + ie.getMessage());
	    }
		return null;
	    
	}
}
