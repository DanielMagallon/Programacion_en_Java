package Unidad4Hilos;

class Clicks implements Runnable
{
	int cont;
	Thread hilo;
	boolean ciclo=true;
	
	public Clicks(String name, int p)
	{
		hilo = new Thread(this, name);
		hilo.setPriority(p);
		hilo.start();
	}
	
	@Override
	public void run()
	{
		while(ciclo)
		{
			cont++;
			
			/**
			 * Si no se especifica el descanso no es
			 */
//			try {
//				
//				Thread.sleep(1);
//				
//			}catch(InterruptedException e) {}
		}
	}
	
	public void detener()
	{
		ciclo = false;
	}
	
	public void mostrar()
	{
		System.out.printf("Valor de %s: %d\n",hilo.getName(),cont);
	}
}

public class Prioridades
{
	public static void main(String[] args)
	{
		Clicks c = new Clicks("Hilo1",Thread.MIN_PRIORITY);
		Clicks c2 = new Clicks("Hilo2",Thread.MAX_PRIORITY);
		
		c.mostrar();
		c2.mostrar();
		try
		{
			Thread.sleep(10000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c.detener();
		c2.detener();
		c.mostrar();
		c2.mostrar();
	}
}
