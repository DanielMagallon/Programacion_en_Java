package C16Recursion;

public class TimeActitvity
{
	public static long factorial(int n)
	{
		long num = 1;
		
		for (int i=n; i>=1; i--)
			num*=i;
		
		return num;
	}
	
	public static long factorialRecusion(int n)
	{
		if(n<=1)
			return 1;
		
		else return n * factorial(n-1);
	}
	
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		//System.out.println(factorialRecusion(20));
		System.out.println(factorial(20));
		long end = System.currentTimeMillis();
		System.out.println("Ha tardado: "+ (end-start) + " milisegundos\n");
		
		start = System.currentTimeMillis();
		System.out.println(factorialRecusion(20));
		end = System.currentTimeMillis();
		System.out.println("Ha tardado: "+ (end-start) + " milisegundos\n");
		
	}
}
