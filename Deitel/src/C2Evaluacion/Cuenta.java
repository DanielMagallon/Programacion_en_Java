package C2Evaluacion;

public class Cuenta 

	{

	private double saldo;
	
		public  Cuenta (double saldoInicial)
			{
		
			if (saldoInicial>0.0)
				saldo=saldoInicial;
			
			
			}
	
		public void cargar (double retiro)
			{
			
			if (retiro>saldo) 
				System.out.println("El monto a cargar excede el saldo de la cuenta");
			
			if (retiro<=saldo) 
				saldo = saldo - retiro;
			
			}
		
		public double Obtenersaldo()
			{
			
			return saldo;
			
		}
		
		
		
	
	}
