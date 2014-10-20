package middleware.componentes;



import middleware.clases.datatypes.TransactionBD;
import middleware.clases.datatypes.TransactionStatus;

public class Transformador {
	
	public TransactionBD transform(TransactionStatus t) throws Exception{
		return new TransactionBD(t.getTransaction());
	}
}
