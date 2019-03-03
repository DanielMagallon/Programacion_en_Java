package C6Evaluacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SerieDeFibonacci
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner (System.in);
		SerieDeFibonacci sf = new SerieDeFibonacci();
		
		int n;
		System.out.print ("\nIntroduzca el enesimo numero de la serie de Fibonacci: ");
		n=lc.nextInt();
		
		
		System.out.printf ("\nEl numero Fibonnaci del termino %d es: %d",n,sf.Fibonacci(n));
	}
	
	
	int Fibonacci(int n)
	{
		 int a=0,b=1,c=0;
		 for(int i=1;i<=n;i++)
		 {
		     c=a+b;
		     b=a;
		     a=c;
		 }
		 return a;
	}
}
