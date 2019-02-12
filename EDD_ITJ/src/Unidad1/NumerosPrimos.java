package Unidad1;

import java.util.BitSet;

public class NumerosPrimos 
{
	int maximo, raiz;
	BitSet bit;
	
	public NumerosPrimos(int max)
	{
		nuevo(max);
	}
	
	public void nuevo(int max)
	{
		maximo = max;
		bit = new BitSet();
		
		activar();
	}
	
	private void activar()
	{
		for(int i=2; i<=maximo; i++)
		{
			bit.set(i);
		}
		
		encontrarPrimos();
		
	}
	
	public void encontrarPrimos()
	{
		
		raiz = (int)Math.sqrt(maximo);

		for(int k = 2; k<=raiz; k++)
		{
//			for(int i=2; i<=maximo; i++)
//			{
//				if(i%k == 0 && i!=k)
//				{
//					bit.clear(i);
//				}
//			}
			
			if(bit.get(k))
			{
				for(int i=k*2; i<=maximo; i+=k)
				{
					bit.clear(i);
				}
			}
		}
		
		System.out.printf("Los numeros primos hasta %d son :"+bit,maximo);
	}
	
	//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89}
	//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89}
	
	
	public static void main(String[] args) 
	{
		new NumerosPrimos(90);//.nuevo(25);
	}
}
