package Recursividad;

import java.util.Scanner;

public class SumarNumero_Inicio_N_numero
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.print ("Introduzca un numero N: ");
		int num=lc.nextInt();
		
		System.out.printf ("La suma de los numeros que"
				+ "hay entre %d y %d es = %d",1,num,sumarNumeros(num));
	}
	
	static int sumarNumeros(int nFinal)
	{
		if (nFinal==1)
			return 1;
		
		else
			return nFinal + sumarNumeros(nFinal-1);
	}
}
