package Unidad4;

public class NodoArbol
{
	String dato;
//	int val;
	NodoArbol hijoDerecho,hijoIzquierdo,padre;
	
	public NodoArbol(String dato)//, int val)
	{
		this.dato=dato;
		//this.val=val;
	}
	
	@Override
	public String toString()
	{
		return dato;
	}
}
