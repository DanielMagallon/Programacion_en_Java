package C6Evaluacion;

public class ListaDeArgumentosDeLongitudVariable
{
	
	public static int producto (int...producto)
	{
		int prod=1;
		
		for (int p : producto)
			prod *= p;
		
		
		return prod;
	}
	
	public static void main(String[] args)
	{

		System.out.println("Calcula el producto de los numeros con variables que se pasan al metodo\n\n");
		
		int n1=5;
		int n2=6;
		int n3=2;
		int n4=8;
		int n5=3;
		
		System.out.println(" n1=5\n n2=6\n n3=2\n n4=8\n n5=3");
		
		System.out.printf ("\n El producto de n1 * n2 es: %d",producto(n1,n2));
		System.out.printf ("\n El producto de n1 * n2 * n3 es: %d",producto(n1,n2,n3));
		System.out.printf ("\n El producto de n1 * n2 * n4 es: %d",producto(n1,n2,n4));
		System.out.printf ("\n El producto de n1 * n2 * n5 es: %d",producto(n1,n2,n5));
		
		System.out.printf ("\n\n El producto de n1 * n3 es: %d",producto(n1,n3));
		System.out.printf ("\n El producto de n1 * n3 * n4 es: %d",producto(n1,n3,n4));
		System.out.printf ("\n El producto de n1 * n3 * n5 es: %d",producto(n1,n3,n5));
		
		
		System.out.printf ("\n\n El producto de n1 * n4 es: %d",producto(n1,n4));
		System.out.printf ("\n El producto de n1 * n4 * n5 es: %d",producto(n1,n4,n5));
		
		System.out.printf ("\n\n El producto de n1 * n5 es: %d",producto(n1,n5));
		
		
		
	}
}
