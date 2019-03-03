package C5Evaluacion;

import java.util.Random;
import java.util.Scanner;

public class InstruccionComputadoraParte2
{
	public static Scanner lc = new Scanner(System.in);
	public static Random lb =  new Random();
	public static int cont=1;
	
	public static void main(String[] args)
	{
		System.out.println(" El siguiente programa servira de ayuda para ayudar a\n un alumno de "
				+ "primaria a multiplicar ");
		
		System.out.println(" \n Por cada respuesta correcta apareceran 1 de 4 posibles mensajes.\n "
				+ "Lo mimso hara si l respuesta es incorecta");
		
		System.out.println("\n Bueno. Empecemos: ");
		
		tablasMultiplicar();
	}
	
	public static void tablasMultiplicar ()
	{
		int numero1 = 1 + lb.nextInt(9);
		int numero2 = 1 + lb.nextInt(9);
		
		int resultado;
		char opc;
		
		do
		{
		System.out.printf ("\n Cuanto es %d x %d?",numero1,numero2);
		System.out.print ("\n Escriba aqui su resultado: ");
		resultado=lc.nextInt();
		
		if (resultado == (numero1*numero2))
		{
			cont++;
			mensajesAleatoriosCorrecto();
			System.out.print (" Avanzemos con la siguiente.\n ");
			
			if (cont>=11)
			{
				System.out.print ("\n Si desea continuar? ");
				opc=lc.next().charAt(0);
				
				if (opc== 'S' || opc == 's')
				{
					tablasMultiplicar();
				}
				
				else
					System.exit(0);
			}
			
		else if (cont<=10)
			tablasMultiplicar();
		}
		
		else
			mensajesAleatoriosIncorrecto();
		}
		while (resultado != (numero1*numero2));
	}
	
	public static void mensajesAleatoriosCorrecto ()
	{
		int cadena = 1 + lb.nextInt(4);
		
		switch (cadena)
		{
			case 1:
				System.out.println("\n Muy Bien¡");
				break;
				
			case 2:
				System.out.println("\n Excelente¡");
				break;
				
			case 3:
				System.out.println("\n Buen Trabajo¡");
				break;
				
			case 4:
				System.out.println("\n Sigue asi¡");
				break;
		}
	}
	
	public static void mensajesAleatoriosIncorrecto ()
	{
		int inccadena = 1 + lb.nextInt(4);
		
		switch (inccadena)
		{
			case 1:
				System.out.println("\n No. Por favor intenta de nuevo");
				break;
				
			case 2:
				System.out.println("\n Incorrecto. Intenta una vez mas.");
				break;
				
			case 3:
				System.out.println("\n No te rindas¡");
				break;
				
			case 4:
				System.out.println("\n No. Sigue intentando¡");
				break;
		}
	}
}
