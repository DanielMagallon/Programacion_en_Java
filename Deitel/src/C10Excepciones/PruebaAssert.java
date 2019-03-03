package C10Excepciones;

import java.util.Scanner;

public class PruebaAssert
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		System.out.print("Escriba un numero entre 0 y 10: ");
		int numero=lc.nextInt();
		
		// asegura que el valor sea >= 0 y >= 10
		assert (numero >= 0 && numero <= 10) : "numero incorrecto: " + numero;
		
		System.out.printf ("Usted escribio %d",numero);
	}
}
