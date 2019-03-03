package C5Evaluacion;

import java.util.Random;
import java.util.Scanner;

public class InstruccionAsistidaPorComputadora
{
	public static Scanner lc = new Scanner(System.in);
	public static Random lb =  new Random();
	public static int cont=1;
	
	public static void main(String[] args)
	{
		System.out.println(" El siguiente programa servira de ayuda para ayudar a\n un alumno de "
				+ "primaria a multiplicar ");
		
		System.out.println("\n Bueno. Empecemos: ");
		
		tablasDeMultiplicar();
	}
	
	public static void tablasDeMultiplicar ()
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
		
		if (resultado==(numero1 * numero2))
		{
			cont++;
			System.out.println ("\n Muy bien¡");
			System.out.print (" Avanzemos con la siguiente.\n ");
			
			if (cont>=11)
			{
				System.out.print ("\n Si desea continuar? ");
				opc=lc.next().charAt(0);
				
				if (opc== 'S' || opc == 's')
				{
					tablasDeMultiplicar();
				}
				
				else
					System.exit(0);
			}
			
		else if (cont<=10)
			tablasDeMultiplicar();
		}
		
		else 
			System.out.println("\n No. Por favor intenta de nuevo");
		}
		while (resultado != (numero1*numero2));
	}
}
