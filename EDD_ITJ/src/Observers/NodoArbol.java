package Observers;

public class NodoArbol
{
	int dato;
	NodoArbol hijoDerecho,hijoIzquierdo,padre;
	
	public NodoArbol(int dato)
	{
		this.dato=dato;
	}
	
	@Override
	public String toString()
	{
		return dato+"";
	}
}
