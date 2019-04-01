package Unidad4Hilos;

import java.util.Calendar;
import java.util.Random;

class Trailer
{
	private int vec[];
	private int pos;
	
	public Trailer()
	{
		vec = new int[10000];
	}
	
	public  int cargar(int num,String name)
	{
		try
		{
			vec[pos] = num;
			pos++;
			System.out.printf("Se guardo: %d por %s\n",num,name);
			
			return num;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return -1;
		}
	}
}

class Trabajadores extends Thread
{
	Trailer trailer;
	int cont;
	
	public Trabajadores(String name,Trailer t)
	{
		super(name);
		trailer=t;
		start();
	}
	
	@Override
	public void run()
	{
		int num=0;
		Random lb = new Random();
		
		while(true)
		{
			num = lb.nextInt(10000)+1;
			
			if(trailer.cargar(num, getName())==-1)
				break;
			
			else cont++;
			
			try
			{
				Thread.sleep(1);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.printf("El trabajador %s subio %d productos\n",getName(),cont);
	}
}

public class EjerCarga
{
	public static void main(String[] args)
	{
		Trailer t = new Trailer();
		Trabajadores trs[] = new Trabajadores[5];
		Calendar tI = Calendar.getInstance();
		
		for(int i=0; i<trs.length; i++)
		{
			trs[i] = new Trabajadores("Trabajador: "+i, t);
			
		}
		
		for(int i=0; i<trs.length; i++)
		{
			try
			{
				trs[i].join();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Calendar tF = Calendar.getInstance();
		
		long res = tF.getTimeInMillis()-tI.getTimeInMillis();
		
		System.out.println("Con "+trs.length+" trabajadores tardo: "+res);
	}
}
