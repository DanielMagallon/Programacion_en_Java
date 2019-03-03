package C5Metodos;

import java.util.Scanner;

public class BuscadorMaximo 
{
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		
		System.out.print (" Escriba tres valores de punto flotante, separados por espacios: ");
		double numero1=input.nextDouble();
		double numero2=input.nextDouble();
		double numero3=input.nextDouble();
		
		double resultado = maximo(numero1,numero2,numero3);
		
		System.out.println(" El maximo es: "+resultado);
	}
	
	// devuelve el maximo de sus tres parametros double
	public static double maximo (double x,double y,double z)
	{
		
		return Math.max (x,Math.max(y,z));
		
		// Ambas maneras sirven para calcular el valor maximo:
		
		/*
		 * double valorMaximo = x; // asume que 'x' es el mayor para empezar
		
		// determina si y es mayor que valor maximo
		if (y>valorMaximo)
			valorMaximo=y;
		
		// determina si z es mayor que valor maximo
		if (z>valorMaximo)
			valorMaximo=z;
		
		return valorMaximo;
		 */
	}
}
