package ProyectoColasU3;

import java.awt.image.BufferedImage;

public class Estudiante
{
	private String nombre, prob;
	private int prioridad;
	public BufferedImage imagen;
	
	public Estudiante(String nombre, int pro)
	{
		this.nombre = nombre;
		prioridad = pro;
		
		if(pro==1)
			imagen = PanelCola.embarazada;
		else if(pro==2)
			imagen = PanelCola.discapacitado;
		else 
			imagen = PanelCola.normal;
		
		prob = getDefecto(pro);
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getProblema()
	{
		return prob;
	}	
	
	public int getPriority()
	{
		return prioridad;
	}
	
	@Override
	public String toString()
	{
		return nombre+"-"+prob;
	}
	
	public static String getDefecto(int pro)
	{
		switch(pro)
		{
			case 1:
				return "Esta ambarazada";
				
			case 2: 
				return "Tiene discapacidad";
				
			default:
				return "No tiene nada";
		}
	}
	
	public static int getValorDefecto(String def)
	{
		switch(def.toUpperCase())
		{
			case "A":
				return 1;
				
			case "B": 
				return 2;
				
			case "C":
				return 3;
		}
		
		return -1;
	}
	
	public static String getLetraValor(int val)
	{
		switch(val)
		{
			case 1:
				return "A";
				
			case 2:
				return "B";
				
			default:
				return "C";
		}
	}
}
