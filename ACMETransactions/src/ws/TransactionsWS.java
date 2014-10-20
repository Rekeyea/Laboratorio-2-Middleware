package ws;

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
			targetNamespace="ACME")
//@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.BARE)
public class TransactionsWS {

	private ITransactions transactionsLogic = Factory.getITransactions();
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
		res.setOk(true);
		res.setMessage("Transacciones procesadas correctamente.");
		
		if(data == null){
			res.setOk(false);
			res.setMessage("Servicio no recibio ninguna transaccion.");
			logger.info("Servicio no recibio ninguna transaccion.");
		}
		else{
			
			try{
				transactionsLogic.ProcessTransaction(data.getTransactionList());//(Arrays.asList(data));
				//transactionsLogic.ProcessTransaction(data.getTransactionList());
				logger.info(String.format("[ %d ] Transacciones procesadas correctamente.",data.getTransactionList().size()));
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
