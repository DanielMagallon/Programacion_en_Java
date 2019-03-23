package Unidad4Hilos;

import java.util.Random;

class HilosRec implements Runnable
{
	RecursoCompartido rc;
	Thread hilos[];
	
	public HilosRec(RecursoCompartido rec, int cantHi)
	{
		hilos = new Thread[cantHi];
		rc = rec;
		
		for(int i=0; i<hilos.length; i++)
		{
			hilos[i] = new Thread(this,"Hilo"+(i+1));
			hilos[i].start();
		}
		
		
	}
	
	@Override
	public void run()
	{
//		synchronized(rc)
		{
			while(rc.pos<10)
			{
				System.out.print(Thread.currentThread().getName()+": ");
				System.out.println(rc.obtener());
				
				try
				{
					Thread.sleep(1);
					
					
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}

public class RecursoCompartido
{
	private int vec[];
	public  int pos;
	
	public RecursoCompartido(int tam)
	{
		vec = new int[tam];
		
		Random lb = new Random();
		
		for(int i=0; i<tam; i++)
		{
			vec[i] = lb.nextInt(51);
		}
	}
	
	public int obtener()
	{
		return vec[pos++];
	}
	
	public void mostrar()
	{
		for(int x : vec)
		{
			System.out.print(x+"-");
		}
	}
	
	public static void main(String[] args)
	{
		RecursoCompartido rc = new RecursoCompartido(10);
	
		rc.mostrar();
		System.out.println();
		
		HilosRec hilo = new HilosRec(rc,3);
//		
//		try
//		{
//			h1.join();
//			h2.join();
//			h3.join();
//		}
//		catch(InterruptedException e)
//		{
//			
//		}
//		
	}
}
