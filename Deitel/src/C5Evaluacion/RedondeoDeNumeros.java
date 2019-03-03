package C5Evaluacion;

import java.util.Scanner;

public class RedondeoDeNumeros 
{
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		
		double num;
	
		
		System.out.println(" Realize lo que se le pide a continuacion, para salir del programa\n introduzca un -1.");
		
		System.out.print (" \n Introduce el numero a redondear, (introducelo en decimales): ");
		num=input.nextDouble ();
		
		
	while (num != -1)
	{
	
	     System.out.printf ("\n Math.floor (%.2f + 0.5)",num);
		
		 System.out.printf ("\n Valor original: %.2f\n",num);
		 System.out.printf (" Numero redondeado: %.2f\n",redondeoNumero(num));
		
		 System.out.print (" \n Introduce el numero a redondear, (introducelo en decimales): ");
		 num=input.nextDouble ();
		
	}
	}
	
	public static double redondeoNumero (double num)
	{
		double redondeo = Math.floor (num + 0.5);
		
		return redondeo;
	}
}
