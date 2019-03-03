package C6Evaluacion;

public class EncontrarError
{
	public static void main(String[] args)
	{
		// 1.- final int TAMANIO_ARREGLO = 5;
			//  TAMANIO_ARREGLO = 10;
		
		/*
		 * Error 1: La cosntante TAMANIO_ARREGLO se declaro como final, por lo tant su valor no puede ser modificado
		 */
		
		
		// 2.- int [] b = new int [10];
			// for (int i=0; i<=b.lenght; i++)
				// b[i];
		
		/*
		 * Error 2: la variable i en la instruccion for tiene como condicion un <= , lo que hara 
		 * se salga del tamño del arreglo
		 */
		
		//   int[][] a = { { 1, 2 }, { 3, 4 } };
				// a[ 1,1 ] = 5;
		
		/*
		 * el areglo a tiene incializado dos veces la posicion [1] [1]
		 * El primer valor que toma es 3 , y en el siguiente toma el valor de 5
		 */
		
		final int TAMANIO_ARREGLO = 2;
		final int TAMANIO_ARREGLO2 = 10;
		
		int [] b = new int [TAMANIO_ARREGLO2];
			
		int total=0;
		
		for (int i=0; i<b.length; i++)
		{
					b[i]= i + 2 * 2;
					total += b[i];
		}
		
		for (int i=0; i<b.length; i++)
		{
				System.out.println(b[i]);
		}
		System.out.printf ("\nEl total de la suma de los arreglos es: %d",total);
		
		System.out.println("\n");
		
		int [] [] a = new int [TAMANIO_ARREGLO][TAMANIO_ARREGLO];
		
		total=0;
		
		for (int i=0; i<a.length; i++)
		{
			for (int j=0; j<a[i].length; j++)	
			{
				a[i][j]= i + 2 * 5;
					total += a[i][j];
			}
		}
		
		for (int i=0; i<a.length; i++)
		{
			for (int j=0; j<a[i].length; j++)	
			{
				System.out.print (a[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.printf ("\nEl total de la suma de los arreglos es: %d",total);
	}
}
