package C6ArreglosArrayList;

import java.util.Scanner;

public class MetodoToString
{
	static String descripcion;
	static String jugador;
	
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		
		
		System.out.print ("Escriba el nombre del jugador: ");
		jugador=lc.nextLine();
		
		System.out.print ("\nEscriba una descripicion: ");
		descripcion=lc.nextLine();
		
		System.out.printf ("%s ", new MetodoToString());
		
		
	}
	
	public  String toString ()
	{
		return jugador + "vale" + descripcion;
	}
}
