package C6ArreglosArrayList;

public class PruebaLibroCalificacionesArreglos
{
	public static void main(String[] args)
	{
		int [] arregloCalif = {87,68,94,100,83,78,85,91,76,87};
		
		LibroCalificacionesArreglos mil =  new LibroCalificacionesArreglos(
				"CS101 Introduccion a la programacion en Java",arregloCalif);
		
		mil.mostrarMensaje();
		mil.procesarCalificaciones();
	}
}
