package Proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import Libreria.Grafica;

public class AreaDibujo extends JComponent implements Serializable
{

	private static final long serialVersionUID = -2210544801040938245L;
	private Grafica gr = new Grafica();

	public String cad="";
	
	private int TYPO_GRAFICA; 
	
	private transient BufferedImage bi;
	private transient Graphics2D g2d;
	
	private transient Image img;

	private int xFig,yFig;
	
	public AreaDibujo()
	{
		fondo();
//		addMouseMotionListener(new Arrastre());
		TYPO_GRAFICA = 1;
		xFig = yFig = 100;
		gr.setDatos(new int[] {50,50});
	}
	
	public void fondo()
	{
		img =  Appi.getImageIcon("ImagesFondo/","Img.jpg").getImage();
	}

	public void crearPNG()
	{
		try
		{
			File f = new File("img");
			ImageIO.write(bi, "png", f);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);

		Graphics2D g2 = (Graphics2D) g;

		drawOnImage();

		g2.drawImage(bi, null, this);

	}
	
	public void rotar(int ang)
	{
		gr.setRotacion(gr.getAnguloRotacion()+ang);
		repaint();
	}
	
	public void disminuir()
	{
		if(gr.radioValido())
		{
			gr.setRadio(gr.getRadio()-30);
			repaint();
		}
	}
	
	public void setPositionTitle(int p)
	{
		gr.setTitleOrientation(p);
		repaint();
	}
	
	public void aumentar()
	{
		gr.setRadio(gr.getRadio()+30);
		repaint();
	}

	protected void drawOnImage()
	{
		if(bi==null)
		{
			bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
			g2d = bi.createGraphics();
			
		}

		g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		gr.setTitle(g2d, cad,Fuentes.colorfuente,Fuentes.fuente);
		
		if(TYPO_GRAFICA == 1)
		{
			gr.dibujarBarraPastel(g2d, xFig, yFig);
		}
		else if(TYPO_GRAFICA == 2)
		{
			gr.dibujarGraficaBarras(g2d, xFig, yFig);
		}
			
	}

	class Arrastre extends MouseMotionAdapter
	{
		@Override
		public void mouseDragged(MouseEvent e)
		{
			
			repaint();
		}
	}
}
