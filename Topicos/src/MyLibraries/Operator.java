package MyLibraries;

import java.util.ArrayList;

public class Operator {
	private StringBuilder cadena;

	public Operator(String cad) { 
		cadena = new StringBuilder(cad);
	}

	public void concatenar(String cad) {
		cadena.append(cad);
	}

	public void asignar(String cad) {
		cadena = new StringBuilder(cad);
	}

	public String obtenerCadena() {
		return cadena.toString();
	}

	public void mostrarEnConsola() {
		System.out.println(cadena);
	}

	public ArrayList<Integer> vocales() {
		ArrayList<Integer> list = new ArrayList();

		for (int i = 0; i < cadena.length(); i++) {
			if (esVocal(cadena.charAt(i) + "")) {
				list.add(Integer.valueOf(i));
			}
		}

		return list;
	}

	private String[] consonants = 
		{ "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "ñ", "p", "q", "r", "s", "t",
			"v", "w", "x", "y", "z" };

	public String consonantes() {
		String c = "";

		for (int i = 0; i < cadena.length(); i++) {
			if (esConsonante(cadena.charAt(i) + "")) {
				c = c + cadena.charAt(i);
			}
		}
		return c;
	}

	public int longitud() {
		return cadena.length();
	}

	public ArrayList<Integer> subcadenas(String sub) {
		ArrayList<Integer> list = new ArrayList();

		int ind = 0;
		int index = 0;

		char[] c = sub.toCharArray();

		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) == c[ind]) {
				if (ind == 0) {
					index = i;
				}
				ind++;

				if (ind == c.length) {
					list.add(Integer.valueOf(index));

					if (cadena.charAt(i) == c[0]) {
						index = i;
						ind = c.length - 1;
					} else {
						ind = 0;
					}
				}
			} else {
				ind = 0;
			}
		}
		return list;
	}

	public String inversa() {
		return new StringBuilder(cadena).reverse().toString();
	}

	public String toString() {
		return cadena.toString();
	}

	private boolean esConsonante(String cad) {
		for (int i = 0; i < consonants.length; i++) {
			if (cad.equalsIgnoreCase(consonants[i])) {
				return true;
			}
		}
		return false;
	}

	private boolean esVocal(String c) {
		return (c.equalsIgnoreCase("a")) || (c.equalsIgnoreCase("e")) || (c.equalsIgnoreCase("i"))
				|| (c.equalsIgnoreCase("o")) || (c.equalsIgnoreCase("u"));
	}
}