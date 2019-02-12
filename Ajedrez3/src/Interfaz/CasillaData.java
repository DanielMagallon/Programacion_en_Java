package Interfaz;

import Piezas.Pieza;

import static Abstract.Variables.reina;
import static Abstract.Variables.alfil;
import static Abstract.Variables.torre;

import static Abstract.Variables.rey;
import static Abstract.Variables.caballo;
import static Abstract.Variables.peon;
import static Abstract.Variables.JUGADOR_BLANCAS;
import static Abstract.Variables.JUGADOR_NEGRAS;


import Abstract.Variables;

public class CasillaData
{
	public String casillaName;
	public final Position position;
	public int valor;

	public Pieza pieza;
	
	public CasillaData(int f , int c)
	{
		position = new Position(f, c);
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
	
	public void desmarcar()
	{
		TableroAjedrez.casillas[position.fila][position.columna].desmarcar();
	}
	
	public void marck()
	{
		TableroAjedrez.casillas[position.fila][position.columna].marck();
	}
	
	public void setOpcional(boolean opc)
	{
		TableroAjedrez.casillas[position.fila][position.columna].setOpcional(opc);
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
	
	private boolean isEsp;
	
	public void setEspecial(boolean esp)
	{
		isEsp=esp;
	}
	
	public boolean isEspecial(){
		
		return isEsp;
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
		return String.format("%s", position);
	}
}
