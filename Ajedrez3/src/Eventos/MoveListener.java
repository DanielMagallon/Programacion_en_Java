package Eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import Abstract.Validaciones;
import Abstract.Variables;
import Abstract.VoidMethod;
import Funcionamiento.PC;
import Interfaz.CasillaData;
import Interfaz.Estaque;
import Interfaz.Position;
import Interfaz.TableroAjedrez;
import Piezas.Pieza;

import static Interfaz.TableroAjedrez.estado;
import static Abstract.Validaciones.colorDominante;
import static Abstract.Variables.turnoBlancas;

public class MoveListener extends MouseAdapter 
{
	public Estaque estaqueTocado, estaqueMeneado;
	public static CasillaData cas;
	private int player;
	public static Position position = new Position(0, 0);
	private boolean haEscogido,puedeMenearse=true;
	private static boolean sigueJuego=true;
	public PC pc = new PC();
	
	public static Almacena almacena = new Almacena();
	
	public static VoidMethod especial; 
	
	public void mouseClicked(MouseEvent e) 
	{
		if(sigueJuego)
		{
			if(!haEscogido)
			{
				Validaciones.estado = TableroAjedrez.estado;
				estaqueTocado = (Estaque) e.getComponent();
				position.fila = estaqueTocado.fila;
				position.columna = estaqueTocado.columna;
				Estaque.marcked=true;
				cas = estado.estaqueAt(position);
				player = cas.valor;
				escoge();
			}
			
			else
			{
				estaqueMeneado = (Estaque) e.getComponent();
				menea();

				if(sigueJuego)
				{
					estado.piezasLibres.showWalks();
					estado.tablas.determinarTablas();
				}
				
				pc.menear();
			}
		}
	}
	
	private void escoge()
	{
		if(validarTurno())
		{
			if(puedeMenearse)
			{ 
				estaqueTocado.selected();
				colorDominante = player;
				haEscogido=true;
				
				if(estaqueTocado.isOpcinal())
				{
					if(cas.esJugadorBlancas())
					{
						estado.jackeBlancas.marcarOpcionales(cas);
					}
					
					else
					{
						estado.jackeNegras.marcarOpcionales(cas);
					}
				}
				else
				{
					if(cas.esJugadorBlancas())
					{
						Validaciones.postionCompare = estado.positionReyBlanco;
						puedeMenearse = estado.jackeBlancas.sePuedeMenear(position);
						Variables.rey.peligroRey=estado.peligroBlancas;
					}
					else
					{
						Validaciones.postionCompare = estado.positionReyNegro;
						puedeMenearse = estado.jackeNegras.sePuedeMenear(position);
						Variables.rey.peligroRey=estado.peligroNegras;
					}
					
					if(puedeMenearse)
					{
						cas.pieza.buscaCaminos(position);
						estado.jugadas.anular();
					}
					else
					{
						if(!cas.esCaballo())
						{
							cas.pieza.searchByIndex(Variables.indexEvaluado, position);
						}
					}
				}
				
			}
		}
		
	}
	
	private void menea()
	{
		if(estaqueMeneado.isValidCasilla())
		{
			Propiedades.copiarPropiedades(estaqueTocado, estaqueMeneado);
			turnoBlancas=!turnoBlancas;
			
			if(especial!=null)
			{
				especial.method();
				especial=null;
			}
			
			almacena.addNew(estaqueTocado, estaqueMeneado);
		}
		Pieza.removeCasillasCamino();
		estaqueTocado.desmarcar();
		haEscogido=false;
		
		estado.jackeBlancas.limpiar();
		estado.jackeNegras.limpiar();
		estado.peligroBlancas.limpiar();
		estado.peligroNegras.limpiar();
		
		if(estado.jackeBlancas.find(estado.positionReyBlanco)){
			MoveListener.estadoJuego("Jaque mate-Negras ganan",false);
			return;
		}
		if(estado.jackeNegras.find(estado.positionReyNegro)){
			MoveListener.estadoJuego("Jaque mate-Blancas ganan",false);
			return;
		}
		
		estado.jackeBlancas.showJaques();
		estado.jackeNegras.showJaques();
		
		estado.jaqueBActivado = estado.jackeBlancas.hayJaque();
		estado.jaqueNActivado = estado.jackeNegras.hayJaque();
	}
	
	public boolean validarTurno()
	{
		if(turnoBlancas)
		{
			if(cas.esRey())
			{
				puedeMenearse=true;
			}
			
			else 
				puedeMenearse = estado.jaqueBActivado && estaqueTocado.isOpcinal() || !estado.jaqueBActivado;
			
			return cas.esJugadorBlancas();
		}
		
		else
		{
			if(cas.esRey())
			{
				puedeMenearse=true;
			}
			
			else
				puedeMenearse = estado.jaqueNActivado && estaqueTocado.isOpcinal() || !estado.jaqueNActivado;
			
			return cas.esJugadorNegras();
		}
	}
	
	public static void estadoJuego(String msg, boolean seguir)
	{
		JOptionPane.showMessageDialog(null, msg);
		sigueJuego=seguir;
	}
}
