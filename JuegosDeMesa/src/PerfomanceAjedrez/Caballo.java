package PerfomanceAjedrez;


import Abstract.Pieza;

import static Abstract.Variables.caballoJ1;
import static Abstract.Variables.caballoJ2;

import java.awt.Image;


import static Abstract.Variables.JUGADOR_BLANCAS;


public class Caballo extends Pieza
{
	
	public Caballo(int val) 
	{
		super("Caballo","C",val);
	}
	
	
	@Override
	public Image getPieza(int player) 
	{
		return player == JUGADOR_BLANCAS ? caballoJ1 : caballoJ2;
	}
	
	@Override
	public void movimiento(int f, int c) 
	{
		
	}
}
