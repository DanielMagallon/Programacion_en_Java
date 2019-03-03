package C6Evaluacion;

public class EjerciciosAutoevalucion
{
	public static void main(String[] args)
	{
		// 1.- Declarar una constante llamada TAMANIO_ARREGLO inicilaizada en 10
				final int TAMANIO_ARREGLO = 10;
				
		// 2.- Declarar un arreglo con TAMANIO_ARREGLO, elementos de tipo double, con valor de 0
				double [] fracciones = new double [TAMANIO_ARREGLO];
				
		// 3.- Hacer referencia al elemnto 4 del arreglo
				fracciones[4] = 0;
				
		// 4.- Asigne el valor 1.667 al elemnto 9 del arreglo
				fracciones[9] = 1.667;
				
		// 5.- Asigne el valor 3.333 al elemento 6 del arreglo
				fracciones[6]= 3.333;
				
		// 6.- Sumar todos los elementos del arreglo, usando el for
				
				double suma=0;
				
				for (int x=0; x<fracciones.length; x++)
				{
					
					System.out.printf ("fracciones [%d] = %.3f\n",x,fracciones[x]);
					suma += fracciones[x];
				}
				
				System.out.printf ("\nLa suma de los elementos es: %.3f",suma);
	}
}
