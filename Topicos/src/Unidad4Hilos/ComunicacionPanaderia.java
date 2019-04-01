package Unidad4Hilos;

class Panaderia 
{
	boolean hayPan;
	
	public Panaderia()
	{
		hayPan = false;
	}
	
	//Debe estar sincronizado para que sea un semaforo;
	//Solo una persona pone el  pan
	public synchronized void ponerPan(String name)
	{
		if (hayPan)
		{
			System.out.println("Se espera el panadero "+name+" porque hay pan");
		
			try
			{
				wait();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		else
		{
		System.out.println("Poniendo pan el panadero "+name);
		hayPan=true;
		notify();
		}
	}
	
	public synchronized void comprarPan(String name)
	{
		if(!hayPan)
		{
			System.out.println("El cliente "+name+" esta esperando a que pongan mas pan");
			try
			{
				wait();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		else 
		{
		System.out.println("Comprando pan: "+name);
		hayPan=false;
		notify();
		}
	}
}

class Panadero extends Thread
{
	Panaderia pn;
	boolean horario;
	
	public Panadero(String name, Panaderia ref)
	{
		super(name);
		pn = ref;
		horario = true;
		start();
	}
	
	@Override
	public void run()
	{
		while (horario)
		{
			pn.ponerPan(getName());
			
			try
			{
				Thread.sleep(1);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void salida()
	{
		horario = false;
//		
	}
}

class Cliente implements Runnable
{
	Panaderia pn;
	Thread h;
	boolean horario;
	
	public Cliente(String name, Panaderia p)
	{
		pn = p;
		h = new Thread(this, name);
		horario = true;
		h.start();
	}
	
	@Override
	public void run()
	{
		while (horario)
		{
			pn.comprarPan(h.getName());
			
			try
			{
				Thread.sleep(1);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void salida()
	{
		horario = false;
	}
}

public class ComunicacionPanaderia
{
	public static void main(String[] args)
	{
		Panaderia pand = new Panaderia();
		Panadero p  = new Panadero("Juan", pand);
		Panadero p2  = new Panadero("Pedro", pand);
		Cliente cl = new Cliente("Edgar", pand);
		
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		p.salida();
		p2.salida();
		cl.salida();
//		System.exit(0);
	}
}
