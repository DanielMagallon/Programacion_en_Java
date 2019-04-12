package Unidad4Hilos;

import java.util.Random;

class HProcesa extends Thread
{
	RecSh r;
	
	public HProcesa(String name, RecSh r)
	{
		super(name);
		this.r = r;
		start();
	}
	
	@Override
	public void run()
	{
		int n=0;
		boolean second=false;
		
		while(n!=-1)
		{
			do 
			{
				n = r.get();
				
				if(n!=-1)
				{
					if(n%2==0)
					{
						System.out.println(getName()+": encontro un "+(second ? "segundo" 
								: "primer")+" par "+n);
					}
				}
				else return;
			}
			while(second=!second);
			
			try
			{
				sleep(5);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


class RecSh 
{
	int num[];
	int pos=-1;
	
	public RecSh()
	{
		num = new int[100];
		
		Random lb = new Random();
		
		for(int i=0; i<num.length; i++)
		{
			num[i] = lb.nextInt(101);
		}
	}
	
	public void arreglo()
	{
		for(int i=0; i<num.length; i++)
		{
			System.out.print(num[i]+" ");
			
			if((i+1)%10==0)
				System.out.println();
		}
	}
	
	public synchronized int get()
	{
		pos++;
		
		if(pos>=num.length)
			return -1;
		
		return num[pos];
	}
}

public class Ejercicio7
{
	public static void main(String[] args)
	{
		RecSh r  = new RecSh();
		HProcesa hp[] = new HProcesa[2];
		r.arreglo();
		
		for(int i=0; i<hp.length; i++)
		{
			hp[i] = new HProcesa("Hilo"+i, r);
		}
	}
}
