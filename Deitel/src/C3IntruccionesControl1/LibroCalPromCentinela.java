package C3IntruccionesControl1;

import java.util.Scanner;

public class LibroCalPromCentinela {
	private String nombreDelCurso;

	public LibroCalPromCentinela(String nombre) {

		nombreDelCurso = nombre;
	}

	public void EstablecernombredelCurso(String nombre) {
		nombreDelCurso = nombre;

	}

	public String Obtenernombre() {
		return nombreDelCurso;
	}

	public void Mostrarmensaje() {
		System.out.printf("Bienvenido al Libro de Calificaciones para: %s¡\n",
				Obtenernombre());
	}

	public void determinarPromedio() {
		Scanner input = new Scanner(System.in);

		int total;
		int contadorCalif;
		int cal;
		double promedio;

		total = 0;
		contadorCalif = 0;

		System.out.println("Escriba la calficacion ó -1 para terminar: ");
		cal = input.nextInt();

		while (cal != -1) 
		{
			total = total + cal;
			contadorCalif = contadorCalif + 1;
			System.out.println("Escriba la calficacion ó -1 para terminar: ");
			cal = input.nextInt();
		}

		// fase de terminacion
		// si el usuario introdujo por lo menos una calif
		if (contadorCalif != 0) 
		{
			promedio = (double) total / contadorCalif; // para convertir de el
														// total de entero a
														// double se pone entre
														// parentesis double, o
														// al tipo que se quiera
														// convertir.
														// Por lo general esto
														// se
														// conoce como el
														// operador unario de
														// conversión de tipos

			// muestra el total y promedio (con digitos de precision)
			System.out.printf(
					"\nEl total de las %d calificaciones introducidas es %d\n",
					contadorCalif, total);
			System.out.printf("El promedio de la clase es: %.2f\n", promedio);

		} // fin de if

		else
			// no se introdujeron calif. por lo que imprime el mensaje apropiado
			System.out.println("No se introdujeron calificaciones");
	}
}
