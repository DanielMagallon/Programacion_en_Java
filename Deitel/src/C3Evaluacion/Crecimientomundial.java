package C3Evaluacion;
import java.util.Scanner;


public class Crecimientomundial 
{
	public static void main(String[] args) 
	{
		int anio=2015,anioo=0;//band=0,
		boolean bandera=false;
		long poblacion,respoblacion,crecimiento=0,respoblacion2;
		
		Scanner nm = new Scanner(System.in);
		
		// Actualmente hay 7376471981, 7380475000, habitantes (2015).
		
		System.out.print (" Introduzca el numero de habitantes de la poblacion mundial actualmente: ");
		poblacion = nm.nextLong();
		respoblacion2=poblacion;
		
		System.out.printf (" El doble sera de: %d", (poblacion*2));
		System.out.println();
		System.out.println(" Año\t     Poblacion Mundial\t     Crecimiento");
		
		while (anio<=2090)
			{
				System.out.printf (" %d\t     %d\t     %d\n",anio,poblacion,crecimiento);
				respoblacion = poblacion;
				poblacion += (long)(poblacion * 1.18) / 100;
				crecimiento = poblacion - respoblacion;
				anio++;
				
			/*	if (poblacion>=(respoblacion2*2))
				{
					band++;
						if (band==1)
						{
							anioo=anio;
						}
				} */
				
			if (bandera==false)
			{
				if (poblacion>=(respoblacion2*2))
				{
					anioo=anio;
					bandera=true;
				}
			}
				
			}
		System.out.println();
		System.out.printf (" El año en que la poblacion mundial sera el doble que la actual es: %d",anioo);
	}
}
