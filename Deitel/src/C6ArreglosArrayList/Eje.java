package C6ArreglosArrayList;

import java.util.ArrayList;

public class Eje
{
	public static void main(String[] args)
	{
		ArrayList<String> d = new ArrayList<>();
		
		d.add("Hola");
		d.add("Adios");
		
		d.remove(1);
		
		for (String f : d)
			System.out.println(f);
	}
}
