package Unidad1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.TextField;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Prcatica1 extends Applet implements AdjustmentListener
{
	Scrollbar sc1,sc2;
	TextField txt1,txt2;
	Panel p2 = new PanelDibujo();
	
	@Override
	public void init() 
	{
		
		setSize(660,500);
		sc1 = new Scrollbar(Scrollbar.HORIZONTAL,0,0,0,11);
		
		sc2 = new Scrollbar(Scrollbar.HORIZONTAL,0,0,0,11);
		
		sc1.setBackground(Color.white);
		sc2.setBackground(Color.white);
		
		setLayout(new BorderLayout());
		
		Label l1 = new Label("Num1");
		Label l2 = new Label("Num2");
		
		txt1 = new TextField(10);
		txt2 = new TextField(10);
		Panel p1 = new Panel();
		
		p1.add(l1);
		p1.add(txt1);
		p1.add(l2);
		p1.add(txt2);
	
		add(p1,"North");
		
		
		
		p2.setLayout(null);
	
		sc1.setBounds(30,40,500,20);
		sc2.setBounds(30,70,500,20);
		
		p2.add(sc1);
		p2.add(sc2);
		add(p2,"Center");
		
		sc1.addAdjustmentListener(this);
		sc2.addAdjustmentListener(this);
	}
	
	int circulos,rectan;
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) 
	{
		
		circulos = sc1.getValue();
		rectan = sc2.getValue();
		txt1.setText(sc1.getValue()+"");
		txt2.setText(sc2.getValue()+"");
		p2.repaint();
	}
	
	class PanelDibujo extends Panel{
		
		@Override
		public void paint(Graphics g) 
		{
			int x=20;
			g.setColor(Color.red);
			for (int i = 1; i <=circulos; i++) 
			{
				g.fillOval(x, 100, 50, 30);
				x+=50;
			}
			
			x=20;
			g.setColor(Color.red);
			for (int i = 1; i <=rectan; i++) 
			{
				g.fillRect(x, 150, 50, 30);
				x+=60;
			}
		}
	}
}
