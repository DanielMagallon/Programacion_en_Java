package Funcionamiento;

import static Abstract.Variables.movsLibre;
import static Abstract.Variables.movsCaballo;

import java.util.ArrayList;


import Abstract.Method;
import Abstract.Validaciones;
import Eventos.EstadoTablero;
import Interfaz.CasillaData;
import Interfaz.Position;

public class PeligrosRey
{
	private final int colorD;
	private int MAX_CASILLAS;
	private Method metodo;
	private CasillaData auxCas;
	private EstadoTablero estado;
	private ArrayList<CasillaData> casillasPeligrosas = new ArrayList<>();
	
	public PeligrosRey(int id, EstadoTablero est) 
	{
		estado=est;
		colorD = id;
		metodo = (a,b) -> agregaCasillaPeligro(est.estaqueAt(a,b));
	}
	
	public void findDanger(Position pos)
	{
		Position aux = new Position(0, 0);
		
		Validaciones.colorDominante = colorD;

		Validaciones.valid = (p) -> isEqualcasillaEvaluada(pos, p); 

		MAX_CASILLAS = 8;
		
		//tenemos que validar que e rey no se pueda menear en poscia aun del jaque, 
		//en las casillas peligro hay error, ya que la pieza puede aun comer en diagonal y este permite que lo haga
		
		for(int i=0; i<movsLibre.length; i++)
		{
			aux.fila = pos.fila+movsLibre[i][0];
			aux.columna = pos.columna+movsLibre[i][1];
			
			if(Validaciones.isInvalidPosition(aux.fila, aux.columna) || 
					estado.estaqueAt(aux.fila,aux.columna).valor == colorD)
			{
				MAX_CASILLAS--;
				continue;
			}

			auxCas = estado.estaqueAt(aux.fila,aux.columna);
			Validaciones.buscaPieza(aux, metodo);
			Validaciones.peonAmenaza(aux);
			Validaciones.reyAmenaza(aux);
		}
		
		Validaciones.valid = (c) -> false;
	}
	
	public ArrayList<CasillaData> casillasAmenaza = new ArrayList<>();
	
	public void añadeCasillas(Position pos)
	{
		int k,l,i;
		casillasAmenaza.clear();
		
		for(i=0; i<movsLibre.length; i++)
		{
			k = pos.fila + movsLibre[i][0];
			l = pos.columna + movsLibre[i][1];
			
			while(true)
			{
				if(Validaciones.isInvalidPosition(k, l))
					break;
				
				if(estado.estaqueAt(k, l).estaVacia())
				{
						casillasAmenaza.add(estado.estaqueAt(k,l));
						k+=movsLibre[i][0];
						l+=movsLibre[i][1];
			
				}
				else break;
			}
		}

		for(i=0; i<movsCaballo.length; i++)
		{
			k = pos.fila + movsCaballo[i][0];
			l = pos.columna + movsCaballo[i][1];
			
			if(!Validaciones.isInvalidPosition(k, l) && estado.estaqueAt(k,l).estaVacia())
				casillasAmenaza.add(estado.estaqueAt(k,l));
		}
	}
	
	private boolean isEqualcasillaEvaluada(Position posRey, Position posEva)
	{
		return posRey.areEqualPostion(posEva);
	}
	
	private void agregaCasillaPeligro(CasillaData cas)
	{
		if(!casillasPeligrosas.contains(auxCas))
		{
			casillasPeligrosas.add(auxCas);
		}
	}
	
	public boolean listContains(CasillaData c)
	{
		return casillasPeligrosas.contains(c);
	}
	
	public boolean reyBloqueado()
	{
		return casillasPeligrosas.size()==MAX_CASILLAS;
	}
	
	public void limpiar()
	{
		casillasPeligrosas.clear();
	}
}
