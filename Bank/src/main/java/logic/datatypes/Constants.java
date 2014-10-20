package logic.datatypes;

import org.apache.activemq.ActiveMQConnection;

public class Constants {
	public static String url= ActiveMQConnection.DEFAULT_BROKER_URL;
	public static String queuename= "bankQueue";
	public static String[] transaction_type = {"compra","deposito","consulta de saldo"};
	public static String[] card_type = {"debito","credito","prepaga"};
	public static String[] money_code = {"UYU","USD"};
	public static String[] device_type= {"POS","WEB","ATM"};
	public static String[] dates= {"010114","010614","010814"};	
	public static String[] hours= {"220114","030314","060807"};	
	public static String[] commerce_codes= {"666","777","888"};
	public static String[] trades= {"Microsoft","Apple","Oracle"};
	public static String[] cards_numbers= {"29353","2432345","32","656"};

}
