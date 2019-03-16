package Simulacion;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JScrollBar;

public class Grafica extends Canvas
{
	public Grafica()
	{
		// TODO Auto-generated constructor stub
		
	}
	
	int dim=10,x,y;
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		x = y = 10;
		
		for(int i=1; i<=100; i++)
		{
			x=10;
			for(int j=1; j<=100; j++)
			{
				g.drawRect(x, y, dim, dim);
				x+=dim;
			}
			
			y+=dim;
		}
	}
	
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		JScrollBar sc = new JScrollBar();
		f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.add(new Grafica(),"Center");
		f.add(sc,"West");
		f.setVisible(true);
		
	}
}
