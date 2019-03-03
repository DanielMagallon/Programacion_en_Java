package PerfomanceAjedrez;


import Abstract.Pieza;

import static Abstract.Variables.alfilJ1;
import static Abstract.Variables.alfilJ2;

import java.awt.Image;


import static Abstract.Variables.JUGADOR_BLANCAS;

public class Alfil extends Pieza 
{
	public Alfil(int val) 
	{
		super("Alfil","A",val);
	}
	
	@Override
	public Image getPieza(int player) 
	{
		return player == JUGADOR_BLANCAS ? alfilJ1 : alfilJ2;
	}
	
	@Override
	public void movimiento(int f, int c) 
	{
		
	}
}
