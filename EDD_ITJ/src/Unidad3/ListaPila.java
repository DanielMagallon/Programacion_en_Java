package Unidad3;

public class ListaPila<E> extends ListaEnlazada<E>
{
	public void push(E dato)
	{
		super.addFinal(dato);
	}
	
	public E pop()
	{
		return super.deleteLast();
	}
	
	public E peek()
	{
		return super.fin.dato;
	}
	
	public static void main(String[] args)
	{
		ListaPila<Integer> pila = new ListaPila<>();
		//5 10 15 3 2
		pila.push(5);
		pila.push(10);
		pila.push(15);
		pila.push(3);
		pila.push(2);
		
		System.out.println(pila);
		System.out.println(pila.peek());
		System.out.println(pila.pop());
		System.out.println(pila);
		
	}
}
