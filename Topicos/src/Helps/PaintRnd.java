package Helps;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PaintRnd extends JFrame 
{

	Random r = new Random();
			
	int incI=5,incJ=5;
	int x,i,j;
	boolean d;
	P p = new P();
	
	public PaintRnd() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		JButton btn = new JButton("A");
		add(btn,"South");
		add(p,"Center");
		
		btn.addActionListener
		(
				(a)->{
					d = true;
					p.repaint();
				}
				);
	}
	
	
	class P extends Canvas{
		@Override
		public void paint(Graphics g) 
		{
			super.paint(g);
			if(d)
			{
				for(i=0; i<=getHeight(); i+=incI)
				{
					for(j=0; j<=getWidth(); j+=incJ)
					{
//						 Color color = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
//						 g.setColor(color);
						
						 x = r.nextInt(2);
						
							if(x==0)
								g.setColor(Color.black);
							
							else g.setColor(Color.white);

							g.fillRect(j, i, i+incJ, j+incI);
//							g.drawLine(j, i, i*x, j*x);
					}
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		new PaintRnd().setVisible(true);
	}
}
