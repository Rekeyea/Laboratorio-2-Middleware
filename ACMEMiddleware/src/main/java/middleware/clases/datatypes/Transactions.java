package middleware.clases.datatypes;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;




@XmlRootElement(name = "Transactions", namespace="ACMEv1")
@XmlAccessorType (XmlAccessType.FIELD)
public class Transactions {
	
	@XmlElement(required=true)
	private List<Transaction> transactionList;

	//@XmlJavaTypeAdapter(TransactionAdapter.class)
	
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
		
}
