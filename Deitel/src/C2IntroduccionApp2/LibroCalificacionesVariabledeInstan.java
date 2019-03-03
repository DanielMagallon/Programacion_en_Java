package C2IntroduccionApp2;



// Clase  LibroCalificacionesVariabledeInstan que contiene una variable de intancia NombreCurso
// y metodos para establecer y obtener su valor.
/* La palabra clave private es un modificador de acceso. Las variables o los métodos declarados 
* con el modificador de acceso private son accesibles sólo para los métodos 
* de la clase en la que se declaran. Así,la variable nombreDelCurso sólo puede utilizarse en los métodos
*establecerNombreDelCurso,obtenerNombreDelCurso y mostrar Mensaje de (cada objeto de) la
* clase LibroCalificaciones.
*/

public class LibroCalificacionesVariabledeInstan 
	{

			private String nombreDelCurso; // nombre del curso para este LibroCalificaciones (VariabledeInstan) 
											// Declaracion para una variable de instancia
			
			
			// método para establecer el nombre del curso
				public void establecerNombredelCurso (String nombre)
					{
				nombreDelCurso = nombre; // Almacena el nombre del curso
					}
				// Fin del metodo establecerNombredelCurso
				
				// Metodo para obtener el el nombre del curso
				public String obtenerNombredelCurso()
						{
							return nombreDelCurso;
							
						} // Fin del metodo obtenerNombredelCurso
				
				// muestra un mensaje de Bienvenida al usuario LibroCalificaciones (VariabledeInstan) 
				public void Mostrarmensaje ()
				{
					
					// Esta instruccion llama a obtenerNombredelCurso para obtener el
					// nombre del curso que representa este LibroCalificaciones (VariabledeInstan) 
					
					System.out.printf ("Bienvenido al libro de calificaciones para \n%s!\n", obtenerNombredelCurso());	
				
				} // Fin del metodo Mostrarmensaje		
	} // Fin de la Clase
