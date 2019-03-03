package C7ClasesObjetos;

import java.awt.Color;
import java.awt.Graphics;

public class MiLinea
{
	private int x1; // coordena x para el p´rimer punto final
	private int y1; // coordena y para el p´rimer punto final
	private int x2; // coordena x para el segundo punto final
	private int y2; // coordena y para el segundo punto final
	
	private Color miColor; // el color de esta figura
	
	public MiLinea (int x1,int y1,int x2,int y2,Color color)
	{
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		miColor=color;
	}
	
	// dibuja lalinea con le color especifico
	void dibujar (Graphics g)
	{
		g.setColor(miColor);
		g.drawLine(x1,y1,x2,y2);
	}
	
}
