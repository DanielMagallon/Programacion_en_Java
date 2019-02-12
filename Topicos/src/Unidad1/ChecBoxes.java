package Unidad1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChecBoxes extends Applet implements ItemListener
{

	Checkbox c1,c2,c3,c4,c5;
	Label lbl;
	
	@Override
	public void init() 
	{
		setSize(600,400);
		setLayout(new BorderLayout());
		
		c1 = new Checkbox("Windows");
		c2 = new Checkbox("Linux Fedora");
		c3 = new Checkbox("Mac OS");
		c4 = new Checkbox("Solaris");
		c5 = new Checkbox("Chrome OS");
		
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		c4.addItemListener(this);
		c5.addItemListener(this);
		
		Panel p = new Panel();
		
		p.setLayout(new GridLayout(6, 1));
		p.add(c1);
		p.add(c2);
		p.add(c3);
		p.add(c4);
		p.add(c5);
		
		add(p,BorderLayout.WEST);
		
		lbl = new Label("Cuales sistemas operativos has utilizado?",Label.CENTER);
		add(lbl,"North");
	}

	String resp="Yo he utilizado: ";
	
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		resp="Yo he utilizado: ";
		
		if(c1.getState())
			resp+=c1.getLabel()+", ";
		
		if(c2.getState())
			resp+=c2.getLabel()+", ";
		
		if(c3.getState())
			resp+=c3.getLabel()+", ";
		
		if(c4.getState())
			resp+=c4.getLabel()+", ";
		
		if(c5.getState())
			resp+=c5.getLabel()+", ";
			
		repaint();
	}
	
	@Override
	public void paint(Graphics g) 
	{
		g.drawString(resp, 300, 400);
	}
}
