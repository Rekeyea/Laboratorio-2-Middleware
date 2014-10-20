package logic;

import javax.jms.JMSException;
import javax.xml.bind.JAXBException;

import logic.Interfaces.Factory;
import logic.Interfaces.IBankController;

/***
 * Inicia un thread que envia mensajes cada cierto intervalo hasta ser detenido.
 * @author Cristiano
 *
 */
public class SendMessagesThread implements Runnable{

	private long sendInterval;
	private int sendMessages;
	private boolean run = false;
	private IBankController contr;
	private Thread t = null;
	
	
	public SendMessagesThread(long interval, int messages){
		this.sendInterval = interval;
		this.sendMessages = messages;
		Factory fac = new Factory();
		contr = fac.getIBankController();
	}
	
	private long _getSeconds(){
		return sendInterval / 1000;
	}
	
	public void run() {

		System.out.println("Iniciando thread");
		System.out.println(String.format("Se van a enviar %d mensajes aleatorios cada %d segundos", this._getSeconds() , this.sendMessages));
		run = true;
		while(run){
			try {
				System.out.println("Enviando mensajes...");
				contr.sendMessages(this.sendMessages);
				System.out.println("Mensajes enviados...");
			} catch (JMSException e) {
				System.out.println("No se pudo enviar mensajes: " + e.getMessage());
				
			} catch (JAXBException e) {
				System.out.println("No se pudo enviar mensajes: " + e.getMessage());				
			}
			if(run){
				System.out.println("Durmiendo...");
				try {
					Thread.sleep(this.sendInterval);
				} catch (InterruptedException e) {
					break;
				}
			}
			else{
				break;
			}
		}
		System.out.println("Terminando...");
	}
	
	public void start(){
		
		if(t != null){
			t.interrupt();
		}
		
		t = new Thread(this);
		t.start();
		
	}
	
	/***
	 * Detiene el thread sin esperar.
	 */
	public void kill(){
		if(t != null){
			t.interrupt();
		}
		t = null;		
	}
	
	/***
	 * Detiene el thread correctamente esperando 
	 */
	public void stop(){
		this.run = false;
		if(t != null){
			try {
				t.join();
			} catch (InterruptedException e) {
				
			}
		}	
		
		t=null;
	}
	

}
