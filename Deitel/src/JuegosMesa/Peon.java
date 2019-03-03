package JuegosMesa;

import javax.swing.JToggleButton;

public final class Peon implements ValorOfAll
{
	private boolean checarPlayer1()
	{
		boolean canBeEatToRight=false,canBeEatToLeft=false;
		
		if(AjedrezToggle.filaActual!=0)
		{
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
		}
		return false;
	}
	
	private boolean checarPlayer2()
	{
		boolean canBeEatToRight=false,canBeEatToLeft=false;
		
		if(AjedrezToggle.filaActual!=7)
		{
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
		}
		return false;
	}
	
	public void walkPeon()
	{
		if(AjedrezToggle.isTurnP1)
		{
			if(isPeonP1())
			{
			AjedrezToggle.isFisrtMovP1 = AjedrezToggle.fila==1 && 
					AjedrezToggle.col>=0 && AjedrezToggle.col<=7;
				
				if(AjedrezToggle.isFisrtMovP1)
				{
					if(AjedrezToggle.newFila-2 != AjedrezToggle.fila && AjedrezToggle.newFila-1 != 
					   AjedrezToggle.fila || AjedrezToggle.newCol != AjedrezToggle.col)
					{
						validPeon();
						return;
					}
					
				}
				
				else
				{
					if(AjedrezToggle.newFila-1 != AjedrezToggle.fila || AjedrezToggle.newCol != AjedrezToggle.col)
					{
						validPeon();
						return;
					}
					
				}
			AjedrezToggle.isTurnP1=false;
			}
			
			else
			{
				AjedrezToggle.toggle.setIcon(AjedrezToggle.togNew.getIcon());
				AjedrezToggle.togNew.setIcon(null);
			}
		}
	
		else
		{
			if(isPeonP2())
			{
			AjedrezToggle.isFisrtMovP2 = AjedrezToggle.fila==6 && AjedrezToggle.col>=0 && AjedrezToggle.col<=7;
			
			if(AjedrezToggle.isFisrtMovP2)
			{
				if(AjedrezToggle.newFila+2 != AjedrezToggle.fila && AjedrezToggle.newFila+1 
				   != AjedrezToggle.fila || AjedrezToggle.newCol != AjedrezToggle.col)
				{
					validPeon();
					return;
				}
				
			}
			else
			{
				if(AjedrezToggle.newFila+1 != AjedrezToggle.fila || AjedrezToggle.newCol != AjedrezToggle.col)
				{
					validPeon();
					return;
				}
				
			}
			AjedrezToggle.isTurnP1=true;
			}
			else
			{
				AjedrezToggle.toggle.setIcon(AjedrezToggle.togNew.getIcon());
				AjedrezToggle.togNew.setIcon(null);
			}
		}
	}
	
	private void validPeon()
	{
		
		AjedrezToggle.toggle.setIcon(AjedrezToggle.togNew.getIcon());
		AjedrezToggle.togNew.setIcon(null);
	}
	
	public boolean canEatDiagonalPlayerX(JToggleButton tog)
	{
		AjedrezToggle.filaActual = getFilaOfToogle(tog);
		AjedrezToggle.columnaActual=getColumnOfToogle(tog);
		
		
			if(isPeon1() || isPeon2())
			{
			if(AjedrezToggle.isPlayer1)
			{
				return checarPlayer1();
			}
			
			else
			{
				return checarPlayer2();
			}
			}
		return false;
	}
}
