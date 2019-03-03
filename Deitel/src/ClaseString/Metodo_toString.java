package ClaseString;

import java.util.Scanner;


public class Metodo_toString
{
	private String nombre;
	private int edad;
	
	public String toString ()
	{
		return nombre + " tiene " + edad + " años de edad";
	}
	
	public Metodo_toString (String nom, int e)
	{
		nombre=nom;
		edad=e;
	}
	
	public static void main(String[] args)
	{
		Metodo_toString mt1 = new Metodo_toString("Daniel",16);
		Metodo_toString mt2 = new Metodo_toString("Luis", 17);
		Metodo_toString mt3 = new Metodo_toString("",0);
		
		System.out.println(mt1);
		System.out.println(mt2.toString());
		
		Scanner lc = new Scanner(System.in);
		
		System.out.print ("Introduzca el nombre del empleado: ");
		String n=lc.nextLine();
		
		System.out.print ("Introduzca la edad del empleado: ");
		int e=lc.nextInt();
		
		mt3.nombre=n;
		mt3.edad=e;
		
		System.out.println(mt3);
	}
}
