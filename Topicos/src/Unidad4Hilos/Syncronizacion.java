package Unidad4Hilos;

class Impresora 
{
	public  void print(String doc)
	{
			System.out.print("["+doc);
			
			try
			{
				Thread.sleep(50);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("]");
		
	}
	
	public  void printSyncthis(String doc)
	{
		synchronized (this)
		{
			System.out.print("["+doc);
			
			try
			{
				Thread.sleep(50);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("]");
		}
		
	}
	
	//A nivel de metodo
	public synchronized void printSync(String doc)
	{
		System.out.print("["+doc);
		
		try
		{
			Thread.sleep(50);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("]");
	}
}

class Persona extends Thread
{
	Impresora imp;
	
	public Persona(String name, Impresora imp)
	{
		super(name);
		this.imp = imp;
			
		start();
		
	}
	
	@Override
	public void run()
	{
		//A nivel de objeto
		synchronized (imp)
		{
			imp.print(getName());
		}
		
	}
}

public class Syncronizacion
{	
	public static void main(String[] args)
	{
		Impresora hp =  new Impresora();
		
		Persona p1 = new Persona("Edgar", hp);
		Persona p2 = new Persona("Otho", hp);
		Persona p3 = new Persona("Daniela", hp);
		
	}
}
