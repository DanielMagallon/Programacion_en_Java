package Unidad4Hilos;

import java.io.IOException;
import java.util.Random;

class MyTread extends Thread
{
	RecursoCompartido rc;
	int pos,n;
	
	public MyTread(RecursoCompartido rec, int posIni,int inc,String name)
	{
		super(name);
		pos = posIni;
		n = inc;
		rc = rec;
	}
	
	@Override
	public  void run()
	{
		while(pos<10)
		{
			synchronized (rc)
			{
				try
				{
					System.out.print(getName()+": ");
					System.out.println(rc.obtener(pos));
					pos+=n;
					Thread.sleep(1);
					
					
				} catch (InterruptedException  e)
				{
					break;
				}
			}
		}
		
			
	}
}

class CreadorHilos
{
	MyTread[] arr;
	
	public CreadorHilos(int cant, RecursoCompartido rc)
	{
		arr = new MyTread[cant];
		
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = new MyTread(rc,i, arr.length,"h"+i);
			arr[i].start();
		}
	}
}

public class RecursoCompartido
{
	private int vec[];

	public RecursoCompartido(int tam)
	{
		vec = new int[tam];
		
		Random lb = new Random();
		
		for(int i=0; i<tam; i++)
		{
			vec[i] = lb.nextInt(51);
		}
	}
	
	public int obtener(int pos)
	{
		return vec[pos];
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
		new CreadorHilos(3, rc);
		
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
