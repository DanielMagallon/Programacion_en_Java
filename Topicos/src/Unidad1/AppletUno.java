package Unidad1;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;


public class AppletUno extends Applet
{
	private static final long serialVersionUID = -2558454609447563001L;

	private Button btn = new Button("Aprieta");
	
	String cad="";
	
	@Override
	public void init() 
	{
		super.init();
		cad += "inicio-";
		setSize(700,500);
	}
	
	@Override
	public void start() 
	{
		super.start();
		cad+="start-";
	}
	
	boolean opc =   true;
	
	@Override
	public void paint(Graphics g) 
	{
		if(opc)
		{
		cad+="paint-";
		g.setColor(Color.pink);
		g.drawString(cad, 15, 15);
		opc=false;
		}else {
			repaint();
		}
	}
	
	@Override
	public void update(Graphics g) 
	{
		cad+="Update-";
		g.setColor(Color.red);
		g.drawString(cad, 20, 20);
		opc=true;
	}

	@Override
	public void stop() 
	{
		super.stop();
		
		cad+="stop-";
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("FIn");
	}
}
