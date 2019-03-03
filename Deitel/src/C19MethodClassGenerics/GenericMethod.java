package C19MethodClassGenerics;

public class GenericMethod
{
	public static void main(String[] args)
	{
		Integer integerA [] = {1,2,3,4,5,6};
		Double doubleA [] = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character charA [] = { 'H', 'E', 'L', 'L', 'O' };
		
		System.out.println( "Array integerArray contains:" );
		printArray( integerA ); // pass an Integer array
		System.out.println( "\nArray doubleArray contains:" );
		printArray( doubleA); // pass a Double array
		System.out.println( "\nArray characterArray contains:" );
		printArray( charA); // pass a Character array		
	}
	
	private static <T> void printArray(T[] array)
	{
		for ( T element : array )
			System.out.printf( "%s ", element );
		
		System.out.println();
	}
}
