package Unidad4Hilos;

import java.util.Random;

class HiloMm implements Runnable
{
	Thread hilo;
	int numeros[] = new int[50];
	int pos;
	
	public HiloMm()
	{
		hilo = new Thread(this,"Hilo Mm");
		
		Random lb = new Random();
		
		for(int i=0; i<numeros.length; i++)
		{
			numeros[i] = lb.nextInt(101);
		}
		
		hilo.start();
	}
	
	@Override
	public void run()
	{
		while(pos!=numeros.length)
		{
			if(numeros[pos]>50 && numeros[pos]<80)
			{
				System.out.println(hilo.getName()+" (>50,<80) encontro "+numeros[pos]);
			}
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pos++;
		}
	}
}

class HiloDiv3 extends Thread
{
	int numeros[] = new int[50];
	int pos;
	
	public HiloDiv3()
	{
		super("HiloD3");
		
		Random lb = new Random();
		
		for(int i=0; i<numeros.length; i++)
		{
			numeros[i] = lb.nextInt(101);
		}
		
		start();
	}
	
	@Override
	public void run()
	{
		while(pos!=numeros.length)
		{
			if(numeros[pos]%3==0)
			{
				System.out.println(getName()+" encontro un divisible%3: "+numeros[pos]);
			}
			try
			{
				Thread.sleep(50);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pos++;

		}
	}
}

public class Ejercicio5
{
	public static void main(String[] args)
	{
		new HiloMm();
		new HiloDiv3();

	}
}
