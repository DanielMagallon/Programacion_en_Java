package C5Evaluacion;

import java.util.Scanner;

public class RedondearNumero_UDCUM 
{
	public static void main(String[] args)
	{
		Scanner input =  new Scanner(System.in);
		
		double num;
		
		System.out.println(" Realize lo que se le pide a continuacion, para salir del programa\n introduzca un -1.");
		
		System.out.print (" \n Introduce el numero a redondear, (introducelo en decimales): ");
		num=input.nextDouble ();
		
		while (num != -1)
		{
			 System.out.printf ("\n Valor original: %.5f\n",num);
			 System.out.printf (" Numero redondeado a:\n Entero mas cercano: %.2f\n Decimas: %.3f\n Centesimas: %.5f\n Milesimas: %.5f\n"
					 ,redondearAInteger(num),redondearADecimas(num),redondearACentesimas(num),redondearAMilesimas(num));
			 
			 System.out.print (" \n Introduce el numero a redondear, (introducelo en decimales): ");
			 num=input.nextDouble ();
		}
	}
	
	public static double redondearAInteger (double num)
	{
		double redondeo = Math.floor(num + 0.5);
		return redondeo;
	}
	
	public static double redondearADecimas (double num)
	{
		double redondeo = Math.floor(num * 10 + 0.5)/10;
		return redondeo;
	}
	
	public static double redondearACentesimas (double num)
	{
		double redondeo = Math.floor(num * 100 + 0.5)/100;
		return redondeo;
	}
	
	public static double redondearAMilesimas (double num)
	{
		double redondeo = Math.floor(num * 1000 + 0.5)/1000;
		return redondeo;
	}
}

