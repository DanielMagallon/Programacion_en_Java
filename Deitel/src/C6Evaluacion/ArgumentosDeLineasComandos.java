package C6Evaluacion;

public class ArgumentosDeLineasComandos
{
	public static void main(String[] args)
	{
		if (args.length > 3 || args.length == 1)
			System.out.println("Error: Vuelva a escribir el comando completo que no exceda de los 3 o o tenga solo uno, incluyendo\n" + 
					"el tamanio del arreglo,el valor inicial y el incremento");
		
		
		else
			if (args.length == 2)
			{
				int [] arreglo = new int [10];
				
				int valorInicial = Integer.parseInt(args[0]);
				int incremento = Integer.parseInt(args[1]);
				
				for (int contador=0; contador<arreglo.length; contador++)
				{
					arreglo[contador] = valorInicial + incremento * contador;
				}
				
				System.out.printf ("%s%8s\n","Indice","Valor");
				
				for (int contador=0; contador<arreglo.length; contador++)
					System.out.printf ("%5d%8d\n",contador,arreglo[contador]);
			}
		
			else
				if (args.length == 3)
				{
					int longituArreglo = Integer.parseInt(args[0]);
					int [] arreglo = new int [longituArreglo];
					
					int valorInicial = Integer.parseInt(args[1]);
					int incremento = Integer.parseInt(args[2]);
					
					for (int contador=0; contador<arreglo.length; contador++)
					{
						arreglo[contador] = valorInicial + incremento * contador;
					}
					
					System.out.printf ("%s%8s\n","Indice","Valor");
					
					for (int contador=0; contador<arreglo.length; contador++)
						System.out.printf ("%5d%8d\n",contador,arreglo[contador]);
				}
	}
}
