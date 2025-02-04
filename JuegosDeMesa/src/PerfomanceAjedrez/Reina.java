package PerfomanceAjedrez;


import Abstract.Pieza;

import static Abstract.Variables.reinaJ1;
import static Abstract.Variables.reinaJ2;

import java.awt.Image;

import static Abstract.Variables.JUGADOR_BLANCAS;

public class Reina extends Pieza 
{
	
	public Reina(int val) 
	{
		super("Reina","D",val);
	}
	
	@Override
	public Image getPieza(int player) 
	{
		return (player == JUGADOR_BLANCAS ) ? reinaJ1 : reinaJ2;
	}
	
	@Override
	public void movimiento(int f, int c) 
	{
		
	}
}
