package Unidad3;

import java.util.EmptyStackException;

public class PilaVector
{
	private int vec[];
	private int pos;
	
	public PilaVector(int size)
	{
		vec = new int [size];
		pos=-1;
	}
	
	public void push(int num)
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
	
	public int peek() throws EmptyStackException
	{
		if(!isEmpty())
			return vec[pos];
		
		else throw new EmptyStackException();
	}
	
	public int pop()
	{
		int pop = vec[pos--];
		
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
	public int search(int element)
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
	
	public int size()
	{
		return pos;
	}
	
	public boolean delete(int element)
	{
//		int num_pops = search(element); 
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
				
				vec[pos] = 0;
				pos--;
				return true;
			}
			
			return false;
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{
		PilaVector p = new PilaVector(5);
		
		p.push(1);
		p.push(2);
		p.push(3);
		p.push(4);
		p.push(5);
		
		p.mostrarPila();
		System.out.println(p.pop());
//		PilaVector pv = new PilaVector(3);
//		
//		System.out.println("La pila esta vacia? "+pv.isEmpty());
//
//		try
//		{
//			System.out.println("Elemento de la cima: "+pv.peek());
//		}
//		catch(EmptyStackException e)
//		{
//			System.out.println("La pila esta vacia, no se puede mostrar la cima");
//		}
//		
//		pv.push(1);
//		
//		System.out.println("Elemento de la cima: "+pv.peek());
//		
//		pv.push(2);
//		pv.push(3);
//		
//		System.out.println("Elemento de la cima: "+pv.peek());
//		
//		pv.push(4);
//		pv.push(10);
//		
//		System.out.println("Elemento de la cima: "+pv.peek());
//		
//		pv.mostrarPila();
//		
//		System.out.println("Elemento fuera: "+pv.pop());
//		
//		pv.mostrarPila();
//		
//		System.out.println("Elemento fuera: "+pv.pop());
//		System.out.println("Elemento fuera: "+pv.pop());
//		
//		pv.mostrarPila();
//		
//		pv.push(10);
//		pv.push(5);
//		pv.mostrarPila();
//		
//		pv.limpiarPila();
//		pv.mostrarPila();
//		
//		pv.push(10);
//		pv.push(5);
//		pv.mostrarPila();
//		
//		System.out.println("La pila esta vacia? "+pv.isEmpty());
//		
//		System.out.println("Elimanddo 5..."+pv.delete(5));
//		
//		pv.mostrarPila();
	}
}
