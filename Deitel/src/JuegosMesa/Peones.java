package JuegosMesa;

import static JuegosMesa.AjedrezToggle.toggle;
import static JuegosMesa.AjedrezToggle.filaActual;
import static JuegosMesa.AjedrezToggle.columnaActual;

public class Peones implements ValorOfAll
{
	public int maxFila, maxColIzquierda, maxColDerecha;
	private int lastF, lastCol;
	private Condition condP1,condP2,condCol, returned;
	boolean p1, canEatR=false, canEatL=false, canEat;
	
	public Peones()
	{
		condP1 = () ->  filaActual <= maxFila && lastCol == columnaActual;
		condP2 = () ->  filaActual >= maxFila && lastCol == columnaActual;
		returned = () -> filaActual <= lastF;
		condCol = () -> columnaActual == maxColDerecha || columnaActual == maxColIzquierda;
	}
	
	//es coneveniente que turno toca para hacer el proceso mas rapido y no cheque de en balde
	public void walkPeon()
	{
		lastF = getFilaOfToogle(toggle);
		lastCol = getColumnOfToogle(toggle);
		
		if(isPeon1())
		{
			if(lastF == 1 )
				maxFila = 3;
			
			else
			{
				if(lastF != 7)
					maxFila = lastF + 1;
			}
			
			p1=true;
			advanceDiagonal();
			return;
		}
		
		
		if(isPeon2())
		{
			if(lastF == 6 )
				maxFila = 4;
			
			else
			{
				if(lastF != 1)
					maxFila = lastF - 1;
			}
			  
			p1=false;
			advanceDiagonal();
		}
	}
	
	private void check (int f)
	{
		 maxColIzquierda = 0;
		 maxColDerecha = 0;
		
		if(lastCol != 7)
		{
			if(isUnfriend(f, lastCol+1))
			{
				maxColDerecha = lastCol + 1;
				canEatR = true;
			}
			else
			{
				maxColDerecha = 0;
				canEatR = false;
			}
		}
		
		if(lastCol != 0)
		{
			if(isUnfriend(f, lastCol-1))
			{
				maxColIzquierda = lastCol - 1;
				canEatL=true;
			}
			else 
			{
				maxColIzquierda = 0;
				canEatL = false;
			}
		}
	}
	
	public void advanceDiagonal() 
	{
		if(p1)
		   check(lastF+1);
		
		else
		   check(lastF-1);
		
		canEat = canEatL || canEatR;
		
	}
	
	public boolean madeMoveValidPeon()
	{
		filaActual = getNewFila();
		columnaActual = getNewCol();
		
		if(!isValideTurn(toggle))
			return false;

		if(p1)
		{
			if(!canEat)
			{
				return !returned.condition() && condP1.condition(); 
			}
			
			else
		      return !returned.condition() &&  condP1.condition() || 
						filaActual == lastF+1 && condCol.condition();
		}
		
		else
		{
			if(!canEat)
				return condP2.condition() && returned.condition(); 
			
			else
				return  condP2.condition() && returned.condition() ||
						filaActual == lastF-1 && condCol.condition();
		}
	}
}

