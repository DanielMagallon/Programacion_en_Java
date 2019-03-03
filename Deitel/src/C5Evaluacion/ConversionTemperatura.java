package C5Evaluacion;

import java.util.Scanner;

public class ConversionTemperatura
{
	public static Scanner lc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		
		System.out.println(" Para convertir de Centigrados a Fahrenheit introduce F o f\n"
				+ " Para convertir Fahrenheit a Centigrados introduce C o c");
		
		System.out.println("\n a) Centigrados\n b) Fahrenheit");
		
		Instrucciones();
	
	}
	
	public static void Instrucciones ()
	{
		char opcion;
		char opc;
		
		do
		{
		System.out.print ("\n Eliga la conversion que deseea hacer: ");
		opcion = lc.next().charAt(0);
		
		if (opcion == 'C' || opcion == 'c')
		{
			System.out.println("\n------Conversion de Grados Fahrenheit en Grados Celsius-------\n");
			
			System.out.print (" Temperatura Fahrenheit: ");
			double fahrenheit = lc.nextDouble();
			System.out.printf ("\n Temperatura en Grados Celsius: %.3f",Centigrados(fahrenheit));
		}
		
		else 
			if (opcion == 'F' || opcion == 'f')
			{
				
				System.out.println("\n------Conversion de Grados Celsius en Grados Fahrenheit-------\n");
				
				System.out.print (" Temperatura Celsius: ");
				double centigrados = lc.nextDouble();
				System.out.printf (" Temperatura en Grados Fahrenheit: %.3f",Fahrenheit(centigrados));
			}
		
			else
				System.out.println("\n No es valida la letra escogida\n Vuelva a introducirla");
		}
		
		while (opcion != 'C' && opcion != 'c' && opcion != 'F' && opcion != 'f' );
		
		
		System.out.print ("\n\n Desea hacer mas conversiones?");
		opc = lc.next().charAt(0);
		
		if (opc == 'S' || opc == 's')
			Instrucciones();
	}
	
	
	public static double Centigrados (double fahrenheit)
	{
		 double centigrados = 5.0/9.0 * (fahrenheit-32);
		 return centigrados;
	}
	
	public static double Fahrenheit (double centigrados)
	{
		double fahrenheit = 9.0/5.0 * centigrados+32;
		return fahrenheit;
	}
}
