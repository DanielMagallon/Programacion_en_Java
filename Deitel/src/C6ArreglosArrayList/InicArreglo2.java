package C6ArreglosArrayList;

public class InicArreglo2
{
	public static void main(String[] args)
	{
		int [] arreglo = {32,27,64,18,95,14,90,70,60,37};
		
		System.out.printf ("%s%8s\n", "Indice", "Valor");
		
		for (int contador=0; contador < arreglo.length; contador++)
			System.out.printf ("%5d%8d\n",contador,arreglo[contador]);
	}
}
