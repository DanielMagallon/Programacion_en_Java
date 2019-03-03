package PerfomanceAjedrez;

import static Abstract.Variables.iFor;
import static Abstract.Variables.jFor;

import Abstract.Pieza;

public class EstadoAjedrez 
{
	CasillaData ubicacionPiezas[][] = new CasillaData[8][8];
	
	public EstadoAjedrez() 
	{
		for(int iFor=0; iFor<8; iFor++)
		{
			for(int jFor=0; jFor<8; jFor++)
			{
				ubicacionPiezas[iFor][jFor] = new CasillaData(iFor, jFor);
			}
		}
	}
	
	public void actulizar(int f, int c, Pieza p,int player)
	{
		ubicacionPiezas[f][c].actualizar(player, p);
	}
	
	public String getEstado()
	{
		StringBuilder sb = new StringBuilder();
		
		for(CasillaData cs[] : ubicacionPiezas)
		{
			for(CasillaData c : cs)
			{
				sb.append(c.casillaName+"\t");
			}
			
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
