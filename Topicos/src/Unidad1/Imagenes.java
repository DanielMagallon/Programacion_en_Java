package Unidad1;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;


public class Imagenes extends Applet
{

	Image img;
	
	@Override
	public void init() 
	{
		URL u =  getClass().getResource("/Unidad1/Images/a5.jpg");
		
		img = getImage(u);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(img, 0, 0,getWidth(),getHeight(),this);
	}
	
}
