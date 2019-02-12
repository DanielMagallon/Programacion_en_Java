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

public class ScrollFigura extends Applet implements AdjustmentListener
{

	Scrollbar scrollVertical;
	Scrollbar scrollHorizontal;
	int x,y;
	TextField txt,txt2;
	Label lbl,lbl2;
	
	
	@Override
	public void init() 
	{
		x  = y = 100;
		setSize(800,600);
		scrollVertical  = new Scrollbar(Scrollbar.VERTICAL,y,10,0,610);
		scrollHorizontal =  new Scrollbar(Scrollbar.HORIZONTAL, x,10,0,800);
		setLayout(new BorderLayout());
		
		scrollHorizontal.addAdjustmentListener(this);
		scrollVertical.addAdjustmentListener(this);
		
		txt = new TextField(x+" ");
		txt2 = new TextField(y+" ");
		
		lbl = new Label("X: ");
		lbl2 = new Label("Y: ");
		
		txt.setEditable(false);
		txt2.setEditable(false);
		
		Panel p = new Panel();
		p.add(lbl);
		p.add(txt);
		p.add(lbl2);
		p.add(txt2);
		
		add(p,BorderLayout.NORTH);
		add(scrollVertical,BorderLayout.EAST);
		add(scrollHorizontal,BorderLayout.SOUTH);
		
		scrollHorizontal.setBackground(Color.white);
		scrollVertical.setBackground(Color.white);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.blue);
		g.fillRect(x, y, 50, 50);
	}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) 
	{
		x = scrollHorizontal.getValue();
		y = scrollVertical.getValue();
		
		txt.setText(x+"");
		txt2.setText(y+"");
		
		repaint();
	}
	
}
