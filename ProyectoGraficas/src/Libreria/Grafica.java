package Libreria;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;


public class Grafica implements Serializable
{
	private static final long serialVersionUID = -6673157375706695043L;
	
	private int disp[], radio,rotacion=0, angIni,grados,i;
	private BigDecimal total = BigDecimal.ZERO, PI2 = new BigDecimal(360f);
	Random lb = new Random();
	private Color[] colores;
	
	public static final int NORTE = 1, SUR = 2; 
	
	public Grafica()
	{
		radio = 100;
	}
	
	public void setDatos(int dispersion[])
	{
		disp = dispersion;
		colores = new Color[disp.length];
		for(i=0; i<colores.length; i++)
		{
			colores[i] = new Color(lb.nextInt(256),lb.nextInt(256),lb.nextInt(256));
		}
		
		for(int x : disp)
		{
			total = total.add(new BigDecimal(x));
		}
		
	}
	
	public void setRadio(int r)
	{
		radio = r;
	}
	
	public void setRotacion(int rot)
	{
		rotacion = rot;
	}
	
	public int getAnguloRotacion()
	{
		return rotacion;
	}
	
	public void setTitle(Graphics g, String titulo, int orientation, Color color, Font font)
	{
		g.setFont(font);
		g.setColor(color);
		g.drawString(titulo, titulo.length()/2,font.getSize());
	}
	
	public void dibujarBarraPastel(Graphics g,int x, int y)
	{
		BigDecimal val = BigDecimal.ZERO, grd;
		
		for(i=0; i<disp.length; i++)
		{
			g.setColor(colores[i]);
			if(i!=0)
			{
				angIni+=grados;
			}
			
			grd = new BigDecimal(disp[i]).multiply(PI2.divide
					(total,5,RoundingMode.HALF_EVEN));
			
			val = val.add(grd.subtract(new BigDecimal(grd.intValue())));
			
//			grados = (disp[i] * 360 / total);
			
			grados = grd.intValue();
			
			if(i==disp.length-1)
			{
				grados = grados+val.intValue();
			}
			
			
			g.fillArc(x, y, radio, radio, angIni, grados);
				
		}
		angIni  = 0;
	}
}
