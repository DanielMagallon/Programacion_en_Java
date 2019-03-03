package C5Evaluacion;

import java.util.Scanner;

public class Exponenciacion
{
	
	public static void main(String[] args)
	{
		Scanner exp = new Scanner(System.in);
		
		int base,exponente=0;
		
		System.out.print (" Escriba un numero entero a calcular o un 0 para salir del programa: ");
		base=exp.nextInt();
		
	while (base != 0)	
	{
		System.out.print (" Escriba su exponente/potecia al que se deseee elevar: ");
		exponente=exp.nextInt();
		
		System.out.printf ("\n El numero %d elevado a la potencia de %d es igual a: %d\n",base,exponente,
							enteroPotencia(base, exponente));
		
		System.out.print ("\n Escriba un numero entero a calcular o un 0 para salir del programa: ");
		base=exp.nextInt();
	}	
	}
	
	public static int enteroPotencia (int base,int exponente)
	{
		int expo=0;
		
		for (int i=2;i<=exponente;i++)
		{
			if (i==2)
			expo = base * base;
			
			else 
				expo *= base;
		}
		
		return expo;
	}
}
