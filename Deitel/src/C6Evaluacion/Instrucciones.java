package C6Evaluacion;

import java.util.Random;

public class Instrucciones
{
	public static void main(String[] args)
	{
		// Mostrar el valor del elemento 6 del arreglo f
			int [] f = {75,43,23,40,65,13,100,37,22,5}; 
				System.out.println(f[6]);
				
				
				System.out.println("\n");
				
		//  Inicializar con 8 cada uno de los 5 elemntos del arreglo unidimensonal g
			int [] g = new int [5];
			
				for (int i=0; i<g.length; i++)
						g[i]=8;
				
				for (int i=0; i<g.length; i++)
					System.out.println(g[i]);
				
				System.out.println();
				
		// Sumar el total de los 100 elemntos del array c de punto flotante
				float []c = new float [100];
				
				float total=0;
				float a;
				
				for (int i=0; i<c.length; i++)
				{
					a=i;
					
					c[i]= (float) ( a + 0.5);
					total += c[i];
				}
				
				for (int i=0; i<c.length; i++)
				{
					System.out.printf ("%5.1f ",c[i]);
					
					if (i%6==0)
						System.out.println();
				}
				
				System.out.printf ("\n\n La suma del total de los elementos es: %.2f",total);
				
				System.out.println("\n");
				
		// Copiar el arreglo z de 11 elementos en la primera posicion del arreglo b, el cual tiene  34 elementos
				int [] z = new int [11];
				int [] b = new int [34];
				
				int suma=0;
				
				for (int i=0; i<z.length; i++)
				{
					z[i] = i;
					suma += z[i];
				}
				
				
				for (int i=0; i<z.length; i++)
				{
					System.out.print (z[i] + " ");
				}
				
				System.out.println("\n");
				System.out.printf (" b[0] = %d ",b[0]=suma);
				
				
		// Determinar e imprimir los valores menor y mayor contendios en el arreglo w de 99 eleemntos de punto flotante
				
				float [] w = new float [99];
				
				Random lb = new Random();
			
				int cont=5;
				
				
				System.out.println("\n");
				
				for (int i=0; i<w.length; i++)
				{
					w[i] = (float) (generarFlotantesAleatorios() + lb.nextInt(100) + 1);
				}
				
				for (int i=0; i<w.length; i++)
				{
					System.out.printf (" %6.2f ",w[i]);
					
					if (i%cont==0)
						System.out.println();
						
				}
				
				double mayor=w[0];
				
				for (int i=0; i<w.length; i++)
				{
					if (mayor<w[i])
						mayor=w[i];
				}
				
				double menor=w[0];
				
				for (int i=0; i<w.length; i++)
				{
					if (menor>w[i])
						menor=w[i];
				}
				
				System.out.printf ("\n\nEl numero mayor del arreglo es %.2f ",mayor);
				System.out.printf ("\n\nEl numero menor del arreglo es %.2f ",menor);
	}
	
	public static double generarFlotantesAleatorios ()
	{
		int flot;
		double a=0;
		
		Random lb = new Random();
		
		flot=lb.nextInt(4) + 1;
		
		switch (flot)
		{
			case 1: 
				a = 0.5; 
				break;
				
			case 2: 
				a = 0.25; 
				break;
			
			case 3: 
				a = 0.75; 
				break;
				
			case 4: 
				a = 1.35; 
				break;
		}
		
		return a;
	}
}
