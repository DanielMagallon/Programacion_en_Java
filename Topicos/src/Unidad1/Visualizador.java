package Unidad1;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


import java.applet.Applet;


public class Visualizador extends Applet implements ActionListener
{ 

	private static final long serialVersionUID = 9075691708862803195L;
	
	Image img[] = new Image[3];
	Button btnNext,btnBefore;
	Label titulo;
	int numIm;
	String tit[] = new String[img.length]; 
	
	public void init()
	{
		setSize(800,500);
		btnNext = new Button("Siguiente");
		btnBefore = new Button("Anterior");
		
		
		for(; numIm<img.length; numIm++)
		{
			
			URL url = getClass().getResource("/Unidad1/Recursos/dalas"+(numIm+1)+".jpg"); 
			tit[numIm] = "dalas"+(numIm+1)+".jpg";
			img[numIm]= getImage(url);
			
		}
		
		numIm=0;
		titulo = new Label(tit[numIm]);

	
		btnNext.addActionListener(this);
		btnBefore.addActionListener(this);

		add(btnBefore);
		add(titulo);
		add(btnNext);

	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnNext)
		{
			numIm++;

			if(numIm==img.length)
				numIm=0;
			
		}

		else 
		{
			numIm--;

			if(numIm<0)
				numIm = img.length-1;
		}		

		titulo.setText(tit[numIm]+"");
		repaint();
	}

	public void paint(Graphics g)
	{
		g.drawImage(img[numIm],100,100,500,400,this);
	}
}
