package C14RegularExpresion;

import java.util.Scanner;

public class StaticCharMethods2
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.println("Please enter a radix: ");
		int radix = lc.nextInt();
		
		System.out.printf( "Please choose one:\n1 -- %s\n2 -- %s\n",
			 "Convert digit to character", "Convert character to digit" );
			int choice = lc.nextInt();
			
		switch (choice)
		{
			case 1:
				System.out.println( "Enter a digit:" );
				int digit=lc.nextInt();
				System.out.printf( "Convert digit to character: %s\n",
						Character.forDigit( digit, radix));
				break;
			
			case 2:
				System.out.println( "Enter a character:" );
				char character = lc.next().charAt( 0 );
				System.out.printf( "Convert character to digit: %s\n",
						Character.digit( character, radix ));
				break;
		}
	}
}
