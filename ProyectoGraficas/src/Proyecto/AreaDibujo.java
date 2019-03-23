package Proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
	
	private transient BufferedImage bi;
	private transient Graphics2D big;
	
	private transient Image img;

	public AreaDibujo()
	{
		fondo();
		gr.setDatos(new int[] { 50,20,100,80,250});
	}
	
	public void fondo()
	{
		img =  Appi.getImageIcon("/ImagesFondo/","img2.jpg").getImage();
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
	
	public void rotar()
	{
		gr.setRotacion(gr.getAnguloRotacion()+5);
		repaint();
	}
	
	int tam=300;
	public void cambiarTamaño()
	{
		gr.setRadio(tam);
		tam+=30;
		repaint();
	}

	protected void drawOnImage()
	{
		if(bi==null)
		{
			bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
			big = bi.createGraphics();
			
		}
		
		big.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		gr.setTitle(big, cad,Grafica.NORTE,Fuentes.colorfuente,Fuentes.fuente);
		gr.dibujarBarraPastel(big, 50, 100);
	}

}
