package PerfomanceAjedrez;


import Abstract.Pieza;

import static Abstract.Variables.peonJ1;
import static Abstract.Variables.peonJ2;

import java.awt.Image;

import static Abstract.Variables.JUGADOR_BLANCAS;

public class Peon extends Pieza
{
	public Peon(int val) 
	{
		super("Peon","P",val);
	}
	
	@Override
	public Image getPieza(int player) 
	{
		return player==JUGADOR_BLANCAS ? peonJ1 : peonJ2;
	}
	
	@Override
	public void movimiento(int f, int c) 
	{
		
	}
}

