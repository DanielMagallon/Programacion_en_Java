package Unidad1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Practica3 extends Applet implements ActionListener
{

	Button b1,b2,b3;
	TextField txt;
	int cant;
	
	@Override
	public void init() 
	{
		setLayout(new BorderLayout());
		setSize(900,500);
		
		Panel p1 =  new Panel();
		add(p1,"West");
		p1.setLayout(new GridLayout(5, 1, 10, 10));

		b1 =  new Button("Aleatorios");
		b2 =  new Button("Cuadrados");
		b3 =  new Button("Circulos");
		
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		
		txt  = new TextField(10);
		txt.setEditable(false);
		
		Panel up  = new Panel();
		up.add(new Label("Numero generado"));
		up.add(txt);
	
		add(up,"North");
		
		b1.addActionListener(this); 
		
		b2.addActionListener(this);

		b3.addActionListener(this);
		
		metodo = (g) -> g.fillRect(x, 200, 50, 50);
	}
	
	
	
	int x=150;
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Aleatorios"))
		{
			Random l = new Random();
			cant = l.nextInt(10)+1;
			txt.setText(cant+"");
		}
		
		else if(e.getActionCommand().equals("Cuadrados"))
			 metodo = (g) -> g.fillRect(x, 200, 50, 50);
			
			 else
				 metodo = (g) -> g.fillOval(x, 200, 50, 50);
		
		repaint();
	}
	
	Method metodo;
	
	@Override
	public void paint(Graphics g)
	{

		x = 150;
		for(int i=1; i<=cant; i++)
		{
			metodo.metodo(g);
			x+=70;
		}
	}
}
