package Unidad4Hilos;

import java.util.Random;

class HiloPares extends Thread
{
	VectorCompartido2 vc2;
	
	public HiloPares(String name,VectorCompartido2 v)
	{
		super(name);
		vc2 = v;
		
		start();
	}
	
	@Override
	public void run()
	{
		int n;
		while(true)
		{
			
			try
			{
				n = vc2.obtener();
				
				if(n%2==0)
				{
					System.out.println(getName()+" encontro un par: "+n);
				}	
				
				try
				{
					sleep(5);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
				break;
			}
		}
	}
	
}

class VectorCompartido2
{
	private int numeros[];
	private int pos;
	
	public VectorCompartido2()
	{
		numeros = new int[100];
		
		Random lb = new Random();
		
		for(int i=0; i<numeros.length; i++)
		{
			numeros[i] = lb.nextInt(101);
			System.out.print(numeros[i]+" ");
			
			if((i+1)%10==0)
				System.out.println();
		}
		
		System.out.println();
	}
	
	public  synchronized int obtener()
	{
		return numeros[pos++];
	}
}

public class Pares
{
	public static void main(String[] args)
	{
		VectorCompartido2 v = new VectorCompartido2();
		
		HiloPares hp[] = new HiloPares[5];

		for(int i=0; i<hp.length; i++)
		{
			hp[i]= new HiloPares("Hilo "+(i+1), v);
		}
		
	}
}
