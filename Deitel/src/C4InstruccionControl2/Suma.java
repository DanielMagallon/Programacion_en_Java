package C4InstruccionControl2;

public class Suma 
{
	public static void main(String[] args) 
	{
		int total = 0;
		
		// total de los enteros totales del 2 al 20
			for (int numero = 2; numero <= 20; numero += 2)
				total += numero;
			
			System.out.printf (" La suma es: %d\n",total);
		
		System.out.println();
		System.out.println();
		
		
		System.out.println(" --- Suamar enteros parte 2: "); // instruccion vacia ';'
		
		total=0;
		
		for (int numero = 2; numero <= 20; total += numero, numero += 2);
			
			System.out.printf (" La suma es: %d\n",total);
		
	}
}
