package Pilas;

public class PilaEstatica
{
	int vectorPila[];
	int cima;
	
	public PilaEstatica(int tamanio)
	{
		vectorPila=new int[tamanio];
		cima=-1;
	}
	
	//Metodo push (empujar un elemento en la pila)
	public void push (int dato)
	{
		cima++;
		vectorPila[cima]=dato;
	}
	
	//Metodo pop (sacar un objeto/numero)
	public int pop()
	{
		int fuera=vectorPila[cima];
		cima--;
		
		return fuera;
	}
	
	//Metodo para saber si la lista esta vacia
	public boolean estaVacia()
	{
		return cima==-1;
	}
	
	//Metodo para saber si la pila esta llena
	public boolean estaLlena()
	{
		return vectorPila.length-1==cima;
	}
	
	//Metodo para saber que elemento se encuntra en la cima
	public int cimaPila()
	{
		return vectorPila[cima];
	}
	
	//Metodo ´para saber el tamanio de la pila
	public int tamanioPila()
	{
		return vectorPila.length;
	}
	
	//Metodo para mostrar los datos de la pila
	public String mostrarPila()
	{
		String pila="";
		
		for (int i=0; i<=cima; i++)
		{
			pila += Integer.toString(vectorPila[i]) + " ";
		}
		
		return pila;
	}
	
	public void limpiarPila()
	{
		while(cima!=-1)
		{
			pop();
		}
	}
}
