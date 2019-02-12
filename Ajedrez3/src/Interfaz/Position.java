package Interfaz;


import Abstract.Variables;

public class Position 
{
	public int fila,columna;
	private int id;
	private Position positionComp;
	
	public Position(int f, int c)
	{
		fila = f;
		columna = c;
	}
	
	public void setID(int ID)
	{
		id = ID;
	}
	
	public void setPosition(Position pos)
	{
		fila = pos.fila;
		columna= pos.columna;
		pos=null;
	}
	
//	public void setPosition(int f, int c)
//	{
//		fila=f;
//		columna=c;
//	}
	
	public int getID()
	{
		return id;
	}
	
	public Position comparePosition(Position pos)
	{
		Variables.indexEvaluado = -1;
		positionComp = pos;
		return this;
	}
	
	public boolean areEqualPostion(Position pos)
	{
		return this.fila == pos.fila && this.columna == pos.columna;
	}
	
	public boolean areEqualFile()
	{
		if(fila == positionComp.fila)
		{
			Variables.indexEvaluado = (columna<positionComp.columna) ? Variables.IZQUIERDA : Variables.DERECHA;
			return true;
		}
		
		return false;
	}
	
	public boolean areEqualColumn()
	{
		if(columna == positionComp.columna)
		{
			Variables.indexEvaluado = (fila<positionComp.fila) ? Variables.ARRIBA : Variables.ABAJO;
			return true;
		}
		
		return false;
	}
	
	public boolean areInDiagonal()
	{
		if(fila-columna == positionComp.fila - positionComp.columna)
		{
			//Es prque esra en arrizq-abader
			Variables.indexEvaluado = (fila < positionComp.fila) ? Variables.ARRIBA_IZQ : Variables.ABAJO_DER;
			
			return true;
		}
		
		else if(fila+columna == positionComp.fila+positionComp.columna)
		{
			//es porque esta abjizq-arrder
			Variables.indexEvaluado = (fila < positionComp.fila) ? Variables.ARRIBA_DER : Variables.ABAJO_IZQ;
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%d][%d]", fila,columna);
	}
}
