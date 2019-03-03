package C2IntroduccionApp2;

// El constructor de LibroCalificacionesConstruc se utiliza para
// especificar el nombre del curso cada vez que se crea cada objeto LibroCalificaciones.


public class PruebaLibroCalificacionesConstruc 

		{
			
			public static void main(String[] args) 
				{
				
				// crea objeto LibroCalificaciones 
		LibroCalificacionesConstruc libroCalificaciones1 = new LibroCalificacionesConstruc ("CS101 Introduccion"
				+ "a la programacion en Java");
				
		LibroCalificacionesConstruc libroCalificaciones2 = new LibroCalificacionesConstruc ("CS102 Estructura de"
				+ "datos en Java");
				
				// muestra el valor inicial de nombreDelCusro para cada LibroCalificacionesConstruc
			System.out.printf ("El nombre del curso de libroCalificaciones1 es: %s\n",
					libroCalificaciones1.obtenerNombredelCurso());
		
			System.out.printf ("El nombre del curso de libroCalificaciones2 es: %s\n",
					libroCalificaciones2.obtenerNombredelCurso());
			
				} // fin de main
		} // fin de la clase
