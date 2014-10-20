package logic.Interfaces;

import java.util.ArrayList;

import javax.jms.JMSException;
import javax.xml.bind.JAXBException;

import logic.datatypes.Transaction;

public interface IBankController {

	public void sendTransactions(ArrayList<Transaction> transactions) throws JMSException, JAXBException;
	public void sendMessages(int messages) throws JMSException, JAXBException;
	public void receiveMessages(int messages) throws JMSException, JAXBException;

}
