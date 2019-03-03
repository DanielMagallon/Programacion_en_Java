package C3IntruccionesControl1;
 
import java.util.Scanner;

// Analisis de los resultados de un examen, usando instrucciones de control anidadas.
/*
 * Los operadores de asignación compuestos abrevian las expresiones de asignación.Cualquier instrucción de la forma
 * variable = variable operador expresión; en donde operador es uno de los operadores binarios o %, 
 *  puede escribirse de la siguiente forma: variable operador expresión;
 *  Por ejemplo, se puede abreviar la instrucción c = c + 3; mediante el operador de asignación 
 *  compuesto de suma,+=, de la siguiente manera: c += 3;
 *  El operador += suma el valor de la expresión que está a  la derecha del operador, al valor de la variable 
 *  ubicada a la izquierda del operador,y almacena el resultado en la variable que se encuentra a la izquierda
 *  del operador. Por lo tanto,la expresión de asignación c += 3 suma 3 a c.
 */

public class Analisis {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int aprobados = 0;
		int reprobados = 0;
		int contEstudiantes = 1;
		int result;

		while (contEstudiantes <= 10) {

			System.out.print("Escriba el resultado (1 = Aprobado, 2 = Reprobado):");
			result = input.nextInt();

			if (result == 1)
				aprobados = aprobados + 1;
			// aprobados += 1;
			// ++aprobados;
			// aprobados++;

			else
				reprobados = reprobados + 1;
			// reprobados += 1;
			// ++reprobados;
			// reprobados++;

			contEstudiantes = contEstudiantes + 1;
			// contEstudiantes += 1;
			// ++contEstudiantes ;
			// contEstudiantes++;

		}

		System.out.printf("Aprobados: %d\n Reprobados: %d\n", aprobados,
				reprobados);

		if (aprobados > 8)
			System.out.println("Bono para el instructor!");
	}
}
