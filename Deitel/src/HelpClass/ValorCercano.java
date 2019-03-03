package HelpClass;

import java.util.Scanner;

public class ValorCercano
{
	public static void main(String[] args)
	{
		Scanner entrada=new Scanner (System.in);
		System.out.print("\nEste programa recibe un numero tipo double y lo ");
		   System.out.print("presenta redondeado a: Entero, Decimas, Centesimas y Milesimas.");
		   int centinela;
		   double  numero;
		  
		  

		   do 
		   {      // Abre do
		   System.out.print("\nPor favor introduzca el numero: ");
		   numero = entrada.nextDouble();
		   double auxiliar; 

		   auxiliar =  Redondear_Entero(numero);

		   System.out.printf("\nEl numero %f redondeado a entero es: %.2f", numero, auxiliar);
		   
		   auxiliar = Redondear_Decimas(numero);
		   System.out.printf("\nEl numero %f redondeado a decimas es: %.3f", numero, auxiliar);

		   auxiliar = Redondear_Centesimas(numero);
		   System.out.printf("\nEl numero %f redondeado a centesimas es: %.5f", numero, auxiliar);

		   auxiliar = Redondear_Milesimas(numero);
		   System.out.printf("\nEl numero %f redondeado a milesimas es: %.5f", numero, auxiliar);

		   System.out.print("\nQuiere volver a ejecutar el programa?");
		   System.out.print(" Introduzca un entero (-1 para terminar)");
		   centinela = entrada.nextInt();

		   }while( -1 != centinela );  
		
	}
	public static double Redondear_Entero( double x )
	  {         // Abre metodo Redondear_Entero

	   return (Math.floor(x + 0.5) );
	  }         // Cierra metodo Redondear_Entero


	  // Se define el metodo Redondear_Decimas
	  public static double Redondear_Decimas( double x )
	  {         // Abre metodo Redondear_Decimas

	   return (Math.floor(x*10 + 0.5) / 10);
	  }         // Cierra metodo Redondear_Decimas


	  // Se define el metodo Redondear_Centesimas
	  public static double Redondear_Centesimas( double x )
	  {         // Abre metodo Redondear_Centesimas

	   return (Math.floor(x*100 + 0.5) / 100);
	  }         // Cierra metodo Redondear_Centesimas


	  // Se define el metodo Redondear_Milesimas
	  public static  double Redondear_Milesimas( double x )
	  {         // Abre metodo Redondear_Milesimas

	   return (Math.floor(x*1000 + 0.5) / 1000);
	  }         // Cierra
}
