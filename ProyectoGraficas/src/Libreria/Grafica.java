package Libreria;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;


public class Grafica implements Serializable
{
	private static final long serialVersionUID = -6673157375706695043L;

	private final int LINEA_SALIENTE=40;
	
	private int disp[], radio,rotacion, angIni,grados,i,posXTitle,posYTitle,
						orientacion,mayor, anchoBarras,espacioBarras,numCat,anchoEjex,interseccion,
						mayorlength,nx,x,y;

	private boolean vertical=true,deBarras=true;
	private String categorias[];
	private String concat;
	private BigDecimal total = BigDecimal.ZERO;
	private final BigDecimal CIEN = new BigDecimal("100"),PI2 = new BigDecimal(360f);
	private Random lb = new Random();
	private Color[] colores;
	private Font fontDatos;
	private Color colorfuente;
	private Font fontTitle;
	private Color colorTitulo;
	private BigDecimal porcentajes[];
	private int alturasY[];
	public int posicionesXYClick[][];
	public boolean byPorcentaes;
	private Color colorEjes;
	private String titulo;
	private boolean showByPorc=true;
	
	public static final int NORTE = 1, SUR = 2,BARRAS=2,PASTEL=1, ANCHO_MINIMO=20,ANCHO_MAXIMO=100; 
	
	public Grafica()
	{
		radio = 200;
		espacioBarras = 10;
		colorEjes = Color.white;
		anchoBarras = 40;
		orientacion = NORTE;
		colorTitulo = colorfuente = Color.black;
		fontDatos = new Font("Sans Serif", Font.ITALIC, 32);
		fontTitle = new Font("Sans Serif", Font.BOLD, 32);
		
		actualizarXY();
	}
	
	
	public void setDatos(int dispersion[], String categorias[])
	{
		disp = dispersion;
		byPorcentaes = false;
		mayor = 0;
		this.categorias = categorias;
		porcentajes = new BigDecimal[categorias.length];
		colores = new Color[disp.length];
		total = BigDecimal.ZERO;
		numCat = categorias.length;
		
		for(int x : disp)
		{
			total = total.add(new BigDecimal(x));
		}
		
		for(i=0; i<colores.length; i++)
		{
			colores[i] = new Color(lb.nextInt(256),lb.nextInt(256),lb.nextInt(256));
			
			if(disp[i]>mayor)
				mayor = disp[i];
			
			porcentajes[i] = new BigDecimal(disp[i]).multiply
					(CIEN).divide(total,2,RoundingMode.HALF_UP);
			
		}
		
		angIni=grados=0;
		
		posicionesXYClick = new int[dispersion.length][4];
		anchoEjex=((anchoBarras+espacioBarras)*numCat+10);
	}
	
	public void setAltura(int altura)
	{
		if(byPorcentaes)
		{
			mayor =  altura;
			BigDecimal bigest = new BigDecimal(mayor);
			
			for(int i=0; i<numCat; i++)
			{
				alturasY[i] = bigest.multiply
						(porcentajes[i]).divide(CIEN,2,RoundingMode.HALF_UP).intValue();
			}
			actualizarXY();
		}
	}
	
	public void setPorcentajes(BigDecimal[] porcenatajes, String cats[], int alturaGraf)
	{
		byPorcentaes = true;
		categorias=cats;
		numCat = cats.length;
		posicionesXYClick = new int[numCat][4];
		
		this.porcentajes = porcenatajes;
		
		mayor = alturaGraf;
		
		BigDecimal bigest = new BigDecimal(mayor);
		
		alturasY = new int[numCat];
		
		colores = new Color[numCat];
		
		for(int i=0; i<numCat; i++)
		{
			colores[i] = new Color(lb.nextInt(256),lb.nextInt(256),lb.nextInt(256));
			alturasY[i] = bigest.multiply
					(porcenatajes[i]).divide(CIEN,2,RoundingMode.HALF_UP).intValue();
		}
		
		anchoEjex=((anchoBarras+espacioBarras)*numCat+10);
		actualizarXY();
	}
	
	public void setColorEjes(Color c)
	{
		colorEjes = c;
	}
	
	public Color[] getColores()
	{
		return colores;
	}
	
	public int getAnchoBarr()
	{
		return anchoBarras;
	}
	
	public void cambiarAncho(int ancho)
	{
		anchoBarras+=ancho;
		anchoEjex=((anchoBarras+espacioBarras)*numCat+10);
		actualizarXY();
	}
	
	public void espaciadoBarras(int esp)
	{
		espacioBarras = esp;
		anchoEjex=((anchoBarras+espacioBarras)*numCat+10);
		actualizarXY();
	}
	
	public int getEspaciado()
	{
		return espacioBarras;
	}
	
	public void setRadio(int r)
	{
		radio = r;
		actualizarXY();
	}
	
	public void setRotacion(int rot)
	{
		rotacion = rot;
	}
	
	public void rotateBarras(boolean vert)
	{
		vertical = vert;
		actualizarXY();
	}
	
	public boolean isVerticalOrientation()
	{
		return vertical;
	}
	
	public int getRadio()
	{
		return radio;
	}
	
	public int getAnguloRotacion()
	{
		return rotacion;
	}
	
	public String[] getCategorias()
	{
		return categorias;
	}
	
	public int[] getFrecuenciasCat()
	{
		return disp;
	}
	
	public void setTitleOrientation(int posi)
	{
		orientacion = posi;
		actualizarXY();
	}
	
	public void setNewXY(int nx, int ny)
	{
		x =  nx;
		y = ny;
		actualizarXY();
	}
	
	public void actualizarXY()
	{
		if(orientacion == NORTE)
		{
			if(deBarras)
			{
				if(vertical)
				{
					posYTitle = y-50;
				}
				
				else
				{
					posYTitle = y-20;
				}
			}
			
			else
				posYTitle=y-50;
		}
		else
		{
			if(deBarras)
			{
				if(vertical)
				{
					posYTitle = y+mayor+LINEA_SALIENTE+40;
				}
				
				else
				{
					posYTitle = y+anchoEjex+50+LINEA_SALIENTE;
				}
			}
				
			else posYTitle = radio+y+70;
		}
		
		if(deBarras)
		{
			if(vertical)
			{
				posXTitle = x+anchoEjex/2-30;
			}
			else
			{
				posXTitle = x + mayor/2-20;
			}
		}
		
		else posXTitle = x  + radio/2 - 30;
	}
	
	public Grafica setFontTitle(Font f)
	{
		fontTitle = f;
		return this;
	}

	public Grafica setDatosFont(Font f)
	{
		fontDatos = f;
		return this;
	}
	
	public Font getTitleFont()
	{
		return fontTitle;
	}
	
	public Font getDatosFont()
	{
		return fontDatos;
	}
	
	public Grafica setDatosColor(Color c)
	{
		colorfuente = c;
		return this;
	}
	
	public Grafica setTitleColor(Color c) 
	{
		colorTitulo = c;
		return this;
	}
	
	public void setTitle(Graphics g, String titulo)
	{
		g.setFont(fontTitle);
		g.setColor(colorTitulo);
		this.titulo = titulo;
		g.drawString(titulo, posXTitle,posYTitle);
	}
	
	public String getTitle()
	{
		return titulo;
	}
	
	public void toPorcentajes()
	{
		showByPorc=true;
	}
	
	public void toDatos()
	{
		showByPorc=false;
	}
	
	
	public void dibujarGraficaBarras(Graphics g,int x, int y)
	{
		deBarras = true;
		g.setColor(colorEjes);
		interseccion = mayor+y;
		actualizarXY();
		g.setFont(fontDatos);
			
		if(numCat>0)
			if(vertical)
			{
				nx=x+espacioBarras+15;
				g.drawLine(x, y, x, y+mayor+LINEA_SALIENTE);
				for(int i=y+mayor,ind=0; i>=y; i-=10,ind++)
				{
					if(ind%5==0)
						g.drawLine(x-10, i, x+10, i);
					
					else g.drawLine(x-5, i, x+5, i);
				}
				
				g.drawLine(x-LINEA_SALIENTE, interseccion, 
								anchoEjex+LINEA_SALIENTE+x, interseccion);
				
				if(byPorcentaes)
					drawRectangles(g, x, y, alturasY, y+mayor);
				else
					drawRectangles(g, x, y, disp, interseccion);
				
				drawCategorias(g, x+anchoEjex+50, y+10,mayor);
			}
				
			else
			{
				g.drawLine(x, y, x, y+anchoEjex+LINEA_SALIENTE);
				g.drawLine(x-LINEA_SALIENTE, y+LINEA_SALIENTE, x+mayor, y+LINEA_SALIENTE);
				
				for(int i=x,cont=0; i<=x+mayor; i+=10,cont++)
				{
					if(cont%5==0)
						g.drawLine(i, y+LINEA_SALIENTE-10, i, y+LINEA_SALIENTE+10);
					
					else
						g.drawLine(i, y+LINEA_SALIENTE-5, i, y+LINEA_SALIENTE+5);
				}
				
				nx = y+espacioBarras+LINEA_SALIENTE+1;
				
				for(i=0; i<numCat; i++)
					{
						g.setColor(colores[i]);
						
						if(byPorcentaes)
							g.fillRect(x+1, nx, alturasY[i], anchoBarras);
						
						else if(disp!=null)
							g.fillRect(x+1, nx, disp[i], anchoBarras);
						
						nx+=espacioBarras+anchoBarras;
					}
				
				drawCategorias(g, x+mayor+10, y+10,anchoEjex);
			}
	}
	
	private void drawRectangles(Graphics g, int x, int y, int arrRef[], int auxCord)
	{
		for(i=0; i<numCat; i++)
		{
			g.setColor(colores[i]);
			g.fillRect(nx, auxCord-arrRef[i], anchoBarras,arrRef[i]);
			nx+=espacioBarras+anchoBarras;
		}
	}
	
	public void dibujarBarraPastel(Graphics g,int x, int y)
	{
			if(disp!=null)
			{
				g.setFont(fontDatos);
				deBarras = false;
				actualizarXY();
				BigDecimal val = BigDecimal.ZERO, grd;
				
				for(i=0; i<disp.length; i++)
				{
					g.setColor(colores[i]);
					if(i!=0)
					{
						angIni+=grados;
					}
					
					grd = new BigDecimal(disp[i]).multiply(PI2.divide
							(total,5,RoundingMode.UP));
					
					val = val.add(grd.subtract(new BigDecimal(grd.intValue())));
					
					
					grados = grd.intValue();
					
					if(i==disp.length-1)
					{
						grados = grados+val.intValue()*2;
					}
					
					
					g.fillArc(x, y, radio, radio, angIni+rotacion, grados);
						
				}
				angIni  = 0;
				
				drawCategorias(g, x+radio+10, y,radio);
			}
		
	}
	
	//juan-jose-daniel-jose-jose-daniel-luis-luis-pedro
	private FontMetrics fontPropierties;
	private int widthFont;
	private void drawCategorias(Graphics g, int x, int y,int varFuncion)
	{
		mayorlength=0;
		int ny = y;
		//(y+radio)/2-20;
		for(i=0; i<numCat; i++)
		{
			g.setColor(colores[i]);
			
			concat=categorias[i]+"-";
			
			if(showByPorc)
				concat+=porcentajes[i]+"%";
			
			else
			{
				if(byPorcentaes)
					concat+=alturasY[i];
				
				else concat+=disp[i];
			}
				
			
			g.fill3DRect(x+20, ny, 20, 20,true);
			g.setColor(colorfuente);
			g.drawString(concat, x+50, ny+20);
			
			fontPropierties = g.getFontMetrics();
			
			widthFont = fontPropierties.stringWidth(concat);
			posicionesXYClick[i][0] = x+20;
			posicionesXYClick[i][1] = x+45+widthFont;
			
			if(widthFont>mayorlength)
				mayorlength = widthFont;
			
			posicionesXYClick[i][2] = ny;
			posicionesXYClick[i][3] = ny+fontPropierties.getHeight()-15;
			
			ny+=40;
			
			if(ny>y+varFuncion)
			{
				ny = y;
				x+=mayorlength+70;
			}
		}
	}
}
