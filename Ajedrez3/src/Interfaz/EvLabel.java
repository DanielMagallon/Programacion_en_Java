package Interfaz;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Piezas.Pieza;

public class EvLabel extends JLabel 
{
	public Position position;
	public boolean activado; 
	
	public EvLabel(int i, int j) 
	{
		position = new Position(i, j);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setHorizontalAlignment(SwingConstants.CENTER);
		setOpaque(true);
	}
	
	
	public void choss()
	{
		setBackground(Color.blue);
	}
	
	public void marck()
	{
		setBackground(Color.green);
	}
	
	public void desmarck()
	{
		setBackground(null);
	}
	
	public void setImage(Pieza pieza, int player)
	{
		if(pieza == null)
		{
			setIcon(null);
		}else{
			
			setIcon(pieza.getPieza(player));
		}
	}
}
