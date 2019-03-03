package C19MethodClassGenerics;

public class stackTest2
{
	public static void main(String[] args)
	{
		Double[] doubleElements = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		Integer[] integerElements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		Stack<Double> stackD = new Stack<>(5);
		Stack< Integer > stackIn = new Stack<>();
		
		push("doubleStack",stackD, doubleElements);
		pop("doubleStack",stackD);
		
		push("integerStack",stackIn, integerElements);
		pop("integerStack",stackIn);
	}
	
	private static <T> void push(String name, Stack<T> stack, T[] v)
	{
		System.out.printf( "\nPushing elements onto %s\n", name );
		
		for ( T value : v )
		{
			System.out.printf( "%s ", value );
			stack.push( value ); 
		}
	}
	
	private static <T> void pop(String name,Stack<T> stack)
	{
		System.out.printf( "\nPopping elements from %s\n", name );
		T popValue; 
		
		try
		{
			while(true)
			{
				popValue=stack.pop();
				System.out.printf( "%s ", popValue );
			}
		}
		catch (EmptyStackException ex)
		{
			System.err.println();
			ex.printStackTrace();
		}
	}
	//930
}
