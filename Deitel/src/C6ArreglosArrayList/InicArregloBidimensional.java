package C6ArreglosArrayList;

public class InicArregloBidimensional
{
	public static void main(String[] args)
	{
		int [][] arreglo1 = /* Fila 0*/ {{1,2,3}, /* Fila 1*/ {4,5,6}};
		int [][] arreglo2 = {  /* Fila 0*/ {1,2}, /* Fila 1*/ {3}, /* Fila 2*/ {4,5,6}};
		
		
		System.out.println("Los valores en arreglo1 por filas son");
		imprimirArreglo (arreglo1); // muestra arreglo1 por filas
		
		System.out.println("\nLos valores en arreeglo2 por filas son:");
		imprimirArreglo (arreglo2); // muestra arreglo2 por filas
		
	}
	
	public static void imprimirArreglo (int [][] arreglo)
	{
		//itera a traves de las filas del arreglo
		for (int fila=0; fila < arreglo.length; fila++)
		{
			//itera a traves de las columnas de la fila actual
			for (int columna=0; columna < arreglo[fila].length; columna++)
				System.out.printf ("%d ",arreglo[fila][columna]);
			
			System.out.println();
		}
		
	}
}
