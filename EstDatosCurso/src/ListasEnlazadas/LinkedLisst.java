package ListasEnlazadas;

import java.util.LinkedList;

public class LinkedLisst
{
	static LinkedList lista;
	
	public static void main(String[] args)
	{
		lista=new LinkedList();
		
		lista.add(10);
		lista.add(50);
		lista.add(30);
		lista.add(40);
		lista.add(20);
		
		displayList();
		lista.remove(2);
		displayList();
		lista.add(3,100);
		displayList();
	}
	
	private static void displayList()
	{
		int tamanio=lista.size();
		int i=0;
		
		while(i<tamanio)
		{
			System.out.print("["+lista.get(i)+"]->");
			i++;
		}
		System.out.println();
	}
}
