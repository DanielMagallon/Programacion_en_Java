package Evaluacion;

public class NodoLista
{
	public NodoLista next;
	public char dato;
	
	public NodoLista(char dato, NodoLista puntero)
	{
		this.dato = dato;
		next = puntero;
		
	}

	public NodoLista(char dato)
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
