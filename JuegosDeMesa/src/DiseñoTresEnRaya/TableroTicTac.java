package DiseñoTresEnRaya;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import Abstract.Variables;
import Diseños.Casilla;
import Diseños.Tablero;

public class TableroTicTac extends Tablero 
{
	
	private static final long serialVersionUID = 4178882703196060346L;
	CasillaTicTac casillasTicTac[][];
	
	public TableroTicTac() 
	{
		super(3,3,false);
//		add(new JPanel(),"North");
//		add(new JPanel(),"South");
//		add(new JPanel(),"West");
	}
	 
	@Override
	public void crearAtributos() 
	{
		casillasTicTac = new CasillaTicTac[3][3];
		firstColor = Color.yellow;
		secondColor = Color.cyan;
		
	}	
	
	@Override
	public void instanciar(int i, int j) 
	{
		casillasTicTac[i][j] = new CasillaTicTac();
		panelJuego.add(casillasTicTac[i][j]);
		
	}
	
	@Override
	public Casilla getCasilla(int i, int j) 
	{
		return casillasTicTac[i][j];
	}
}

