package C6ArreglosArrayList;

public class ArreglosConArgumentos
{
	public static void main(String[] args)
	{
		int cont=0;
		
		for (int i=0; i<args.length; i++)
		{
			System.out.print (args[i] + " ");
			cont++;
		}
		
		System.out.printf ("\n\nTiene %d argumentos",cont);
		
		System.out.println("\n");
		
		System.out.println("Usando instruccion for mejorada:\n");
		
		for (String argumento : args )
			System.out.print (argumento + " ");
	}
}
