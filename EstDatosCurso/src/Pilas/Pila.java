package Pilas;

public class Pila
{
	private NodoPila cima;
	int tama;
	
	public Pila()
	{
		cima=null;
		tama=0;
	}
	
	//Metodo para saber cuando la lista esta vacia
	public boolean estaVacia()
	{
		return cima==null;
	}
	
	//Metodo para empujar un elemento
	public void push(int dato)
	{
		NodoPila nuevo = new NodoPila(dato);
		nuevo.siguiente=cima;
		cima=nuevo;
		tama++;
	}
	
	//Metodo para sacar un elemento
	public int pop()
	{
		int auxiliar=cima.dato;
		cima=cima.siguiente;
		tama--;
		
		return auxiliar;
	}
	
	//Metodo para saber quien esta en la cima
	public int cima()
	{
		return cima.dato;
	}
	
	//Metodo para saber el tamaño de la pila
	public int size()
	{
		return tama;
	}
	
	//Metodo para limpiar la Pila
	public void clean()
	{
		while(!estaVacia())
		{
			pop();
		}
	}
	
	//Metodo para mostrar elementos de la Pila
	public String displayAll()
	{
		NodoPila recorrer=cima;
		
		String ele="";
		
		while(recorrer!=null)
		{
			ele+=recorrer.dato + " ";
			recorrer=recorrer.siguiente;
		}
		
		return ele;
	}
}
