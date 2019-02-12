package Piezas;

import static Abstract.Variables.k;
import static Abstract.Variables.l;
import static Abstract.Variables.movsLibre;
import static Abstract.Validaciones.esEnemigo;
import static Abstract.Validaciones.puedeAvanzar;
import static Interfaz.TableroAjedrez.casillas;

import javax.swing.Icon;

import Abstract.Iterador;
import Abstract.Validaciones;
import Abstract.Variables;
import Eventos.EstadoTablero;
import Funcionamiento.PeligrosRey;
import Interfaz.Position;
import Interfaz.TableroAjedrez;

public class Rey extends Pieza
{
	public EstadoTablero estado;
	
	public Rey(int val)
	{
		nombre="Rey";
		clave="R";
		valor = val;
	}

	public void setEstado(EstadoTablero estado)
	{
		this.estado=estado;
	}
	
	@Override
	public Icon getPieza(int pla) 
	{
		
		if(pla==Variables.JUGADOR_BLANCAS)
			return Variables.REY1;
		
		else
			return Variables.REY2;
	}
	
	@Override
	public void buscaCaminos(Position pos) 
	{
		Iterador.iterar(0, () -> rey(pos), movsLibre.length);
		enroque();
	}
	
	private void enroque()
	{
		
		if(Validaciones.colorDominante == Variables.JUGADOR_BLANCAS)
		{
			if(!Variables.reyBlancoMeneado)
			{
				if(!estado.jackeBlancas.hayJaque())
				{
					if(!Variables.torreBlancaLM)
					{
						enroqueLargo(7,4);
					}
					
					if(!Variables.torreBlancaCM)
					{
						enroqueCorto(7,4);
					}
				}
			}
		}
		
		else
		{
			if(!Variables.reyNegroMeneado)
			{
				if(!estado.jackeNegras.hayJaque())
				{
					if(!Variables.torreNegraLM)
					{
						enroqueLargo(0,4);
					}
					
					if(!Variables.torreNegraCM)
					{
						enroqueCorto(0,4);
					}
				}
			}
		}
		
		casillaIlegal=false;
	}
	
	//A la izquierda
	 
	private void enroqueLargo(int f, int c)
	{
		Position posEnroque = new Position(f, 0);
		--c;
		while(true)
		{
			if(c==0)
			{
				casillas[f][2].marck();
				break;
			}
			
			if(puedeAvanzar(f, c))
			{
				if(c>1)
				{
					
					posEnroque.columna=c;
					
					Validaciones.buscaPieza(posEnroque, (a,b) -> casillaIlegal=true);
					Validaciones.peonAmenaza(posEnroque);
					Validaciones.reyAmenaza(posEnroque);
				}
				
				if(casillaIlegal)
				{
					break;
				}
				
				else
				{
					--c;
				}
			}
			
			else 
			{
				break;
			}
		}
	}
	
	private void enroqueCorto(int f, int c)
	{
		Position posEnroque = new Position(f, 0);
		++c;
		
		while(true)
		{
			if(c==7)
			{
				casillas[f][6].marck();
				break;
			}
			
			if(puedeAvanzar(f, c))
			{
				posEnroque.columna=c;
				Validaciones.buscaPieza(posEnroque, (a,b) -> casillaIlegal=true);
				Validaciones.peonAmenaza(posEnroque);
				Validaciones.reyAmenaza(posEnroque);
				
				if(casillaIlegal)
				{
					break;
				}
				
				else
				{
					++c;
				}
			}
			
			else 
			{
				break;
			}
		}
	}
	
	
	private boolean casillaIlegal=false;
	
	public PeligrosRey peligroRey;
	
	private void rey(Position pos)
	{
		k = pos.fila + movsLibre[Iterador.getIndex()][0];
		l = pos.columna + movsLibre[Iterador.getIndex()][1];
			
		if(puedeAvanzar(k, l) || esEnemigo(k, l))
		{
			if(!peligroRey.listContains(TableroAjedrez.estado.estaqueAt(k,l)))
			{
				casillas[k][l].marck();
			}
		}
	}

	
}
