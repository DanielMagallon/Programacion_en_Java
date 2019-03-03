package C7ClasesObjetos;

public class EmpleadoStatic
{
	private String primerNombre;
	private String apellidoPaterno;
	private static int cuenta=0; // numero de objetos empleado creado
	
	// inicializa empleado , suma 1 a la variable static cuenta e
	// imprime objeto String que indica que se llamo al constructor
	
	public EmpleadoStatic (String nombre, String apellido)
	{
		primerNombre=nombre;
		apellidoPaterno=apellido;
		
		++cuenta; // incremeneta la variable static cuenta de empleados
		System.out.printf ("Constructor de empleado: %s %s; cuenta=%d\n",
				primerNombre,apellidoPaterno,cuenta);
	}
	
	public String obtenerNombre ()
	{
		return primerNombre;
	}
	
	public String obtenerApellido ()
	{
		return apellidoPaterno;
	}
	
	// metodo static para obtener el valor de la variable static cuenta
	public static int obtenerCuenta ()
	{
		return cuenta;
	}
}