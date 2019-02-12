package Eventos;

import Interfaz.Estaque;
import Interfaz.TableroAjedrez;

import static Interfaz.TableroAjedrez.estado;

import static Eventos.MoveListener.position;
import static Eventos.MoveListener.cas;


public class Propiedades 
{
	public static void copiarPropiedades(Estaque tocado,Estaque destino)
	{
		destino.setIcon(tocado.getIcon());
		tocado.setIcon(null);
		
		if(!cas.esRey())
		{
			if(cas.esJugadorBlancas())
			{
				estado.piezasBlancasDisponibles.remove(cas);
				estado.piezasBlancasDisponibles.add(estado.estaqueAt(destino.fila,destino.columna));
			}
			else
			{
				estado.piezasNegrasDisponibles.remove(cas);
				estado.piezasNegrasDisponibles.add(estado.estaqueAt(destino.fila,destino.columna));
			}
		}
		
		TableroAjedrez.estadoAnalisis.actualizarTableroFT(destino.fila,destino.columna,cas.pieza ,cas.valor, position);
		estado.actualizarTableroFT(destino.fila,destino.columna,cas.pieza ,cas.valor, position);
		estado.mostrar();
		System.out.println("Analisis");
		TableroAjedrez.estadoAnalisis.mostrar();
	}
	
}
