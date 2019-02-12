package LE_Repasos;


public class ListaEnlazada2App {

	public static void main(String[] args) 
	{
		ListaEnlazada2 lista = new ListaEnlazada2();
		
		System.out.printf ("Esta vacia: %b\n",lista.estaVacia());
		
		lista.addPrimero("Yeo");
		lista.addPrimero(20);
		lista.addPrimero("Hi¡ Everybody");
		lista.addPrimero(3);
		
		System.out.println ("Primer elemento: " + lista.obtener(0));
		System.out.println ("Ultimo elemento: " + lista.obtener(lista.size()-1));
		System.out.println ("Index 2: " +lista.obtener(2));
		
		System.out.println ("Esta vacia: "+lista.estaVacia());
		System.out.println ("Tamaño: "+lista.size());
	}
}
