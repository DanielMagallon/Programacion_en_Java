package Unidad1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MoverFiggura extends Applet
{
	private static final long serialVersionUID = -32070700152345368L;
	
	int x,y,ancho,largo;
	boolean dentro=false;
	
	@Override
	public void init() 
	{
		x=100;
		y=100;
		ancho = 150;
		largo = 100;
		
		Adapter ad =  new Adapter();
		addMouseListener(ad);
		addMouseMotionListener(ad);
		addMouseWheelListener(ad);
		addKeyListener(new Key() );
		setSize(800, 600);
	}
	
	@Override
	public void paint(Graphics g) 
	{
		g.setColor(Color.blue);
		g.fillRect(x-(ancho/2), y-(largo/2), ancho, largo);
	}
	
	class Adapter extends MouseAdapter{
		
		@Override
		public void mousePressed(MouseEvent e) 
		{
			dentro = (e.getX()>=x-(ancho/2) && e.getX()<=(x-(ancho/2)+ancho)) && 
					(e.getY()>=y-(largo/2) && e.getY()<=(y-(largo/2)+largo));
		}
		
		@Override
		public void mouseDragged(MouseEvent e) 
		{
			if(dentro)
			{
				x = e.getX();
				y = e.getY();
				repaint();
			}
		}
		
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			// TODO Auto-generated method stub
			if(e.getWheelRotation()>0)
			{
				largo-=3;
				ancho-=5;
			}
			else {
				largo+=3;
				ancho+=5;
			}
			
			repaint();
		}
	}
	

	class Key extends KeyAdapter{
		
		int inc=5;
		boolean ctrl=false;
		
		@Override
		public void keyPressed(KeyEvent e) 
		{
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				x+=inc;
				
				if(x>getSize().width)
					x = 0;
			}
			
			else if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				x-=inc;
				
				if(x<0)
					x = getSize().width;
			}
			
			else if(e.getKeyCode() == KeyEvent.VK_UP)
			{
				y-=inc;
				
				if(y<0)
					y = getSize().height;
			}
			
			else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			
				y+=inc;
				
				if(y>getSize().height)
					y = 0;

			}
			
			else if(e.getKeyCode() == KeyEvent.VK_F1)
			{
				inc+=5;
				
				if(inc>15)
					inc=5;
			}
			
			else if(e.getKeyCode() == KeyEvent.VK_Q && ctrl)
				System.exit(0);
			
			ctrl = (e.getKeyCode() == KeyEvent.VK_CONTROL);
			
			
				
			
			repaint();
		}
	}
	
}
