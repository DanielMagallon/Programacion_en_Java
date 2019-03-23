package Unidad4Hilos;

class HiloR implements Runnable
{
	Thread temp;
	
	public HiloR(String name)
	{
		temp = new Thread(this,name);
		temp.start();
	}
	
	@Override
	public void run()
	{
		for(int i=1; i<=10; i++)
		{
			System.out.println(temp.getName()+": "+i);
			
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

public class HiloRunn
{
	public static void main(String[] args)
	{
		Thread hilo = Thread.currentThread();

		new HiloR("HiloRun2");
		
		new HiloR("HiloRun3");
		
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
