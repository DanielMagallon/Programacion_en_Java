package Diseños;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Casilla extends JLabel 
{
	private static final long serialVersionUID = 5867099104478680492L;

	public Casilla() 
	{
		setBorder(BorderFactory.createLineBorder(Color.black));
		setOpaque(true);
	}
}
