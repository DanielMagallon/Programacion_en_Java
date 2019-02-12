package Ayuda;

public class Letras
{
	private char vec[] = new char[26];
	private int ind;
	
	public void guardar()
	{
		for(ind=0; ind<vec.length; ind++)
			vec[ind] =  (char) (65+ind);
	}
	
	public void mostrar()
	{
		System.out.println("Letras del vector: ");
		for(ind=0; ind<vec.length; ind++)
			System.out.println(ind + "{ "+vec[ind]+" }");
	}
}
