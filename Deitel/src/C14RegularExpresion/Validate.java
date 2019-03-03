package C14RegularExpresion;

import myjava.ScannerRead;

public class Validate
{
	public static void main(String[] args)
	{
		datos();
	}
	
	private static void datos()
	{
		ScannerRead sc = new ScannerRead();
		
		System.out.println( "Please enter first name:" );
		String firstName = sc.getInputStringLine();
		System.out.println( "Please enter the last name:" );
		String lastName = sc.getInputStringLine();
		System.out.println( "Please enter address:" );
		String address = sc.getInputStringLine();
		System.out.println( "Please enter city:" );
		String city = sc.getInputStringLine();
		System.out.println( "Please enter state:" );
		String state = sc.getInputStringLine();
		System.out.println( "Please enter zip:" );
		String zip = sc.getInputStringLine();
		System.out.println( "Please enter phone:" );
		String phone = sc.getInputStringLine();
		
		System.out.println( "\nValidate Result:" );
		
		if ( !ValidateInput.validateFirstName( firstName ) )
			System.out.println( "Invalid first name" );
		else if ( !ValidateInput.validateLastName( lastName ) )
			System.out.println( "Invalid last name" );
		else if (! ValidateInput.validateAddress(address))
			System.out.println( "Invalid address" );
		else if ( !ValidateInput.validateCity( city ) )
			 System.out.println( "Invalid city" );
		else if ( !ValidateInput.validateState( state ) )
			 System.out.println( "Invalid state" );
		else if ( !ValidateInput.validateZip( zip ) )
			 System.out.println( "Invalid zip code" );
		else if ( !ValidateInput.validatePhone( phone ) )
			 System.out.println( "Invalid phone number" );
		else
			 System.out.println( "Valid input. Thank you." );
	}
}
