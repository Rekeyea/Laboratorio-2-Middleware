package logic.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import logic.datatypes.Constants;
import logic.datatypes.Transaction;
import logic.datatypes.InvalidDataException;
import logic.interfaces.ITransactions;


public class TransactionsController implements ITransactions {

	private String getErrorMessage(long id, String msg){
		return String.format("Transaccion [ %d ] invalida: %s", id,msg);
	}
	
	private void ValidateTransaction(Transaction t)throws InvalidDataException{
		if (t == null){
			throw new InvalidDataException("Transaction no puede ser null.");
		}
		

		//validar fecha
		try{
			SimpleDateFormat parser = new SimpleDateFormat(Constants.dateFormat);
			parser.parse(t.getFecha());
		}
		catch(Exception e){
			throw new InvalidDataException(this.getErrorMessage(t.getId(), "Fecha invalida."));
		}
		
		//validar hora
		try{
			SimpleDateFormat parser = new SimpleDateFormat(Constants.timeFormat);
			parser.parse(t.getHora());
		}
		catch(Exception e){
			throw new InvalidDataException(this.getErrorMessage(t.getId(), "Hora invalida."));
			
		}
		
		//validar tipo de transaccion
		boolean validTransactionType = false;
		if(t.getTipo() != null){
			for(String type:Constants.transactionTypes){
				if(t.getTipo().equals(type)){
					validTransactionType = true;
					break;
				}
			}
		}
		
		if(!validTransactionType){
			throw new InvalidDataException(this.getErrorMessage(t.getId(), "Tipo de transaccion invalido."));
			
		}
		
		
		//validar tipo de tarjeta
		boolean validCardType = false;
		if(t.getTipoTarjeta() != null){
			for(String type:Constants.cardTypes){
				if(t.getTipoTarjeta().equals(type)){
					validCardType = true;
					break;
				}
			}
		}
		
		if(!validCardType){
			throw new InvalidDataException(this.getErrorMessage(t.getId(), "Tipo de tarjeta invalido."));			
		}
		
		//Validar moneda
		boolean validCurrencyType = false;
		if(t.getCodigoMoneda() != null){
			for(String type:Constants.currencyTypes){
				if(t.getCodigoMoneda().equals(type)){
					validCurrencyType = true;
					break;
				}
			}
		}
		
		if(!validCurrencyType){
			throw new InvalidDataException(this.getErrorMessage(t.getId(), "Tipo de moneda invalido."));
			
		}
		
		//validar tipo dispositivo.		
		if(t.getTipoDispositivo() == null || !t.getTipoDispositivo().equals(Constants.deviceType)){
			throw new InvalidDataException(this.getErrorMessage(t.getId(), "Tipo de dispositivo invalido."));
			
		}
	}
	
	@Override
	public void ProcessTransaction(List<Transaction> data) throws InvalidDataException {

		if(data == null || data.isEmpty()){
			throw new InvalidDataException("Lista de transacciones vacia.");
		}
		
		ArrayList<String> errors = new ArrayList<String>();
		for(Transaction t : data){
			try{
				this.ValidateTransaction(t);			
			}
			catch(Exception e){
				errors.add(e.getMessage());
			}
		}
		
		if (!errors.isEmpty()){
			StringBuilder str = new StringBuilder();
			for(String e : errors){
				if(str.length() != 0){
					str.append("; ");
				}
				str.append(e);
			}
			
			throw new InvalidDataException(str.toString());
		}
				
		
		//todas las transacciones ok, hacer algo con ellas.

	}

}
