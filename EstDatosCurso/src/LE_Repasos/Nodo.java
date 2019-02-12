package LE_Repasos;

public class Nodo 
{
	Object valor;
	Nodo siguiente;
	
	public Nodo (Object valor)
	{
		this.valor=valor;
		this.siguiente=null;
	}
	
	public void enlazarSiguiente(Nodo n)
	{
		siguiente=n;
	}
	
	public Nodo obtenerSiguiente()
	{
		return siguiente;
	}
	
	public Object obtenerValor()
	{
		return valor;
	}
}
