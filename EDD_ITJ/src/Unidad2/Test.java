package Unidad2;

public class Test
{
	public static boolean vectoresIguales(int v1[], int v2[], int i)
	{
		if(i==v1.length-1)
			return v1[i] == v2[i];
		
		return  v1[i] == v2[i] && vectoresIguales(v1, v2, i+1);
	}
	
	public static void divisibles3(int n)
	{
		if(n==0)
			System.out.print("0 ");
		
		else{
			
			divisibles3(n-1);
			if(n%3==0)
			{
				System.out.print(n+" ");
			}
		}
	}
	
	public static int conjunto1_2(int vec[], int i, int cont)
	{
		if(i+1>=vec.length)
			return cont;
		
		if(vec[i] == 1 && vec[i+1]==2)
		{
			cont++;
			return conjunto1_2(vec, i+2, cont);
		}
		else return conjunto1_2(vec, i+1, cont);
	}
	
	// 1 1 1 1 1
	// 2 2 2 2
	// 3 3 3
	// 4 4 
	// 5
	public static void escaleraNumeros(int num, int n)
	{
		if(num<=n)
		{
			imprime(num, n);
			escaleraNumeros(num+1, n);
		}
	}
	
	private static void imprime(int num, int n)
	{
		if(n<num)
		{
			System.out.println();
			return;
		}
		
		System.out.print(num+" ");
		
		imprime(num, --n);
	}
	
	public static void main(String[] args)
	{
		System.out.println("Son iguales los vectores? "+
					vectoresIguales(new int[]{11,222,31,40}, new int[]{11,222,31,40}, 0));
		
		divisibles3(37);
		
		System.out.println("\n\nConjuntos de 1-2: "+
				conjunto1_2(new int[]{1,1,2,1,2,1}, 0, 0));
		
		System.out.println();
		
		escaleraNumeros(1, 5);
	}
}
