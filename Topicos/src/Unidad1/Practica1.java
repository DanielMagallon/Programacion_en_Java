package Unidad1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@SuppressWarnings("serial")
public class Practica1 extends Applet implements AdjustmentListener, ItemListener
{
	String cad;
	Scrollbar sc;
	Choice choiceTipo,choiceTam;
	Panel panelTexto;
	
	@Override
	public void init() 
	{
		setSize(600, 600);
		
		cad = "Cadena controlada por scrollbar";
		
		setLayout(new BorderLayout());
		
		String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		choiceTipo = new Choice();
		choiceTipo.add("Escoge una fuente");
		choiceTam = new Choice();
		choiceTam.add("Escoge un tamaño");
		
		for(String f : fuentes)
				choiceTipo.add(f);
				
		for(int i=1; i<=100; i++)
		{
			choiceTam.add(i+"");
			choiceTam.add((-i)+"");
		}
		
		panelTexto = new PanelTexto();
		
		
		sc = new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,cad.length());
		sc.addAdjustmentListener(this);
		
		sc.setBackground(Color.white);
		add(sc,"South");
		
		Panel north = new Panel();
		north.add(choiceTipo);
		north.add(choiceTam);
		
		choiceTam.select(63);
		
		add(north,"North");
		add(panelTexto,"Center");
		
		choiceTipo.addItemListener(this);
		choiceTam.addItemListener(this);
	}
	
	Font font = new Font(Font.DIALOG,Font.BOLD,32);
	
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) 
	{
		char c[] = cad.toLowerCase().toCharArray();
		int val = e.getValue();
		String cd = String.valueOf(c[val]).toUpperCase();
		c[val]  = cd.charAt(0);
		cad = new String(c);
		panelTexto.repaint();

	}
	
	
	int x=1;
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		
		x=32;
		if(choiceTam.getSelectedIndex()!=0)
			 x = Integer.parseInt(choiceTam.getSelectedItem());
		
		
		font = new Font(choiceTipo.getSelectedItem(),Font.BOLD|Font.ITALIC,x);
		panelTexto.repaint();
	}
	

	class PanelTexto extends Panel
	{
		@Override
		public void paint(Graphics g) 
		{
			
			g.setFont(font);
			if(x>0)
				g.drawString(cad, 50, 240);
			else
				g.drawString(cad, getWidth(), 240);
		}
	}
}
