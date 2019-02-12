package Unidad3;

public class NodoLista<E>
{
	public NodoLista<E> next;//,before;
	public E dato;
	//https://sites.google.com/view/estdatjiq
	
	public NodoLista(E dato, NodoLista<E> puntero)
	{
		this.dato = dato;
		next = puntero;
	}

	public NodoLista(E dato)
	{
		this.dato = dato;
		next = null;
	}
	
	@Override
	public String toString()
	{
		return dato+"";
	}
}
