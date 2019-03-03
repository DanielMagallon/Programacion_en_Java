package C11ATM;

public class CashDispenser // = Dispensador de dinero
{
	private final static int INITIAL_COUNT=50;
	private int count;
	
	public CashDispenser()
	{
		count=INITIAL_COUNT;
	}
	
	// dispensar efectivo
	void dispenseCash(int amount)
	{
		// bills = Billetes, factura,cuenta
		
		int billsRequired = amount / 20;
		count -= billsRequired;
	}
	
	// esSuficienteEfectivoDisponible
	// Available : disponible
	boolean isSufficientCashAvailable(int amount)
	{
		int billsRequired = amount / 20;
		
		if (count >= billsRequired) 
			return true;
		
		else
			return false;
	}
}
