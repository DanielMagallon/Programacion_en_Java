package Unidad3;

public class ListaDoble<E>
{
	public NodoDoble<E> inicio,fin;

	public int size;
	
	public void addFirst(E dato)
	{
		if(isEmpty())
			inicio = fin = new NodoDoble<E>(dato);
		
		else
		{
			inicio = new NodoDoble<E>(dato,inicio,null);
			inicio.next.before=inicio;
		}
		
		size++;
	}
	
	
	public void addLast(E dato)
	{
		if(isEmpty())
		{
			inicio = fin = new NodoDoble<E>(dato);
			
		}
		
		else
		{
			fin = new NodoDoble<E>(dato,null,fin);
			fin.before.next = fin;
		}
		
		size++;
	}
	
	
	public void show()
	{
		for(NodoDoble<E> node=inicio; node!=null; node=node.next)
		{
			System.out.print(node.dato+"->");
		}
		
		System.out.println();
	}

	public E deleteLast()
	{
		if(!isEmpty())
		{
			E dato;
			if(inicio==fin)
			{
				dato = inicio.dato;
				inicio=fin=null;
			}
			
			else
			{
				dato = fin.dato;
				fin = fin.before;
				fin.next=null;
			}
			
			size--;
			return dato;
		}
		
		return (E) "No hay elemento en la lista";
	}
	
	public E deleteFirst()
	{
		if(!isEmpty())
		{
			E dato = inicio.dato;
			
			if(inicio==fin)
			{
				inicio=fin=null;
				return dato;
			}
			
			else
			{
				inicio = inicio.next;
				inicio.before=null;
			}
			
			size--;
			return dato;
		}
		
		return (E) "No hay elemento en la lista";
	}
	
	public boolean deleteAt(int ind)
	{
		if(ind<0 || ind>size-1)
		{
			System.out.println("Indice fuera de rango: "+ind);
			return false;
		}
		
		if(ind==0)
		{
			deleteFirst();
			return true;
		}
		
		if(ind==size-1)
		{
			deleteLast();
			return true;
		}
		
		NodoDoble<E> aux=inicio.next;
		
		for(int i=1; i<ind; i++,aux = aux.next);
		
		aux.before.next = aux.next;
		aux.next.before = aux.before;
		
		size--;
		
		return true;
	}
	
	public void showReverse()
	{
		for(NodoDoble<E> node=fin; node!=null; node=node.before)
		{
			System.out.print(node.dato+"->");
		}
		
		System.out.println();
	}
	
	public boolean isEmpty()
	{
		return inicio==null;
	}
	
	
	public static void main(String[] args)
	{
		ListaDoble<String> listaD = new ListaDoble<>();
		
		listaD.addLast("Luis");
		listaD.addLast("Peña");
		listaD.addLast("Ja");
		listaD.addLast("WOw");
		listaD.addLast("Do");
		listaD.addLast("Re");
		listaD.addLast("Mi");
		listaD.show();
		
		
		listaD.show();
	}
}
