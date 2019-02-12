package Abstract;

import Interfaz.Position;
import Piezas.Pieza;

import static Abstract.Variables.movsCaballo;
import static Abstract.Variables.movsLibre;
import static Abstract.Variables.k;
import static Abstract.Variables.l;
import static Abstract.Variables.reina;
import static Abstract.Variables.alfil;
import static Abstract.Variables.torre;

import Eventos.EstadoTablero;

import static Abstract.Variables.JUGADOR_BLANCAS;
import static Abstract.Variables.JUGADOR_NEGRAS;

public class Validaciones {

	public static int colorDominante;
	private static Position pos;
	private static Pieza pieces [] = new Pieza[2];
	public static EstadoTablero estado;
	
	static{
		pieces[0] = reina; 
	}
	
	public static boolean puedeAvanzar(int f, int c)
	{
		try 
		{
			return estado.estaqueAt(f,c).estaVacia();
		}
		catch (ArrayIndexOutOfBoundsException e){
			return false;
		}
	}
	
	public static boolean esEnemigo(int f, int c)
	{
		try
		{
			if(colorDominante==JUGADOR_BLANCAS)
			{
				return estado.estaqueAt(f,c).esJugadorNegras();
			}
			
			return estado.estaqueAt(f,c).esJugadorBlancas();
		}
		catch (ArrayIndexOutOfBoundsException e){
			return false;
		}
		
	}
	
	private static Method metodo;
	
	public static void buscaPieza(Position p, Method meto)
	{
		metodo = meto;

		pos = p;
		pieces[1] = torre;
		
		Iterador.iterar(0, () -> piezasLibres(), movsLibre.length);
		Iterador.iterar(0, () -> caballoAmenaza(), movsCaballo.length);
		
	}
	
	public static void reyAmenaza(Position pos)
	{
		
		for(int i=0; i<movsLibre.length; i++)
		{
			k = pos.fila + movsLibre[i][0];
			l = pos.columna + movsLibre[i][1];
			
			if(esColorContrario(k, l) && estado.estaqueAt(k,l).esRey())
			{
				metodo.method(k, l);
			}
		}
	}
	
	public static void peonAmenaza(Position pos)
	{ 
		int k = pos.fila;
		int l = pos.columna;
		
		if(colorDominante == JUGADOR_NEGRAS)
		{
			if(!isInvalidPosition(k+1, l+1))
			{
				if(estado.estaqueAt(k+1,l+1).esPeon())
				{
					if(esEnemigo(k+1, l+1))
					{
						metodo.method(k+1, l+1);
					}
					
				}
			}
			
			if(!isInvalidPosition(k+1, l-1))
			{
				if(estado.estaqueAt(k+1,l-1).esPeon())
				{
					if(esEnemigo(k+1, l-1))
					{
						metodo.method(k+1, l-1);
					}
					
				}
			}
		}
		
		else{
			
			if(!isInvalidPosition(k-1, l+1))
			{
				if(estado.estaqueAt(k-1,l+1).esPeon())
				{
					if(esEnemigo(k-1, l+1))
					{
						metodo.method(k-1, l+1);
					}
					
				}
			}
			
			if(!isInvalidPosition(k-1, l-1))
			{
				if(estado.estaqueAt(k-1,l-1).esPeon())
				{
					if(esEnemigo(k-1, l-1))
					{
						metodo.method(k-1, l-1);
					}
					
				}
			}
			
		}
	}

	public static void peoncCubreCasilla(Position pos)
	{
		int k = pos.fila;
		int m = pos.columna;
		
		if(colorDominante == JUGADOR_NEGRAS)
		{
			if(k==4)
			{
				if(estado.estaqueAt(6,m).esPeon() && estado.estaqueAt(6,m).esJugadorBlancas())
				{
					if(estado.estaqueAt(5,m).estaVacia())
						metodo.method(6, m);
				}
			}
			
			if(k!=7)
				
			if(estado.estaqueAt(k+1,m).esPeon() && estado.estaqueAt(k+1,m).esJugadorBlancas())
			{
				metodo.method(k+1, m);
			}
		}
		
		else
		{
			if(k==3)
			{
				if(estado.estaqueAt(1,m).esPeon() && estado.estaqueAt(1,m).esJugadorNegras())
				{
					if(estado.estaqueAt(2,m).estaVacia())
						metodo.method(1, m);
				}
			}
			
			if(k!=0)
				
			if(estado.estaqueAt(k-1,m).esPeon() && estado.estaqueAt(k-1,m).esJugadorNegras())
			{
				metodo.method(k-1, m);
			}
		}
	}
	
	public static ReturnMethod<Position> valid = (c) -> false; 
	
	private static void piezasLibres()
	{
		k = pos.fila + movsLibre[Iterador.getIndex()][0];
		l = pos.columna + movsLibre[Iterador.getIndex()][1];
		
		if(Iterador.getIndex() >= 4)
		{
			pieces[1]=alfil;
			
		}
		
		while(true)
		{
			if(isInvalidPosition(k, l))
				break;
			
			if(estado.estaqueAt(k,l).estaVacia() || valid.method_get(new Position(k, l)))
			{
				
				k +=  movsLibre[Iterador.getIndex()][0];
				l += movsLibre[Iterador.getIndex()][1];
				continue;
			}
			
			if(esColorContrario(k, l) && comparePieceTo(k, l, pieces))
			{
				metodo.method(k, l);
			}

			break;
		}
	}
	
	private static void caballoAmenaza()
	{
		k = pos.fila + movsCaballo[Iterador.getIndex()][0];
		l = pos.columna + movsCaballo[Iterador.getIndex()][1];
		
		if(esColorContrario(k, l) && estado.estaqueAt(k,l).esCaballo())
		{
			metodo.method(k, l);
		}
	}
	
	public static boolean esColorContrario(int f, int c)
	{
		try
		{
			if(colorDominante==JUGADOR_BLANCAS)
			{
				return estado.estaqueAt(f,c).esJugadorNegras();
			}
		
			else 
			{
				return estado.estaqueAt(f,c).esJugadorBlancas();
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return false;
		}
	}
	
	public static boolean comparePieceTo(int f, int c, Pieza...pieces)
	{
		for(int i=0; i<pieces.length; i++)
		{
			try
			{
				if(pieces[i] ==  estado.estaqueAt(f,c).pieza)
				{
					return true;
				}
			}
			catch (ArrayIndexOutOfBoundsException e){
				
			}
		}
		
		return false;
	}
	
	public static boolean isInvalidPosition(int f, int c)
	{
		if(f<0 || c<0)
			return true;
		
		if(f>7 || c>7)
			return true;
		
		return false;
	}
	
	public static boolean validarPieza(Position posicionPieza)
	{
		posicionPieza.comparePosition(postionCompare);
		
		if(posicionPieza.areEqualColumn() || posicionPieza.areEqualFile())
		{
			pieces[1] = torre;
		}
		
		else if(posicionPieza.areInDiagonal()){
			
			pieces[1] = alfil;
		}

		else if(Variables.indexEvaluado == -1)
		{
			return true;
		}
		
		boolean puede=true;
		k = posicionPieza.fila;
		l = posicionPieza.columna;
		
		while(true)
		{
			k +=  movsLibre[Variables.indexEvaluado][0];
			l +=  movsLibre[Variables.indexEvaluado][1];
			
			if(isInvalidPosition(k, l))
				return true;
			
			if(estado.estaqueAt(k,l).estaVacia())
				continue;
			
			if(esColorContrario(k, l) && comparePieceTo(k, l, pieces))
			{
				puede=false;
			}
			
			break;
			
		}
		
		k = postionCompare.fila;
		l = postionCompare.columna;
		
		while(true)
		{
			k +=  movsLibre[Variables.indexEvaluado][0];
			l +=  movsLibre[Variables.indexEvaluado][1];
			
			if((posicionPieza.fila == k && posicionPieza.columna == l))
				break;
			
			if(estado.estaqueAt(k,l).estaVacia())
				continue;
			
			else return true;
		}
		
		return puede;
	}
	
	//Es la posicion del rey enemigo, si buscamos las blancas el jaque, vaidara que las negras
	//no dejen en jaque a su rey
	public static Position postionCompare;
}
