package PanelsAbout;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Proyecto.Appi;

public class Info extends JPanel
{
	private static final long serialVersionUID = -5828720024236351702L;

	public JLabel lbl[];
	
	public Info(String[][]textos)
	{
		lbl = new JLabel[textos.length];
		setLayout(new GridLayout(textos.length, 1));
		for(int i=0; i<textos.length; i++)
		{
			lbl[i] = new JLabel(textos[i][0]);
			lbl[i].setBackground(Color.white);
			lbl[i].setOpaque(true);
			lbl[i].setHorizontalAlignment(JLabel.CENTER);
			
			if(!textos[i][1].equals(""))
				lbl[i].setIcon(Appi.getImageIcon(textos[i][1]));
			add(lbl[i]);
		}
	}
}
