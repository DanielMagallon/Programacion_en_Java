package C6Evaluacion;

import java.util.Random;
import java.util.Scanner;


public class Simulacion_TortugaLiebre
{
	Random lb = new Random();
	
	 public static void main(String[] args)
		{
		 
		    Scanner lc = new Scanner(System.in);
		 
			Simulacion_TortugaLiebre sim = new Simulacion_TortugaLiebre();
		
			System.out.print ("Presione cualquier boton para comenzar con la carrera: ");
			lc.hasNext();
			
			System.out.println();
			
			
				for (int i=3; i>=1; i--)
				{
					if (i==3)
					System.out.printf ("%n%20d...\n",i);
					
					else
						if (i==2)
							System.out.printf ("%20d..\n",i);
					
						else
							System.out.printf ("%20d.\n",i);
					
				}
				
				System.out.println();
				System.out.printf ("%S","\t\tPum¡¡ \n \t\tY Arrancan¡¡");
				
				sim.generarJuego();
			
		}
	 
	 public void generarJuego ()
	 {
		 int recorrido = 69;
			int pasos=0;
			int pasosL=0;
			int avTortuga=0;
			int avLiebre=0;
			System.out.println("\n");
			
			for (int i=1; i<=avTortuga; i++)
				System.out.print (" ");
			
			System.out.println ("T");
			
			for (int i=1; i<=70; i++)
			{
				System.out.print("_");
			}
			
			System.out.println();
			
			for (int i=1; i<=avLiebre; i++)
				System.out.print (" ");
			
			System.out.println ("H");
			
			
			while (avTortuga<=recorrido || avLiebre<=recorrido)
			{
				
				
				pasos=avanzarRetrocederTortuga();
			
				//System.out.println("\nPasos retornados: " + pasos);
				
				avTortuga += pasos;
				//System.out.print ("Numero de pasos: "+ avTortuga);
				//System.out.println("\n");
				
				for (int i=1; i<=avTortuga; i++)
					System.out.print (" ");
				
				System.out.println ("T");
				
				for (int i=1; i<=70; i++)
				{
					System.out.print("_");
				}
				System.out.println();
				
				pasosL=avanzarRetrocederLiebre();
				avLiebre += pasosL;
				
				for (int i=1; i<=avLiebre; i++)
					System.out.print (" ");
				
				System.out.println ("H");
				
				
			if (avTortuga>=70)
				{
					System.out.println("\nLa tortuga gano");
					System.exit(0);
				}
				
			else 
				if (avLiebre>=70)
				{
					System.out.println("\nLa liebre gano");
					System.exit(0);
				}
			
			
			System.out.println("\n\n");
			
			}
	 }
	 
	 
	 public int avanzarRetrocederTortuga ()
		{
			int rango=lb.nextInt(10)+ 1;
			int avRe=0;
			
			switch (rango)
			{
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
					avRe=3;
					break;
					
				case 6:
				case 7:
					avRe=-6;
					break;
					
				case 8:
				case 9:
				case 10:
					avRe=1;
					break;
			}
			
			return avRe;
			
		}
	 
	 public int avanzarRetrocederLiebre ()
		{
			int rango=lb.nextInt(10)+ 1;
			int avRe=0;
			
			switch (rango)
			{
				case 1:
				case 2:
					avRe=0;
					break;
					
				case 3:
				case 4:
					avRe=9;
					break;
					
				case 5:
					avRe=-12;
					break;
					
				case 6:
				case 7:
				case 8:
					avRe=1;
					break;
					
				case 9:
				case 10:
					avRe=-2;
					break;
			}
			
			return avRe;
			
		}
}
