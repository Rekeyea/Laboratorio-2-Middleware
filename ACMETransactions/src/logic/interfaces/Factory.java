package logic.interfaces;

import logic.impl.TransactionsController;

public class Factory {

	public static ITransactions getITransactions(){
		return new TransactionsController();
	}
}
