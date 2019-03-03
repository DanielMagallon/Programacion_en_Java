package JuegosMesa;

import static JuegosMesa.AjedrezToggle.filaActual;
import static JuegosMesa.AjedrezToggle.columnaActual;
import static JuegosMesa.AjedrezToggle.toggle;
import static JuegosMesa.AjedrezToggle.ficha;

public class King extends Position implements ValorOfAll, Get<King>
{	

	private int veces = 0;
	private Method metodNoth, metodSouth;
	public Is isKing1, isKing2;
	
	public King()
	{
		isKing1 = () -> getRouteIconOld().contains("rey1.png");
		isKing2 = () -> getRouteIconOld().contains("rey2.png");
		
		metodNoth = (f, c) -> moveToNorth(f, c + 1);
		metodSouth = (f, c) -> moveToSouth(f, c + 1);
	}
	
	public void waklKing()
	{
		deletePositions();
		moveToNorth(filaActual - 1, columnaActual - 1);
		veces = 0;
		moveToSouth(filaActual + 1, columnaActual - 1);
		veces = 0;
		moveWEAST();
		System.out.println("Posiciones posibles " + position);
		
	}
	
	public boolean madeMoveValidKing()
	{
		if(!isValideTurn(toggle))
			return false;
		
		return comparePositions();
	}
	
	private void addAndAdvance(int fila,int columna, Method met)
	{
		try
		{
			if(isUnfriend(fila, columna) || !hasIcon(fila, columna))
			{
				addPosition(fila+""+columna);
				met.method(fila, columna);
			}
			else
				met.method(fila, columna);
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{
			met.method(fila, columna);
		}
		
		met=null;
	}
	
	private void moveToNorth(int fila, int columna)
	{
		veces++;
		
		if(veces==4 || fila == -1)
			return;
		
		addAndAdvance(fila, columna, metodNoth);
	}
	
	private void moveToSouth(int fila, int columna)
	{
		veces++;
		
		if(veces==4 || fila == 8)
			return;
		
		addAndAdvance(fila, columna, metodSouth);
	}
	
	private void moveWEAST()
	{
		try
		{
			if(isUnfriend(filaActual, columnaActual-1) || !hasIcon(filaActual, columnaActual-1))
			{
				addPosition(filaActual+""+ (columnaActual-1));
			}
			
			if(isUnfriend(filaActual, columnaActual+1) || !hasIcon(filaActual, columnaActual+1))
			{
				addPosition(filaActual+""+ (columnaActual+1));
			}
		}
		catch (ArrayIndexOutOfBoundsException ex){}
	}
	
	public boolean isKing()
	{
		return isKing1.check() || isKing2.check();
	}
	
	@Override
	public King getPiece()
	{
		ficha = getRouteIconOld();
		return this;
	}
}
