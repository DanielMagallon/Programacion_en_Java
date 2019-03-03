package C4Evaluacion;

import java.util.Scanner;

public class Numero_menor 
{
	public static void main(String[] args) 
	{
		Scanner lc = new Scanner(System.in);
		
		int num,cont=1,menor=0;
		boolean vez = false;
		
		System.out.print (" Escriba el numero de veces que desee introducir valores: ");
		int veces = lc.nextInt();
		
			do
			{
				System.out.print (" Dame un numero: ");
				num = lc.nextInt();
				
				if (vez==false)
				{
					menor = num;
				}
				
				if (num<menor)
				{
					menor=num;
				}
				
				cont++;
				vez=true;
			}
			while (cont<=veces);
			
			System.out.println();
			System.out.printf (" El numero menor es: %d",menor);
	}
}
