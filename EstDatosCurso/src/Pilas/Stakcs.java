package Pilas;

import java.util.Stack;

public class Stakcs
{
	static Stack pila;
	
	public static void main(String[] args)
	{
		pila = new Stack();
		
		System.out.println("La pila esta vacia? "+pila.isEmpty());
		pila.push(10);
		pila.push(20);
		pila.push(30);
		pila.push(40);
		pila.push(50);
		
		System.out.println("Tamaño de la pila: "+pila.size());
		System.out.println ("La cima es: "+pila.peek());
		System.out.println("Sacando a un elemnto de la Pila: "+pila.pop());
		System.out.println("Sacando a un elemnto de la Pila: "+pila.pop());
		System.out.println("Tamaño de la pila: "+pila.size());
		System.out.println("La pila esta vacia? "+pila.isEmpty());
	}
}
