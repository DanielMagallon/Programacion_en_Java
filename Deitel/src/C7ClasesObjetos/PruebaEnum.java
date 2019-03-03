package C7ClasesObjetos;

import java.util.EnumSet;

public class PruebaEnum
{
	public static void main(String[] args)
	{
		System.out.println("Todos lo libros:\n");
		
		// imprime todos los libro en enum libro
		for (LibroEnum libro : LibroEnum.values())
			System.out.printf ("%-10s%-45s%s\n",
					libro,libro.obtenerTitulo(),libro.obtenerAnio());
		
		System.out.println("\nMostrar un rango de constantes enum:\n");
		
		// imprime los priemros cuatros libros
		
		for (LibroEnum libro : EnumSet.range(LibroEnum.JHTP,LibroEnum.CPPHTP))
			System.out.printf ("%-10s%-45s%s\n",
					libro,libro.obtenerTitulo(),libro.obtenerAnio());
	}
}
