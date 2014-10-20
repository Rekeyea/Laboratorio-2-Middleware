package logic.Interfaces;

import logic.Controllers.BankController;

public class Factory {

	public IBankController getIBankController(){
		return new BankController();
	}
}
