package PerfomanceAjedrez;


import Abstract.Pieza;

import static Abstract.Variables.reyJ1;
import static Abstract.Variables.reyJ2;

import java.awt.Image;


import static Abstract.Variables.JUGADOR_BLANCAS;;

public class Rey extends Pieza 
{
	
	public Rey(int val) 
	{
		super("Rey","R",val);
	}
	
	@Override
	public Image getPieza(int player) 
	{
		return player == JUGADOR_BLANCAS ? reyJ1 : reyJ2;
	}
	
	@Override
	public void movimiento(int f, int c) 
	{
		
	}
}
