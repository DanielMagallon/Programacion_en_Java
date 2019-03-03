package C2IntroduccionApp2;

// La clase Libro Calificaciones con un constructor  para inicializar el nombre del curso.

public class LibroCalificacionesConstruc 
	{

		private String nombreDelCurso; // nombre del curso para este LibroCalificaciones (Construc) 
	
		
		// el constructor inicializa nombreDelcusro con un argumento String. 
	public LibroCalificacionesConstruc (String nombre) // el nombre del constructor es el nombre de la clase.
			{
			
		nombreDelCurso = nombre; // inicializa nombreDelCurso.
			
			} // fin del constructor
		
			// metodo para establecer el nombre del curso.
		public void establecerNombredelCurso (String nombre)
			{
			
			nombreDelCurso = nombre; // almacena el nombre del curso.
			
			} // fin del metodo establecer establecerNombredelCurso 
		
			// metodo para obtener el nombre del curso.
		public String obtenerNombredelCurso()
			{
			
				return nombreDelCurso;
			
			} // fin del metodo obtenerNombredelCurso()
	
			// muestra un mensaje de bienvenida al usuario 
		public void Mostrarmensaje ()
			{
			
			// esta intruccion llama a obtenerNombredelCurso para obtener el nombre del curso 
			// que este LibroCalificacionesConstruc representa
			System.out.printf ("Bienvenido al libro de calificaciones para \n%s!\n", obtenerNombredelCurso());
			
			} // fin del metodo Mostrarmensaje
		
	} // fin de la clase
