package HelpClass;

public class ConvertirDecimalBinario 
{
	public static void main(String[] args) 
	{
		long numeroDecimal = 134000; // numero que se convertira a binario
		
		long aux = numeroDecimal; // se le asigna el numero decimal a la variable auxiliar
		
		/* Creamos una variable String para guardar el numero Binario */
		String numeroBinario = new String ();
		
		/* Ciclo que va preguntando hasta que aux sea mayor a cero */
		while (aux>0)
		{
			numeroBinario = aux % 2 + numeroBinario; /* Dividimos y tomaos el residuo
			y lo conectamos con la cadena de numeroBinario */
			
			aux/=2; // Vamos disminuyendo la variable aux hasta dividirla entre 2
		}
		
		System.out.println(numeroBinario);
		
		/* Ahora vamos a pasar de Binario a Decimal. Tomemos el mismo numero que nos dio como resultado
		 * de la conversion de decimal a Binario */
		
		long numeroBinarioConvertir=Long.parseLong(numeroBinario);
	    long salidaDecimal=0;
	    long contador=1;
	    long auxDecimal;
	    
	    while (numeroBinarioConvertir>0)
	    {
	    	/* Sacamos el residuo de la operacion,el cual multiplicaremos por la variable auxdecimal */
	    	
	    	auxDecimal = numeroBinarioConvertir % 2;
	    	
	    	// Vamos sumando y guardando en la variable decimal la operacion
	    	salidaDecimal = salidaDecimal + auxDecimal * contador;
	    	
	    	// Dividimos entre 10
	    	numeroBinarioConvertir/=10;
	    	
	    	contador *= 2;
	    }
	    
	    System.out.println(salidaDecimal);
	}
}
