package Unidad4Hilos;

class CH extends Thread
{
	Rec r;
	
	public CH(Rec re)
	{
		// TODO Auto-generated constructor stub
		r = re;
		start();
	}
	
	@Override
	public void run()
	{
		r.corriendo();
		try
		{
			Thread.sleep(500);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Ch2 extends Thread
{
	Rec r;
	
	public Ch2(Rec r)
	{
		// TODO Auto-generated constructor stub
		this.r = r;
		start();
	}
	
	@Override
	public void run()
	{
		r.corriendo2();
		try
		{
			Thread.sleep(500);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Rec {
	public synchronized void corriendo()
	{
		System.out.println("Corro en hilo 1");
		try
		{
			wait();
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notify();
	}
	
	public synchronized void corriendo2()
	{
		System.out.println("Correidno en hilo2");
	}
}

public class Comunicacion
{	
	public static void main(String[] args)
	{
		Rec r = new Rec();
		
		new CH(r);
		new Ch2(r);
	}
}


