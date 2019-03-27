package Unidad4Hilos;

import java.util.Calendar;
import java.util.Random;

class Hilo2 implements Runnable
{
	VectorComp vc;
	Thread h;
	
	public Hilo2(String name, VectorComp c)
	{
		h = new Thread(this,"hilo"+name);
		vc = c;
		h.start();
	}
	
	@Override
	public void run()
	{
		int v=0;
		
		while(v!=-1)
		{
//			synchronized (vc)
			{
				v = vc.obtener();
				
				if(v!=-1)
					System.out.printf("%s->%d\n",h.getName(),v);
				
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
		
	}
}

class VectorComp
{
	private int vec[];
	private int pos;
//	private volatile int pos;
	
	public VectorComp(int tam)
	{
		Random lb = new Random();
		vec = new int[tam];
		
		for(int i=0; i<tam; i++)
		{
			vec[i] = lb.nextInt(tam);
		}
	}
	
	//Imprime los numeros sin que se repita un dato
	public synchronized  int obtener()
	{
		try
		{
			return vec[pos++];
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return -1;
		}
	}
	
	public void mostrar()
	{
		for(int i=0; i<vec.length; i++)
		{
			System.out.print(vec[i]+" ");
			
			if((i+1)%20==0)
			{
				System.out.println();
			}
		}
	}
	
	
}

public class RecComp
{
	public static void main(String[] args)
	{
		Calendar tIv = Calendar.getInstance();
		
		VectorComp vc = new VectorComp(100);
		
		vc.mostrar();
		System.out.println();
		
		Hilo2 []s = new Hilo2[1];
		
				
		for(int i=0; i<s.length; i++)
		{
			s[i] = new Hilo2(i+"", vc);
		}
		
		for(int i=0; i<s.length; i++)
		{
			try
			{
				s[i].h.join();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Calendar tfin = Calendar.getInstance();
		
		long dur = tfin.getTimeInMillis()-tIv.getTimeInMillis();
		
		System.out.println("Duracion: "+dur);
		
	}
}
