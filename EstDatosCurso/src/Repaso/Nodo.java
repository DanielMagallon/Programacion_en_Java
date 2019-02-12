package Repaso;

public class Nodo {

	private int index;
	private String dato;
	public Nodo next;
	
	public Nodo (int ind, String x)
	{
		dato=x;
		index=ind;
		next=null;
	}
	
	public Nodo(int ind, String x, Nodo node)
	{
		dato=x;
		index=ind;
		next=node;
	}
	
	public void mostrarDatos()
	{
		System.out.printf("%d: %s -> ",index,dato);
	}
}
