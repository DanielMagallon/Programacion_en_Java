package Diseños;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public abstract class Tablero extends JPanel 
{

	private static final long serialVersionUID = 3653183218781865085L;
	public boolean pintado;
	protected JPanel panelJuego;
	
	public Tablero() 
	{
		int i,j;
		
		setLayout(new BorderLayout(10,10));
		
		panelJuego = new JPanel();
		panelJuego.setLayout(new GridLayout(8,8,3,3));
		add(panelJuego,"Center");
		
		JPanel panelFilas = new JPanel();
		panelFilas.setLayout(new GridLayout(8,1));
		add(panelFilas,"West");
		
		for(i=8; i>=1; i--)
		{
			JLabel lbl = new JLabel(i+"");
			panelFilas.add(lbl);
		}
		
		JPanel panelCols = new JPanel();
		panelCols.setLayout(new GridLayout(1,8,3,3));
		add(panelCols,"North");

		
		for(i=8; i>=1; i--)
		{
			panelCols.add(new JLabel(( (char) (73-i))+"   ",JLabel.CENTER));
		}
		
		crearAtributos();
		
		for(i=0; i<8; i++)
		{
			for(j=0; j<8; j++)
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
