package Unidad3;

import java.util.EmptyStackException;

public class PilaVectorChar
{
	private char vec[];
	private int pos;
	
	public PilaVectorChar(int size)
	{
		vec = new char [size];
		pos=-1;
	}
	
	public void push(char num)
	{
		try
		{
			vec[++pos]=num;
			System.out.println("Dato almacenado correctamente");
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Pila llena. No se pueden almacenar mas datos");
			--pos;
		}
	}
	
	public char peek() throws EmptyStackException
	{
		if(!isEmpty())
			return vec[pos];
		
		else throw new EmptyStackException();
	}
	
	public char pop()
	{
		char pop = vec[pos--];
		
		return pop;
	}
	
	public void limpiarPila()
	{
		while(pos!=-1)
		{
			pop();
		}
	}
	
	public void mostrarPila()
	{
		if(isEmpty())
			System.out.println("La Pila esta vacia, no se pueden mostrar elementos");
		
		else
		{
			System.out.println("Contenido de la pila: ");
			System.out.print("[");
			
			for(int i=0; i<=pos; i++)
			{
				if(i==pos)
					System.out.printf("%d]",vec[i]);
					
				else
				System.out.printf("%d, ",vec[i]);
			}
			
			System.out.println();
		}
	}
	
	public boolean isEmpty()
	{
		return pos==-1;
	}
	
	//Returna cuantos pop tengo que hacer para llegar al numero del parametro
	public int search(char element)
	{
		if(isEmpty())
			System.out.println("No hay elementos, no se puede hacer la busqueda");
		
		else
		{
			for(int i=0; i<=pos; i++)
			{
				if(vec[i]==element)
					return pos-i;
			}
			
			System.out.println("No existe en la pila: "+element);
		}
		
		
		return -1;
	}
	
	public boolean delete(char element)
	{
//		String num_pops = search(element); 
//		
//		if(num_pops==-1)
//			return false;
//		
//		else
//		{
//		}
		
		boolean enc=false;
		
		if(!isEmpty())
		{
			int i=0;
			
			while(!enc && i<=pos)
			{
				if(vec[i] == element)
					enc = true;
				
				i++;
			}
			
			if(enc)
			{
				for(; i<=pos; i++)
					vec[i-1] = vec[i];
				
				return true;
			}
			
			return false;
		}
		
		return false;
	}
}
