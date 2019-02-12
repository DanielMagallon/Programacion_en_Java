package Unidad1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


public class ScrollColor extends Applet implements AdjustmentListener,ActionListener
{
	
	int r,g,b;
	
	TextField txt1 = new TextField("0");
	Scrollbar sc1 = new Scrollbar(Scrollbar.VERTICAL, 0, 10, 0, 265);
	
	TextField txt2 = new TextField("0");
	Scrollbar sc2 = new Scrollbar(Scrollbar.VERTICAL, 0, 10, 0, 265);
	
	TextField txt3 = new TextField("0");
	Scrollbar sc3 = new Scrollbar(Scrollbar.VERTICAL, 0, 10, 0, 265);
	
	
	public void init()
	{
		setLayout(null);
		setSize(800, 600);
		
		Label lblRed = new Label("Red: ",Label.CENTER);
		
		lblRed.setBounds(20,20,40,20);
		txt1.setBounds(100, 20, 50, 20);
		sc1.setBounds(80, 70, 20, 300);
		sc1.setBackground(Color.white);
		
		Label lblGreen = new Label("Green: ",Label.CENTER);
		lblGreen.setBounds(180,20,40,20);
		txt2.setBounds(260,20,50,20);
		sc2.setBounds(220, 70, 20, 300);
		sc2.setBackground(Color.white);
		
		Label lblBlue = new Label("Blue:",Label.CENTER);
		lblBlue.setBounds(340, 20, 40, 20);
		txt3.setBounds(420,20,50,20);
		sc3.setBackground(Color.white);
		sc3.setBounds(380, 70, 20, 300);
		
		add(sc1);
		add(txt1);
		add(lblRed);
		add(sc2);
		add(txt2);
		add(sc3);
		add(lblGreen);
		add(txt3);
		add(lblBlue);
		
		sc1.addAdjustmentListener(this);
		sc2.addAdjustmentListener(this);
		sc3.addAdjustmentListener(this);
		
		txt1.addActionListener(this);
		txt2.addActionListener(this);
		txt3.addActionListener(this);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == txt1)
		{
			try
			{
				r = Integer.parseInt(txt1.getText());
				sc1.setValue(r);
			}
			catch(NumberFormatException ex){}
		} 
		else if(e.getSource() == txt2)
		{
			try
			{
				g = Integer.parseInt(txt2.getText());
				sc2.setValue(g);
			}
			catch(NumberFormatException ex){}

		}
		
		else{
			try
			{
				b = Integer.parseInt(txt3.getText());
				sc3.setValue(b);
			}
			catch(NumberFormatException ex){}

		}
		
		repaint();
	}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) 
	{
		if(sc1 == e.getSource())
		{
			r = sc1.getValue();
			txt1.setText(r+"");
		}
		else if(sc2 == e.getSource())
		{
			g = sc2.getValue();
			txt2.setText(g+"");
		}
		else{
			
			b = sc3.getValue();
			txt3.setText(b+"");
			
		}
		
		repaint();
	}
	
	@Override
	public void paint(Graphics g) 
	{
		g.setColor(new Color(r,this.g,b));
		
		g.fillRect(600, 200, 100, 100);
	}
} 

