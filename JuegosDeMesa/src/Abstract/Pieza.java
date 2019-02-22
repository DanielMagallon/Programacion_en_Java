package Abstract;

import javax.swing.Icon;

public abstract class Pieza 
{
	public String nombre,clave;
	public int val;
	
	public Pieza(String name, String cv, int valor) 
	{
		nombre = name;
		clave = cv;
		val = valor;
	}
	
	public abstract Icon getPieza(int player);
	public abstract void movimiento(int f, int c);
	
}
