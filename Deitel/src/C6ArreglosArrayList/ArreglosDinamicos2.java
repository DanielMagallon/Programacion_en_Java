package C6ArreglosArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ArreglosDinamicos2
{
	static Scanner lc = new Scanner(System.in);
	
	private static void usuaros()
	{
		ArrayList< Integer > enetro = new ArrayList<Integer>();
		
		int cont=1;
		do
		{
			System.out.print("inttroduzca un numero: ");
			int numero=lc.nextInt();
			enetro.add(numero);
			cont++;
		}
		while(cont<=5);
		
		System.out.println("\nSon: ");
		
		for (int i=0; i<0; i++)
		{
			System.out.println(enetro.get(i));
		}
	}
	
	public static void main(String[] args)
	{
		usuaros();
		
		Scanner lc = new Scanner(System.in);
		
		ArrayList< String > cadenas = new ArrayList<String>();
		ArrayList< Integer > enetro = new ArrayList<Integer>();
		
		System.out.println("Introduzca el nombre de los alumnos y su calificacion.\n"
				+ "Para terminar con los nombres introduzca una End"
				+ "\nPara terminar con las calificaciones introduzca un -1");
		
		String nombre,n="End";
		int cal,i;
		int cont=1,contnombre=1;
		
		
		do
		{
			System.out.printf ("\nIntroduzca el nombre del alumno %d:  ",contnombre);
			nombre=lc.next();
			
			i=nombre.compareTo(n);
			
			if (i != 0)
			{
				cadenas.add(nombre);
				contnombre++;
			}
			
		}
		while (i != 0);
		
		System.out.print ("\nHa introducido: " + cadenas.size () + " nombres");
		
		System.out.printf ("\nLas nombres introducidos fueron: ");
		System.out.println(cadenas);
		
		
		System.out.println("\nLos dos primeros nombres fueron: ");
		for (int z=0; z<2; z++)
		System.out.print (cadenas.get(z) + " ");
		
		System.out.println("\n");
		
		java.util.Iterator<String> it = cadenas.iterator();

        while(it.hasNext())

            System.out.println(it.next());
		
		do
		{
			
			
			System.out.printf ("\nIntroduzca su calificacion %d: ",cont);
			cal=lc.nextInt();
			
			
			if (cal != -1)
			{
				enetro.add(cal);
				cont++;
			}
			
		}
		while (cal != -1);
		
		System.out.print ("\nHa introducido: " + enetro.size () + " calificaciones");
		
		System.out.printf ("\nLas calificaciones introducidas son: ");
		System.out.print (enetro);
		
		System.out.println("\n");
		
		java.util.Iterator<Integer> it2 = enetro.iterator();

        while(it2.hasNext())

            System.out.println(it2.next());
		
	}
}
