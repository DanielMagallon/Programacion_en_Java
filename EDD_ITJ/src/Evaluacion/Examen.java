package Evaluacion;

/**
 * 
 * @author edgar daniel magallon villanueva
 *
 */
public class Examen
{
	public static void serieDivision(int n)
	{
		System.out.printf("%d/2 = %d\n",n,(n/2));
		
		if(n/2==1)
			return;
		
		serieDivision(n/2);
	}
	
	public static void multplicarVector(int vec[], int i)
	{
		if(i==vec.length)
			return;
		
		vec[i] = vec[i]*2;
		multplicarVector(vec, i+1);
	}
	
	public static void mostrarVecor(int v[], String msg)
	{
		System.out.println(msg);
		
		for(int a : v)
			System.out.print(a+" ");
		
		System.out.println();
	}
	
	public static void main(String[] args)
	{
			serieDivision(73);
			
			int v[] = {3,6,8};

			mostrarVecor(v, "Elementos vector viejo: ");
			
			multplicarVector(v, 0);
			
			mostrarVecor(v, "Elementos vector nuevo (multiplicados): ");
	}
}
