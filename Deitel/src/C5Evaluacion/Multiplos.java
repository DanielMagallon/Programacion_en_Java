package C5Evaluacion;

import java.io.IOException;
import java.util.Scanner;

public class Multiplos
{
	public static void main(String[] args) throws IOException
	{
		System.out.println(" Este programa pide que se introduzcan entero. Y determinara:"
				+ " \n Si el segundo entero es multiplo del primero el valor sera true,\n de lo contrario devolvera false\n");
		
		Scanner lc =  new Scanner(System.in);
		
		int ent1,ent2;
		char continuar;
		
	do 
	{
		System.out.print (" \n Introduzca el primer entero: ");
		ent1=lc.nextInt();
		
		System.out.print (" Introduzca el segundo entero: ");
		ent2=lc.nextInt();
		
		System.out.printf (" El valor es %b\n",esMultiplo(ent1, ent2));
		
		System.out.println ("\n Desea volver a ejecutar el programa?");
		continuar = (char)System.in.read( ); 
	}
	while (continuar != 'N' && continuar != 'n');
	}
	
	public static boolean esMultiplo (int ent1,int ent2)
	{
		if (ent2 % ent1 == 0)
			return true;
		
		else
			return false;
	}
}
