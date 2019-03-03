package C5Evaluacion;

import java.util.Scanner;

public class PromedioEstudiante
{
	public static void main(String[] args)
	{
		Scanner lc =  new Scanner(System.in);
		
		System.out.print (" Introduzca su nombre: ");
		String nombre=lc.nextLine();
		
		System.out.printf ("\n %s introduzca el promedio del examen: ",nombre);
		int prom=lc.nextInt();
		
		System.out.printf ("\n %S usted saco %d puntos en total",nombre,puntosCalidad(prom));
	}
	
	public static int puntosCalidad (int prom)
	{
		switch (prom/10)
		{
			case 10:
			case 9:
				return 4;
				
			case 8:
				return 3;
				
			case 7:
				return 2;
			
			case 6:
				return 1;
				
			default:
				return 0;
		}
		
	}
}
