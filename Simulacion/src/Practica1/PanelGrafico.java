package Practica1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.Timer;


public class PanelGrafico extends Canvas{

	private static final long serialVersionUID = -2037183031447651698L;
	
	private Ejecutable filaEspera;
	
	Random lb = new Random();
	int x=1,y=1,z=1;
	
	public Timer timer = new Timer(30, 
			
				(a) -> 
				{
					
						x = lb.nextInt(6)+1;
						y = lb.nextInt(6)+1;
						z = lb.nextInt(6)+1;
						repaint();
					
				
				}
			
			);
	
	public PanelGrafico(Ejecutable tb) {
		filaEspera = tb;
		addMouseListener(new Click());
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		g.setColor(Color.white);
		g.fillRoundRect(5, 15, 790, 170,80,80);
		
		
		g.setColor(Color.black);
		g.fillRoundRect(40, 35, 130, 130, 40, 40);
		
		g.setColor(Color.white);
		dibujarNumeracion(1, x,g);
		
		g.setColor(Color.pink);
		g.fillRoundRect(340, 35, 130, 130,40,40);
		g.fillRoundRect(640, 35, 130, 130,40,40);
	
		g.setColor(Color.black);
		g.fillRect(550, 40, 5, 120);
		g.fillRect(495, 100, 120, 5);
		g.drawString("Click para parar", 50, 10);
		
		
		dibujarNumeracion(2, y,g);
		dibujarNumeracion(3, z,g);
	}
	
	private void dibujarNumeracion(int dado, int numero,Graphics g)
	{
		int compensacion = (dado-1)*300;
			switch(numero)
			{
				case 1:
					g.fillOval(90+compensacion, 90, 25, 25);
					break;
					
				case 2:
					g.fillOval(90+compensacion, 65, 25, 25);
					g.fillOval(90+compensacion, 110, 25, 25);
					break;
					
				case 3:
					g.fillOval(50+compensacion, 45, 25, 25);
					g.fillOval(130+compensacion, 130, 25, 25);
					g.fillOval(90+((dado-1)*300), 84, 25, 25);
					break;
					
				case 4:
					g.fillOval(50+compensacion, 50, 25, 25);
					g.fillOval(50+compensacion, 130, 25, 25);
					
					g.fillOval(130+compensacion, 50, 25, 25);
					g.fillOval(130+compensacion, 130, 25, 25);
					break;
					
				case 5:
					g.fillOval(50+compensacion, 50, 25, 25);
					g.fillOval(50+compensacion, 130, 25, 25);
					
					g.fillOval(90+compensacion, 90, 25, 25);

					g.fillOval(130+compensacion, 50, 25, 25);
					g.fillOval(130+compensacion, 130, 25, 25);
					break;
					
				case 6:
					
					g.fillOval(50+compensacion, 50, 25, 25);
					g.fillOval(50+compensacion, 130, 25, 25);
					
					g.fillOval(50+compensacion, 90, 25, 25);
					g.fillOval(130+compensacion, 90, 25, 25);

					g.fillOval(130+compensacion, 50, 25, 25);
					g.fillOval(130+compensacion, 130, 25, 25);
					
					break;
			}
	}
		
	
	class Click extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			if(timer.isRunning())
			{
				restablecer();
			}
		}
	}
	
	public void restablecer()
	{
		timer.stop();
		filaEspera.nuevaFila(x, y+z);
		
		filaEspera.btnGenera.setEnabled(true);
		filaEspera.btnCrearLan.setText("Crear lanzamientos");
	}
}

