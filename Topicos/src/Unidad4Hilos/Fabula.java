package Unidad4Hilos;

public class Fabula
{
	public static void main(String[] args)
	{
		Tortuga t = new Tortuga("Yeo",1);
		Conejo c = new Conejo("Daniel",2);
		
		//Asi espera a que acaben los dos hilos para mostrar el system
		try
		{
			t.join();
			c.con.join();
			
			
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Termino la carrera");
	}
}

class Tortuga extends Thread
{
	int descanso;
	
	public Tortuga(String name, int desc)
	{
		super(name);
		descanso = desc;
		start();
	}
	
	@Override
	public void run()
	{
		System.out.println("Arranca: "+getName());
		
		for(int i=0; i<=100; i++)
		{
			System.out.println("Corriendo: "+getName()+" en km: "+i);
			
			
			try
			{
				sleep(descanso);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Termino: "+getName());
	}
}

class Conejo implements Runnable
{
	Thread con;
	int descanso;
	
	public Conejo(String name, int d)
	{
		con  = new Thread(this,name);
		descanso = d;
		con.start();
	}
	@Override
	public void run()
	{
		System.out.println("Arranca: "+con.getName());
		
		for(int i=0; i<=100; i++)
		{
			System.out.println("Corriendo: "+con.getName()+" en km: "+i);
			
			
			try
			{
				Thread.sleep(descanso);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Termino: "+con.getName());
	}
}
