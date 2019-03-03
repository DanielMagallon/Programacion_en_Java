package C4InstruccionControl2;

// Instruccion break para salir de la instruccion for 

public class Prueba_break 
{
	public static void main(String[] args) 
	{
		int cuenta; // la varibale de control tambien se usa cuando termina el ciclo
		
		for (cuenta=1; cuenta<= 10; cuenta++)
		{
			if (cuenta==5) // si cuenta es 5
				break; // termina el ciclo
			
			System.out.printf (" %d ",cuenta);
		}
		
		System.out.printf ("\nSalio del ciclo en cuenta = %d\n",cuenta);
	}
}
