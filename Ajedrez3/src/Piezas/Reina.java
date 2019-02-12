package Piezas;

import static Abstract.Variables.movsLibre;

import javax.swing.Icon;

import Abstract.Iterador;
import Abstract.Variables;
import Interfaz.Position;

public class Reina extends Pieza
{

	public Reina(int val)
	{
		nombre="Reina";	
		clave="D";
		valor = val;
	}
	
	@Override
	public Icon getPieza(int pla) 
	{
		
		if(pla==Variables.JUGADOR_BLANCAS)
			return Variables.REINA;
		
		else
			return Variables.REINA2;
	}
	
	@Override
	public void buscaCaminos(Position pos) 
	{
		super.buscaCaminos(pos);
		
		Iterador.iterar(0, () -> whileTrue(movsLibre),movsLibre.length);
	}
}
