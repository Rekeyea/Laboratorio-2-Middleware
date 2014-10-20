package middleware.componentes;

import java.util.ArrayList;
import java.util.List;

import middleware.clases.datatypes.Constants;
import middleware.clases.datatypes.Transaction;
import middleware.clases.datatypes.TransactionStatus;
import middleware.clases.datatypes.Transactions;


public class TransactionAggregator {
	
	public Transactions addTransaction(List<TransactionStatus> listTransactions){
		Transactions tr = new Transactions();
		List<Transaction> list= new ArrayList<Transaction>();
		for(TransactionStatus ts : listTransactions){
			list.add(ts.getTransaction());
		}
		tr.setTransactionList(list);
		return tr;
	}
	
	public boolean releaseChecker(List<TransactionStatus> listTransactions){
		//System.out.println("Trans agregator: "+listTransactions.size());
		return listTransactions.size() == Constants.release;
	}
	
}
