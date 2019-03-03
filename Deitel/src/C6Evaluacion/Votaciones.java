package C6Evaluacion;

import java.util.Scanner;

public class Votaciones
{

	String [] temas = {"Politica",
	                   "Deportes",
	                   "Problemas Ambientales",
	                   "Entorno Global",
	                   "Extincion Animal"};
	
	int respuestas [][] = new int [5][10];

	public void principal ()
	{
		
		Scanner lc = new Scanner(System.in);
		
		int cal;
		
		System.out.println("A continuacion se le pedira que califique del 1-10\ncada asunto presentado a continuacion");

		System.out.println("\n");
		
		for (int i=0; i<5; i++)
		{
			
			for (int j=0; j<5; j++)
			{
				if (j==0)
				System.out.printf ("Usuario #%d:\n",i+1);
				
				System.out.printf ("\n%d.- Que tan importante es para usted el tema sobre %s?",j+1,temas[j]);
				
				do
				{	
					System.out.print ("\n    Calificacion al tema: ");
					cal=lc.nextInt();
					
					try 
					{
						++respuestas[i][cal-1];
					} // fin de try
					
					catch (ArrayIndexOutOfBoundsException e)
					{
						
						System.out.println(e);
						//System.out.printf ("   respuestas [%d] = %d\n\n",
							//	respuesta,respuestas[respuesta]);
						
					}
					
					if (cal>10 || cal<=0)
						System.out.println("\nNo esta permitido esa calificacion.Intente de nuevo");
				}
				while (cal>10 || cal<=0);
				
			}
			System.out.println("\n");
		}
		
		System.out.println("\nRango de Calificaciones para cada tema:\n");
		
		for (int calificacion=0; calificacion<respuestas[0].length; calificacion++)
			if (calificacion==0)
				System.out.printf ("%11s%d","C",calificacion+1);
		
			else
				System.out.printf ("    %s%d","C",calificacion+1);
		
		System.out.println("    Promedio");
		
		for (int i=0; i<respuestas.length; i++)
		{
			System.out.printf ("%s %d","Tema",i+1);
			
			for (int c: respuestas [i])
			{
				System.out.printf ("%5d ",c);
			}
			double promedio=promedioPorTema(respuestas[i]);
			System.out.printf ("%10.2f\n",promedio);
			System.out.println();
		}
		
	}
	
	public double promedioPorTema (int [] conjuntoCal)
	{
		int total=0;
		
		for (int cal : conjuntoCal)
			total+=cal;
		
		return (double) total / conjuntoCal.length;
	}

	public int mayorPuntuacion ()
	{
		int calAlta=respuestas[0][0];
		
		for (int[] califTema : respuestas)
		{
			for (int calificion : califTema)
			{
				if (calificion > calAlta)
					calAlta=calificion;
			}
		}
		return calAlta;
	}
	
	public int menorPuntuacion ()
	{
		int calBaja=respuestas[0][0];
		
		for (int[] califTema : respuestas)
		{
			for (int calificion : califTema)
			{
				if (calificion < calBaja)
					calBaja=calificion;
			}
		}
		
		return calBaja;
	}
	
	
	public static void main(String[] args)
	
	{
		Votaciones miVotaciones = new Votaciones();
		
		miVotaciones.principal();
		
		System.out.printf ("La mayor puntuacion fue: %d",miVotaciones.mayorPuntuacion());
		System.out.printf ("\nLa menor puntuacion fue: %d\n",miVotaciones.menorPuntuacion());
		
	}
}
