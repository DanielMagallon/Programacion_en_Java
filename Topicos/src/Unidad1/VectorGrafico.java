package Unidad1;

import java.applet.Applet;
 import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.util.Random;

import javax.swing.JOptionPane;

public class VectorGrafico extends Applet{

	Label lbl = new Label("Valor: ");
	TextField txt = new TextField(5);
	Button btnReset = new Button("Reset");
	int nums[] = new int[10];
	int ind=-1;
	
	@Override
	public void init() 
	{
		setSize(900,700);
		add(lbl);
		add(txt);
		
		add(btnReset);
		
		txt.addActionListener(
				
				(a)->{
					
					try
					{
						int num = Integer.parseInt(txt.getText());
						
						if(num<=300 && ind<nums.length-1)
						{
							nums[++ind] = num;
						}
						
					}
					catch(NumberFormatException e)
					{
						JOptionPane.showMessageDialog(this, "Error","Solo datos numericos"
								,JOptionPane.ERROR_MESSAGE);
					}
					
					txt.setText("");
					repaint();
				}
				
				);
		
		btnReset.addActionListener(
				
				(a) -> 
				{
					ind=-1;
					repaint();
				}
		);
		
	}
	
	int x = 100,y=100,ancho=80,largo=50;
	@Override
	public void paint(Graphics g) 
	{
		dibujaGraficos(g);
		
		if(ind==9)
		{
			Random lb = new Random();
			int r;
			int gg;
			int b;
			
			
			x=301;
			y=450;
			r = lb.nextInt(256);
			gg = lb.nextInt(256);
			b = lb.nextInt(256);
			g.setColor(new Color(r,gg,b));
			
			for(int i=0; i<=ind; i++)
			{
				
				///
				g.fillRect(x, y-nums[i], 45, nums[i]);
				r = lb.nextInt(256);
				gg = lb.nextInt(256);
				b = lb.nextInt(256);
				g.setColor(new Color(r,gg,b));
				///
				
				/////
//				g.drawString("P", x+45, y-nums[i]);
				
//				if(ind>0 && i>=1)
//				{
//					g.drawLine(x, y-nums[i-1], x+45, y-nums[i]);
//				}
				/////
				
				x+=45;
			}
		}
	}
	
	public void dibujaGraficos(Graphics g)
	{
		x = 100;y=100;ancho=80;largo=50;
		g.setColor(Color.black);
		
		for(int i=0; i<10; i++)
		{
			g.drawRect(x, y, ancho, largo);
			y+=largo;
		}
	
		x=130;
		y=135;
		
		for(int i=0; i<=ind; i++)
		{
			g.drawString(nums[i]+"", x, y);
			y+=largo;
		}
		
		/**
		 * Punto referncia por la lineas (300,450);
		 */
		g.setColor(Color.blue);
		g.drawLine(300, 150, 300, 500);
		
		g.drawLine(280, 450, 750, 450);
	}
}
