package TiposDatosAbstractos;

import java.util.Arrays;
import java.util.Random;

public class MemoryEstaticArrays 
{
	/**
	 * Metodos de la clase Arrays (Memoria estatica):
	 * .-Sort (Ordena los numero sde < a > de u arreglo dado)
	 * .-Fill (Rellenar un arreglo con x valor)
	 * .- Equals (detrmina si un arreglo contien los mismo valores que otro)
	 * .- System.arraycopy (copiar los elemnetos de un arreglo a otro)
	 */
	
	public static void main(String[] args) 
	{
		//Arrays
		
		Random lb = new Random();
		
		int numeros [] = new int [5];
		int numerotes[] = new int [numeros.length];
		String palabras [] = new String [5];
		
		for (int i=0; i<numeros.length; i++)
		{
			numeros[i]=lb.nextInt(10)-2;
		}

		System.out.println("Los datos sin ordenar son: ");
		
		for (int i : numeros)
		{
			System.out.printf ("%3d\n",i);
		}
		
		System.out.println("\nLos datos ordenados son: ");
		Arrays.sort(numeros);
		
		for (int i : numeros)
		{
			System.out.printf ("%3d\n",i);
		}

		System.out.println("\nArreglo palabras sin rellenar:");
		for (String i : palabras)
		{
			System.out.printf ("%3s\n",i);
		}
		
		System.out.println("\nRellenando el arreglo palabras");
		Arrays.fill(palabras,"Hola man¡");
		
		for (String i : palabras)
		{
			System.out.printf ("%3s\n",i);
		}
		
		System.out.println("\nArreglo numerotes sin rellenar:");
		for (int i : numerotes)
		{
			System.out.printf ("%3d\n",i);
		}
		
		System.out.println("\nArreglo numerotes rellenado:");
		System.arraycopy(numeros,0,numerotes,0,numeros.length);
		
		for (int i : numerotes)
		{
			System.out.printf ("%3d\n",i);
		}
	}
}
