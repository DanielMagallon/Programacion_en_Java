package Piezas;

import static Abstract.Variables.movsLibre;

import javax.swing.Icon;

import Abstract.Iterador;
import Abstract.Variables;
import Interfaz.Position;

public class Torre extends Pieza
{
	public Torre(int val) {
		// TODO Auto-generated constructor stub
		nombre="torre";
		clave = "T";
		valor = val;
	}
	
	@Override
	public Icon getPieza(int pla) 
	{ 
		
		if(pla==Variables.JUGADOR_BLANCAS)
			return Variables.TORRE;
		
		return Variables.TORRE2;
	}
	
	@Override
	public void searchByIndex(int indexEva, Position pos) {

		if(indexEva<=3)
			super.searchByIndex(indexEva,pos);
		
	}
	
	@Override
	public void buscaCaminos(Position pos) 
	{
		super.buscaCaminos(pos);
		
		Iterador.iterar(0, () -> whileTrue(movsLibre), 4);
	}
	
}