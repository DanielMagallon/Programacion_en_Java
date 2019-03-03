package C19MethodClassGenerics;

import java.util.ArrayList;

public class Stack<T>
{
	private ArrayList<T> list;
	
	public Stack()
	{
		this(10);
	}
	
	public Stack(int capacity)
	{
		int initCapacity = capacity > 0 ? capacity : 10;
		list = new ArrayList<T>(initCapacity);
	}
	
	public void push(T element)
	{
		list.add(element);
	}
	
	public T pop() 
	{
		if(list.isEmpty())
			throw new EmptyStackException("Stack is empty, cannot pop.");
		
		return list.remove(list.size()-1);
	}
}
