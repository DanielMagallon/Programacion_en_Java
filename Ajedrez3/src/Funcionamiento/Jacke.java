 package Funcionamiento;

import java.util.ArrayList;

import Abstract.DobleList;
import Abstract.Method;
import Abstract.ReturnVMethod;
import Abstract.Validaciones;
import Abstract.Variables;
import Eventos.EstadoTablero;
import Interfaz.Busquedas;
import Interfaz.CasillaData;
import Interfaz.Position;
import static Abstract.Variables.k;
import static Abstract.Variables.l;
import static Abstract.Variables.movsLibre;

public class Jacke 
{
	private final int colorD;
	
	protected  ArrayList<CasillaData> piezasDanJaque = new ArrayList<>();
	protected  ArrayList<CasillaData> casillasPasaJaque = new ArrayList<>();
	 
	private ArrayList<CasillaData> piezasComeJaque = new ArrayList<>();
	
	private DobleList piezasCubren = new DobleList();
	private Method metodo;
	private EstadoTablero estado;
	private ReturnVMethod get;
	
	public Jacke(int id, EstadoTablero est, ReturnVMethod get) 
	{
		this.get=get;
		estado=est;
		colorD = id;
		metodo = (a,b) -> agregaJaques(estado.estaqueAt(a,b));
	}
	
	//Ve que piezas dan jaque
	//return 1 para bancas, 2 para negras
	public boolean find(Position pos)
	{
		if(colorD == Variables.JUGADOR_BLANCAS)
			estado.peligroBlancas.findDanger(estado.positionReyBlanco);
		
		else estado.peligroNegras.findDanger(estado.positionReyNegro);
		
		
		Validaciones.colorDominante = colorD;
		Validaciones.buscaPieza(pos,metodo);
		Validaciones.peonAmenaza(pos);
		
		if(hayJaque())
		{
			
			if(getJaques() == 1)
			{
				//Las casilla por las que el jaque pasa
				if(!piezasDanJaque.get(0).esCaballo())
				{
					Position aux = piezasDanJaque.get(0).position;
					
					pos.comparePosition(aux);
					
					pos.areEqualColumn();
					pos.areEqualFile();
					pos.areInDiagonal();
					
					k = aux.fila + movsLibre[Variables.indexEvaluado][0];
					l = aux.columna + movsLibre[Variables.indexEvaluado][1];
					
					
					
					while(true)
					{
						if( !(k == pos.fila && l == pos.columna) )
						{
							casillasPasaJaque.add(estado.estaqueAt(k,l));
							k += movsLibre[Variables.indexEvaluado][0];
							l += movsLibre[Variables.indexEvaluado][1];
							continue;
						}
						
						else break;
					}
				}
				
				comerJaque();
				cubrirJaque();
				metodo = (a,b) -> agregaJaques(estado.estaqueAt(a,b));
				
				if(!hayAyudas())
					return get.get();
			}
			else if(getJaques()==2)
				return get.get();
			
			if(colorD == Variables.JUGADOR_BLANCAS)
				estado.blancasOn.clear();
			else
				estado.negrasOn.clear();
		}
		else
			estado.piezasLibres.search(colorD == Variables.JUGADOR_BLANCAS);
		
		return false;
	}
	
	public boolean hayAyudas()
	{
		return (!piezasComeJaque.isEmpty() || piezasCubren.size()>0);
	}
	
	private void comerJaque()
	{
		metodo = (a,b) -> agregaComeJaque(estado.estaqueAt(a,b));
		Validaciones.postionCompare = (Validaciones.colorDominante == Variables.JUGADOR_BLANCAS)
				? estado.positionReyBlanco : estado.positionReyNegro;
		//Invierte el color del dominante para la pieza que da jque (que es deke color contrario al colorD)
		//y le busque cuales son sus piezas enemigas
		Validaciones.colorDominante = ~Validaciones.colorDominante;
		Validaciones.buscaPieza(piezasDanJaque.get(0).position,metodo);
		Validaciones.peonAmenaza(piezasDanJaque.get(0).position);
	}
	
	private CasillaData aux;
	
	private void cubrirJaque()
	{
		metodo = (a,b) -> agregaCubreJaque(estado.estaqueAt(a,b));

		for(int i=0; i<casillasPasaJaque.size(); i++)
		{			
			aux = casillasPasaJaque.get(i);
			Validaciones.buscaPieza(aux.position, metodo);
			Validaciones.peoncCubreCasilla(aux.position);
		}
	}
	
	public boolean sePuedeMenear(Position pos)
	{
		Validaciones.colorDominante = colorD;
		
		return Validaciones.validarPieza(pos);
	}
	
	private void agregaJaques(CasillaData cas)
	{
		piezasDanJaque.add(cas);
	}
	

	private void agregaCubreJaque(CasillaData cas)
	{
		Validaciones.colorDominante = ~Validaciones.colorDominante;
		
		if(Validaciones.validarPieza(cas.position))
		{
			piezasCubren.addCasillas(cas, aux);
			cas.setOpcional(true);
		}
			
		Validaciones.colorDominante = ~Validaciones.colorDominante;
	}
	
	private void agregaComeJaque(CasillaData cas)
	{
		Validaciones.colorDominante = ~Validaciones.colorDominante; //Enconrando
		//as piezas que comen jaque, se ivnierte de nuevo el valor al original
		//para ver si esa pieza sta en posico del rey y almoverse deja un ajque
		
		
		if(Validaciones.validarPieza(cas.position))
		{
				piezasComeJaque.add(cas);
				cas.setOpcional(true);
		}
		
		Validaciones.colorDominante = ~Validaciones.colorDominante;	//Aqui siempre terminara con el color
		//contario

	}
	
	public int getJaques()
	{
		return piezasDanJaque.size();
	}
	
	public boolean hayJaque()
	{
		return !piezasDanJaque.isEmpty();
	}
	
	public void showJaques()
	{
		StringBuilder cadena = new StringBuilder();
		StringBuilder cadena2 = new StringBuilder();
		StringBuilder cadena3 = new StringBuilder();
		
		for (int i=0; i<piezasDanJaque.size(); i++)
		{
			cadena.append(piezasDanJaque.get(i)+"\n");
		}
		
		for (int i=0; i<casillasPasaJaque.size(); i++)
		{
			cadena2.append(casillasPasaJaque.get(i)+"\n");
		}
		
		for (int i=0; i<piezasComeJaque.size(); i++)
		{
			cadena3.append(piezasComeJaque.get(i)+"\n");
		}
		
		if(colorD == Variables.JUGADOR_NEGRAS)
		{
			Busquedas.setTextArea(Busquedas.txtPiezasDanJaqueN, cadena.toString());
			Busquedas.setTextArea(Busquedas.txtCasillasPasaJaqueN, cadena2.toString());
			Busquedas.setTextArea(Busquedas.txtComeJaqueN, cadena3.toString());
			Busquedas.setTextArea(Busquedas.txtPiezasCubrenJN, piezasCubren.mostrar(" cubre ").toString());
		}
		
		else
		{
			Busquedas.setTextArea(Busquedas.txtPiezasDanJB, cadena.toString());
			Busquedas.setTextArea(Busquedas.txtCasillasPasaJB, cadena2.toString());
			Busquedas.setTextArea(Busquedas.txtComeJaqueB, cadena3.toString());
			Busquedas.setTextArea(Busquedas.txtPiezasCubreJB, piezasCubren.mostrar(" cubre ").toString());
		}
	}
	
	public void limpiar()
	{
		piezasDanJaque.clear();
		casillasPasaJaque.clear();
		
		for(int i=0; i<piezasComeJaque.size(); i++)
		{
			piezasComeJaque.get(i).setOpcional(false);
		}
		
		piezasComeJaque.clear();
		
		for(int i=0; i<piezasCubren.size(); i++)
		{
			piezasCubren.getCasillaAct(i).setOpcional(false);
		}
		
		piezasCubren.clear();
	}
	
	public void marcarOpcionales(CasillaData casClick)
	{
		for(int i=0; i<piezasCubren.size(); i++)
		{
			if(piezasCubren.getCasillaAct(i) == casClick)
			{
				piezasCubren.getCasillaOld(i).marck();
			}
		}
		
		for(int i=0; i<piezasComeJaque.size(); i++)
		{
			if(piezasComeJaque.get(i) == casClick)
			{
				piezasDanJaque.get(0).marck();
				break;
			}
		}
		
	}
	
}

