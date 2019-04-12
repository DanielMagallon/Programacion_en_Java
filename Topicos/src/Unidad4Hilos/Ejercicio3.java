package Unidad4Hilos;

import java.util.Random;

class HiloGenerador extends Thread
{
	ArregloCompartido ac;
	
	//String cdd = (text.isEmpty()) ? "" : text.length()==2 ? "d" : "#";
	
	public HiloGenerador(ArregloCompartido ac)
	{
		this.ac = ac;
		start();
	}
	
	@Override
	public void run()
	{
		Random lb = new Random();
		
		while(!ac.acabado)
		{
			//System.out.println("Genero ");
			ac.set(lb.nextInt(101));
			
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}System.out.println("se teiim");
		
	}
}

class HiloPrinter extends Thread
{
	ArregloCompartido ac;
	int pos;
	
	public HiloPrinter(ArregloCompartido ac)
	{
		this.ac = ac;
		start();
	}
	
	@Override
	public void run()
	{
		while(!ac.acabado)
		{
			//System.out.println("Imprimo");
			ac.print();
			
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("se teiim");
	}
	
}


class ArregloCompartido
{
	int cant;
	int arreglo[];
	boolean acabado=false;
	int pos;
	boolean generado;
	
	ArregloCompartido(int n)
	{
		cant = n;
		arreglo = new int[n];
	}
	
	public synchronized void set(int dato)
	{
			System.out.println("Lo genero "+pos);
			arreglo[pos] = dato;
			
//			generado=true;
			if(pos==cant) {
				acabado=true;
				return;
			}
			notify();
		
	}
	
	public synchronized void print()
	{
			String cad=arreglo[pos]+" ";
			
			cad += (arreglo[pos]%2==0) ? "es par" : "es impar";
			cad += (arreglo[pos]%3==0) ? " y ademas divisible entre 3" :  "";
			
			System.out.println(cad);
//			generado=false;
			pos++;
			
			if(pos==cant)
			{
				acabado=true;
				return;
			}

			try
			{
				wait();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}

public class Ejercicio3
{
	public static void main(String[] args)
	{
		ArregloCompartido ac = new ArregloCompartido(10);
		
		HiloGenerador h1 = new HiloGenerador(ac);
		HiloPrinter h2 = new HiloPrinter(ac);
		
		
		try
		{
			h1.join();
			h2.join();
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
