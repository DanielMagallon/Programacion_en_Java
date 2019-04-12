package Unidad4Hilos;

import java.util.Random;

class HiloRangos extends Thread
{
	VectorCompartido vc;
	int pos;
	
	public HiloRangos(String name, VectorCompartido vc)
	{
		super(name);
		this.vc = vc;
		start();
	}
	
	@Override
	public void run()
	{
		int n=0;
		
		while(n!=-1)
		{
			n = vc.obtener(pos);
			
			if(n>20 && n<80)
			{
				System.out.println(getName()+" encontro: "+n);
			}
			pos++;
			
			try
			{
				Thread.sleep(5);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class HiloDivisible implements Runnable
{
	Thread hilo;
	int pos;
	VectorCompartido vc;
	
	public HiloDivisible(String name, VectorCompartido vc)
	{
		hilo = new Thread(this, name);
		this.vc = vc;		
		hilo.start();
		
	}
	
	@Override
	public void run()
	{
		int n=0;
		
		while(n!=-1)
		{
			n = vc.obtener(pos);
			
			if(n%3==0)
			{
				System.out.println(hilo.getName()+" encontro "+n);
			}
			
			pos++;
			
			try
			{
				Thread.sleep(5);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class VectorCompartido 
{
	private int numeros[];
	
	public VectorCompartido()
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
	
	public  int obtener(int pos)
	{
		if(pos==numeros.length)
			return -1;
		
		return numeros[pos];
	}
}

public class RangoNumeros
{
	public static void main(String[] args)
	{
		VectorCompartido vc = new VectorCompartido();
		
		new HiloDivisible("HiloDiv3", vc);
		new HiloRangos("HiloRangos", vc);
	}
}
