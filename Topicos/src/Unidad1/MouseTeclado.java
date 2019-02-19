package Unidad1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class MouseTeclado extends Applet
{
	int x,y,ancho,alto,dibujo;
	Button btnCuadrado,btnCirculo,btnLinea;
	
	Method metodo  = (g) -> 
	{
		g.drawRect(x, y, ancho, alto);
	};
	
	@Override
	public void init() 
	{
		setSize(600,600);
		addMouseListener(new MousePressed());
		addMouseMotionListener(new MouseArrastre());
		setLayout(new BorderLayout());
		
		Panel opciones = new Panel();
		
		btnCuadrado = new Button("Cuadrado");
		btnCuadrado.addActionListener(
				
				(a)->
				{
					metodo = (g) -> 
					{
						g.drawRect(x,y,ancho,alto);
					};
					
					dibujo=0;
				}
				
				);
		
		btnCirculo = new Button("Circulo");
		btnCirculo.addActionListener(
				
				(a)->
				{
					metodo = (g)->
						{
							g.drawOval(x, y, ancho, alto);
						};
						
					dibujo = 1;
				}
				);
		
		btnLinea = new Button("Linea");
		btnLinea.addActionListener(
				
					(a)->
					{
						metodo = (g)->
						{
							g.drawLine(x, y, ancho, alto);
						};
						
						dibujo = 2;
					}
				
				);
		
		setBackground(Color.white);
		opciones.add(btnCuadrado);
		opciones.add(btnCirculo);
		opciones.add(btnLinea);
		add(opciones,"North");
		
	}
	
	ArrayList<Figura> figuras = new ArrayList<Figura>();

	boolean entro=false;
	Graphics g2;
	
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		paint(g);
	}
	
	@Override
	public void paint(Graphics g) 
	{
		{
//			for(Figura fig : figuras)
//				fig.dibujar(g);
			
	
			metodo.metodo(g);
		}
		
//		if(xPintar!=-1)
//		{
//			g.setColor(Color.cyan);
//			pintarArea((Graphics2D)g, xPintar, yPintar);
//			xPintar = -1;
//		}
		
	}
	
	private void pintarArea(Graphics2D g, int x,int y)
	{
		
	}
	
	int xPintar=-1,yPintar=-1;
	
	class MousePressed extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			xPintar = e.getX();
			yPintar = e.getY();
			repaint();
		}
		
		@Override
		public void mousePressed(MouseEvent e) 
		{
			x = e.getX();
			y = e.getY();
		}
		
		@Override
		public void mouseReleased(MouseEvent e) 
		{
			if(ancho!=0 || alto!=0)
			{
				figuras.add(new Figura(x, y, ancho, alto,dibujo));
				ancho = alto = 0;
			}
		}
	}
	

	class MouseArrastre extends MouseMotionAdapter{
		@Override
		public void mouseDragged(MouseEvent e) 
		{
			if(dibujo==2)
			{
				ancho = e.getX();
				alto = e.getY();
			}
			else 
			{
			ancho = e.getX()-x;
			alto = e.getY()-y;
			}

			repaint();
		}
	}
	
	class Figura extends Rectangle
	{
		int valor;
		
		public Figura(int x, int y, int ancho,int alto,int v) 
		{
			super(x, y, ancho, alto);
			valor = v;
		}
		
		public void dibujar(Graphics g)
		{
			switch(valor)
			{
				case 0:
					g.drawRect(super.x, super.y, super.width, super.height);
					break;
					
				case 1:
					g.drawOval(super.x, super.y, super.width, super.height);
					break;
					
				case 2:
					g.drawLine(super.x, super.y, super.width, super.height);
					break;
			}
		}
	}
}

