package logic.Controllers;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Random;

import javax.jms.JMSException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import logic.datatypes.Constants;
import logic.datatypes.Transaction;

public class TransactionsController {
	

	public int getRandomId(){
		Random rand = new Random();
		return rand.nextInt(100);
	}
	
	public String getRandomTransactionType(){
		Random rand = new Random();
		return Constants.transaction_type[rand.nextInt(Constants.transaction_type.length)];
	}
	
	public String getRandomCardType(){
		Random rand = new Random();
		return Constants.card_type[rand.nextInt(Constants.card_type.length)];
	}
	
	public String getRandomMoneyCode(){
		Random rand = new Random();
		return Constants.money_code[rand.nextInt(Constants.money_code.length)];
	}
	
	public String getRandomDeviceType(){
		Random rand = new Random();
		return Constants.device_type[rand.nextInt(Constants.device_type.length)];
	}
	
	public String getRandomDate(){
		Random rand = new Random();
		return Constants.dates[rand.nextInt(Constants.dates.length)];
	}
	
	public String getRandomHour(){
		Random rand = new Random();
		return Constants.hours[rand.nextInt(Constants.hours.length)];
	}
	
	public String getRandomCommerceCode(){
		Random rand = new Random();
		return Constants.commerce_codes[rand.nextInt(Constants.commerce_codes.length)];
	}
	
	public String getRandomTrade(){
		Random rand = new Random();
		return Constants.trades[rand.nextInt(Constants.trades.length)];
	}
	
	public String getRandomCardNumber(){
		Random rand = new Random();
		return Constants.cards_numbers[rand.nextInt(Constants.cards_numbers.length)];	
	}
	
	public BigDecimal getRandomMonto(){
		Random rand = new Random();
		return BigDecimal.valueOf(rand.nextInt(1000000));	
	}
	
	public Transaction createTransaction(){
		Transaction transaction= new Transaction();
		int id= getRandomId();
		String t_t= getRandomTransactionType();
		String c_t= getRandomCardType();
		String c_c = getRandomCommerceCode();
		String money= getRandomMoneyCode();
		String device= getRandomDeviceType();
		String date= getRandomDate();
		String hour= getRandomHour();
		String trade= getRandomTrade();
		String card= getRandomCardNumber();
		BigDecimal monto= getRandomMonto();
		
		transaction.setId(id);
		transaction.setFecha(date);
		transaction.setHora(hour);
		transaction.setTipo(t_t);
		transaction.setCodigoComercio(c_c);
		transaction.setNombreComercio(trade);
		transaction.setNumeroTarjeta(card);
		transaction.setTipoTarjeta(c_t);
		transaction.setCodigoMoneda(money);
		transaction.setTipoDispositivo(device);
		transaction.setMonto(monto);
		return transaction;
		
	}
	
	public Transaction StringXMLtoTransaction(String XMLs) throws JAXBException{
		JAXBContext context= JAXBContext.newInstance(Transaction.class);
		Unmarshaller un = context.createUnmarshaller();
		StringReader sr = new StringReader(XMLs);
		Transaction transaction = (Transaction) un.unmarshal(sr);
		return transaction;
	}
	
	/***
	 * Crea una transaccion invalida
	 * @throws JMSException
	 * @throws JAXBException
	 */
	public Transaction createInvalidTransaction(){
		Transaction res = this.createTransaction();
		Random rand = new Random();
		
		int random = rand.nextInt(6);
		switch(random){
			case 0: res.setFecha("INVALID FECHA");break;
			case 1: res.setHora("INVALID HORA");break;
			case 2: res.setTipo("INVALID TIPO");break;
			case 3: res.setTipoTarjeta("INVALID TARJETA");break;
			case 4: res.setTipoDispositivo("INVALID DISPOSITIVO");break;
			case 5: res.setCodigoMoneda("INVALID MONEDA");break;
		}
		
		return res;
	}
	
	/***
	 * Crea una transaccion de tipo dispositivo WEB
	 */
	public Transaction createWebTransaction(){
		Transaction res = this.createTransaction();
		res.setTipoDispositivo("WEB");
		return res;
	}
	
	/***
	 * Crea una transaccion de tipo dispositivo POS
	 */
	public Transaction createPosTransaction(){
		Transaction res = this.createTransaction();
		res.setTipoDispositivo("POS");
		return res;
	}
	
	/***
	 * Crea una transaccion de tipo dispositivo  ATM
	 */
	public Transaction createAtmTransaction(){
		Transaction res = this.createTransaction();
		res.setTipoDispositivo("ATM");
		return res;
	}

	
}
