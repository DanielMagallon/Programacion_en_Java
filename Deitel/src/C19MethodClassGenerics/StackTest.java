package C19MethodClassGenerics;

public class StackTest
{
	public static void main(String[] args)
	{
		double[] doubleElements = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		int[] integerElements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		Stack<Double> stackD = new Stack<>(5);
		Stack< Integer > stackIn = new Stack<>();
		
		pushDouble(stackD, doubleElements);
		popDouble(stackD);
		
		pushInteger(stackIn, integerElements);
		popInteger(stackIn);
	}
	
	private static void pushDouble(Stack<Double> stack, double[] v)
	{
		System.out.println( "\nPushing elements onto doubleStack" );
		
		for ( double value : v )
		{
			System.out.printf( "%.1f ", value );
			stack.push( value ); 
		}
	}
	
	private static void popDouble(Stack<Double> stack)
	{
		System.out.println( "\nPopping elements from doubleStack" );
		double popValue; 
		
		try
		{
			while(true)
			{
				popValue=stack.pop();
				System.out.printf( "%.1f ", popValue );
			}
		}
		catch (EmptyStackException ex)
		{
			System.err.println();
			ex.printStackTrace();
		}
	}
	
	private static void pushInteger(Stack<Integer> stack, int[] v)
	{
		System.out.println( "\nPushing elements onto integerStack" );
		
		for ( Integer value : v )
		{
			System.out.printf( "%d ", value );
			stack.push( value ); 
		}
	}
	
	private static void popInteger(Stack<Integer> stack)
	{
		System.out.println( "\nPopping elements from integerStack" );
		int popValue; 
		
		try
		{
			while(true)
			{
				popValue=stack.pop();
				System.out.printf( "%d ", popValue );
			}
		}
		catch (EmptyStackException ex)
		{
			System.err.println();
			ex.printStackTrace();
		}
	}
}
