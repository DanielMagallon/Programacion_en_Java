package Unidad4Hilos;

import java.util.ArrayList;

class Bolsa
{

	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();

	public void addProducto(Producto pro)
	{
		if (!estaLlena())
			listaProductos.add(pro);
	}

	public ArrayList<Producto> listaProductos()
	{
		return listaProductos;
	}

	public boolean estaLlena()
	{
		return listaProductos.size() >= 5;
	}

	public int getSize()
	{
		return listaProductos.size();
	}
}

class Producto
{
	String nombre;

	public void setNombre(String nam)
	{
		nombre = nam;
	}

	public String getNombre()
	{
		return nombre;
	}
}

class HhiloEnvio extends Thread
{
	private Bolsa bolsa;

	public HhiloEnvio(Bolsa bol)
	{
		bolsa = bol;
	}

	@Override
	public void run()
	{
		if (!bolsa.estaLlena())
		{
			try
			{
				synchronized (bolsa)
				{
					bolsa.wait();
				}
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			System.out.println("Enviando la bolsa con " + bolsa.getSize() + " elementos");
		}
	}

	public void setBolsa(Bolsa b)
	{
		bolsa = b;
	}

	public Bolsa getBolsa()
	{
		return bolsa;
	}
}

public class ListaSync
{
	public static void main(String[] args)
	{

		Bolsa bolsa = new Bolsa();
		HhiloEnvio hilo = new HhiloEnvio(bolsa);
		hilo.start();

		for (int i = 0; i <= 10; i++)
		{

			Producto p = new Producto();
			try
			{

				synchronized (bolsa)
				{

					Thread.sleep(1000);
					if (bolsa.estaLlena())
					{
						bolsa.notify();
					}
				}

			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			bolsa.addProducto(p);
			System.out.println(bolsa.getSize());

		}

	}
}
