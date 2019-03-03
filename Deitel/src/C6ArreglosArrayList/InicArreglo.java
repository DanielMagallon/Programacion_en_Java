package C6ArreglosArrayList;

public class InicArreglo
{
	public static void main(String[] args)
	{
		int [] arreglo;
		
		arreglo = new int [10];
		
		System.out.printf ("%s%8s\n", "Indice", "Valor");
		
		// imprime el valor de cada elemnto del arreglo
		
		for (int contador=0; contador < arreglo.length; contador++)
			System.out.printf ("%5d%8d\n",contador,arreglo[contador]);
	}
}
