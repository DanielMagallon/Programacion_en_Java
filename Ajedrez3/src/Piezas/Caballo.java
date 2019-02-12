package Piezas;

import javax.swing.Icon;

import Abstract.Iterador;
import Abstract.Variables;
import Interfaz.Position;

import static Abstract.Variables.movsCaballo;
import static Abstract.Validaciones.*;
import static Abstract.Variables.k;
import static Abstract.Variables.l;
import static Interfaz.TableroAjedrez.casillas;

public class Caballo extends Pieza
{
	public Caballo(int val) {
		
		nombre="caballo";
		clave="C";
		valor = val;
	}
	
	@Override
	public Icon getPieza(int pla) 
	{ 
		if(pla==Variables.JUGADOR_BLANCAS)
			return Variables.CABALLO;
		
		return Variables.CABALLO2;
	}
	
	@Override
	public void buscaCaminos(Position pos) 
	{

		Iterador.iterar(0, () -> caballo(pos) , movsCaballo.length);
		
	}

	private void caballo(Position pos)
	{
		k = pos.fila + movsCaballo[Iterador.getIndex()][0];
		l = pos.columna + movsCaballo[Iterador.getIndex()][1];
		
		if(puedeAvanzar(k, l) || esEnemigo(k, l))
		{
			casillas[k][l].marck();
		}
	}
}
