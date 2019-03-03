package Aplication;

import javax.swing.JToggleButton;

public final class Peon implements ValorOfAll
{
	private boolean checarPlayer1()
	{
		boolean canBeEatToRight=false,canBeEatToLeft=false;
		
		if(AjedrezToggle.columnaActual==0)
		{
			AjedrezToggle.indiceFila1=AjedrezToggle.filaActual+1;
			AjedrezToggle.indiceColumna1=AjedrezToggle.columnaActual+1;
		  return isOfPlayer2(AjedrezToggle.cuadros[AjedrezToggle.filaActual+1][AjedrezToggle.columnaActual+1]);
		}
		
		else if (AjedrezToggle.columnaActual==7)
		{
			AjedrezToggle.indiceFila1=AjedrezToggle.filaActual+1;
			AjedrezToggle.indiceColumna1=AjedrezToggle.columnaActual-1;
			return isOfPlayer2(AjedrezToggle.cuadros[AjedrezToggle.filaActual+1][AjedrezToggle.columnaActual-1]);
		}
		
		else if (AjedrezToggle.columnaActual>=1 && AjedrezToggle.columnaActual<=6)
		{
			if(isOfPlayer2(AjedrezToggle.cuadros[AjedrezToggle.filaActual+1][AjedrezToggle.columnaActual-1]))
			{
				AjedrezToggle.indiceFila1=AjedrezToggle.filaActual+1;
				AjedrezToggle.indiceColumna1=AjedrezToggle.columnaActual-1;
				canBeEatToLeft=true;
			}
			else
			{
				AjedrezToggle.indiceFila1=-1;
				AjedrezToggle.indiceColumna1=-1;
			}
			if(isOfPlayer2(AjedrezToggle.cuadros[AjedrezToggle.filaActual+1][AjedrezToggle.columnaActual+1]))
			{
				AjedrezToggle.indiceFila2 = AjedrezToggle.filaActual+1;
				AjedrezToggle.indiceColumna2 = AjedrezToggle.columnaActual+1; 
				canBeEatToRight=true;
			}
			else
			{
				AjedrezToggle.indiceFila2=-1;
				AjedrezToggle.indiceColumna2=-1;
			}
			
			return canBeEatToLeft || canBeEatToRight;
		}
		return false;
	}
	
	private boolean checarPlayer2()
	{
		boolean canBeEatToRight=false,canBeEatToLeft=false;
		
		if(AjedrezToggle.columnaActual==0)
		{			
			AjedrezToggle.indiceFila1=AjedrezToggle.filaActual-1;
			AjedrezToggle.indiceColumna1=AjedrezToggle.columnaActual+1;
			return isOfPlayer1(AjedrezToggle.cuadros[AjedrezToggle.filaActual-1][AjedrezToggle.columnaActual+1]);
		}
		
		else if (AjedrezToggle.columnaActual==7)
		{
			AjedrezToggle.indiceFila1=AjedrezToggle.filaActual-1;
			AjedrezToggle.indiceColumna1=AjedrezToggle.columnaActual-1;
			return isOfPlayer1(AjedrezToggle.cuadros[AjedrezToggle.filaActual-1][AjedrezToggle.columnaActual-1]);
		}
		
		else if (AjedrezToggle.columnaActual>=1 && AjedrezToggle.columnaActual<=6)
		{
			if(isOfPlayer1(AjedrezToggle.cuadros[AjedrezToggle.filaActual-1][AjedrezToggle.columnaActual-1]))
			{
				AjedrezToggle.indiceFila1=AjedrezToggle.filaActual-1;
				AjedrezToggle.indiceColumna1=AjedrezToggle.columnaActual-1;
				canBeEatToLeft=true;
			}
			else
			{
				AjedrezToggle.indiceFila1=-1;
				AjedrezToggle.indiceColumna1=-1;
			}
			
			if(isOfPlayer1(AjedrezToggle.cuadros[AjedrezToggle.filaActual-1][AjedrezToggle.columnaActual+1]))
			{
				AjedrezToggle.indiceFila2 = AjedrezToggle.filaActual-1;
				AjedrezToggle.indiceColumna2 = AjedrezToggle.columnaActual+1; 
				canBeEatToRight=true;
			}
			else
			{
				AjedrezToggle.indiceFila2=-1;
				AjedrezToggle.indiceColumna2=-1;
			}
			
			return canBeEatToLeft || canBeEatToRight;
		}
		return false;
	}
	
	public boolean canEatDiagonalPlayerX(JToggleButton tog)
	{
		AjedrezToggle.filaActual = getFilaOfToogle(tog);
		AjedrezToggle.columnaActual=getColumnOfToogle(tog);
		
		if(AjedrezToggle.isPlayer1)
		{
			return checarPlayer1();
		}
		
		else
		{
			return checarPlayer2();
		}
	}
	
	public boolean isPeonP2()
	{
		return getRouteIcon().contains("peonYell0.png") ;
	}
	
	public boolean isPeonP1()
	{
		return getRouteIcon().contains("peon0.png");
	}
}
