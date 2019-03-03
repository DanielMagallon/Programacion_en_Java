package C6ArreglosArrayList;

public class PruebaForMejorado
{
	public static void main(String[] args)
	{
		int [] arreglo = {87,68,94,100,83,78,85,91,76,87};
		
		int total=0;
		
		// suma el valor de cada elemnto al total
		for (int numero : arreglo)
			total += numero;
		
		System.out.printf (" Total de los elementos del arreglo: %d\n",total);
	}
}
