package Unidad3;

public class NodoDoble<E>
{
	public NodoDoble<E> next,before;
	public E dato;
	
	public NodoDoble(E dato, NodoDoble<E> sig, NodoDoble<E> ant)
	{
		this.dato = dato;
		next = sig;
		before = ant;
	}
	
	public NodoDoble(E dato)
	{
		this(dato,null,null);
	}
}
