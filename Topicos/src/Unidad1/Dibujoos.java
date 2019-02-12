package Unidad1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Dibujoos  extends Applet implements ActionListener
{

	Panel p = new Panel();
	Panel pCentro = new Panel();
	String title[] = {"Circulo","Cuadrado","Color","Color aleatorio","Borrar todo"};
	Button botones[] = new Button[title.length];
		

	Graphics gPanel;
	Color c = Color.yellow;
	int x,y,r,g,b;
	Random rnd = new Random();
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout(10,10));
		setSize(1000,500);
		
		pCentro = new Panel();
		
		pCentro.setBackground(Color.lightGray);
		
		add(p,BorderLayout.WEST);
		p.setLayout(new GridLayout(10, 1,10,10));
		
		for(x=0; x<botones.length; x++)
		{
			p.add(botones[x] = new Button(title[x]));
			botones[x].addActionListener(this);
			
		}
		
		add(pCentro,"Center");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		gPanel = pCentro.getGraphics();
		gPanel.setXORMode(c);
		
		x = rnd.nextInt(pCentro.getWidth());
		y = rnd.nextInt(pCentro.getHeight());
		
		if(e.getSource() == botones[0])
		{
			gPanel.fillOval(x, y, 100, 100);
			pCentro.paint(gPanel);
			
		}
		else if(e.getSource() == botones[1])
		{
			gPanel.fillRect(x, y, 50, 50);
			pCentro.paint(gPanel);
		}
		else if(e.getSource() == botones[2])
		{
			c = JColorChooser.showDialog(this, "Escoge un color para la figura", Color.blue);
		}
		else if(e.getSource() == botones[3])
		{
			r = rnd.nextInt(256);
			g = rnd.nextInt(256);
			b = rnd.nextInt(256);
			
			c = new Color(r, g, b);
		}
		else
		{
			pCentro.repaint();
		}
	}
}

