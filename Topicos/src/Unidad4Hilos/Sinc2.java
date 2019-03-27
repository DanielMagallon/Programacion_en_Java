package Unidad4Hilos;

import java.util.Calendar;
import java.util.Random;

class H2
{
	VectorComp vc;
	
	public H2(VectorComp c)
	{
		vc = c;
	}
	
	public void run()
	{
		int v=0;
		
		while(v!=-1)
		{
//			synchronized (vc)
			{
				v = vc.obtener();
				
				if(v!=-1)
					System.out.printf("%d\n",v);
			}
		}
		
	}
}

class VectorC
{
	private int vec[];
	private int pos;
//	private volatile int pos;
	
	public VectorC(int tam)
	{
		Random lb = new Random();
		vec = new int[tam];
		
		for(int i=0; i<tam; i++)
		{
			vec[i] = lb.nextInt(tam);
		}
	}
	
	//Imprime los numeros sin que se repita un dato
	public   int obtener()
	{
		try
		{
			return vec[pos++];
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return -1;
		}
	}
	
	public void mostrar()
	{
		for(int i=0; i<vec.length; i++)
		{
			System.out.print(vec[i]+" ");
			
			if((i+1)%20==0)
			{
				System.out.println();
			}
		}
	}
	
	
}

public class Sinc2
{
	public static void main(String[] args)
	{
		Calendar tIv = Calendar.getInstance();
		
		VectorComp vc = new VectorComp(100);
		
		vc.mostrar();

		new H2(vc).run();
		
		Calendar tfin = Calendar.getInstance();
		
		long dur = tfin.getTimeInMillis()-tIv.getTimeInMillis();
		
		System.out.println("Duracion: "+dur);
		
	}
}

