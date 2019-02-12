package Unidad1;

import java.util.Random;

public class ArreglosDinamicos 
{
	static Random lb = new Random();
	
	static int vec[]=new int[3], vec2[] = new int[4];
	
	
	static void llenar()
	{
		for(int i=0; i<vec.length; i++)
		{
			vec[i] = lb.nextInt(101);
		}
		
		for(int i=0; i<vec2.length; i++)
		{
			vec2[i] = lb.nextInt(101);
		}
	}
	
	static void mostrar(int arrRef[])
	{
		for(int l : arrRef)
		{
			System.out.print (l+" ");
		}
		
		System.out.println();
	}

	
	static void pasarDatos()
	{
		int []temp = new int[vec.length+vec2.length];
		
		for(int i=0; i<vec.length; i++)
			temp[i] = vec[i];
		
		
		for(int i=vec.length, j=0; i<temp.length; j++, i++)
			temp[i] = vec2[j];
		
		vec=temp;
	}
	
	public static void main(String[] args) 
	{
		llenar();
		llenar();
		
		System.out.println("Vector 1: ");
		mostrar(vec);
		System.out.println("Vector 2: ");
		mostrar(vec2);
		pasarDatos();
		System.out.println("nuevo contenido del Vec1[]: ");
		mostrar(vec);
	}
}
