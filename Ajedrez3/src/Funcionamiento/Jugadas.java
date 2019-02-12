package Funcionamiento;

import static Abstract.Variables.JUGADOR_BLANCAS;
import static Abstract.Variables.JUGADOR_NEGRAS;
import static Abstract.Variables.reyBlancoMeneado;
import static Abstract.Variables.reyNegroMeneado;
import static Abstract.Variables.torre;
import static Abstract.Variables.torreBlancaCM;
import static Abstract.Variables.torreBlancaLM;
import static Abstract.Variables.torreNegraCM;
import static Abstract.Variables.torreNegraLM;
import static Eventos.MoveListener.especial;
import static Interfaz.TableroAjedrez.casillas;
import static Interfaz.TableroAjedrez.estado;

import Abstract.ReturnMethod;
import Abstract.Variables;
import Interfaz.CasillaData;
import Interfaz.Position;
import Juego.Ajedrez;
import Piezas.Peon;

public class Jugadas 
{
	private ReturnMethod<CasillaData> get;
	private CasillaData tocada,destino;
	
	public void jugadasEspeciales(CasillaData estaqueTocado, CasillaData estaqueDestino)
	{
		tocada=estaqueTocado;
		destino=estaqueDestino;
		
		if(!(reyBlancoMeneado && reyNegroMeneado))
		{
			if(tocada.esTorre())
			{
				torreMeneada();
			}
			else if(tocada.esRey())
				enroque();
		}
		
		if(tocada.esRey())
		{
			if(tocada.esJugadorNegras())
			{
				estado.positionReyNegro.setPosition(destino.position);
			}
			else
			{
				estado.positionReyBlanco.setPosition(destino.position);
			}
		}
		
		if(tocada.esPeon())
			peonAlPaso();
	}
	
	private void peonAlPaso()
	{
		if(tocada.esJugadorBlancas())
		{
			get = (a) -> a.esJugadorNegras();
			validPeonPaso(6, 4, 1);
		}
		else
		{
			get = (a) -> a.esJugadorBlancas();
			validPeonPaso(1, 3, -1);
		}
	}
	
	private CasillaData casilla,casilla2;
	
	public void anular()
	{
		if(casilla!= null)
		casilla.setEspecial(false);
		if(casilla2 != null)
		casilla2.setEspecial(false);

		Peon.marcaPasoD=null;
		Peon.marcaPasoI=null;
	}
	
	private void validPeonPaso(int filaT, int filaD,int avance)
	{
		if(tocada.position.fila == filaT && destino.position.fila == filaD)
		{
			//position->destino la casilla que sera comida
			if(tocada.position.columna != 0)
			{
				casilla = estado.estaqueAt(destino.position.fila,destino.position.columna-1);
				
				if(casilla.esPeon() && get.method_get(casilla))
				{
					Peon.marcaPasoI = ()->{
						
						estado.estaqueAt(destino.position.fila+avance,destino.position.columna).marck();
					};
					casilla.setEspecial(true);
				}
				
			}
			if(tocada.position.columna != 7)
			{
				casilla2 = estado.estaqueAt(destino.position.fila,destino.position.columna+1);
				
				if(casilla2.esPeon() && get.method_get(casilla2))
				{
						Peon.marcaPasoD = ()->{
						
						estado.estaqueAt(destino.position.fila+avance,destino.position.columna).marck();
					};
					casilla2.setEspecial(true);
				}
			}
		}
	}
	
	private void torreMeneada()
	{
		if(tocada.esJugadorNegras())
		{
			  if(!reyNegroMeneado)
			  {
				  	if(!torreNegraCM)
						if(tocada.position.areEqualPostion(new Position(0, 7)))
							torreNegraCM=true;

				  	if(!torreNegraLM)
				  		if(tocada.position.areEqualPostion(new Position(0, 0)))
							torreNegraLM=true;
				  	
				  	reyNegroMeneado = torreNegraCM && torreNegraLM;
				  	
				  	
			  }
		 }
	
		else
		{
			if(!reyBlancoMeneado)
			{
				if(!torreBlancaCM)
					if(tocada.position.areEqualPostion(new Position(7, 7)))
					{
						torreBlancaCM=true;
					}
				
				if(!torreBlancaLM)
					if(tocada.position.areEqualPostion(new Position(7, 0)))
						torreBlancaLM=true;
				
				reyBlancoMeneado = torreBlancaCM && torreBlancaLM;
			}
		}
		
	}
	
	private Object[] pieza_color = new Object[2];
	
	public Object[] coronarPeon()
	{
		if(tocada.esPeon())
		{
//			if(destino.position.fila == 0 || destino.position.fila==7)
//			{
//				pieza_color[0] = Ajedrez.piezaPremio;
//				pieza_color[1] = tocada.valor;
//				
//				especial = () -> {
//					
//					casillas[destino.position.fila][destino.position.columna].setIcon
//							(Ajedrez.piezaPremio.getPieza(destino.valor));
//					
//				};
//				return pieza_color;
//			}
		}
		
		return null;
	}
	
	private void enroque()
	{
		if(tocada.esJugadorNegras())
		{
			if(!Variables.reyNegroMeneado)
			{
				if(destino.position.columna == tocada.position.columna-2)
					moverEnroque(0, 0, 3, JUGADOR_NEGRAS);
				
				else if(destino.position.columna == tocada.position.columna+2)
					moverEnroque(0, 7, 5, JUGADOR_NEGRAS);
				
				Variables.reyNegroMeneado=true;
			}
		}
		else
		{
			if(!Variables.reyBlancoMeneado)
			{
				if(destino.position.columna == tocada.position.columna-2)
					moverEnroque(7, 0, 3, JUGADOR_BLANCAS);
				
				else if(destino.position.columna == tocada.position.columna+2)
					moverEnroque(7, 7, 5, JUGADOR_BLANCAS);

				Variables.reyBlancoMeneado=true;
			}
		
		}
	}
	
	private void moverEnroque(int f, int cFrom, int cTo,int player)
	{
		CasillaData from = estado.estaqueAt(f,cFrom);
		CasillaData to = estado.estaqueAt(f,cTo);
		
		to.actualizar(from.valor, from.pieza);
		from.actualizar(-1, null);
		
		if(player == JUGADOR_BLANCAS)
		{
			estado.piezasBlancasDisponibles.remove(from);
			estado.piezasBlancasDisponibles.add(to);
		}else{
			estado.piezasNegrasDisponibles.remove(from);
			estado.piezasNegrasDisponibles.add(to);
		}
		
		especial = () -> {
			casillas[f][cFrom].setIcon(null);
			casillas[f][cTo].setIcon(torre.getPieza(player));
		};
	}
}
