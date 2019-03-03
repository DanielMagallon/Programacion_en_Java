package C5Evaluacion;

import java.util.Scanner;

public class AreaCirculo
{
	
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		char car;
		
		System.out.println(" Programa que imprime el area del circulo.\n Toma como base el radio"
				+ " introducido por el usuario");
		
		do
		{
		System.out.println(" Introduzca el radio del circulo: ");
		double radio=lc.nextDouble();
		
		System.out.printf (" El area del circulo es de %f\n",circuloArea(radio));
		
		System.out.println("\n Desea volver a sacar el area del circulo?");
		car = lc.next().charAt(0);
		}
		while (car != 'N' && car != 'n');
	}	
	
	public static double circuloArea (double radio)
	{
		 return  Math.PI * Math.pow(radio, 2);
	}
}
