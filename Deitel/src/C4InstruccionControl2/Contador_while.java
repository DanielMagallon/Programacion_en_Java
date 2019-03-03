package C4InstruccionControl2;

// Repeticion controlada por contador , con la instruccion de repeticion while 

public class Contador_while 
{
	public static void main(String[] args) 
	{
		int contador = 1;
		
			while (contador<=10)
			{
				System.out.printf (" %d ",contador);
				++contador; // incrementa la variable de control en 1
			}
		
		System.out.println(); // imprime una nueva linea.
	
		 	contador = 0;
		
		 	while (++contador<=10) // condicion de continuacion del ciclo
		 		System.out.printf (" %d ",contador);
	
		 	System.out.println(); // imprime una nueva linea.
	}
				
}
