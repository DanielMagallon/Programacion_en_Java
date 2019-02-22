package PerfomanceAjedrez;

import javax.swing.Icon;

import Abstract.Pieza;

import static Abstract.Variables.reinaJ1;
import static Abstract.Variables.reinaJ2;
import static Abstract.Variables.JUGADOR_BLANCAS;

public class Reina extends Pieza 
{
	
	public Reina(int val) 
	{
		super("Reina","D",val);
	}
	
	@Override
	public Icon getPieza(int player) 
	{
		if(player == JUGADOR_BLANCAS )
			return reinaJ1;	
		
		return  reinaJ2;
	}
	
	@Override
	public void movimiento(int f, int c) 
	{
		
	}
}
