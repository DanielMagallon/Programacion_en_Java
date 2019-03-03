package HelpClass;

import java.util.Scanner;

public class GetFactorial 
{
	public static void main(String[] args) 
	{
		Scanner yeo = new Scanner (System.in);
		
		System.out.print (" Ingrese un numero: ");
		int num=yeo.nextInt();
		
		int factorial=1;
		
		while (num != 0)
		{
			factorial *= num;
			num--;
		}
		
		System.out.printf (" El factorial es %d",factorial);
		
	}
}
