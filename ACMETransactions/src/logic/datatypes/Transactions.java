package logic.datatypes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;



@XmlRootElement(name = "Transactions")
@XmlAccessorType (XmlAccessType.FIELD)

public class Transactions {
		
	@XmlElement( required=true)
	private List<Transaction> transactionList;
	
	@XmlElement( required = true )
	private String messageId;

		
	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	
	@Override
	public String toString() {		
		String ret = "";
		for(Transaction t : transactionList){
			ret= ret + t.getCodigoComercio() + " ";
		}
		return ret;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
		
}
