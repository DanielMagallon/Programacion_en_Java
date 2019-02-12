package Funcionamiento;


import Eventos.EstadoTablero;
import Eventos.MoveListener;

public class Tablas  
{
	private EstadoTablero estado;
	
	public Tablas(EstadoTablero est)
	{
		estado = est;
	}
	
	public void determinarTablas()
	{
		if(tablasAhogado())
			return;
		
		tablasPiezas();
	}
	
	private boolean tablasAhogado()
	{
		if(estado.blancasOn.isEmpty() && estado.peligroBlancas.reyBloqueado() && !estado.jackeBlancas.hayAyudas())
		{
			MoveListener.estadoJuego("Tablas-Blancas ahogado",false);
			return true;
		}
		
		else if(estado.negrasOn.isEmpty() && estado.peligroNegras.reyBloqueado() && !estado.jackeNegras.hayAyudas())
		{
			MoveListener.estadoJuego("Tablas-Negras ahogado",false);
			return true;
		}
		
		
		return false;
	}
	
	private void tablasPiezas()
	{
		if(estado.piezasBlancasDisponibles.isEmpty() && estado.piezasNegrasDisponibles.isEmpty())
		{
			MoveListener.estadoJuego("Tablas (rey contra rey)",false);
		}

		else if(estado.piezasBlancasDisponibles.isEmpty() && piezasSobrantes(false))
		{
			MoveListener.estadoJuego("Tablas (Rey vs Rey-Caballo||Alfil) a favor negras",false);
		}
			
		else if(estado.piezasNegrasDisponibles.isEmpty() && piezasSobrantes(true))
		{
			MoveListener.estadoJuego("Tablas (Rey vs Rey-Caballo||Alfil) a favor blancas",false);
		}
		
		else if(estado.piezasBlancasDisponibles.size()==1 && estado.piezasNegrasDisponibles.size()==1)
		{
			if(estado.piezasBlancasDisponibles.get(0).esAlfil() && estado.piezasNegrasDisponibles.get(0).esAlfil())
				MoveListener.estadoJuego("Tablas (Rey-Alfil vs Rey-Alfil)",false);
		}
	}
	
	private boolean piezasSobrantes(boolean blancas)
	{
		if(blancas)
		{
			if(estado.piezasBlancasDisponibles.size()==1)
			{
				return estado.piezasBlancasDisponibles.get(0).esCaballo() ||
						estado.piezasBlancasDisponibles.get(0).esAlfil();
			}
			
		}
		
		else
		{
			if(estado.piezasNegrasDisponibles.size()==1)
			{
				return estado.piezasNegrasDisponibles.get(0).esCaballo()||
						estado.piezasNegrasDisponibles.get(0).esAlfil();
			}
		}
		
		return false;
	}
}
