package Unidad3;

public class ColaCircular<E>
{
	E dato;
	int tamanio, inicio, fin;
	Object elements[];
	
	public ColaCircular(int tam)
	{
		tamanio = tam;
		elements = new Object[tam];
		inicio = fin = -1;
	}
	
	public void agregar(E dato)
	{
		if(!isFull())
		{
			if(isEmpty())
			{
				inicio = fin = 0;
				elements[fin] = dato;
			}
			else
			{
				fin++;
				
				if(fin == elements.length)
					fin = 0;
				
				elements[fin] = dato;
			}
		}
		else System.out.println("La cola esta llena");
		
	}
	
	public E quitar()
	{
		if(!isEmpty())
		{
			//Si hay un solo elemento
			E num = (E) elements[inicio];
			if(inicio == fin)
			{
				
				inicio = fin = -1;
			}
			else
			{
				inicio++;
				
				if(inicio == elements.length)
					inicio = 0;
			}
			
			return num;
		}
		
		return null;
	}
	
	int i;
	boolean mayor=true;
	public void mostrar()
	{
		if(!isEmpty())
		{
			System.out.println("Contenido de a fila: ");
			
			int ind = inicio;
			boolean salio=true;
			
			while(salio)
			{
				System.out.println(elements[ind]+" - ");
				ind++;
				
				if(ind == fin+1)
					salio = false;
				
				else if(ind == elements.length)
					ind = 0;
			}
		}
		else{
			System.out.println("Fila vacia");
		}
	}
	
	public boolean isFull()
	{
		if((fin+1 == elements.length && inicio==0) || (fin+1==inicio))
			return true;
		
		
		return false;
	}
	
	public boolean isEmpty()
	{
		return inicio == -1;
	}
	
	
	public static void main(String[] args)
	{
		ColaCircular<String> d = new ColaCircular<>(5);
		
		/*
		 * Al quitar elementos de una estructura (1,2) 
		 * |1| |2| |3| |4|-> | | | | |3| |4| = inicio = 3, fin = 4;
		 *  Al agrgar un elemeno (6)
		 *  |6| | | |3| |4|->  inicio = 3, fin=6;
		 */
		
		d.agregar("1");
		d.agregar("2");
		d.agregar("3");
		d.agregar("4");
		
		d.mostrar();
		
		d.quitar();
		d.quitar();
		
		d.mostrar();
		d.agregar("6");
		
		d.mostrar();
		
		d.agregar("99");
		d.mostrar();
	}
}
