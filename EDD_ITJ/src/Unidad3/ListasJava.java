package Unidad3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Registro{
	
	String nombre;
	int edad;
	char sex;
	
	public Registro(String n, int e, char s)
	{
		nombre=n;
		edad = e;
		sex = s;
	}
	
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return String.format("%s - %d - %c\n", nombre,edad,sex);
	}
}

class porNombre implements Comparator<Registro>{
	
	@Override
	public int compare(Registro arg0, Registro arg1)
	{
		int res = arg0.nombre.compareToIgnoreCase(arg1.nombre);
		
		return res;
	}
	
	
}

public class ListasJava
{
	static void show(List<?> lista)
	{
		Iterator<?> it = lista.iterator();
		
		System.out.println(it);
		while(it.hasNext())
		{
			System.out.print(it.next()+" ");
		}
		
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> alist = new ArrayList<>();
		
		alist.add(3);
		alist.add(5);
		alist.add(6);
		alist.add(3);
		alist.add(7);
		alist.add(5);
		
		show(alist);
		
		LinkedList<Registro> linkList = new LinkedList<>();
		
		linkList.add(new Registro("Edgar", 10, 'M'));
		linkList.add(new Registro("Melody", 17, 'F'));
		linkList.add(new Registro("Jacki", 14, 'F'));
		linkList.add(new Registro("Luis", 12, 'M'));

		show(linkList);
		Collections.sort(linkList, new porNombre());
		show(linkList);
	}
}
