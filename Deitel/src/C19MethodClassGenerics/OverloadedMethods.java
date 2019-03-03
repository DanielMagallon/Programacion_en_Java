package C19MethodClassGenerics;

public class OverloadedMethods
{
	public static void main(String[] args)
	{
		Integer integerA [] = {1,2,3,4,5,6};
		Double doubleA [] = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character charA [] = { 'H', 'E', 'L', 'L', 'O' };
		
		printArray(integerA);
		printArray(doubleA);
		printArray(charA);
		
	}
	
	private static void printArray(Integer[] arr)
	{
		for ( Integer element : arr )
			System.out.printf( "%s ", element );
			
		System.out.println();
	}
	
	private static void printArray(Double[] arr)
	{
		for ( Double element : arr )
			System.out.printf( "%s ", element );
			
		System.out.println();
	}
	
	private static void printArray(Character[] arr)
	{
		for ( Character element : arr )
			System.out.printf( "%s ", element );
			
		System.out.println();
	}
}
