package HelpClass;

import java.util.ArrayList;

public class Generico <T>
{
	private ArrayList<T> lista;
	
	public Generico()
	{
		lista=new ArrayList<T>();
	}
	
	public void add(T element)
	{
		lista.add(element);
	}
	
	public void get(int i)
	{
		System.out.println(lista.get(i));
	}
	
	public void getAll()
	{
		getAll(getSize()-1);
	}
	
	private void getAll(int i)
	{
		
		if(i==0)
		{
			System.out.println(lista.get(i));
		}
		
		else
		{
			System.out.println(lista.get(i));
			getAll(i-1);
		}
	}
	
	public int  getSize()
	{
		return lista.size();
	}
}
