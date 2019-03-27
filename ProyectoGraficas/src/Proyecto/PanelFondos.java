package Proyecto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelFondos extends JPanel
{
	int rows=1;
	private GridLayout gridL;
	
	public PanelFondos()
	{
		gridL = new GridLayout(rows, 1,0,10);
		setBackground(Color.white);
		setLayout(gridL);
		
		for(int i=1; i<=rows; i++)
		add(new JLabel(Appi.getScaledImageIcon("ImagesFondo/", "Img.jpg", 80, 80)));
	}
}
