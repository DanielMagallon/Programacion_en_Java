package C7ClasesObjetos;

public class PruebaTiempo1
{
	public static void main(String[] args)
	{
		Tiempo1 tiempo = new Tiempo1();
		
		// imprime representaciones de cadena del tiempo
		System.out.print ("La hora universal inicial es: ");
		System.out.println(tiempo.aStringUniversal());
		
		System.out.print ("La hora estandar inicial es: ");
		System.out.println(tiempo.toString());
		
		System.out.println();
		
		// modifica el tiempo e imprime el tiempo actualizado
		tiempo.establecerTiempo(13, 27, 6);
		System.out.print ("La hora universal despues de establecerTiempo es: ");
		System.out.println(tiempo.aStringUniversal());
		System.out.print ("La hora estandar despues de establecerTiempo es: ");
		System.out.println(tiempo.toString());
		System.out.println();
		
		// intenta establcer tiempo con valores invalidos 
		try 
		{
			tiempo.establecerTiempo(99,99,99); // todos los valores fueras de rango
		}
		
		catch (IllegalArgumentException e)
		{
			System.out.printf ("Excepcion: %s\n\n",e.getMessage());
		}
		
		// muestra el tiempo depsues de establecer valores invalidos 
		System.out.println("Despues de intentar ajuste invalidos:");
		System.out.print ("Hora Universal: ");
		System.out.println(tiempo.aStringUniversal());
		System.out.print ("Hora estandar: ");
		System.out.println(tiempo.toString());
	}
}
