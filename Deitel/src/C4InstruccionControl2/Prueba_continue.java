package C4InstruccionControl2;

// Instruccion continue para terinar una iteracion de una instruccion for

public class Prueba_continue 
{
	public static void main(String[] args) 
	{
		for (int cuenta=1; cuenta<=10; cuenta++) // itera 10 veces
		{
			if (cuenta==5) // si cuenta es 5
				continue; // omite el resto del codigo en el ciclo
			
			System.out.printf (" %d ",cuenta);
		}
		
		System.out.println("\nSe uso 'continue' para omitir imprimir 5");
	}
}
