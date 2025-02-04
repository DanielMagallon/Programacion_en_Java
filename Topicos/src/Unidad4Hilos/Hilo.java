package Unidad4Hilos;

class Hilos extends Thread
{
	public Hilos(String name, int prior)
	{
		super(name);
		setPriority(prior);
		start();
	}
	
	@Override
	public  void run()
	{
		for(int i=1; i<=10; i++)
		{
			System.out.println(getName()+": "+i);
			
			//Descansar Proceso
			
			try
			{
				//Con un milisegundo basta, hay que poner a descansar para que no haga todo de putazo
				sleep(100);
				
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class Hilo 
{
	public static void main(String[] args)
	{		
		
		Thread hilo = Thread.currentThread();

		synchronized(new Hilos("Hilo2",5))
		{
		}
		Hilos h3 = new Hilos("Hilo3",5);
		
		System.out.println(hilo);
		
		hilo.setName("Yeo");
		
		System.out.println(hilo);
		
		System.out.println(hilo.getName());
		
		System.out.println("Corriendo? "+hilo.isAlive());
		
		System.out.println("Prioridad: "+hilo.getPriority());
		
		//Demonio = GC = Garbage Collector, proceso que usa menos cantidad de uso 
		//del procesador pero que no se ve, (al actualizar la hora)
		System.out.println("Demon? "+hilo.isDaemon());
		
		
		for(int i=1; i<=10; i++)
		{
			System.out.println(hilo.getName()+": "+i);
			
			//Descansar Proceso
			
			try
			{
				//Con un milisegundo basta
				Thread.sleep(100);
				
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
