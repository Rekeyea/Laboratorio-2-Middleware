package middleware.componentes;

import java.util.ArrayList;
import java.util.List;

import middleware.clases.datatypes.Constants;
import middleware.clases.datatypes.TransactionStatus;



public class RecipentList {	
	
	/***
	 * Recibe un XML representando la transaccion proveniente de la cola JMS (a partir del channel adapter)
	 * Valida los datos, deserializando el XML en una clase java, y validando los datos internos.
	 * Segun el contenido decide a que canal enviar el mensaje.
	 * @param transaction
	 * @return
	 * @throws Exception 
	 */
	public List<String> resolveTransaction(TransactionStatus t){
		
		List<String> res = new ArrayList<String>();
		if(t.isValid()){
			
			
			//to WS
			if(t.getTransaction().getTipoDispositivo().equals(Constants.webServiceDeviceType)){
				res.add("router-aggregator");
				
			}
			res.add("transformJDBC-channel");

		}
		else{
			res.add("invalidMessageChannel"); //mando a invalid.
		}
		
		return res;
	}
	
	

}
