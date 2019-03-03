package C3Evaluacion;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Calcular 
{
	public static void main(String[] args) 
	{
		
		int suma=0,x=1;
		
		suma += x;
		
		System.out.printf("La suma es: %d\n",suma);
		System.out.println();
		System.out.printf ("La suma de %d + %d = %d\n",suma,x,suma += x);
		
		while (suma<11)
			{
				System.out.printf ("La suma de %d + %d = %d\n",suma,x,suma += x);
			}
		
		System.out.println();
		
		suma=0;
		x=1;
		while (x<=10)
			{
				suma += x;
				++x;
			}
		
		System.out.printf ("La suma es: %d\n",suma);
		
		System.out.println("--------");
		
		Scanner input=new Scanner(System.in);
		
		int num,cont=0;
		
		System.out.print ("Dame un numero: ");
		num=input.nextInt();
		
		while (cont<num)
		{
			cont++;
			System.out.println(cont);
		}
		
	}
}
