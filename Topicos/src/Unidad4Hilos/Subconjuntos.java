package Unidad4Hilos;

import java.util.Random;

class HiloSubj implements Runnable
{
	int numeros[];
	int ind = 0;
	boolean dosEnc = false;
	Thread hilo;

	public HiloSubj()
	{
		hilo = new Thread(this);

		numeros = new int[50];
		Random lb = new Random();

		for (int i = 0; i < numeros.length; i++)
		{
			numeros[i] = lb.nextInt(4);
			System.out.print(numeros[i]+" ");
		}
		System.out.println();

		hilo.start();
	}

	@Override
	public void run()
	{
		while (ind != numeros.length)
		{
			if (numeros[ind] == 2)
				dosEnc = true;

			else if (numeros[ind] == 1 && dosEnc)
			{
				System.out.printf("Se encontro un subcojunto 2-1 entre las pos [%d]-[%d]\n", ind - 1, ind);
				dosEnc = false;
			} else
				dosEnc = false;

			ind++;

			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class HiloChar extends Thread
{
	private String[] letras = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p",
			"q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

	char c, cs[];

	int pos = 0;

	public HiloChar()
	{
		int num = letras.length;

		cs = new char[30];

		Random lb = new Random();

		for (int i = 0; i < cs.length; i++)
		{
			cs[i] = letras[lb.nextInt(num)].charAt(0);
			System.out.print(cs[i]+" ");
		}
		System.out.println();

		start();
	}

	@Override
	public void run()
	{
		while (pos != cs.length)
		{
			if (cs[pos] ==  't')
				System.out.println("Se encontro una t en la posicion: "+pos);

			pos++;
			
			try
			{
				sleep(50);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class Subconjuntos
{
	public static void main(String[] args)
	{
		new HiloSubj();
		new HiloChar();
	}
}
