package HelpClass;

import java.util.Scanner;

public class ConvertirCadenaNegativa_Entero
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.print ("Introduzca algun numero: ");
		String num=lc.nextLine();
		char car=num.charAt(0);
		
		System.out.printf ("Primer caracetre: %c\n",car);
		
		int numero=Integer.parseInt(num);
		
		System.out.printf ("Numero convertido: %d",numero);
	}
}
