package Recursividad;

public class SumarElementosArreglo 
{
	public static void main(String[] args)
	{
		int arreglo[] = {5,3,2,1,4,10,100};
		
		int tam=arreglo.length-1;
		
		System.out.printf ("Suma de los elemnetos del arreglo: {5,3,2,1,4,10,100} = %d",
							sumarElementos(arreglo, tam));
		
		int arreglo2[] = {5,4,8,2};
		tam=arreglo2.length-1;
		
		System.out.printf ("\nProducto de los elementos del arreglo: {5,4,8,2} = %d",
							multiplicarElemntos(arreglo2, tam));
		
		
	}
	
	static int sumarElementos(int [] arreglo,int tamanio)
	{
		if (tamanio==0)
			return arreglo[0];
		
		else
		{
			return arreglo[tamanio] + sumarElementos(arreglo,tamanio-1);
		}
	}
	
	static int multiplicarElemntos(int []arreglo,int tam)
	{
		if (tam==0)
			return arreglo[0];
		
		else
		{
			return arreglo[tam] * multiplicarElemntos(arreglo,tam-1);
		}
	}
}
