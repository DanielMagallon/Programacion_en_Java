package Unidad1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;

import javax.swing.JColorChooser;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;

public class Applet2 extends Applet implements ActionListener
{
//	Timer timer = new Timer(1000, new ActionListener() 
//	{
//		
//		@Override
//		public void actionPerformed(ActionEvent e) 
//		{
//			
//			x+=30;
//			timer.stop();
//			repaint();
//		}
//	});
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8505393011695925430L;
	int x = 400;
	int y = 400;
	Button btn[] = new Button[10];
	
	
	@Override
	public void init() 
	{
		setBackground(new Color(0xAAFF));
		setForeground(Color.BLUE);
		setSize(600,600);
		//20 espacio horizonta,20 espacio vertical
		setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
		
		for(int i=0; i<btn.length; i++)
		{
			add( btn[i] = new Button("Boton "+(i+1)));
			btn[i].addActionListener(this);
		}
	}
	
	
	@Override
	public void paint(Graphics g) 
	{
		showStatus("Hail Quiñoness");
		g.drawString("Texto a color", 100, 200);
		g.setColor(Color.black);
		g.drawRect(170, 200, 80, 80);
		g.fillOval(x, 400, 120, 120);
		g.setColor(Color.yellow);
		g.fillPolygon(new int[]{50,150,100}, new int[]{100,100,150}, 3);
		Dimension d = getSize();
		g.drawLine(0, 0, d.width, d.height);
//		timer.start();
	}
	
	@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			Graphics g2 = getGraphics();
			
			g2.setColor(Color.lightGray);
			g2.fillOval(x+50, 500, 100, 120);
		}
}
