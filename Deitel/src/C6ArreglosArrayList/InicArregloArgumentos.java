package C6ArreglosArrayList;

public class InicArregloArgumentos
{
	public static void main(String[] args)
	{
		// comprueba el numero de argumentos de liena de comandos
		
		if (args.length != 3)
			System.out.println("Error: Vuelva a escribir el comando completo, incluyendo\n" + 
								"el tamanio del arreglo,el valor inicial y el incremento");
		
		else
		{
			// obtiene el tamaño del arreglo del primer aargumento en linea de comandos
			
			int longitudArreglo = Integer.parseInt(args[0]);
			int [] arreglo = new int [longitudArreglo];
			
			// obtiene el valor inicial y el incremento de los argumtnos de lienas de comandos 
			
			int valorInicial = Integer.parseInt(args[1]);
			int incremento = Integer.parseInt(args[2]);
			
			// calcula el valor para cada elemnto del arreglo
			for (int contador=0; contador <arreglo.length; contador++)
				arreglo [contador] = valorInicial + incremento * contador;
			
			System.out.printf ("%s%8s\n","Indice","Valor");
			
			//muestra el indice y el valor del arreglof
			for (int contador=0; contador < arreglo.length; contador++)
				System.out.printf ("%5d%8d\n",contador,arreglo[contador]);
		}
	}
}
