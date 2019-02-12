package Evaluacion;

public class ListaEnlazada
{
	
	protected NodoLista inicio,fin,auxiliar;
	
	public ListaEnlazada()
	{
		inicio = fin = null;
	}
	
	public void addFirst(char dato)
	{
		inicio = new NodoLista(dato,inicio);
		
		if(fin == null)
		{
			fin = inicio;
		}
		
	}

	public boolean isEmpty()
	{
		return inicio == null;
	}
	
	public void show()
	{
		for(NodoLista nodo = inicio; nodo!=null; nodo=nodo.next)
		{
			System.out.print(nodo+"->");
		}
		
		System.out.println();

	}
	
	private boolean llegoFin;
	
	public void insertarNumero(char num)
	{
		if(!llegoFin)
		{
			NodoLista  nuevo,temp;
			
			nuevo = new NodoLista(num);
			
			if(auxiliar == null)
			{
				auxiliar = inicio;
			}
			
			else if(auxiliar == fin)
			{
				fin.next = nuevo;
				fin = fin.next;
				llegoFin = true;
				return;
			}
			
			temp = auxiliar.next;
			auxiliar.next = nuevo;
			nuevo.next = temp;
			
			auxiliar = auxiliar.next.next;
		}
		else System.out.println("Ya no es posible agregar el elemento: "+num);
	}
	
	public void eliminarConsonantes()
	{
		char consonantesLista[] = {'b','c','d','f','g'};
		
		for(char c : consonantesLista)
			deleteElement(c);
	}
	
	public void deleteFirst()
	{
		if(!isEmpty())
		{
			if(inicio == fin)
				inicio = fin = null;
			
			else
				inicio = inicio.next;
		}
		
	}	
	
	public void deleteElement(char element)
	{
		if(!isEmpty())
		{
			if(element==inicio.dato)
			{
				deleteFirst();
				return;
			}
			
			NodoLista temporal=inicio.next, anterior=inicio;
			
			while(temporal!=fin && temporal.dato != element)
			{
				anterior=temporal;
				temporal=temporal.next;
			}
			
			if(temporal!=fin)
			{
				anterior.next = temporal.next;
				temporal=null;
			}
		}
	}
	
	
	
	public static void main(String[] args)
	{
		ListaEnlazada lista = new ListaEnlazada();
		
		char letras[] = {'a','b','c','d','e','f','g','h','i','j','k'};
		char numeros[] = {'1','2','3','4','5','6','7','8','9','0','\"','?'};
		
		for(char c : letras)
			lista.addFirst(c);

		System.out.println("\nElementos de la lista (vocales y consonantes): ");
		lista.show();
		
		for(char n : numeros)
			lista.insertarNumero(n);
		
		System.out.println("\nNuevos elementos de la lista (numeros):");
		lista.show();
		
		System.out.println("\nEliminando consonantes");
		lista.eliminarConsonantes();
		lista.show();
			
	}
}

