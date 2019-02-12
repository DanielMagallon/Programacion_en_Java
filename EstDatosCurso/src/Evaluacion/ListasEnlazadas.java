package Evaluacion;

public class ListasEnlazadas 
{
	Node inicio,fin;
	int size;
	
	public ListasEnlazadas()
	{
		inicio=fin=null;
		size=0;
	}
	
	public boolean isEmpty()
	{
		return inicio==null;
	}
	
	public void addFirst(int fila, int columna)
	{
		inicio = new Node(fila, columna, inicio);
		
		if(fin==null)
			fin=inicio;
		
		size++;
	}
	
	public void addFinal(int fila, int columna)
	{
		if(!isEmpty())
		{
			fin.siguiente = new Node(fila, columna);
			fin = fin.siguiente; 
			// Este fin apuntaba anteriormente al penultimo nodo-->fin = fin.siguiente;
			// fin.siguinete --> El fin ahora apuntara al ultimo nodo insertado 
		}
		else
		{
			inicio = fin = new Node(fila, columna);
		}
		
		size++;
	}
	
	public String removeFirst()
	{
		int fila = inicio.fila;
		int columna = inicio.columna;
		
		if(inicio==fin)
			inicio=fin=null;
		
		else
			inicio = inicio.siguiente;
		
		size--;
		
		return "\nSe ha elimnado: ["+fila+","+columna+"]";
	}
	
	public String removeFinal()
	{
		int f = fin.fila;
		int col = fin.columna;
		
		if(inicio==fin)
			inicio=fin=null;
			
		else
		{
			Node temporal = inicio;
			
			while(temporal.siguiente != fin)
			{
				temporal = temporal.siguiente;
			}
			
			fin = temporal;
			fin = fin.siguiente = null;
			temporal = null;
		}
		size--;
		return "\nSe ha eleminado: ["+f+","+col+"]";
	}
	
	public void removeElement (int f, int col)
	{
		
	}
	
	public void removeElementIndexOf(int index)
	{
		
	}
	
	public void clear()
	{
		size=0;
		inicio = fin = null;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void showList() throws NullPointerException
	{
		if(!isEmpty())
		{
			Node advance = inicio;
			
			while(advance!=null)
			{
				System.out.printf ("[%d, %d]--->",advance.fila, advance.columna);
				advance = advance.siguiente;
			}
		}
		else
			throw new NullPointerException("The list is empty.\n");
	}
	
	public static void main(String[] args) 
	{
		ListasEnlazadas lista = new ListasEnlazadas();

		
		lista.addFinal(0,0);
		lista.addFinal(6,0);
		lista.addFinal(3,7);
		lista.addFirst(1,2);
		lista.addFirst(8,9);
		System.out.println("Size: "+lista.getSize());
		lista.showList();
		System.out.println(lista.removeFirst());
		lista.showList();
		System.out.println(lista.removeFinal());
		lista.showList();
		lista.clear();
		System.out.println("\nSe ha elimiando todo");
		System.out.println("Size: "+lista.getSize());
		lista.addFinal(3,0);
		lista.addFirst(1,1);
		lista.showList();
		System.out.println("\nSize: "+lista.getSize());
		lista.clear();
		lista.showList();
	}
}
