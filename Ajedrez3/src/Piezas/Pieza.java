package Piezas;

import static Abstract.Variables.k;
import static Abstract.Variables.l;
import static Interfaz.TableroAjedrez.casillas;

//import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.Icon;

import Abstract.Iterador;
import Interfaz.CasillaData;
import Interfaz.Position;

import static Abstract.Variables.movsLibre;
import static Abstract.Validaciones.esEnemigo;
import static Abstract.Validaciones.puedeAvanzar;

public abstract class Pieza 
{
	
	public String nombre,clave;
	public int valor;
	private Position position;
	
	public static ArrayList<CasillaData> casillasCamino = new ArrayList<>();
	
	public abstract Icon getPieza(int player);
	
	
	public void buscaCaminos(Position pos){
		
		position = pos;
	}

	
	public static void removeCasillasCamino()
	{
		for (int i=0; i<casillasCamino.size(); i++)
		{
			casillasCamino.get(i).desmarcar();
		}
		casillasCamino.clear();
	}
	
	
	public void searchByIndex(int indexEva, Position pos)
	{
		
		search(indexEva, pos);
		
		if(indexEva%2==0)
			search(indexEva+1, pos);
		else 
			search(indexEva-1, pos);
		
	}
	
	private void search(int index, Position pos)
	{
		k = pos.fila + movsLibre[index][0];
		l = pos.columna + movsLibre[index][1];
		
		while(true)
		{
			if(esEnemigo(k, l))
			{
				casillas[k][l].marck();
				break;
			}
			
			if(puedeAvanzar(k, l))
			{
				casillas[k][l].marck();
				k += movsLibre[index][0];
				l += movsLibre[index][1];
				
			}
			
			else break;
		}
		
	}
	
	protected  void whileTrue(int arrayRefence[][])
	{
		k = position.fila + arrayRefence[Iterador.getIndex()][0];
		l = position.columna + arrayRefence[Iterador.getIndex()][1];
		
		while(true)
		{
			
			if(esEnemigo(k, l))
			{
				casillas[k][l].marck();
				break;
			}
			
			if(puedeAvanzar(k, l))
			{
				casillas[k][l].marck();
				k += arrayRefence[Iterador.getIndex()][0];
				l += arrayRefence[Iterador.getIndex()][1];
			}
			
			else break;
		}
		
	}
	
	public int getValor(){return valor;}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre;
	}
}
