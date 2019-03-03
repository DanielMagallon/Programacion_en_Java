package C6ArreglosArrayList;

import java.util.ArrayList;

public class ColeccionArrayList
{
	public static void main(String[] args)
	{
		// crea un nuevo objeto ArrayList  de objetos String con una capacidad inicial de 10
			ArrayList< String > elementos =  new ArrayList< String >();
		
			elementos.add("rojo"); // adjunta un elemento a la lista
			elementos.add(0,"amarillo"); // inserta el valor en el subinidice 0
			
		// encabezado
			System.out.print ("Mostrar contenido de la lista con ciclo controlado por contador:");
			
		// muestra los colores en la lista 
			for (int i = 0; i < elementos.size(); i++)
				System.out.printf (" %s",elementos.get(i));
			
		// muestra los colores usando foreach en el metodo mostrar 
			mostrar(elementos,
					"\nMostrar contenido de lista con instruccion for mejorada:");
			
			elementos.add( "verde" ); // agrega verde al final de la lista
 			elementos.add ( "amarillo" ); // agrega amarillo al final de la lista
 			mostrar (elementos,"Lista con dos nuevos elementos:");
 			
 			elementos.remove("amarillo"); // elimina el primer amarillo
 			mostrar (elementos,"Eliminar primaria instancia de amarillo");
 			
 			elementos.remove(1);
 			mostrar(elementos, "Eliminar segundo elemento de la lista (verde): ");
 			
 			// verifica si hay un valor en la lista
 			System.out.printf ("\"rojo\" %sesta en la lista\n",
 					elementos.contains("rojo") ? "" : "no ");
 			
 			// muestra el numero de elementos en la lista 
 			System.out.printf ( "Tamanio: %s\n",elementos.size());
	}
	
	public static void mostrar (ArrayList < String > elementos, String encabezado)
	{
		System.out.print (encabezado);
		
		for (String elemento : elementos)
			System.out.printf (" %s",elemento);
		
		System.out.println();
	}
}
