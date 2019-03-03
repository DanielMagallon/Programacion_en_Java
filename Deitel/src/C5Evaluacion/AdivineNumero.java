package C5Evaluacion;

import java.util.Random;
import java.util.Scanner;

public class AdivineNumero
{
    public static	Random lb = new Random();
	public static int numero = 1 +  lb.nextInt(1000);
	public static int resnumero = 1 +  lb.nextInt(1000);
	public static Scanner lc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
	
		System.out.println(" Adivinar el numero aleatorio entre 1-1000");
		//System.out.printf (" %d ",numero);
		AdivinarNum();
	
	}
	
	public static void AdivinarNum ()
	{
		char opc;
		int num;
		
		System.out.print ("\n Adivine el numero: ");
		num=lc.nextInt();
		
		if (num==numero)
		{
			System.out.println("\n Felicidades¡ Ha acertado");
			tryAgain();
		}
		
		else if (num<numero-100)
			System.out.println ("\n Demasiado Bajo¡ Intentelo de nuevo");
		
		else if (num>numero+100) 
			System.out.println ("\n Demasiado Alto¡ Intentelo de nuevo");
		
		else 
			System.out.println("\n Demasiado cerca¡¡");
		
		AdivinarNum();
	}
	
	public static void tryAgain ()
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
		
		//System.out.printf ("%d\n",resnumero);
		
		System.out.print ("\n Adivine el numero: ");
		num=lc.nextInt();
		
		if (num==resnumero)
		{
			System.out.println("\n Felicidades¡ Ha acertado");
			tryAgain();
		}
		else if (num<resnumero-100)
			System.out.println ("\n Demasiado Bajo¡ Intentelo de nuevo");
		
		else if (num>resnumero+100) 
			System.out.println ("\n Demasiado Alto¡ Intentelo de nuevo");
		
		else 
			System.out.println("\n Demasiado cerca¡¡");
		
		adivinarAgain();
	}
}
