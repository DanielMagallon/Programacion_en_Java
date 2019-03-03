package C4InstruccionControl2;

import java.util.Scanner;

public class String_switch 
{
	public static void main(String[] args) 
	{
		Scanner lc = new Scanner(System.in);
		
		String codigoPostal;
		
		System.out.print (" Escribe el nombre de la ciudad: ");
		String ciudad = lc.nextLine();
		
		switch (ciudad)
		{
			case "Maynard": 
			codigoPostal = "01754";
			System.out.printf (" Codigo postal: %s",codigoPostal);
			break;
			
			case "Marlborough": 
			codigoPostal = "01752";
			System.out.printf (" Codigo postal: %s",codigoPostal);
			break;
			
			case "Framingham": 
			codigoPostal = "01701";
			System.out.printf (" Codigo postal: %sM",codigoPostal);
			break;
		}
	}
}
