package C4InstruccionControl2;

// Repeticion controlada por contador , con la instruccion de repeticion for 

public class Contador_for 
{
	public static void main(String[] args) 
	{
		// el encabezado de la instruccion for incluye la inicializacion,
		// la condicion de continuacion ciclo y el incremento
		for (int contador = 1; contador <= 10; contador++)
			System.out.printf (" %d ",contador);
		
		System.out.println();
	}
}
