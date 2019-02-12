package Interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import Eventos.EstadoTablero;
import Eventos.MoveListener;
import Juego.Ajedrez;
import Piezas.Pieza;

import static Abstract.Variables.alfil;
import static Abstract.Variables.peon;
import static Abstract.Variables.caballo;
import static Abstract.Variables.reina;
import static Abstract.Variables.rey;
import static Abstract.Variables.torre;
import static Abstract.Variables.JUGADOR_BLANCAS;
import static Abstract.Variables.JUGADOR_NEGRAS;

public class TableroAjedrez extends JPanel
{
	
	public static Estaque casillas[][] = new Estaque[8][8];
	public static EstadoTablero estado = new EstadoTablero("Normal");
	
	public static EstadoTablero estadoAnalisis = new EstadoTablero("Analizador");
	
	private static final long serialVersionUID = -7468009020219907163L;

	public boolean esParI=true, esParJ=true,haEscogido;
	
	public Color colorPar,colorImpar;
	
	private MoveListener listener = new MoveListener();
	
	public TableroAjedrez(int f, int c,Color par, Color impar, int sepF, int sepC) 
	{
		colorPar=par;
		colorImpar=impar;
		setLayout(new GridLayout(f, c,sepF,sepC));
		crear();
		setBackground(Color.black);
	}

	public void crear()
	{
		for(int i=0; i<casillas.length; i++)
		{
			esParI = !esParI;
			
			for (int j=0; j<casillas[0].length; j++)
			{
				esParJ=!esParJ;
				
				casillas[i][j] = new Estaque(i,j);
				casillas[i][j].setSelectedColor(Color.pink);
				casillas[i][j].setColorMarck(Color.magenta);
				
				casillas[i][j].addMouseListener(listener);
				
				if(esParI)
				{
					if(esParJ)
						casillas[i][j].setDefaultColor(colorPar);
					else
						casillas[i][j].setDefaultColor(colorImpar);
				}
				else
				{
					if(esParJ)
						casillas[i][j].setDefaultColor(colorImpar);
					else
						casillas[i][j].setDefaultColor(colorPar);
				}
			
				add(casillas[i][j]);
			}
		}
	}

	
	public void acomodadoPrincipal() 
	{
		Pieza piezas [] = {torre,caballo, alfil, reina,rey,alfil,caballo,torre};
		
		estado.init();
		estado.resetElements();
		
		estadoAnalisis.init();
		
		for(int i=2; i<=5; i++)
		{
			for (int j=0; j<piezas.length; j++)
			{
				casillas[i][j].setIcon(null);
			}
		}
		
		for (int j=0; j<piezas.length; j++)
		{
			
			casillas[0][j].putPiece(piezas[j],JUGADOR_NEGRAS);
			estado.actualizarTablero(0,j,piezas[j],JUGADOR_NEGRAS);
			estadoAnalisis.actualizarTablero(0,j,piezas[j],JUGADOR_NEGRAS);
			
			casillas[7][j].putPiece(piezas[j],JUGADOR_BLANCAS);
			estado.actualizarTablero(7,j,piezas[j],JUGADOR_BLANCAS);
			estadoAnalisis.actualizarTablero(7,j,piezas[j],JUGADOR_BLANCAS);
			
			casillas[1][j].putPiece(peon, JUGADOR_NEGRAS);
			estado.actualizarTablero(1,j,peon,JUGADOR_NEGRAS);
			estadoAnalisis.actualizarTablero(1,j,peon,JUGADOR_NEGRAS);
			
			casillas[6][j].putPiece(peon,JUGADOR_BLANCAS);
			estado.actualizarTablero(6,j,peon,JUGADOR_BLANCAS);
			estadoAnalisis.actualizarTablero(6,j,peon,JUGADOR_BLANCAS);
			
			if(j!=4)
			{
				estado.piezasNegrasDisponibles.add(estado.estaqueAt(0,j));
				estado.piezasBlancasDisponibles.add(estado.estaqueAt(7,j));
				estadoAnalisis.piezasNegrasDisponibles.add(estado.estaqueAt(0,j));
				estadoAnalisis.piezasBlancasDisponibles.add(estado.estaqueAt(7,j));
			}
			estado.piezasNegrasDisponibles.add(estado.estaqueAt(1,j));
			estado.piezasBlancasDisponibles.add(estado.estaqueAt(6,j));
			
			estadoAnalisis.piezasNegrasDisponibles.add(estado.estaqueAt(1,j));
			estadoAnalisis.piezasBlancasDisponibles.add(estado.estaqueAt(6,j));
		}
		piezas=null;

		estado.mostrar();
		
	}

	public void acomodadoEspecial()
	{
		//EstadoTablero.tablero = Descodificador.descodificar();
		estado.tablero = Ajedrez.desc.descodificar();
		estadoAnalisis.tablero = Ajedrez.desc2.descodificar();
		estado.resetElements();
		int val;
		Pieza piece;
		
		for(int i=0; i<casillas.length; i++)
		{
			for(int j=0; j<casillas.length; j++)
			{
				val = estado.estaqueAt(i,j).valor;
				piece = estado.estaqueAt(i,j).pieza;
				
				if(val!=-1)
				{
					if(val == JUGADOR_BLANCAS)
					{
						if(piece!=rey)
						{
							estado.piezasBlancasDisponibles.add(estado.estaqueAt(i,j));
							estadoAnalisis.piezasBlancasDisponibles.add(estadoAnalisis.estaqueAt(i,j));
						}
						else
						{
							estado.positionReyBlanco.setPosition(new Position(i, j));
							estadoAnalisis.positionReyBlanco.setPosition(new Position(i, j));
						}
					}
					else
					{
						if(piece!=rey)
						{
							estado.piezasNegrasDisponibles.add(estado.estaqueAt(i,j));
							estadoAnalisis.piezasNegrasDisponibles.add(estadoAnalisis.estaqueAt(i,j));
						}
						else
						{
							estado.positionReyNegro.setPosition(new Position(i, j));
							estadoAnalisis.positionReyNegro.setPosition(new Position(i, j));
						}
					}
					casillas[i][j].setIcon(estado.estaqueAt(i,j).pieza.getPieza(val));
				}
				else casillas[i][j].setIcon(null);
					
			}
		}
		estado.mostrar();
	}
}
