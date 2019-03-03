package C5Evaluacion;

import java.util.Scanner;

/*
 *  Distancia = Math.sqrt (x2 - x1)^2 + (y2 - y1)^2
 */

public class CalcularDistancia
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.println("Escriba la coordenada (tipo flotante) para: ");
		System.out.print ("\n x1 = ");
		double x1=lc.nextDouble();
		System.out.print (" y1 = ");
		double y1=lc.nextDouble();
		System.out.print (" x2 = ");
		double x2=lc.nextDouble();
		System.out.print (" y2 = ");
		double y2=lc.nextDouble();
		
		System.out.printf ("\n La distancia entre los 4 valores dados es de: %f ",distancia(x1, y1, x2, y2));
	}
	
	public static double distancia (double x1,double y1,double x2,double y2)
	{
		return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
	}
}
