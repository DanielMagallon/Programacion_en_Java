
package Piezas;

import javax.swing.Icon;

import Abstract.Variables;
import Abstract.VoidMethod;
import Abstract.Validaciones;
import Interfaz.Position;

import static Interfaz.TableroAjedrez.estado;
import static Interfaz.TableroAjedrez.casillas;
import static Abstract.Variables.movsLibre;
import static Abstract.Validaciones.*;

public class Peon extends Pieza 
{
	public static VoidMethod marcaPasoI, marcaPasoD;
	
	public Peon(int val) {
		// TODO Auto-generated constructor stub
		nombre="peon";
		clave="P";
		valor = val;
	}
	
	@Override
	public Icon getPieza(int pl) 
	{
		if(pl==Variables.JUGADOR_BLANCAS)
			return Variables.PEON;
		
		return Variables.PEON2;
	} 
	
	@Override
	public void searchByIndex(int indexEva,Position pos) 
	{
		if(indexEva == 2 || indexEva == 3)
		{
			return;
		}
		
		//Es ppen blanco
		if(indexEva == 0)
		{
			//if(casillas[f][c].getPlayer() == Variables.TURNO_NEGRAS)
				//return;
			if(puedeAvanzar(pos.fila-1, pos.columna))
			{
				casillas[pos.fila-1][pos.columna].marck();
				
				if(pos.fila==6)
				{
					if(puedeAvanzar(4, pos.columna))
					{
						casillas[4][pos.columna].marck();
					}
				}
			}
		}
		
		//Es ppe negro
		else if (indexEva == 1)
		{
			//if(casillas[f][c].getPlayer() == Variables.TURNO_BLANCAS)
				//return;
			
			if(puedeAvanzar(pos.fila+1, pos.columna))
			{
				casillas[pos.fila+1][pos.columna].marck();
				
				if(pos.fila==1)
				{
					if(puedeAvanzar(3, pos.columna))
					{
						casillas[3][pos.columna].marck();
					}
				}
			}
		}
		
		//Hay que validar que el peon no como en digonal si es que se ocuara un retrocedimeinto
		//Para diagonal poen nero
		
		//Este se encarga de ver si la pieza del jaque eta en la digonal del peon actual
		else 
		{
			if(indexEva == 4 || indexEva == 7)
			{
				if(estado.estaqueAt(pos).esJugadorBlancas())
						return;
			}
			
			if(indexEva == 5 || indexEva == 6)
			{			
				if(estado.estaqueAt(pos).esJugadorNegras())
						return;
			}
			
			incF = pos.fila + movsLibre[indexEva][0];
			incC = pos.columna + movsLibre[indexEva][1];
			
			if(esEnemigo(incF, incC))
			{
				casillas[incF][incC].marck();
			}
		}
	}
	
	private int incF, incC;
	
	
	@Override
	public void buscaCaminos(Position pos) 
	{
		if(Validaciones.colorDominante == Variables.JUGADOR_BLANCAS)
			moverPeonBlancas(pos);
		
		else
			moverPeonNegras(pos);
		
		if(estado.estaqueAt(pos).isEspecial())
		{
			if(marcaPasoD!=null)
			marcaPasoD.method();
			if(marcaPasoI!=null)
			marcaPasoI.method();
		}		
		
	}
	
	private void moverPeonBlancas(Position pos)
	{
		if(esEnemigo(pos.fila-1, pos.columna+1))
		{
			casillas[pos.fila-1][pos.columna+1].marck();
		}
		
		if(esEnemigo(pos.fila-1, pos.columna-1))
		{
			casillas[pos.fila-1][pos.columna-1].marck();
		}
		
		if(puedeAvanzar(pos.fila-1, pos.columna))
		{
			casillas[pos.fila-1][pos.columna].marck();
			
			if(pos.fila==6)
			{
				if(puedeAvanzar(4, pos.columna))
				{
					casillas[4][pos.columna].marck();
				}
			}
		}
	}
	
	private void moverPeonNegras(Position pos)
	{
		if(esEnemigo(pos.fila+1, pos.columna+1))
		{
			casillas[pos.fila+1][pos.columna+1].marck();
		}
		
		if(esEnemigo(pos.fila+1, pos.columna-1))
		{
			casillas[pos.fila+1][pos.columna-1].marck();
		}
		
		if(puedeAvanzar(pos.fila+1, pos.columna))
		{
			casillas[pos.fila+1][pos.columna].marck();
			
			if(pos.fila==1)
			{
				if(puedeAvanzar(3, pos.columna))
				{
					casillas[3][pos.columna].marck();
				}
			}
		}
	}
}