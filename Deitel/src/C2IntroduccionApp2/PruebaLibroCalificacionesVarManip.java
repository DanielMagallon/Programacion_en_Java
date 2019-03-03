package C2IntroduccionApp2;

// Crea y manipula un objeto LibroCalificaciones (VariabledeInstan) 

import java.util.Scanner;

public class PruebaLibroCalificacionesVarManip 
	{

			// El metodo main empieza la ejecucion del programa.
		public static void main(String[] args) 
			{
			
			Scanner input=new Scanner(System.in);
			
			// Crea un objeto LibroCalificaciones (VariabledeInstan) y lo asigna a 
			LibroCalificacionesVariabledeInstan miLibroCalificaciones = new LibroCalificacionesVariabledeInstan();
			
			// Muestra el valor inicial del nombreDelCurso 
				System.out.printf ("El nombre inicial del cusro es: %s\n\n", miLibroCalificaciones.obtenerNombredelCurso());
			
			// Pide y lee el nombre del curso
				System.out.println("Escribe el nombre del curso: ");
				String Elnombre = input.nextLine();
				miLibroCalificaciones.establecerNombredelCurso (Elnombre); // Establece el nombre del curso
				
				System.out.println(); // Imprime una linea en blanco
				
				miLibroCalificaciones.Mostrarmensaje();
			
			}
	
	}	
