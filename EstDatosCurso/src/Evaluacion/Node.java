package Evaluacion;

public class Node 
{
	int fila,columna;
	Node siguiente;
	
	public Node(int f, int c)
	{
		fila=f;
		columna=c;
		siguiente=null;
	}
	
	public Node(int f, int c, Node n)
	{
		fila=f;
		columna=c;
		siguiente=n;
	}
}
