package Diseños;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public abstract class Tablero extends JPanel 
{

	private static final long serialVersionUID = 3653183218781865085L;
	public boolean pintado;
	
	public Tablero() 
	{
		setLayout(new GridLayout(8,8,3,3));
		setBackground(Color.yellow);
		crearAtributos();
		
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				instanciar(i, j);
				pintado=!pintado;
			}
			
			pintado=!pintado;
		}
	}
	
	public abstract void crearAtributos();
	public abstract void instanciar(int i,int j);
	public abstract Casilla getCasilla(int i,int j);
}
