package C6ArreglosArrayList;

public class PruebaLibroCalificacionesArregloBidimensional
{
	public static void main(String[] args)
	{
		int [][] arregloCalif = {{87,96,70},
								 {68,87,90},
								 {94,100,90},
								 {100,81,82},
								 {83,65,85},
								 {78,87,65},
								 {85,75,83},
								 {91,94,100},
								 {76,72,84},
								 {87,93,73}};
		
		LibroCalificacionesArregloBidimensional milibro=  new LibroCalificacionesArregloBidimensional(
				"CS101 Introduccion a la programacion en Java", arregloCalif);
		
		milibro.mostrarMensaje();
		milibro.procesarCalificaciones();
		
	}
}
