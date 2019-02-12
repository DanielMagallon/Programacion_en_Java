package LE_Repasos;

public class NodoMain 
{
	public static void main(String[] args) 
	{
		Nodo primer = new Nodo("Ejemplo");
		Nodo segundo = new Nodo (45);
		Nodo tercero = new Nodo ("Hola");
		
		primer.enlazarSiguiente(segundo);
		
		primer.obtenerSiguiente().enlazarSiguiente(tercero);
		
		System.out.printf (primer.obtenerSiguiente()
						   .obtenerSiguiente().toString());
		
	}
}
