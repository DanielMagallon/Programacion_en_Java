package Unidad3;

import java.util.LinkedList;
import java.util.Queue;

public class ListaCola<E> extends ListaEnlazada<E>
{
	public void offer(E dato)
	{
		super.addFinal(dato);
	}
	
	public E poll()
	{
		return super.deleteFirst();
	}
	
	public E peek()
	{
		return super.inicio.dato;
	}
	
	public static void main(String[] args)
	{
		ListaCola<Integer> cola = new ListaCola<>();
		
		cola.offer(1);
		cola.offer(2);
		cola.offer(3);
		cola.offer(4);
		cola.offer(5);
		
		System.out.println(cola.peek());
		
		Queue<Integer> c = new LinkedList<>();
		
		c.offer(1);
		c.offer(2);
		c.offer(3);
		c.offer(4);
		c.offer(5);
		
		System.out.println(c.peek());
	}
}
