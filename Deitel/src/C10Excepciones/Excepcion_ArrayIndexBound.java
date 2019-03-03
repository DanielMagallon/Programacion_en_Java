package C10Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepcion_ArrayIndexBound
{
	private static Scanner lc;

	
	public static void main(String[] args)
	{
		lc = new Scanner(System.in);

		int califExamen[] = new int [5];
		int calificaciones[] = new int [11];
		int calificacion;
		int suma=0;
		boolean ciclo=true;
		
		for (int i=0; i<califExamen.length; i++)
		{
		
		do
		{
			try
			{
			System.out.printf ("Introduzca la calfificacion del examen %d: ",i+1);
			calificacion=lc.nextInt();

			++calificaciones[calificacion];
			suma+=calificacion;
			
			ciclo=false;
			}
			
			catch (ArrayIndexOutOfBoundsException e)
			{
				System.err.printf ("\nExcepcion: %s\n",e);
				lc.nextLine();
				System.out.println("La calificacion debe estar entre 0 y 10\n");
			}
			
			catch (InputMismatchException e)
			{
				System.err.printf ("\nExcepcion: %s\n",e);
				lc.nextLine();
				System.out.println("Debe introducir valores enteros\n");
			}
		}
		while (ciclo);
		ciclo=true;
		}

		System.out.printf ("\n%s %d\n%s %.2f","La suma de las calificaciones es: ",suma,
				"El promedio de las calificaciones es: ",(double)suma/califExamen.length);
	}
}
