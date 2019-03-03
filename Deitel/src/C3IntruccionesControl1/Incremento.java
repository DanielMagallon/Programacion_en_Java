package C3IntruccionesControl1;

// Operadores de preincremento y postincremento.

public class Incremento {
	public static void main(String[] args) {
		int c;

		// demuestra el operador postincremento

		c = 5; // asigna 5 a c;

		System.out.println(c); // imprime 5
		System.out.println(c++); // imprime 5 despues postincrementa
		System.out.println(c); // imprime 6

		System.out.println();

		// demuestra el operador de preincremento
		c = 5;

		System.out.println(c); // imprime 5
		System.out.println(++c); // preincrementa y despues imprime 6
		System.out.println(c); // imprime 6
	}
}
