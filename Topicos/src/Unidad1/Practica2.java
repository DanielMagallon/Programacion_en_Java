package Unidad1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Practica2 extends Applet{

	Button btnCiruclos,btnCuadrado;
	Scrollbar sc;
	Panel dib;
	int alt = 10;
	boolean circulos=true;

	@Override
	public void init()
	{
		setSize(600,500);
		btnCiruclos = new Button("Circulos");
		btnCuadrado = new Button("Cuadrados");
		
		sc  = new Scrollbar(Scrollbar.VERTICAL,10,0,0,200);
		sc.setBackground(Color.white);
		setLayout(new BorderLayout());
		
		Panel p = new Panel();
		
		dib = new PanelDib();
		
		p.setLayout(new GridLayout(5,1,10,10));
		p.add(btnCiruclos);
		p.add(btnCuadrado);
		
		add(p, "West");
		add(sc,"East");
		add(dib,"Center");
		
		btnCiruclos.addActionListener(
				
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						circulos=true;
						dib.repaint();
					}
				}
				
				);
		
	btnCuadrado.addActionListener(
				
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						circulos=false;
						dib.repaint();
					}
				}
				
				);
	
	sc.addAdjustmentListener(new AdjustmentListener() {
		
		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			// TODO Auto-generated method stub
			alt = sc.getValue();
			dib.repaint();
		}
	});
		
	}
	
	class PanelDib extends Panel{
		@Override
		public void paint(Graphics g) {
			
			if(circulos)
				g.drawOval(50, 100, alt, alt);
			
			else 
				g.drawRect(50, 100, alt, alt);
		}
		
	}

}
