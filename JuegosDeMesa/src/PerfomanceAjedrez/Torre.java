package PerfomanceAjedrez;

import javax.swing.ImageIcon;

import Abstract.Pieza;

import static Abstract.Variables.torreJ1;
import static Abstract.Variables.torreJ2;

import java.awt.Image;

import static Abstract.Variables.JUGADOR_BLANCAS;

public class Torre extends Pieza 
{
	public Torre(int val) 
	{
		super("Torre","T",val);
	}
	
	@Override
	public Image getPieza(int player) 
	{
		return player == JUGADOR_BLANCAS ? torreJ1 : torreJ2;
	}
		// TODO Auto-generated method stub
	
	@Override
	public void movimiento(int f, int c) {
		// TODO Auto-generated method stub
		
	}
}
