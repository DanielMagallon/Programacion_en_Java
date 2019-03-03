package PerfomanceAjedrez;


import static Abstract.Variables.reina;
import static Abstract.Variables.alfil;
import static Abstract.Variables.torre;

import Abstract.Pieza;

import static Abstract.Variables.rey;
import static Abstract.Variables.caballo;
import static Abstract.Variables.peon;
import static Abstract.Variables.JUGADOR_BLANCAS;
import static Abstract.Variables.JUGADOR_NEGRAS;


import Abstract.Variables;

public class CasillaData
{
	public String casillaName;
	public int valor,f,c;

	public Pieza pieza;
	
	public CasillaData(int f , int c)
	{
		this.f=f;
		this.c=c;
		casillaName = "--";
		valor = -1;
	}
	
	public void actualizar(int val, Pieza piece)
	{
		this.valor=val;
		pieza=piece;
		
		if(valor == JUGADOR_BLANCAS)
			casillaName = piece.clave+"B";
		
		else if(valor == JUGADOR_NEGRAS)
			casillaName = piece.clave+"N";
		
		else casillaName="--";
	}
	
	public boolean estaVacia()
	{
		return valor == -1;
	}
	
	public boolean esJugadorBlancas()
	{
		return valor == Variables.JUGADOR_BLANCAS;
	}
	
	public boolean esJugadorNegras()
	{
		return valor == Variables.JUGADOR_NEGRAS;
	}
	
	
	public boolean esRey()
	{
		return pieza == rey;
	}
	
	public boolean esDama()
	{
		return pieza == reina;
	}
	
	public boolean esCaballo()
	{
		return pieza == caballo;
	}
	
	public boolean esAlfil()
	{
		return pieza == alfil;
	}
	
	public boolean esPeon()
	{
		return pieza == peon;
	}
	
	public boolean esTorre()
	{
		return pieza == torre;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%d][%d]\n", f,c);
	}
}
