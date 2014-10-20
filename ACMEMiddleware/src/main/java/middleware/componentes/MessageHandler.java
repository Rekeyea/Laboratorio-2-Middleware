package middleware.componentes;

import org.springframework.messaging.support.ErrorMessage;

import middleware.clases.datatypes.Result;
import middleware.clases.datatypes.TransactionStatus;

import org.apache.log4j.Logger;

/***
 * Clase de ejemplo para recibir y loguear mensajes invalidos.
 * El invalid message channel es publish suscribe, por lo que se podrian recibir los mensajes de muchas formas.
 * @author Cristiano
 *
 */

public class MessageHandler {
	
	final static Logger logger = Logger.getLogger(MessageHandler.class.getName());
	
	public void LogInvalid(TransactionStatus t){
		logger.error("Mensaje invalido recibido por middleware : " + t.getMessage());
		//System.out.println("Mensaje invalido recibido por middleware: " + t.getMessage());		
	}
	
	public void LogError(ErrorMessage e){
		if (e.getPayload().getCause() != null){
			logger.error("Excepcion: " + e.getPayload().getCause());
			//System.out.println("Excepcion: " + e.getPayload().getCause());
		}
		else{
			logger.error("Excepcion: " + e.getPayload().getMessage());
			//System.out.println("Excepcion: " + e.getPayload().getMessage());
		}
				
	}
		
	public void LogInvalidMessageWS(Result res){
		if(!res.isOk()){
			logger.error("Mensaje invalido desde el WS" + res.getMessage());
			//System.out.println(res.getMessage());
		}
	}

}
