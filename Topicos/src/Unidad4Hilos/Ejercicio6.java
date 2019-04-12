package Unidad4Hilos;

import java.util.Random;

class HiloPares2 implements Runnable
{
	RecursoShared rs;
	Thread hilo;
	int pares,ind;
	Random lb = new Random();
	
	public HiloPares2(RecursoShared s)
	{
		hilo = new Thread(this,"HP");
		rs = s;
		
		hilo.start();
	}
	
	@Override
	public void run()
	{
		int n;
		
		while(ind!=50)
		{
			n = lb.nextInt(101);
			
			if(n%2==0)
			{
				rs.asignar(n);
				pares++;
			}
			
			ind++;
			
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String toString()
	{
		return "Se encontraron "+pares+" numeros pares";
	}
}

class HiloM50 extends Thread
{
	RecursoShared rs;
	int ind,mayores;
	Random lb = new Random();
	
	public HiloM50(RecursoShared s)
	{
		super("HM50");
		rs = s;
		start();
	}
	
	@Override
	public void run()
	{
		int n;
		
		while(ind!=50)
		{
			n = lb.nextInt(101);
			
			if(n>50)
			{
				rs.asignar(n);
				mayores++;
			}
			
			ind++;
			
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
	
	@Override
	public String toString()
	{
		return "Se encontraron "+mayores+" numeros >50";
	}
}

class RecursoShared 
{
	int vec[];
	int pos;
	
	public RecursoShared()
	{
		vec = new int[100];
	}
	
	public synchronized void asignar(int num)
	{
		System.out.println("Asginando: "+num);
		vec[pos] = num;
		pos++;
	}
}

public class Ejercicio6
{
	public static void main(String[] args)
	{
		RecursoShared r = new RecursoShared();
		
		HiloPares2 h = new HiloPares2(r);
		HiloM50 g = new HiloM50(r);
		
		try
		{
			h.hilo.join();
			g.join();
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(h);
		System.out.println(g);
	}
}
