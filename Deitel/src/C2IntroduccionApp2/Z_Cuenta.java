package C2IntroduccionApp2;

// La clase (Z) Cuenta con un constructor para validar e inicializar la 
// variable de instancia saldo de tipo double.

public class Z_Cuenta 
	{

		private double saldo; // variable de instancia que almacena el saldo
		
		//constructor
			public Z_Cuenta (double saldoInicial)
				{
				
				// valida que saldo inicial sea mayor que 0.0;
				// si no lo es, saldo se inicializa con el valor prederteminado 0.0 
					if (saldoInicial>0.0)
						saldo=saldoInicial;
				
				} // fin del constructor de la cuenta.
			
		// abona (suma) un monto a la cuenta
			public void abonar (double monto)
				{
				
				saldo = saldo + monto; //suma el monto al saldo
				
				} // fin del metodo abonar
			
		//devuelve el saldo de la cuenta
			public double obtenerSaldo()
				{
				
				return saldo; // proporciona el valor de saldo al método que hizo la llamada.

				
				} //fin del metodo obtenerSaldo()
	
	} // fin de la clase
