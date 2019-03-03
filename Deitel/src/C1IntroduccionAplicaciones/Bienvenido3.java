package C1IntroduccionAplicaciones;
// Imprimir varias líneas de texto con una sola intruccion.
/*
 *  La interdiagonal (\) se conoce como caracter de escape.
 *  Secuencias de escape:
 *  1.- \n: Nueva línea.Coloca el cursor de la pantalla al inicio de la siguiente línea.
 *  2.- \t: Tabulador horizontal. Desplaza el cursor de la pantalla hasta la siguiente posición de tabulación.
 *  3.- \r: Retorno de carro. Coloca el cursor de la pantalla al inicio de la línea actual.
 *          No avanza a la siguiente línea. Cualquier carácter que se imprima después del retorno de carro sobrescribe
 *		    los caracteres previamente impresos en esa línea.
 *  4.- \\: Barra diagonal inversa.Se usa para imprimir un carácter de barra diagonal inversa.
 *  5.- \": Doble comilla.Se usa para imprimir un caracter de doble comilla.Por ejemplo:
 *  		System.out.println ("\" entre comillas\"");
 *  		displays “entre comillas". 
 */


public class Bienvenido3
{
	public static void main(String[] args)
	{
		System.out.println("Bienvenido\na\nla programación\nen Java¡	");
	}
}
