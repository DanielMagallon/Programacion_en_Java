package Piezas;

import javax.swing.Icon;

import Abstract.Iterador;
import Abstract.Variables;
import Interfaz.Position;

import static Abstract.Variables.movsLibre;




public class Alfil extends Pieza 
{
	public Alfil(int val) 
	{
		nombre="alfil";
		clave="A";
		valor = val;
	}
	
	@Override
	public Icon getPieza(int pla) 
	{ 
		if(pla==Variables.JUGADOR_BLANCAS)
			return Variables.ALFIL;
		
		return Variables.ALFIL2;
	}
	
	@Override
	public void searchByIndex(int indexEva, Position pos) 
	{
		if(indexEva>=4)
			super.searchByIndex(indexEva, pos);
		
	}
	
	@Override
	public void buscaCaminos(Position pos) 
	{
		super.buscaCaminos(pos);

		Iterador.iterar(4, () -> whileTrue(movsLibre),movsLibre.length);
		
	}
}
