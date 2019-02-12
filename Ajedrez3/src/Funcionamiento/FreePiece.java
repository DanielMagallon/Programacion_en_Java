package Funcionamiento;

import java.util.ArrayList;
import java.util.Iterator;

import Abstract.Validaciones;
import Abstract.Variables;
import Eventos.EstadoTablero;
import Interfaz.CasillaData;
import Interfaz.Estaque;
import Piezas.Pieza;

public class FreePiece 
{

	private boolean puedeMenearse;
	
	private EstadoTablero estadoT;
	
	public FreePiece(EstadoTablero est)
	{
		estadoT=est;
	}
	
	public void search(boolean blancas)
	{
		Estaque.marcked=false;
		
		if(blancas)
		{
			estadoT.blancasOn.clear();
			Validaciones.postionCompare = estadoT.positionReyBlanco;
			searchEspecific(estadoT.piezasBlancasDisponibles, estadoT.jackeBlancas,true);
		}
		
		else
		{
			estadoT.negrasOn.clear();
			Validaciones.postionCompare = estadoT.positionReyNegro;
			searchEspecific(estadoT.piezasNegrasDisponibles, estadoT.jackeNegras,false);
		}
		
	}
	
	private void searchEspecific(ArrayList<CasillaData> piezas, Jacke jacke, boolean blancas)
	{
		
		for(CasillaData casilla : piezas)
		{
			puedeMenearse = jacke.sePuedeMenear(casilla.position);
		
			if(puedeMenearse)
			{
				casilla.pieza.buscaCaminos(casilla.position);
				
				if(!Pieza.casillasCamino.isEmpty())
				{
					if(blancas)
					{
						estadoT.blancasOn.put(casilla, new ArrayList<>(Pieza.casillasCamino));
					}
					else
					{
						estadoT.negrasOn.put(casilla, new ArrayList<>(Pieza.casillasCamino));
					}
				}
			}
			else
			{
				
				if(!casilla.esCaballo())
				{
					casilla.pieza.searchByIndex(Variables.indexEvaluado	, casilla.position);
					
					if(!Pieza.casillasCamino.isEmpty())
					{
						if(blancas)
							estadoT.blancasOn.put(casilla, new ArrayList<>(Pieza.casillasCamino));
						else
							estadoT.negrasOn.put(casilla, new ArrayList<>(Pieza.casillasCamino));
					}
				}
			}
			
			Pieza.casillasCamino.clear();
		}
	}
	
	public void showWalks()
	{
		Iterator<CasillaData> it = estadoT.blancasOn.keySet().iterator();
		CasillaData casilla;

		while(it.hasNext())
		{
			casilla = it.next();
			
			System.out.printf ("La casilla %s->%s se puede menear a las pos: %s\n\n",casilla,casilla.pieza.nombre,
							estadoT.blancasOn.get(casilla));
		}
		
		System.out.println("\n\n");
		
		 it = estadoT.negrasOn.keySet().iterator();
		
		 
		while(it.hasNext())
		{
			casilla = it.next();
			
			System.out.printf ("La casilla %s->%s se puede menear a las pos: %s\n\n",casilla,casilla.pieza.nombre,
					estadoT.negrasOn.get(casilla));
		}
		
		System.out.println("\n\n");
	}
}
