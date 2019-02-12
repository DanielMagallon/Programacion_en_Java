package ListasEnlazadas;

public class Nodo
{
	public int dato;
	public Nodo siguiente;
	
	// Contructor para insertar al final
	public Nodo (int d)
	{
		this.dato=d;
		this.siguiente=null;
	}
	
	// Contructor para insertar al incio
	public Nodo(int d, Nodo n)
	{
		dato=d;
		siguiente=n;
	}
}
