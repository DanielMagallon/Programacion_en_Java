
package C4InstruccionControl2;

// La clase LibroCalificaciones usa la instruccion switch para contar las calificaciones de letras

import java.util.Scanner;

public class LibroCalificaciones_switch 
{
		private String nombreDelCurso;
		
		// las variables de instancia int se inicializan en 0 de manera prederteminada.
		private int total;
		private int contadorCalif;
		private int aCuenta;
		private int bCuenta;
		private int cCuenta;
		private int dCuenta; 
		private int fCuenta;
		
		// el constructor inicializa nombre del curso;
		public LibroCalificaciones_switch (String nombre)
		{
			nombreDelCurso = nombre;
		}
		
		public void establecerNombreDelCurso (String nombre)
		{
			nombreDelCurso = nombre; // almacena el nombre del curso
		}
		
		public String obtenerNombreDelCurso ()
		{
			return nombreDelCurso;
		}
		
		public void mostrarMensaje ()
		{
			System.out.printf (" Bienvenido al Libro de Calificaciones para\n%s!\n\n",obtenerNombreDelCurso());
		}
		
		// introduce un numero arbitrario de calificaciones del usuario 
		public void introducirCalif ()
		{
			Scanner lc = new Scanner(System.in);
			
			int calificacion;
			
			System.out.printf (" %s\n%s\n  %s\n  %s\n",
					" Escriba las calificaciones enteras en el rango de 0 a 100: ",
					" Escriba el indicador de fin de archivo para terminar la entrada: ",
					" En UNIX/LINUX/MAC OS X escriba <Ctrl> d y despues oprima intro.",
					" En Windows escriba <Ctrl> z y despues oprima intro.");
			
			// itera hasta que el usuario introduzca el indicador de fin de archivo
			while (lc.hasNext())
			{
				calificacion = lc.nextInt();
				total += calificacion;
				++contadorCalif;
				
				// llama al metodo para incrementar el contador apropiado
				incrementarContadorCalifLetra (calificacion);
			}
		}
		
		// suma 1 al contador apropiado para la calififacion esepecificada 
		private void incrementarContadorCalifLetra (int calificacion)
		{
			// determina cual calificacion se introdujo 
			switch (calificacion / 10)
			{
				case 9: //calificacion esta entre 90
				case 10: // y 100 inclusive
					++aCuenta; // incrementa aCuenta
				break; // necesaria para salir del switch 
				
				case 8: // calificacion esta entre 80 y 89
					++bCuenta; // incrementa bCuenta
				break; // 
				
				case 7: // calificacion esta entre 70 y 79
					++cCuenta; // incrementa cCuenta
				break; //
				
				case 6: // calificacion esta entre 60 y 69
					++dCuenta; // incrementa dCuenta
				break; //
				
				default: // calificacion es menor que 60
					++fCuenta;
				break;
			}
		}
		
		// muestra un reporte con base en las calificaciones introudcidas por el usuario
		public void mostrarReporteCalif ()
		{
			System.out.println ("\nReporte de Calificaciones: ");
			
		// si el usuario introudjo por lo menos una calificacion
			if (contadorCalif != 0)
			{
				double promedio = (double) total / contadorCalif;
				
			// imprime resumen de resultados 
				System.out.printf (" El total de las %d calificaciones introducidas es %d\n",
						contadorCalif,total);
				
				System.out.printf (" El promedio de la clase es %.2f\n",promedio);
				System.out.printf (" %s\n%s%d\n%s%d\n%s%d\n%s%d\n%s%d\n",
						" Numero de estudiantes que recibieron cada calificacion: ",
						" A: ", aCuenta, // muestra el numero de calificaciones A
						" B: ", bCuenta, // muestra el numero de calificaciones B
						" C: ", cCuenta, // muestra el numero de calificaciones C
						" D: ", dCuenta, // muestra el numero de calificaciones D
						" F: ", fCuenta); // muestra el numero de calificaciones F
			}
			
			else // no se introdujeron calificaciones, por lo que imprime el mensaje apropiado
				System.out.println (" No se introdujeron calificaciones");
				
		}
}
