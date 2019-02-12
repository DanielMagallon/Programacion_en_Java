package Eventos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.Icon;

import Interfaz.Estaque;

public class Almacena implements Serializable
{
	private static final long serialVersionUID = 1341355892178235107L;
	
	public ArrayList<Estaque> estaqueT = new ArrayList<>();
	public ArrayList<Estaque> estaqueM = new ArrayList<>();
	public ArrayList<Icon> piezas = new ArrayList<>();
	
	public void addNew(Estaque old, Estaque neww)
	{
		estaqueT.add(old);
		piezas.add(neww.getIcon());
		estaqueM.add(neww);
	}
	
	public void mostrar()
	{
		for(int i=0; i<estaqueM.size(); i++)
		{
			System.out.printf("From %s to %s \n",estaqueT.get(i),estaqueM.get(i));
		}
		System.out.println("\n");
	}
}
