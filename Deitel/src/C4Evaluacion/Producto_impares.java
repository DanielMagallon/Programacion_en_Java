package C4Evaluacion;

public class Producto_impares 
{
	public static void main(String[] args) 
	{
		double prod = 1;
		
		for (int i = 1; i <= 15; i +=2)
		{
			System.out.printf ("%d ",i);
			 prod *= i;
		}
		
		System.out.printf (" \nEl producto de los numeros impares es: %,.0f",prod);
	}
}
