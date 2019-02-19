package Unidad1;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class EventoRaton extends Applet implements MouseListener, MouseWheelListener
{
	String cad="";
	int x,y;
	
	@Override
	public void init() 
	{
		setSize(800,600);
		addMouseListener(this);
		addMouseMotionListener(new Motion());
		addMouseWheelListener(this);
	}
	
	@Override
	public void paint(Graphics g) 
	{
		g.drawString(cad, x, y);
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		cad="Presionaste un boton del raton";
		x = e.getX();
		y = e.getY();
		repaint();
		
		//e.BUTTON1,2,3 = izquierdo,medio,derecho
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub

		if(e.getWheelRotation()>0)
			y++;
		else y--;
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		
	}
	
	class Motion extends MouseMotionAdapter{
		 
		@Override
		public void mouseDragged(MouseEvent e) 
		{
			x = e.getX();
			y = e.getY();
			repaint();
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			//super.mouseMoved(e);
			x = e.getX();
			y = e.getY();
			repaint();
		}
	}
	
	class Key extends KeyAdapter{
		
		/*
		 * keyTyped(KeyEvent e): Se ejecuta cuando el usuario presiona una tecla, 
		 * pero solo cuando la tecla corresponde a caractéres
		 */
	}
}
