package C3IntruccionesControl1;

import java.util.Scanner;

// La clase LibroCalPromedio que resuelve el problema del promedio usando la repeticion controlada por un contador.

public class LibroCalPromedio 
{
	private String nombreDelCurso;

	public LibroCalPromedio(String nombre) {
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

	// Determina el promedio de la clase, con base a las 10 calificaciones
	// introducidas por el usuario
	public void determinarPromedioClase() 
	{
		Scanner input = new Scanner(System.in);

		int total; // Suma de las calificaciones escritas por el usuario
		int contadorCalif; // Numero de la siguiente calificacion a introducir
		int cal; // valor de la calificacion escrita por el usuario
		int prom; // el promedio de las calificaciones

		// fase de inicializacion
		total = 0;
		contadorCalif = 1;

		while (contadorCalif <= 10) 
		{
			System.out.print("Escriba la califiacion: ");
			cal = input.nextInt(); // lee la calif del usuario
			total = total + cal; // suma la calif al total
			contadorCalif = contadorCalif + 1; // incrementa contador en 1
		}

		// fase de terminacion
		prom = total / 10;

		// muestra el total y el promedio de las calif
		System.out.printf("\nEl total de 10 calificacione es de: %d\n", total);
		System.out.printf("El promedio de la clase es: %d\n", prom);
	}
}
