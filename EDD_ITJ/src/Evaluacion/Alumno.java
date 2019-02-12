package Evaluacion;

public class Alumno extends Escuela
{
	int[] clave,promedio;
	String nombreMateria[];
	
	@Override
	public void leer()
	{
		super.leer();
		clave = new int[numeroMaterias];
		promedio = new int[numeroMaterias];
		nombreMateria = new String[numeroMaterias];
		
	}
	
	public void leerMaterias()
	{
		
	}
	
	
}
