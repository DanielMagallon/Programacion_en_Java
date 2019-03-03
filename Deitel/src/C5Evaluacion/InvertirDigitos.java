package C5Evaluacion;

import java.util.Scanner;

public class InvertirDigitos
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.print (" Escriba un numero entero: ");
		int numero=lc.nextInt();
		
		System.out.print("\n");
		
		System.out.print (" El numero invertido es: ");
		invertirDigito(numero);
		
	}
	
	public static void invertirDigito (int numero)
	{
	
		int num,resnum;
		
		while (numero != 0)
		{
			resnum=numero;
			numero %= 10;
			num=numero;
			System.out.printf ("%d",num);
			numero = resnum/10; 
		}
		
	}
}
