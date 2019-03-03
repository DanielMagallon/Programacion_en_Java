package C6ArreglosArrayList;

import java.util.Scanner;

public class TamanioArreglos
{
	public static void main(String[] args)
	{
		int tamano=1,num;
		
		Scanner lc = new Scanner(System.in);
		
		System.out.print ("Introduzca el tamaño del arreglo: ");
		tamano=lc.nextInt();
		
		int vec [] = new int [tamano];
		int total=0;
		int cont=1;
		
		for (int i=0; i<vec.length; i++)
		{
			System.out.printf ("\nIntroduzca el numero %d: ",cont);
			num=lc.nextInt();
			
			vec[i] = num;
			total += vec[i];
			cont++;
			
		}
	
		System.out.println("\nLos numeros introducidos fueron:\n");
		
		for (int i=0; i<vec.length; i++)
		{
			System.out.println(vec[i]);
		}
		
		System.out.printf ("\nEl total de la suma de los numeros es: %d",total);
	}
}
