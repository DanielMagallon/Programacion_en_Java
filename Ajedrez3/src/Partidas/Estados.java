package Partidas;

import java.io.Serializable;

public class Estados implements Serializable 
{
	private static final long serialVersionUID = -5376929255571982063L;
	
	public String tablero[][];
	public boolean turnoBlanca;
	public boolean reyNMen,reyBMen,torrNCM,torrNLM,torrBCM,torrBLM;
	
	public void charge(String tablero[][], boolean turnoB,boolean reyNMen,boolean reyBMen,
					   boolean torrNCM, boolean torrNLM, boolean torrBCM, boolean torrBLM)
	{
		this.tablero = tablero;
		this.turnoBlanca = turnoB;
		this.reyNMen = reyNMen;
		this.reyBMen = reyBMen;
		this.torrNCM = torrNCM;
		this.torrNLM = torrNLM;
		this.torrBCM = torrBCM;
		this.torrBLM = torrBLM;
	}
}
