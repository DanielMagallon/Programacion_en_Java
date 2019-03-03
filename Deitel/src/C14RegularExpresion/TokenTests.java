package C14RegularExpresion;

import java.util.Scanner;


public class TokenTests
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner (System.in);
		System.out.println( "Enter a sentence and press Enter" );
		String sentence = lc.nextLine();
		
		String[] tokens = sentence.split( " " );
		System.out.printf( "Number of elements: %d\nThe tokens are:\n",tokens.length );
		
		for ( String token : tokens )
			System.out.println( token );
	}
}
