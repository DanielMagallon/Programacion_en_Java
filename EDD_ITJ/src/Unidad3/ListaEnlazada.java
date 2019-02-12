package Unidad3;


@SuppressWarnings("unchecked")
public class ListaEnlazada<E>
{
	
	protected NodoLista<E> inicio,fin;
	private int size=0;
	// inicio 
	
	public void addFirst(E dato)
	{
		inicio = new NodoLista<>(dato,inicio);
		
		if(fin == null)
		{
			fin = inicio;
		}
		size++;
		
	}
	
	public void addFinal(E elemento)
	{
		if (!isEmpty())
		{
			fin.next=new NodoLista<>(elemento);
			fin=fin.next;
		}
		
		else
		{
			inicio=fin=new NodoLista<>(elemento);
		}
		
		size++;
	}
	

	public void agregar2Pos(E dato)
	{
		NodoLista<E> nuevo;
		
		nuevo = new NodoLista<>(dato);

		if(isEmpty())
		{
			inicio = fin = nuevo;
			
		}
		else if(fin == null)
		{
			fin.next = nuevo;
			fin = nuevo;
		}else
		{
			nuevo.next = inicio.next;
			inicio.next = nuevo;
		}
		
		size++;
	}
	
	
	public boolean isEmpty()
	{
		return inicio == null;
	}
	
	public void showList()
	{
		for(NodoLista<E> nodo = inicio; nodo!=null; nodo=nodo.next)
		{
			System.out.print(nodo+"->");
		}
		
		System.out.println();

	}
	
	
	@Override
	public String toString()
	{
		String x = "[";
		
		for(NodoLista<E> nodo = inicio; nodo!=null; nodo=nodo.next)
		{
			x+=nodo+",";
		}
		
		x+="]";
		
		return x;
	}
	
	public void showListPares()
	{
		System.out.println("Datos de las posciones pares de la lista");
		
		for(NodoLista<E> nodo = inicio; nodo!=null;)
		{
			System.out.print(nodo+"->");
			
			nodo = nodo.next;
			
			if(nodo!=null)
				nodo=nodo.next;
			
		}
		
		System.out.println();
	}
	
	public void addAt(int ind, E dato)
	{
		if(ind<0)
			return;
		
		
		if(isEmpty() || ind==0)
		{
			addFirst(dato);
			return;
		}
		
		if((size-1)<ind)
		{
			addFinal(dato);
		}
		else
		{
			NodoLista<E>  nuevo = new NodoLista<>(dato);
			
			NodoLista<E> aux=inicio, ant=null;
			
			for(int i=0; i<ind && aux!=null; i++)
			{
				ant = aux;
				aux = aux.next;
			}
			
			if(aux!=null)
			{
				ant.next = nuevo;
				nuevo.next = aux;
			}
			
			size++;
		}
			
	}
	
	public E deleteFirst()
	{
		if(!isEmpty())
		{
			E dato = inicio.dato;
			
			if(inicio == fin)
				inicio = fin = null;
			
			else
				inicio = inicio.next;
			
			size--;
			
			return dato;
		}
		
		return (E) "La lista esta vacia, no hay elementos por borrar";
	}
	
	public E deleteLast()
	{
		if(!isEmpty())
		{
			E dato=null;
			
			if(inicio == fin)
			{
				dato = inicio.dato;
				inicio = fin = null;
			}
			
			else
			{
				dato=fin.dato;
				
				NodoLista<E> temp=inicio;
				
				while(temp.next!=fin)
					temp = temp.next;
				
				fin=temp;
				fin.next=null;
			}
			
			size--;
			
			return dato;
		}
		
		return (E) "La lista esta vacia, no hay elementos por borrar";
	}
	
	public E deletAt(int ind)
	{
		if(ind<0 || (ind>size-1))
			return (E) "Error: Indices fuera del tamaño de la lista";
		
		if(!isEmpty())
		{
			if(ind==0)
				return deleteFirst();
			
			if(ind == size-1)
				return deleteLast();
			
			NodoLista<E> temporal=inicio.next, anterior=inicio;
			
			for(int i=1; i<ind; i++)
			{
				anterior=temporal;
				temporal=temporal.next;
			}
			
			anterior.next = temporal.next;
			E dato = temporal.dato;
			temporal=null;
			size--;
			
			return dato;
		}
		
		return (E) "La lista esta vacia, no hay elementos por borrar";
	}
	
	public boolean deleteElement(E element)
	{
		if(!isEmpty())
		{
			if(element==inicio.dato)
			{
				deleteFirst();
				return deleteElement(element) || true;
			}
			
			if(element == fin.dato)
			{
				deleteLast();
				return deleteElement(element) || true;
			}
			
			NodoLista<E> temporal=inicio.next, anterior=inicio;
			
			while(temporal!=fin && temporal.dato != element)
			{
				anterior=temporal;
				temporal=temporal.next;
			}
			
			if(temporal!=fin)
			{
				size--;
				anterior.next = temporal.next;
				temporal=null;
				return deleteElement(element) || true;
			}
		}
		
		return false;
	}
	
	public void agregarEnOrden()
	{
		
	}
	
	
	public int getSize(){
		return size;
	}
	
	public static void main(String[] args)
	{
		String x="Babosa";
		
		//Si es menor retorna -1, si es mayor 1, si es igual 0
		System.out.println(x.compareTo("Baboso"));
		
		ListaEnlazada<String> lista = new ListaEnlazada<>();
		
		lista.addFinal("Yeo");
		lista.addFinal("Juan");
		lista.addFinal("Pepe");
		lista.addFinal("Monica");
		lista.addFinal("Juan");
		lista.addFinal("Yeo");
		lista.addFinal("Mariana");
		lista.addFinal("Yeo");
		lista.addFinal("Yeo");
		lista.addFinal("Yeo");
		
		lista.showList();
		
		String el = "Yeo";
		System.out.printf("Delete %s? %b\n",el,lista.deleteElement(el));
		
		lista.showList();
	}

	boolean esIgual,esMenor,esMayor;
	
	public ListaEnlazada<E> compare(E dato, E dato2)
	{
		esIgual = esMenor = esMayor = false;
		
		if(dato instanceof String)
		{
			int val = dato.toString().compareTo(dato2.toString()); 
			
			if(val==0)
				esIgual = true;
			
			//if(val==1)
				
		}
		
		return this;
	}
	
	
	
	/*
	 * Metodo que agreggue elementos de manera ordenada
	 * Metodo que perimita eliinar un nodo de acuerdo a su valor, (tratar cuando tine elementos repetidos)
	 * Realizar una lista simple que trabaje como Pila
	 * "										" Cola
	 * Realizar un metodo que permitar eliminar el nodo de la 2pos
	 */
}

