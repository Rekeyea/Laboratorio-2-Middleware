package middleware.clases.datatypes;

import java.util.HashMap;
import java.util.Map;

/***
 * 
 * @author Cristiano
 *	Contiene posibles valores de atributos.
 */
public class Constants {

	public static String dateFormat = "ddmmyy";
	public static String timeFormat = "hhmmss";
	public static String[] transactionTypes = new String[]{"compra", "deposito", "consulta de saldo"};
	public static String[] cardTypes = new String[]{"debito", "credito", "prepaga"};
	public static String[] currencyTypes = new String[] {"UYU","USD"};
	public static String[] deviceTypes = new String[] {"POS","WEB","ATM"};
	public static String webServiceDeviceType = "POS"; //Tipo que hay que enviar al web service.
	public static int release = 10;
	
	public static Map<String,String> transactionTypesMap = new HashMap<String,String>();
	public static Map<String,String> cardTypesMap = new HashMap<String,String>();
	
	static
    {
        
		transactionTypesMap.put("compra", "C");
		transactionTypesMap.put("deposito", "D");
		transactionTypesMap.put("consulta de saldo", "S");
		
		cardTypesMap.put("debito", "D");
		cardTypesMap.put("credito", "C");
		cardTypesMap.put("prepaga", "P");
		
		
    }
	
	
}
