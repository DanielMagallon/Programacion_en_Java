package C5Evaluacion;

import java.util.Random;
import java.util.Scanner;

public class AdivinaNumero_2
{
	public static Scanner lc = new Scanner(System.in);
	public static Random numerosAleatorios = new Random();
	public static int numero = 1 + numerosAleatorios.nextInt(1000);
	public static int resnumero = 1 + numerosAleatorios.nextInt(1000);
	public static int cont=0;
	
	public static void main(String[] args)
	{
		System.out.println(" Adivinar el numero entre 1-1000\n Contando los intentos del jugador");
		adivinarNum();
	}
	
	public static void adivinarNum ()
	{
		int num;
		// System.out.println(numero);
		
		System.out.print ("\n Adivine el numero: ");
		num=lc.nextInt();
		cont++;
	
		// System.out.printf ("\n %d\n ",cont);
		
		if (cont<=9)
		{
			if (num==numero)
			{
				System.out.println ("\n Tuvo suerte¡");
				cont=0;	
				intentarDeNuevo();
			}
			
			else if (num<numero-100)
				System.out.println ("\n Demasiado Bajo¡ Intentelo de nuevo");
				
			
			
			else if (num>numero+100) 
				System.out.println ("\n Demasiado Alto¡ Intentelo de nuevo");
			
			else 
				System.out.println("\n Demasiado cerca¡¡");
		}
	
		else if (cont==10)
		 {
			 if (num==numero)
				{
			System.out.println("\n Aja¡ Sabia usted el secreto¡");
				cont=0;
				intentarDeNuevo();
				}
			 
		else if (cont>=10)
		{
			if (num != numero)
			{
			System.out.println("\n Demasiados intentos\n Deberia haberlo hecho mejor");
			System.out.printf ("\n El numero genrado era: %d\n ",numero);
				cont=0;
				intentarDeNuevo();
			}
		} 
		}
		
		adivinarNum();		
		
	}
	
	public static void intentarDeNuevo ()
	{
		char opc;
		
		
		System.out.print ("\n Quiere intentarlo de nuevo?");
		opc = lc.next().charAt(0);
		
		if (opc == 'S' || opc == 's')
		{
			adivinarAgain();
		}
		
		else 
			System.exit(0);
	}
	
	public static void adivinarAgain ()
	{
	
		int num;
		// int resnumero = 1 + numerosAleatorios.nextInt(1000);
		
		 System.out.printf ("%d\n",resnumero);
		
		System.out.print (" Adivine el numero: ");
		num=lc.nextInt();
		cont++;
	
		// System.out.printf ("\n %d\n ",cont);
		
		if (cont<=9)
		{
			if (num==resnumero)
			{
				System.out.println ("\n Tuvo suerte¡");
				cont=0;
				 intentarDeNuevo();
			}
			
			else if (num<resnumero-100)
				System.out.println ("\n Demasiado Bajo¡ Intentelo de nuevo");
			
			else if (num>resnumero+100) 
				System.out.println ("\n Demasiado Alto¡ Intentelo de nuevo");
			
			else 
				System.out.println("\n Demasiado cerca¡¡");
		}
	
		else if (cont==10)
		 {
			 if (num==resnumero)
				{
			System.out.println("\n Aja¡ Sabia usted el secreto¡");
				cont=0;
				intentarDeNuevo();
				}
			 
		else if (cont>=10)
		{
			if (num != resnumero)
			{
			System.out.println("\n Demasiados intentos\n Deberia haberlo hecho mejor");
			System.out.printf ("\nEl numero genrado era: %d\n ",resnumero);
				cont=0;
				intentarDeNuevo();
			}
		} 
		}
		
		adivinarAgain();
	}
}
