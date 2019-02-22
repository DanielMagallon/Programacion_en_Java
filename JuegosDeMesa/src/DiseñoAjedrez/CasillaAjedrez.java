package DiseñoAjedrez;


import Abstract.Pieza;
import Diseños.Casilla;

public class CasillaAjedrez extends Casilla
{
	private static final long serialVersionUID = -1110606640691663197L;
	
	public CasillaAjedrez() 
	{
		setHorizontalAlignment(HORIZONTAL);
	}
	
	public void putPiece(Pieza pieza, int player)
	{
		setIcon( pieza == null ? null : pieza.getPieza(player));
	}
}
