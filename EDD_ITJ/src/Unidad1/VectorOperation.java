package Unidad1;

import java.util.Random;

public class VectorOperation 
{
	private int redimension;
	private int vector[];
	private int index=0;
	private Random lb = new Random();
	
	public VectorOperation(int redimension)
	{
		this.redimension = redimension;
		vector = new int[redimension];
	}
	
	public VectorOperation()
	{
		redimension=5;
		vector = new int[redimension];
	}
	
	public void agregar(int num)
	{
		if(index % redimension == 0 && index!=0)
		{
			redimensionar(num);
		}
		
		else vector[index++] = num;
	}
	
	public void agregar(int...vec)
	{
		for(int i=0; i<vec.length; i++)
		{
			agregar(vec[i]);
		}
	}
	
	public int pares()
	{
		int pares=0;
		
		for(int i=0; i<index; i++)
		{
			if(vector[i]%2==0)
				pares++;
		}
		
		return pares;
	}
	
	public void eliminar(int n)
	{
		if(index!=0)
		{
			int x = iguales(n);
			
			if(x == index)
			{
				vector = new int[redimension];
				index=0;
			}
			
			else
			{
				if(x!=0)
				{
					int redi = index-x;
					int temp[]; 
					
					index = redi;
					
					if(redi%redimension != 0)
					{
						redi /= redimension;
						
						redi++;
						
						temp = new int[redi*redimension];
						
					}
					else temp = new int[redi];
		
					
					for(int i=0, j=0; j<index; i++)
					{
						if(vector[i] != n)
						{
							temp[j] = vector[i];
							j++;
						}
					}
					
					vector = temp;
				}
			}
			
			System.out.println("\nSE HA ELIMINADO EL "+n);
		}
		else
		{
			System.out.println("Eliminar() -> No hay elementos en la lista");
		}
	}
	
	private int iguales(int n)
	{
		int total=0;
		
		for(int i=0; i<index; i++ )
		{
			if(vector[i] == n)
				total++;
		}
		
		return total;
	}
	
	public void aletorio()
	{
		for(; index<vector.length; index++)
		{
			vector[index] = lb.nextInt(101);
		}
	}
	
	public int subConj(int x, int y)
	{
		int total=0;
		
		for(int i=0; i<index-1; i++)
		{
			if(vector[i] == x && vector[i+1] == y)
			{
				total++;
			}
		}
		
		return total;
	}
	
	private void redimensionar(int num)
	{
		int temp[] = new int[vector.length+redimension];
		
		for(int i=0; i<vector.length; i++)
			temp[i] = vector[i];
		
		temp[index++] = num;
		
		
		
		vector = temp;
	}
	
	public void mostrar()
	{
		if(index!=0)
		{
			System.out.println("\nElementos del vector: ");
			
			for(int i=0; i<index; i++)
				System.out.print(vector[i]+" ");
			
			System.out.println();
		}
		else
		{
			System.out.println("Mostrar() -> La lista esta vacia");
		}
	}
	
	public int obtenTamanio()
	{
		return index;
	}
	
	public int obtenTamanioVector()
	{
		return vector.length;
	}
	
	public int numerosMayoresA(int n)
	{
		int cont=0;
		
		for(int c : vector)
			if(c > n)
				cont++;
		
		return cont;
	}
	
	public static void main(String[] args) 
	{
		VectorOperation vec = new VectorOperation(5);
		
		vec.mostrar();
		
		vec.agregar(1);
		vec.agregar(1);
		vec.agregar(3);
		vec.agregar(3);
		vec.agregar(3);
		
		vec.mostrar();
		
//		System.out.println("Vecotr.lengt: "+vec.obtenTamanio());
//		System.out.println("Vector.length real: "+vec.obtenTamanioVector());
		
		vec.eliminar(1);
		vec.eliminar(3);
		vec.mostrar();
//		System.out.println("Vecotr.lengt: "+vec.obtenTamanio());
//		System.out.println("Vector.length real: "+vec.obtenTamanioVector());
		vec.agregar(4);
		vec.mostrar();
//		System.out.println("Vecotr.lengt: "+vec.obtenTamanio());
//		System.out.println("Vector.length real: "+vec.obtenTamanioVector());
		vec.agregar(new int[]{1,1,8});
		vec.mostrar();
		
		System.out.printf("\nHay %d conjuntos seguidos de 3-3\n\n",vec.subConj(3,3));
		
//		System.out.println("Vecotr.lengt: "+vec.obtenTamanio());
//		System.out.println("Vector.length real: "+vec.obtenTamanioVector());
		
		vec.agregar(2,2,11,10,32,24);
		vec.mostrar();
		
		System.out.printf ("\nHay %d numeros pares\n",vec.pares());
		
//		System.out.println("Vecotr.lengt: "+vec.obtenTamanio());
//		System.out.println("Vector.length real: "+vec.obtenTamanioVector());
		vec.eliminar(1);
		vec.mostrar();
//		System.out.println("Vecotr.lengt: "+vec.obtenTamanio());
//		System.out.println("Vector.length real: "+vec.obtenTamanioVector());
		vec.agregar(1);
		vec.agregar(1);
		vec.agregar(3);
		vec.agregar(new int[]{32,21,8});
		vec.agregar(6);
		vec.mostrar();
//		System.out.println("Vecotr.lengt: "+vec.obtenTamanio());
//		System.out.println("Vector.length real: "+vec.obtenTamanioVector());
		
		System.out.printf ("\nHay %d numeros pares\n",vec.pares());
		System.out.printf("\nHay %d numeros mayores a %d\n",vec.numerosMayoresA(10),10);
	}
}
