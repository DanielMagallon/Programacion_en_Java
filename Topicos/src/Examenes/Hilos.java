package Examenes;

import java.util.Random;

class Hilo1 implements Runnable
{
	Thread hilo;
	Recurso r;
	boolean sigue=true;
	char vocales[] = {'a','e','i','o','u'};
	int cont;
	
	
	public Hilo1(Recurso re)
	{
		r = re;
		hilo = new Thread(this);
		hilo.start();
	}
	
	@Override
	public void run()
	{
		Random lb = new Random();
		
		while(sigue)
		{
			char c =  vocales[lb.nextInt(5)];
			sigue  = r.set((cont+1)+": "+c);
			try
			{
				Thread.sleep(5);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cont++;
		}
	}
}

class Hilo2 extends Thread
{
	Recurso r;
	char cons[] = {'b','c','d','f','g','h','j','k','l','m','n','m','p','q'
					,'r','s','t','v','w','x','y','z'};
	boolean sigue=true;
	int cont=0;
	
	public Hilo2(Recurso r)
	{
		this.r = r;
		start();
	}
	
	@Override
	public void run()
	{
		Random lb = new Random();
		
		while(sigue)
		{
			char c = cons[lb.nextInt(cons.length)];
			sigue = r.set(c+"");
			cont++;
			
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

class Recurso {
	
	String letras[]= new String[20];
	int pos;
	
	public synchronized boolean set(String e)
	{
		if(pos>=letras.length)
			return false;
		
		letras[pos] = e;
		pos++;
		return true;
	}
	
	public void mostrar()
	{
		for(String c : letras)
			System.out.println(c);
	}
}

public class Hilos
{
	public static void main(String[] args)
	{
		Recurso r = new Recurso();
		Hilo1 h1 = new Hilo1(r);
		Hilo2 h2 = new Hilo2(r);
		
		try
		{
			h1.hilo.join();
			h2.join();
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		r.mostrar();
	}
}
