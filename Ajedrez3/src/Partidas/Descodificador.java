package Partidas;

import static Abstract.Variables.alfil;
import static Abstract.Variables.peon;
import static Abstract.Variables.caballo;
import static Abstract.Variables.reina;
import static Abstract.Variables.rey;
import static Abstract.Variables.torre;

import static Abstract.Variables.torreBlancaCM;
import static Abstract.Variables.torreBlancaLM;
import static Abstract.Variables.torreNegraCM;
import static Abstract.Variables.torreNegraLM;
import static Abstract.Variables.reyBlancoMeneado;
import static Abstract.Variables.reyNegroMeneado;
import static Abstract.Variables.turnoBlancas;

import Interfaz.CasillaData; 

import static Abstract.Variables.JUGADOR_BLANCAS;
import static Abstract.Variables.JUGADOR_NEGRAS;

public class Descodificador 
{
	public  Estados valores = new Estados();
	private  String[][] codificado;
	private  CasillaData[][] tablero = new CasillaData[8][8];
	
	public CasillaData[][] descodificar()
	{
		
		codificado = valores.tablero;
		torreBlancaCM = valores.torrBCM;
		torreBlancaLM = valores.torrBLM;
		torreNegraLM = valores.torrNLM;
		torreNegraCM = valores.torrNCM;
		reyBlancoMeneado = valores.reyBMen;
		reyNegroMeneado = valores.reyNMen;
		turnoBlancas = valores.turnoBlanca;
		
		for(int i=0; i<codificado.length; i++)
		{
			for(int j=0; j<codificado.length; j++)
			{
				tablero[i][j] = new CasillaData(i, j);
				asignValor(i, j);
			}
		}
		
		return tablero;
				
	}
	
	private void asignValor(int i, int j)
	{
		switch(codificado[i][j])
		{
			case "PB":
				tablero[i][j].actualizar(JUGADOR_BLANCAS, peon);
				break;
				
			case "PN":
				tablero[i][j].actualizar(JUGADOR_NEGRAS, peon);
				break;
				
			case "TB":
				tablero[i][j].actualizar(JUGADOR_BLANCAS,torre);
				break;
			
			case "TN":
				tablero[i][j].actualizar(JUGADOR_NEGRAS, torre);
				break;
				
			case "CB":
				tablero[i][j].actualizar(JUGADOR_BLANCAS,caballo);
				break;
				
			case "CN":
				tablero[i][j].actualizar(JUGADOR_NEGRAS, caballo);
				break;
				
			case "AB":
				tablero[i][j].actualizar(JUGADOR_BLANCAS, alfil);
				break;
				
			case "AN":
				tablero[i][j].actualizar(JUGADOR_NEGRAS, alfil);
				break;
				
			case "DN":
				tablero[i][j].actualizar(JUGADOR_NEGRAS, reina);
				break;
				
			case "DB":
				tablero[i][j].actualizar(JUGADOR_BLANCAS,reina);
				break;
				
			case "RB":
				tablero[i][j].actualizar(JUGADOR_BLANCAS, rey);
				break;
				
			case "RN":
				tablero[i][j].actualizar(JUGADOR_NEGRAS, rey);
		}
	}
}
