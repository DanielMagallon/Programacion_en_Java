package DiseñoAjedrez;

import java.awt.Color;

import Diseños.Tablero;

public class TableroAjedrez extends Tablero 
{
	private static final long serialVersionUID = -2921673764673999677L;
	CasillaAjedrez casillasAj[][];
	Color firstColor,secondColor;
	
	
	@Override
	public void crearAtributos() 
	{
		firstColor = Color.black;
		secondColor = Color.white;
		casillasAj = new CasillaAjedrez[8][8];
	}
	
	@Override
	public void instanciar(int i, int j) 
	{
		casillasAj[i][j] = new CasillaAjedrez();
		casillasAj[i][j].setBackground((pintado) ? firstColor : secondColor);
		
		add(casillasAj[i][j]);
	}
	
	@Override
	public CasillaAjedrez getCasilla(int i, int j) 
	{
		return casillasAj[i][j];
	}

}
