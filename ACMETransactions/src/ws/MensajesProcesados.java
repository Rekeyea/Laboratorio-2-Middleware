package ws;

import java.util.HashMap;
import java.util.Map;

public class MensajesProcesados {
	
	private Map<String,String> mensajes = new HashMap<String,String>();
	
	/***
	 * Marca un mensaje como procesado guardando su id y mensaje indicando resultado.
	 * Si ya existe, se lanza excepcion.
	 * @param msgId
	 * @param resultado
	 * @throws Exception 
	 */
	public synchronized void MarcarMensaje(String msgId) throws Exception{
		String existe = mensajes.get(msgId);
		
		if (existe != null){
			throw new Exception(String.format("Mensaje [%s] ya fue procesado", msgId));
		}
		else{
			mensajes.put(msgId,"");
		}
	}

}
