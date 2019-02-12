package Unidad1;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class ClaseVector 
{
	private int edad;
	private String nombre;
	
	public ClaseVector(String name, int edad) 
	{
		nombre = name;
		this.edad=edad;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
	
		return String.format("%s usted tiene %d años", nombre,edad);
	}
	
	public static void main(String[] args) 
	{
		Vector<ClaseVector> vector = new Vector<>();
		
		vector.addElement(new ClaseVector("Edgar", 19));
		vector.addElement(new ClaseVector("Pollo", 15));
		vector.addElement(new ClaseVector("Luis", 11));
		
		for(ClaseVector c : vector)
			System.out.println(c);
		
		Vector<Integer> vector2 = new Vector<>();
		
		vector2.addElement(1);
		vector2.addElement(15);
		vector2.addElement(8);
		
		for(int c : vector2)
			System.out.println(c);
		
		Vector<Object> objects = new Vector<>();
		
		objects.addElement(1);
		objects.addElement(new ClaseVector("Mariana", 23));
		objects.addElement("Hola");
		
		for(Object c : objects)
			System.out.println(c);
		
		Enumeration<Object> enums = objects.elements();
		
		System.out.println(enums.nextElement());
		System.out.println(enums.nextElement());
		System.out.println(enums.nextElement());
		
		Iterator<Integer> it = vector2.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
