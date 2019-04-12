package Helps;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import Libreria.Grafica;

public class PaintRnd extends JFrame 
{

	Random r = new Random();
			
	int incI=5,incJ=5;
	int x,i,j;
	boolean d;
	P p = new P();
	Grafica gr = new Grafica();
	public PaintRnd() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		JButton btn = new JButton("A");
		add(btn,"South");
		add(p,"Center");
		
		gr.setDatos(new int[] {100,200,700}, new String[] {"Hola","Mundo","Juan"});
		
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
				drawAsh(g);
		
//			if(d)
//			{
//				gr.dibujarBarraPastel(g, 20, 30);
//				gr.dibujarGraficaBarras(g, 100, 100);
//			}
//			if(d)
//			{
//				for(i=0; i<=getHeight(); i+=incI)
//				{
//					for(j=0; j<=getWidth(); j+=incJ)
//					{
//						 Color color = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
//						 g.setColor(color);
//						
////						 x = r.nextInt(2);
////						
////							if(x==0)
////								g.setColor(Color.black);
////							
////							else g.setColor(Color.white);
//
//							g.fillRect(j, i, i+incJ, j+incI);
////							g.drawLine(j, i, i*x, j*x);
//					}
//				}
//				
//			}
		}
	}
	
	private int ash[]=
		{0x0fc00000, 0x10200000, 0x20100000, 0x60380000, 0x83f80000, 0x61f80000, 0x29300000, 0x28300000,
0x20200000, 0x10d00000, 0x0f900000, 0x06500000, 0x06500000, 0x09e00000, 0x08400000, 0x07800000};



public void drawAsh(Graphics g)
{
	g.setColor(Color.black);
	
	int mascara = 1<<31;
	
	for (int i=0; i<ash.length; i++)
	{
		for (int c=0; c<=16; c++)
		{
			if((ash[i] & mascara >> 32) != 0)
			{
				g.drawLine(i, c, i, c);
			}
		}
	}
}
	
	public static void main(String[] args) {
		new PaintRnd().setVisible(true);
	}
}
