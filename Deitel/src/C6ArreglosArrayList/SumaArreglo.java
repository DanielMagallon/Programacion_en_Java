package C6ArreglosArrayList;

public class SumaArreglo
{
	public static void main(String[] args)
	{
		int [] arreglo = {87,68,94,100,83,78,85,91,76,87};
		
		int total=0;
		
		// suma el total de cada elemento al total
		for (int contador=0; contador < arreglo.length; contador++)
			total += arreglo [contador];
		
		System.out.printf (" Total de los elementos del arreglo: %d\n",total);
	} 
	
}
