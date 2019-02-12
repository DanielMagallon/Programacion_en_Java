package Eventos;

import Funcionamiento.FreePiece;
import Funcionamiento.Jacke;
import Funcionamiento.Jugadas;
import Funcionamiento.PeligrosRey;
import Funcionamiento.Tablas;
import Interfaz.CasillaData;
import Interfaz.Position;
import Interfaz.TableroAjedrez;
import Piezas.Pieza;

import static Abstract.Variables.JUGADOR_BLANCAS;
import static Abstract.Variables.JUGADOR_NEGRAS;

import java.util.ArrayList;
import java.util.HashMap;

import Abstract.Method;
import Abstract.ReturnVMethod;
import Abstract.Variables;
import Abstract.VoidMethod;
import Abstract.VoidMethodParameter;

public class EstadoTablero
{
	public  CasillaData tablero[][];
	
	public Position positionReyNegro = new Position(0, 4);
	public Position positionReyBlanco = new Position(7, 4);
	
	public PeligrosRey peligroBlancas = new PeligrosRey(JUGADOR_BLANCAS,this);
	public PeligrosRey peligroNegras = new PeligrosRey(JUGADOR_NEGRAS,this);
	
	public Jacke jackeBlancas = new Jacke(JUGADOR_BLANCAS,this,()->peligroBlancas.reyBloqueado());
	public Jacke jackeNegras = new Jacke(JUGADOR_NEGRAS,this,()-> peligroNegras.reyBloqueado());
	
	public HashMap<CasillaData, ArrayList<CasillaData>> blancasOn = new HashMap<>();
	public HashMap<CasillaData, ArrayList<CasillaData>> negrasOn = new HashMap<>();
	
	public Jugadas jugadas = new Jugadas();
	
	
	public Tablas tablas = new Tablas(this);
	
	public boolean jaqueNActivado,jaqueBActivado;
	
	public ArrayList<CasillaData> piezasBlancasDisponibles = new ArrayList<>();
	public ArrayList<CasillaData> piezasNegrasDisponibles = new ArrayList<>();
	
	public FreePiece piezasLibres = new FreePiece(this);
	
	public String nameObject;
	
	public EstadoTablero(String n) 
	{
		nameObject = n;
		Variables.rey.setEstado(this);
	}
	
	public void init()
	{
		tablero =  new CasillaData[8][8];
		
		for(int i=0; i<tablero.length; i++)
		{
			for(int j=0; j<tablero.length; j++)
			{
				tablero[i][j] = new CasillaData(i,j);
			}
		}
	}
	
	public void mostrar()
	{
		System.out.println("Estado del tablero: ");
		for(CasillaData x[] : tablero)
		{
			for(CasillaData y : x)
			{
				System.out.print("\"");
				System.out.print(y.casillaName);
				System.out.print ("\" ");
			}
			
			System.out.println();
		}
		
		System.out.println("\n-------------------");
	}
	
	public void actualizarTableroFT(int f, int c,Pieza pieza,int val, Position pos)
	{
//		metodos.clear();
		
		if(tablero[f][c].pieza!=null)
		{
			piezaComida(f, c);
		}
		
		if(tablero[pos.fila][pos.columna].esPeon())
		{
				//Comio por derecha
				if(pos.columna == c-1)
				{
					MoveListener.especial = ()->
					{
						TableroAjedrez.casillas[pos.fila][pos.columna+1].setIcon(null);
					};
					
					piezaComida(pos.fila, pos.columna+1);
					tablero[pos.fila][pos.columna+1].actualizar(-1, null);
				}
				
				else if(pos.columna == c+1)
				{
					MoveListener.especial = ()->
					{
						TableroAjedrez.casillas[pos.fila][pos.columna-1].setIcon(null);
					};
					piezaComida(pos.fila, pos.columna-1);
					tablero[pos.fila][pos.columna-1].actualizar(-1, null);
				}
		}
		
		
		jugadas.jugadasEspeciales(tablero[pos.fila][pos.columna],tablero[f][c]);
		Object[] pv = jugadas.coronarPeon();
		
		if(pv!=null)
		{
			pieza = (Pieza)pv[0];
			val  = (int) pv[1];
		}
	
		//Posicion destino
		actualizarTablero(f,c, pieza, val);
		//Posicion tocada
		actualizarTablero(pos, null, -1);
	}
	
	public void actualizarTablero(int f, int c,Pieza pieza,int val)
	{
//		metodos.add((a)-> a.tablero[f][c].actualizar(val, pieza));
		tablero[f][c].actualizar(val, pieza);
	}
	
	
	public void actualizarTablero(Position pos, Pieza pieza,int val)
	{
//		metodos.add((a)-> a.tablero[pos.fila][pos.columna].actualizar(val, pieza));
		tablero[pos.fila][pos.columna].actualizar(val, pieza);
	}
	
	public CasillaData estaqueAt(Position pos)
	{
		return tablero[pos.fila][pos.columna];
	}
	
	public CasillaData estaqueAt(int f, int c)
	{
		return tablero[f][c];
	}
	
//	public ArrayList<VoidMethodParameter<EstadoTablero>> metodos = new ArrayList<>();
//	
//	public void activity()
//	{
//		for(VoidMethodParameter<EstadoTablero> met : metodos)
//		{
//			System.out.println("Acividad");
//			met.method(TableroAjedrez.estadoAnalisis);
//		}
//	}
	
	private void piezaComida(int f, int c)
	{
		if(tablero[f][c].esJugadorBlancas())
		{
			piezasBlancasDisponibles.remove(tablero[f][c]);
//			metodos.add((a)-> a.piezasBlancasDisponibles.remove(tablero[f][c]));
		}
		else{
			piezasNegrasDisponibles.remove(tablero[f][c]);
//			metodos.add((a)-> a.piezasNegrasDisponibles.remove(tablero[f][c]));
		}
	}
	
	public String[][] saveStringTablero()
	{
		String arr[][] = new String[8][8];
		
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr[i].length; j++)
			{
				arr[i][j] = tablero[i][j].casillaName;
			}
		}
		
		return arr;
	}
	
	public void resetElements()
	{
		piezasBlancasDisponibles.clear();
		piezasNegrasDisponibles.clear();
	}
}

