package C2Evaluacion;

public class LibroCalifConstruc 
	{

			private String nombreDelCurso, nombreDelInstructor;
		
		public LibroCalifConstruc (String nombre, String nombrein)
		{
			
			nombreDelCurso = nombre;
			nombreDelInstructor = nombrein;
			
		}
		
			
		public void establecerNombreCurso (String nombre)
		{
		
			nombreDelCurso = nombre;

		}
		
		public void establecerNombreIns (String nombre)
		{
		
			nombreDelInstructor = nombre;

		}
			
		public String ObtenerNombreCurso ()
		{
			
			return nombreDelCurso;
			
		}
		
		public String ObtenerNombreIns ()
		{
			
			return nombreDelInstructor;
			
		}
		
		public void Mostrarmensaje ()
		{
		
		System.out.printf ("Bienvenido al libro de calificaciones para \n%s!\n Este curso es presentado por: %s\n", ObtenerNombreCurso(),ObtenerNombreIns());
		
		}
		
	}
