package Libreria;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;


public class Grafica implements Serializable
{
	private static final long serialVersionUID = -6673157375706695043L;

	private int disp[], radio,rotacion=0, angIni,grados,i,posXTitle,posYTitle,
						orientacion;
	private BigDecimal total = BigDecimal.ZERO, PI2 = new BigDecimal(360f);
	private Random lb = new Random();
	private Color[] colores;
	
	public static final int NORTE = 1, SUR = 2; 
	
	public Grafica()
	{
		radio = 200;
		orientacion = NORTE;
		actualizarXY();
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
		actualizarXY();
	}
	
	public boolean radioValido()
	{
		return radio>=200;
	}
	
	public void setRotacion(int rot)
	{
		rotacion = rot;
	}
	
	public int getRadio()
	{
		return radio;
	}
	
	public int getAnguloRotacion()
	{
		return rotacion;
	}
	
	public void setTitleOrientation(int posi)
	{
		orientacion = posi;
		actualizarXY();
	}
	
	private void actualizarXY()
	{
		if(orientacion == NORTE)
		{
			posYTitle=70;
		}
		else
		{
			posYTitle = radio+150;
		}
		
		posXTitle = radio/2+50;
	}
	
	public void setTitle(Graphics g, String titulo, Color color, Font font)
	{
		g.setFont(font);
		g.setColor(color);
		g.drawString(titulo, posXTitle,posYTitle);
	}
	
	public void dibujarGraficaBarras(Graphics g,int x, int y)
	{
		
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
			
//			System.out.println("%: "+grd.divide(PI2,4,RoundingMode.HALF_EVEN).multiply
//					(new BigDecimal(100)));
			
			val = val.add(grd.subtract(new BigDecimal(grd.intValue())));
			
			
			grados = grd.intValue();
			
			if(i==disp.length-1)
			{
				grados = grados+val.intValue();
			}
			
			
			g.fillArc(x, y, radio, radio, angIni+rotacion, grados);
				
		}
		angIni  = 0;
	}
}
