package HelpClass;

import java.util.Random;

public class CodigoASCII
{
	static int [] arreglo;
	
	
	public static void main(String[] args)
	{
		String nombre [] = {"Edgar","Daniel","Huani","Pollo","Luis","Valeria","Lola","Emmanuel"};
		String t;
		
		int salto=nombre.length/2;
		int comp = (nombre.length%2==0) ? salto : salto+1;
	
		mostrarName(nombre);
		
	 while(salto>=1)
	 {
		for (int i=0; i<comp; i++)
		{
			if (nombre[i].compareTo(nombre[i+salto])>0)
			{
				t=nombre[i];
				nombre[i]=nombre[i+salto];
				nombre[i+salto]=t;
				
			}
		}
		salto--;
		comp++;
	 }
	 
	 	System.out.println("\nNombre ordenados: ");
	 	mostrarName(nombre);
	 	
	 	generarNumeros();
	 	QuickSort(0, arreglo.length-1);
	 	mostrarNumbers();
	}
	
	
	private static void mostrarName(String name[])
	{

	 	for (String n : name)
	 	{
	 		System.out.printf ("%3s ",n);
	 	}
	 	System.out.println();
	}
	
	
	private static void QuickSort(int pri, int ult)
	{
		int i,j,t,pivote;
		
		i=pri;
		j=ult;
		pivote=arreglo[(pri+ult)/2];
		
		do
		{
			while (arreglo[i]<pivote) i++;
			while (arreglo[j]>pivote) j--;
			
			if (i<=j)
			{
				t=arreglo[i];
				arreglo[i]=arreglo[j];
				arreglo[j]=t;
				i++;
				j--;
			}
		}
		while (i<=j);
		
		if (pri<j)
			QuickSort(pri, j);
		
		if (i<ult)
			QuickSort(i, ult);
	}
	
	private static void generarNumeros()
	{
		arreglo = new int [10];
		Random lb = new Random();
		
		for (int i=0; i<arreglo.length; i++)
		{
			arreglo[i]=lb.nextInt(50)+1;
		}
		
		mostrarNumbers();
	}
	
	private static void mostrarNumbers()
	{
		System.out.println();
		
		for (int i : arreglo)
			System.out.printf ("%3d ",i);
	}
}
