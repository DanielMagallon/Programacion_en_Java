package DiseñoAjedrez;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

import Abstract.Pieza;
import Abstract.Variables;
import Diseños.Tablero;
import PerfomanceAjedrez.EstadoAjedrez;

import static Abstract.Variables.iFor;

public class TableroAjedrez extends Tablero 
{
	private static final long serialVersionUID = -2921673764673999677L;
	CasillaAjedrez casillasAj[][];
	EstadoAjedrez estadoAj;
	
	
	public TableroAjedrez() 
	{
		super(8,8,true);
		estadoAj = new EstadoAjedrez();
//		acomodadoNormal();
	}
	
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
		panelJuego.add(casillasAj[i][j]);
	}
	
	public void acomodadoNormal() 
	{
		Pieza piece[] = {Variables.torre,Variables.caballo,Variables.alfil,Variables.reina,Variables.rey};
		
		int ind;
		
		for(iFor=0,ind=0; iFor<8; iFor++)
		{
		
			if(ind>4)
				ind=0;
			
			{
				casillasAj[0][iFor].putPiece(piece[ind], Variables.JUGADOR_NEGRAS);
				casillasAj[1][iFor].putPiece(Variables.peon, Variables.JUGADOR_NEGRAS);
				
			
				casillasAj[7][iFor].putPiece(piece[ind], Variables.JUGADOR_BLANCAS);
				casillasAj[6][iFor].putPiece(Variables.peon, Variables.JUGADOR_BLANCAS);
			}
			
			{
				estadoAj.actulizar(0, iFor, piece[ind], Variables.JUGADOR_NEGRAS);
				estadoAj.actulizar(1, iFor, Variables.peon, Variables.JUGADOR_NEGRAS);
				
				estadoAj.actulizar(7, iFor, piece[ind], Variables.JUGADOR_BLANCAS);
				estadoAj.actulizar(6, iFor, Variables.peon, Variables.JUGADOR_BLANCAS);
			}
			
			
			ind++;
		}
		
		piece = null;
		
		
	}
	
	public void setTexArea(JTextArea tA)
	{
		tA.setText(estadoAj.getEstado());
	}
	
	
	@Override
	public CasillaAjedrez getCasilla(int i, int j) 
	{
		return casillasAj[i][j];
	}

}
