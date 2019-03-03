package C6ArreglosArrayList;

public class PruebaForMejoradoSuma
{
	public static void main(String[] args)
	{
		int [] valores = {2,33,42,99,1};
		
		int suma=0;
		
		for (int iterador : valores)
			suma += iterador;
		
		System.out.printf("La suma de los elementos del arreglo son: %d",suma);
	}
}
