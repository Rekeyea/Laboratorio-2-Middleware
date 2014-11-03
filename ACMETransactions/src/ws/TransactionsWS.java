package ws;

import org.apache.cxf.annotations.WSDLDocumentation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.apache.log4j.Logger;

import logic.datatypes.Transactions;
import logic.interfaces.Factory;
import logic.interfaces.ITransactions;


@WebService(name = "transactions",
			serviceName = "transactions", 
			portName="transactionsPort",
			targetNamespace="ACMEv1"
		)
//@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.BARE)
@WSDLDocumentation(value = "Version: 1.0", placement = WSDLDocumentation.Placement.TOP)
public class TransactionsWS {

	private ITransactions transactionsLogic = Factory.getITransactions();
	
	//Diccionario de mensajes procesados.
	private static MensajesProcesados procesados = new MensajesProcesados(); 
	
	final static Logger logger = Logger.getLogger(TransactionsWS.class.getName());
	
	/**
	 * Recibe, valida,y guarda un conjunto de transacciones.
	 * 
	 * @param data
	 * Lista de transacciones a procesar.
	 * 
	 * @return estructura que contiene si todo salio bien, y el mensaje en caso de error.
	 */
	
	@WebMethod
	public Result ReceiveTransactions(@WebParam(name ="Transactions")Transactions data){
		
		Result res = new Result();
		
		
		if(data == null){
			res.setOk(false);
			res.setMessage("Servicio no recibio ninguna transaccion.");
			logger.info("Servicio no recibio ninguna transaccion.");
		}
		else{
			
			try{
				
				if(data.getMessageId() == null || data.getMessageId().isEmpty()){
					throw new Exception("Mensaje invalido, no tiene messageId");
				}
				
				procesados.MarcarMensaje(data.getMessageId());
				
				transactionsLogic.ProcessTransaction(data.getTransactionList());//(Arrays.asList(data));
				//transactionsLogic.ProcessTransaction(data.getTransactionList());
				logger.info(String.format("[ %d ] Transacciones procesadas correctamente. Id de mensaje: %s",data.getTransactionList().size(), data.getMessageId()));
				res.setOk(true);
				res.setMessage(String.format("[ %d ] Transacciones procesadas correctamente. Id de mensaje: %s",data.getTransactionList().size(),data.getMessageId()));
			}
			catch(Exception e){
				res.setOk(false);
				res.setMessage("No se pudo procesar las transacciones: " + e.getMessage());
				logger.error("No se pudo procesar las transacciones: " + e.getMessage());
			}
			
			
		}
		
		return res;
	}
}
