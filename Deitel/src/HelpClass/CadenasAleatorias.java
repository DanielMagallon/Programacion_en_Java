package HelpClass;

import java.util.Random;
import java.util.Scanner;

public class CadenasAleatorias
{
	public static Random lb  = new Random();
    public static int numero = 1 + lb.nextInt(2);
	public static Scanner lc = new Scanner(System.in);
			
	public static void main(String[] args)
	{
		
		mostrar();
	}
	
	public static void mostrar ()
	{		
		String nom;
		char opc;
		do
		{
		System.out.print (" Introduzca un nombre: ");
		nom = lc.next();

		System.out.println(numero);
		
		switch (numero)
		{
			case 1: 
				System.out.println(" Es horrible ese nombre");
				break;
			case 2:
				System.out.println("\n Es asombroso ese nombre");
				break;
		}
		
		System.out.println("\n Desea repetir: ");
		opc = lc.next().charAt(0);
		}
		while (opc != 'N' && opc != 'n');
		
	}
}

