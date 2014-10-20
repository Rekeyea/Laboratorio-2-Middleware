package logic.datatypes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;



@XmlRootElement(name = "Transactions")
@XmlAccessorType (XmlAccessType.FIELD)
public class Transactions {
	List<Transaction> transactionList;

	//@XmlJavaTypeAdapter(TransactionAdapter.class)
	//@XmlElement(name = "Transaction")
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
