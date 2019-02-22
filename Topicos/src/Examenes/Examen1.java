package Examenes;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

public class Examen1 extends Applet implements ActionListener, ItemListener
{
	List lista;
	PanelImagen pim = new PanelImagen();
	Image imagenes[], img;
	
	public void init()
	{
		setLayout(new BorderLayout());
		setSize(600,600);
		
		imagenes = new Image[] 
		{
			getImage(getClass().getResource("/Examenes/im1.jpg")),
			getImage(getClass().getResource("/Examenes/im2.jpg")),
			getImage(getClass().getResource("/Examenes/im3.jpg")),
			getImage(getClass().getResource("/Examenes/im4.jpg")),
		};
		
		
		lista = new List();
		lista.add("Dado cara 1");
		lista.add("Dado cara 2");
		lista.add("Dado cara 3");
		lista.add("Dado cara 4");
			
		add(lista,"West");
		add(pim,"Center");
		
//		lista.addActionListener(this);
		lista.addItemListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("Repo");
	
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		// TODO Auto-generated method stub
		img = imagenes[lista.getSelectedIndex()];
		pim.repaint();
	}
	
	
	class PanelImagen extends JPanel implements AdjustmentListener
	{
		Scrollbar scHori,scVert;
		int width=227,height=222;
	
		public PanelImagen() 
		{
			setLayout(new BorderLayout());
			setBackground(Color.white);
			
			scHori = new Scrollbar(Scrollbar.HORIZONTAL,227,0,0,227);
			scVert = new Scrollbar(Scrollbar.VERTICAL,222,0,0,222);
			
			scHori.setBackground(Color.white);
			scVert.setBackground(Color.white);

			
			scHori.addAdjustmentListener(this);
			scVert.addAdjustmentListener(this);
			
			add(scHori,"North");
			add(scVert,"East");
		}
		
		
		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) 
		{
			if(e.getSource() == scHori)
			{
				width  = scHori.getValue();
			}
			
			else if(e.getSource() == scVert)
			height = scVert.getValue();
			
			repaint();
		}
		
		
		@Override
		public void paint(Graphics g) 
		{
			super.paint(g);
			if(img!=null) 
			{
				g.drawImage(img, 200, 200, width, height, this);
			}
		}
	}
}
