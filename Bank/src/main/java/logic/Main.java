package logic;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.jms.JMSException;
import javax.xml.bind.JAXBException;

import logic.Controllers.TransactionsController;
import logic.Interfaces.Factory;
import logic.Interfaces.IBankController;
import logic.datatypes.Transaction;


public class Main {
	

	private static int mes_send=5;
	private static int mes_rec=10;
	private static int mes_send_interval = 5000;
	
	//http://localhost:8161/admin/queues.jsp
	
	
	public static void main(String[] args){
		
		Factory fac = new Factory();
		IBankController bController= fac.getIBankController();
		TransactionsController tController = new TransactionsController();
		
		SendMessagesThread send = new SendMessagesThread(mes_send_interval, mes_send);
		
		
		String leido = "";
		int comando = -1;
		ArrayList<Transaction> transacciones = new ArrayList<Transaction>();
	
		try {
				
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("----------- Iniciado banco -----------");
			
			while( comando != 6){
				System.out.println("");
				System.out.println("Elija una opcion:");
				
				System.out.println("0 - Crear mensaje invalido.");
				System.out.println("1 - Crear mensaje valido tipo WEB.");
				System.out.println("2 - Crear mensaje valido tipo POS.");
				System.out.println("3 - Crear mensaje valido tipo ATM.");
				System.out.println("4 - Enviar todos los mensajes creados.");
				System.out.println("5 - Enviar mensajes aleatorios en background.");
				System.out.println("6 - Salir ahora.");
				
				leido = br.readLine();
				System.out.println("");
				
				try{
					comando = Integer.parseInt(leido.replaceAll("\\D", "")); //Intento parsear entrada, elimino todo lo que no sea numeros					
				}
				catch(Exception e){
					comando = -1;
				}
				
				try{
					switch(comando){
						case 0: 
							transacciones.add(tController.createInvalidTransaction());
							System.out.println("----- Transaccione creada -----");
							break;
						case 1: 
							transacciones.add(tController.createWebTransaction());
							System.out.println("----- Transaccione creada -----");
							break;
						case 2: 
							transacciones.add(tController.createPosTransaction());
							System.out.println("----- Transaccione creada -----");
							break;
						case 3: 
							transacciones.add(tController.createAtmTransaction());
							System.out.println("----- Transaccione creada -----");
							break;
						case 4: 
							bController.sendTransactions(transacciones);
							int largo = transacciones.size();
							transacciones.clear();
							System.out.println("----- Transacciones enviadas: " + largo + " -----");
							break;
						case 5:
							
							send.start();													
							Thread.sleep(500);
							System.out.println("----- Presione una tecla para detener el envio de mensajes. -----");
							br.readLine();							
							send.stop();
							break;
						case 6: System.out.println("----- Saliendo.... -----"); break;
						default: System.out.println("----- Comando Invalido. -----");break;
					}
				}
				catch(Exception e){
					System.out.println("Error al ejecutar accion: " + e.getMessage());
				}
				
			}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	
	} 
	
}
