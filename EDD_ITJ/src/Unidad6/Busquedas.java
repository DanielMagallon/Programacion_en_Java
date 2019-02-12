package Unidad6;

import java.util.Arrays;
import java.util.Random;

import Unidad5.OrdenamientoInterno;

public class Busquedas
{

	/*
	 * Binaria:
	 * 
	 * posb = (ini+fin)/2
	 * 
	 * if(num==vec[posb])
	 *   return true;
	 * 
	 * else if(num>vec[posb])
	 *    ini = posb+1;
	 *    
	 * else 
	 *   fin  = posb-1;
	 *   
	 *   cuando ini<=fin;
	 */
	
	
	public int vec[];
	
	public Busquedas(int size)
	{
		vec = new int[size];
		Random lb = new Random();
		
		for(int i=0; i<vec.length; i++)
			vec[i] = 1+lb.nextInt(200);
		
	}
	
	public void mostrarNumeros()
	{
		for(int c : vec)
			System.out.print(c+" ");
		
		System.out.println();
	}
	
	public void secuencial(int num)
	{
		for(int i=0; i<vec.length; i++)
		{
			if(vec[i] == num)
			{
				System.out.printf("El numero %d esta en la pos: %d\n",num,i);
				return;
			}
		}
		
		System.out.println("EL numero "+num+" no esta en el arreglo");
	}
	
	public void binaria(int num)
	{
		Arrays.sort(vec);
		System.out.println("\nVector ordenado: ");
		mostrarNumeros();
		System.out.println("\n");
		
		int ini=0, fin=vec.length-1;
		
		while(ini<=fin)
		{
			int posb = (ini+fin)/2;
			
			if(num==vec[posb])
			{
				System.out.printf("El numero %d esta en la pos: %d\n",num,posb);
				return;
			}
			
			else if(num>vec[posb])
				ini = posb+1;
			
			else 
				fin = posb-1;
		}
		
		System.out.println("EL numero no existe");
	}
	
	public static void main(String[] args)
	{
		Busquedas b = new Busquedas(20);
		
		b.mostrarNumeros();
		b.binaria(20);
		
	}

}
