package Diseños;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import static Abstract.Variables.iFor;
import static Abstract.Variables.jFor;


public abstract class Tablero extends JPanel 
{

	private static final long serialVersionUID = 3653183218781865085L;
	public boolean pintado;
	protected JPanel panelJuego;
	public Color firstColor,secondColor;
	
	public Tablero(int f, int c,boolean addTexts) 
	{
		setLayout(new BorderLayout(10,10));
		
		panelJuego = new JPanel();
		panelJuego.setLayout(new GridLayout(f,c,3,3));
		add(panelJuego,"Center");
		
		if(addTexts)
		{
			JPanel panelFilas = new JPanel();
			panelFilas.setLayout(new GridLayout(8,1));
			add(panelFilas,"West");
			
			for(int iFor=f; iFor>=1; iFor--)
			{
				JLabel lbl = new JLabel(iFor+"");
				panelFilas.add(lbl);
			}
			
			JPanel panelCols = new JPanel();
			panelCols.setLayout(new GridLayout(1,8,3,3));
			add(panelCols,"North");
	
			
			for(int iFor=c; iFor>=1; iFor--)
			{
				panelCols.add(new JLabel(( (char) (73-iFor))+"   ",JLabel.CENTER));
			}
		}
		
		crearAtributos();
		
		for(int iFor=0; iFor<f; iFor++)
		{
			for(int jFor=0; jFor<c; jFor++)
			{
				instanciar(iFor, jFor);
				pintado=!pintado;
			}
			
			pintado=!pintado;
		}
	}
	
	public abstract void crearAtributos();
	public abstract void instanciar(int i,int j);
	public abstract Casilla getCasilla(int i,int j);
}
