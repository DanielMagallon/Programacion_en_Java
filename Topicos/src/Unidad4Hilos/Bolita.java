package Unidad4Hilos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Bolita extends Thread
{
	static final int N=0,S=1,E=2,O=3,NE=4,NO=5,SE=6,SO=7;
	Random lb = new Random();
	int velocidad,radio,sentido,x,y;
	Color color;
	PanelBolita pb;
	
	public Bolita(PanelBolita p)
	{
		color = new Color(lb.nextInt(256),lb.nextInt(256),lb.nextInt(256));

		radio = lb.nextInt(100)+10;
		x = lb.nextInt(p.getWidth());
		y = lb.nextInt(p.getHeight());
		sentido = lb.nextInt(8);
		velocidad = 5;//(lb.nextInt(4)+1)*2;
		pb = p;
	}
	
	public void dibujar(Graphics g)
	{
		g.setColor(color);
		g.fillOval(x, y, radio, radio);
	}
	
	private void mover()
	{
		switch(sentido)
		{
			case 0://Arriba
				if(y-velocidad>=0)
					y-=velocidad;
				else {
					sentido = lb.nextInt(3)+3;
				}
				break;
				
			case 1://Arriba-der
				if(x+velocidad<pb.getWidth()-radio && y-velocidad>=0)
				{
					x+=velocidad;
					y-=velocidad;
				}
				else {
					sentido = lb.nextInt(3)+4;
				}
				break;
				
			case 2: //Der
				if(x+velocidad<pb.getWidth()-radio)
					x+=velocidad;
				
				else {
					sentido = lb.nextInt(3)+5;
				}
				break;
				
			case 3://Der-Ab
				if(x+velocidad<pb.getWidth()-radio && y+velocidad<pb.getHeight()-radio)
				{
					x+=velocidad;
					y+=velocidad;
				}
				else {
					sentido = lb.nextInt(3)+6;
					
					if(sentido==8)
						sentido=0;
				}
				break;
				
			case 4://Ab
				if(y+velocidad<pb.getHeight()-radio)
					y+=velocidad;
				else
				{
					sentido = lb.nextInt(3);
					
					if(sentido==2)
						sentido=7;
				}
				break;
		
			case 5: //AbIzq
				if(y+velocidad<pb.getHeight()-radio && x-velocidad>=0)
				{
					y+=velocidad;
					x-=velocidad;
				}
				else sentido = lb.nextInt(3);
				break;
				
			case 6://izq
				if(x-velocidad>=0)
					x-=velocidad;
				
				else sentido=lb.nextInt(3)+1;
				break;
				
			case 7://Arr-izq
				if(y-velocidad>=0 && x-velocidad>=0)
				{
					x-= velocidad;
					y-=velocidad;
				}
				else sentido=lb.nextInt(3)+2;
				break;
		}
	}
	
	@Override
	public void run()
	{
		while(pb.isVisible())
		{
			mover();
			pb.repaint();
			
			try
			{
				Thread.sleep(5);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}