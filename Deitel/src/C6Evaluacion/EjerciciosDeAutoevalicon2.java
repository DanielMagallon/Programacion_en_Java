package C6Evaluacion;

public class EjerciciosDeAutoevalicon2
{
	public static void main(String[] args)
	{
		// 1.- Declarar y crear el arreglo con arreglo de 3 filas * 3 columnas.La constante TAMANIO_ARREGLO debe
			// ser igual a 3
		
		final int TAMANIO_ARREGLO=3;
		
		int [] [] arreglo = new int [TAMANIO_ARREGLO][TAMANIO_ARREGLO];
		
		// 2.- Utilizar una instruccio for para inicializar cada elemnto con la suma de sus indices 
		// Supomga que se declaran las variables x and y como variables de control
		
		for (int x=0; x<arreglo.length; x++)
		{
			for (int y=0; y<arreglo[x].length; y++)
				arreglo[x][y]= x + y;
		}
		
		for (int x=0; x<arreglo.length; x++)
		{
			for (int y=0; y<arreglo[x].length; y++)
			{
				System.out.printf ("%d ",arreglo[x][y]);
			}			
			System.out.println();
		}
		
		System.out.println();
		
		for (int x=0; x<arreglo.length; x++)
		{
			for (int y=0; y<arreglo[x].length; y++)
			{
				System.out.printf ("arreglo [%d][%d] = %d\n",x,y,arreglo[x][y]);
			}			
			System.out.println();
		}
	}
}
