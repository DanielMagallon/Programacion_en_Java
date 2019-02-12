package ArbolesBinarios;

public class NodoArbol
{
	int dato;
	String nombre;
	NodoArbol hijoIzquierdo;
	NodoArbol hijoDerecho;
	
	public NodoArbol(int d, String nom)
	{
		dato=d;
		nombre=nom;
		hijoIzquierdo=null;
		hijoDerecho=null;
	}
	
	
	public String toString()
	{
		return nombre + " su dato es " + dato;
	}
}
