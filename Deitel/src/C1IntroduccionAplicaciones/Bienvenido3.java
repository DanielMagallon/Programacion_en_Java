package C1IntroduccionAplicaciones;
// Imprimir varias l�neas de texto con una sola intruccion.
/*
 *  La interdiagonal (\) se conoce como caracter de escape.
 *  Secuencias de escape:
 *  1.- \n: Nueva l�nea.Coloca el cursor de la pantalla al inicio de la siguiente l�nea.
 *  2.- \t: Tabulador horizontal. Desplaza el cursor de la pantalla hasta la siguiente posici�n de tabulaci�n.
 *  3.- \r: Retorno de carro. Coloca el cursor de la pantalla al inicio de la l�nea actual.
 *          No avanza a la siguiente l�nea. Cualquier car�cter que se imprima despu�s del retorno de carro sobrescribe
 *		    los caracteres previamente impresos en esa l�nea.
 *  4.- \\: Barra diagonal inversa.Se usa para imprimir un car�cter de barra diagonal inversa.
 *  5.- \": Doble comilla.Se usa para imprimir un caracter de doble comilla.Por ejemplo:
 *  		System.out.println ("\" entre comillas\"");
 *  		displays �entre comillas". 
 */


public class Bienvenido3
{
	public static void main(String[] args)
	{
		System.out.println("Bienvenido\na\nla programaci�n\nen Java�	");
	}
}
