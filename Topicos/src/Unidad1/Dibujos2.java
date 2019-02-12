package Unidad1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JColorChooser;

public class Dibujos2 extends Applet implements ActionListener {

	Panel p = new Panel();
	Button botones[] = new Button[3];
	String title[] = {"Circulo","Cuadrado","Color"};
	PanelDibujo pd = new PanelDibujo();

	Graphics gPanel;
	int x,y,r,g,b;
	Random rnd = new Random();
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout(10,10));
		setSize(1000,500);
		
		r = rnd.nextInt(256);
		g = rnd.nextInt(256);
		b = rnd.nextInt(256);
		
		pd = new PanelDibujo();
		pd.setBackground(Color.lightGray);

		add(p,BorderLayout.WEST);
		p.setLayout(new GridLayout(10, 1,10,10));
		
		for(x=0; x<botones.length; x++)
		{
			p.add(botones[x] = new Button(title[x]));
			botones[x].addActionListener(this);
			
		}
		
		add(pd,"Center");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource() == botones[0])
		{
			pd.dibujar(false);
		}
		
		else if(e.getSource() == botones[1])
		{
			pd.dibujar(true);
		}
		else if(e.getSource() == botones[2])
		{
			r = rnd.nextInt(256);
			g = rnd.nextInt(256);
			b = rnd.nextInt(256);
		}
		
	}
	
	class PanelDibujo extends Panel
	{
		private boolean cuadro;
		
		
		@Override
		public void paint(Graphics g) 
		{
			{
				g.setColor(new Color(r,Dibujos2.this.g,b));
				
				x = rnd.nextInt(getWidth());
				y = rnd.nextInt(getHeight());
				
				if(cuadro)
					g.fillRect(x, y, 100, 100);
				else
					g.fillOval(x, y, 100, 100);
			}
				
		}
		
		public void dibujar(boolean cuadro)
		{
			this.cuadro = cuadro;
			repaint();
		}
	}

}
