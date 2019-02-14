package Unidad1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.JOptionPane;

public class Practica4 extends Applet implements ItemListener, ActionListener
{
	
	Choice choice;
	Button aleatorios;
	int r,g,b,trans;
	TextField txtR,txtG,txtB,txtTrans;
	Random lb = new Random();
	Method metodo;
	
	@Override
	public void init() 
	{
		setLayout(new BorderLayout());
		setSize(700,600);
		metodo = (a) -> a.fillPolygon(new int[] {150,450,150}, new int[] {200,200,450}, 3);
		
		Panel up = new Panel();
		up.setLayout(new FlowLayout(FlowLayout.LEFT));
		Label lbl = new Label("Selecciona una figura para dibujar");
		choice = new Choice();
		choice.add("Triangulo");
		choice.add("Circulo");
		choice.add("Rectangulo redondeado");
		choice.add("Salir");
		
		choice.addItemListener(this);
		
		up.add(lbl);
		up.add(choice);
		add(up,"North");
		
		
		txtR = new TextField(5);
		txtG = new TextField(5);
		txtB = new TextField(5);
		txtTrans = new TextField(5);
		
		aleatorios = new Button("RGB aleatorio");
		
		random();
		
		Panel sur = new Panel();
		sur.add(aleatorios);
		sur.add(txtR);
		sur.add(txtG);
		sur.add(txtB);
		sur.add(txtTrans);
		add(sur,"South");
		
		txtR.addActionListener(this);
		txtG.addActionListener(this);
		
		txtB.addActionListener(this);
		txtTrans.addActionListener(this);
		aleatorios.addActionListener(this);
		
	}
	
	private void random()
	{
		r = lb.nextInt(256);
		g = lb.nextInt(256);
		b = lb.nextInt(256);
		trans = lb.nextInt(256);
		
		txtR.setText(r+"");
		txtG.setText(g+"");
		txtB.setText(b+"");
		txtTrans.setText(trans+"");
		
		color = new Color(r,g,b,trans);
	}
	
	public int convierte(String texto)
	{
		int c;
		
		
		try
		{
			c = Integer.parseInt(texto);
			
			if(c<0)
			{
				throw new NumberFormatException();
			}
			return c;
		}
		catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Solo datos enteros positivos","Error",
						JOptionPane.ERROR_MESSAGE);
			return -1;
		}

	}
	
	Color color;
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == aleatorios)
			random();
		
		if(e.getSource() == txtR) {
			r = convierte(txtR.getText());
			
			if(r==-1)
				return;
		}
		
		else if(e.getSource() == txtG) {
			g = convierte(txtG.getText());
			
			if(g==-1)
				return;
		}
		
		else if(e.getSource() == txtB) {
			b = convierte(txtB.getText());
			
			if(b==-1)
				return;
		}
		
		else if(e.getSource() == txtTrans) {
			trans = convierte(txtTrans.getText());
			
			if(trans==-1)
				return;
		}
		
		color = new Color(r,g,b,trans);
		
		repaint();
	}
	
	@Override
	public void paint(Graphics g) 
	{
		g.setColor(color);
		
		metodo.metodo(g.create());
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		switch(choice.getSelectedIndex())
		{
			case 0:
				metodo = (a) -> a.fillPolygon(new int[] {150,450,150}, new int[] {200,200,450}, 3);
				break;
				
			case 1:
				metodo = (a) -> a.fillOval(150,200,350,350);
				break;
			
			case 2:
				metodo = (a) -> a.fillRoundRect(150, 200, 350, 200, 40, 40);
				break;
				
			case 3: 
				JOptionPane.showMessageDialog(this, "App finalizada", "Saliendo", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
		}
		
		repaint();
	}
}
