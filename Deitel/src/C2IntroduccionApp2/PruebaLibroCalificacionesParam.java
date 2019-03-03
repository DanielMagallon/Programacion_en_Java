package C2IntroduccionApp2;

import java.util.Scanner;

public class PruebaLibroCalificacionesParam 
	{


	

		public static void main(String[] args) 
				{
			
				Scanner input=new Scanner(System.in);
				
				// crea un objeto LibroCalificacionesParametro y lo asigna a miLibroCalificaciones
				LibroCalificacionesParam  miLibroCalificaciones=new LibroCalificacionesParam (); 
				
				// Pide y recibe el nombre del curso como entrada.
				System.out.println("Escribe el nombre del curso: ");
				String Nombrec=input.nextLine(); // Lee una linea de texto (nextLine)
				System.out.println(); // Imprime una linea en blanco.
				
				// Llama al metodo Mostrarmensaje de miLibroCalificaciones y pasa el nobre del curso (Historia) como argumento.
				miLibroCalificaciones.Mostrarmensaje(Nombrec);
				
				}
	
	}