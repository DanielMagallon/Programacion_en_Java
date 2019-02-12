package Unidad1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ScrollTamaño extends Applet implements AdjustmentListener
{
	int ancho=30,alto=30;
	Scrollbar scAncho = new Scrollbar(Scrollbar.HORIZONTAL,ancho,10,0,310);
	Scrollbar scAlto = new Scrollbar(Scrollbar.VERTICAL,alto,10,0,310);
	
	public void init()
	{
		setLayout(new BorderLayout());
		setSize(800,600);
		add(scAncho,"South");
		add(scAlto,"East");
		
		scAlto.setBackground(Color.white);
		scAncho.setBackground(Color.white);
		
		scAlto.addAdjustmentListener(this);
		scAncho.addAdjustmentListener(this);
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) 
	{
		if(e.getSource() == scAncho)
		{
			ancho = scAncho.getValue();
		}
		else{
			alto = scAlto.getValue();
		}
		
		repaint();
	}
	
	@Override
	public void paint(Graphics g) 
	{
				g.fillOval(getWidth()/2, getHeight()/2, ancho, alto);
				g.setFont(new Font("Arial", Font.ITALIC, 20*-1));
				g.drawString("Dibujando", 200, 200);
	}
}

