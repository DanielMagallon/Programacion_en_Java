package SalidaConFormato;

public class ConversionCadenasChar
{
	public static void main(String[] args)
	{
		char caracter = 'A';
		
		String cadena = "Esta tambien es una cadena";
		
		Integer entero = 1234; // inicializa el entero (autoboxing)

		System.out.printf ("%c\n",caracter);
		System.out.printf ("%s\n","Esta es una cadena");
		System.out.printf ("%s\n",cadena);
		System.out.printf ("%S\n",cadena);
		System.out.printf ("%b\n",entero);
	}
}
