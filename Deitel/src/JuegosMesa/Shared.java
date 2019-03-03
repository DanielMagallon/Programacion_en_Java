package JuegosMesa;

import static JuegosMesa.AjedrezToggle.MaxColumnasToLeft;
import static JuegosMesa.AjedrezToggle.MaxColumnasToRight;
import static JuegosMesa.AjedrezToggle.MaxFilasToDown;
import static JuegosMesa.AjedrezToggle.MaxFilasToUp;
import static JuegosMesa.AjedrezToggle.columnaActual;
import static JuegosMesa.AjedrezToggle.filaActual;
import static JuegosMesa.AjedrezToggle.maxDownLeft;
import static JuegosMesa.AjedrezToggle.maxDownRigth;
import static JuegosMesa.AjedrezToggle.maxUpLeft;
import static JuegosMesa.AjedrezToggle.maxUpRigth;
import static JuegosMesa.AjedrezToggle.toggle;

import javax.swing.JOptionPane;

public class Shared implements ValorOfAll
{
	public void moveDiagonal()
	{
		
		filaActual = getFilaOfToogle(toggle);
		columnaActual = getColumnOfToogle(toggle);
		
		maxDownRigth = 0;
		maxUpLeft = 0;
		maxDownLeft = 0;
		maxUpRigth = 0;
		
		if(isDownLeft())
		{
			moveDownRight(filaActual, columnaActual, filaActual);
			moveUpLeft(filaActual, columnaActual, columnaActual);
		}
		else
		{
			moveDownRight(filaActual, columnaActual, columnaActual);
			moveUpLeft(filaActual, columnaActual, filaActual);
			
		}
		
		if(isUpLeft())
		{
			moveUpRightDecrement(filaActual, columnaActual);
			moveDownLeftDecrement(filaActual, columnaActual);
		}
		else
		{
			moveUpRightIncrement(filaActual, columnaActual);
			moveDownLeftIncrement(filaActual, columnaActual);
			
		}
		
		System.out.println(" >>> Maximo avance derecha - abajo: " + maxDownRigth);
		System.out.println(" >>> Maximo avance derecha - arriba: " + maxUpRigth);
		System.out.println(" >>> Maximo avance izquierda - abajo: " + maxDownLeft);
		System.out.println(" >>> Maximo avance izquierda - arriba: " + maxUpLeft);
	}
	
	public boolean validMoveDiagonal()
	{
		if(!isValideTurn(toggle))
		{
			System.out.println("<<< No era tu turno >>>");
			return false;
		}
		
		
		
		return false;
	}
	
	public void moveDURL()
	{
		filaActual = getFilaOfToogle(toggle);
		columnaActual = getColumnOfToogle(toggle);
		
		if(filaActual==0)
		{
				MaxFilasToDown = maxFilasDown();
				MaxColumnasToRight = maxColumnsRight();
				MaxColumnasToLeft = maxColumnsLeft();
				MaxFilasToUp = 0;
		}
		
		else if(filaActual==7)
		{
			MaxFilasToUp = maxFilasUp();
			MaxColumnasToRight = maxColumnsRight();
			MaxColumnasToLeft = maxColumnsLeft();
			MaxFilasToDown = 0;
		}
		else
		{
			MaxFilasToDown = maxFilasDown();
			MaxFilasToUp = maxFilasUp();
			MaxColumnasToRight = maxColumnsRight();
			MaxColumnasToLeft = maxColumnsLeft();
		}
		
		System.out.println(" >>> Maximo avance hacia abajo: " + MaxFilasToDown);
		System.out.println(" >>> Maximo avance hacia arriba: " + MaxFilasToUp);
		System.out.println(" >>> Maximo avance hacia la derecha: " + MaxColumnasToRight);
		System.out.println(" >>> Maximo avance hacia la izquierda: " +MaxColumnasToLeft);
	}
	
	public boolean validMoveDURL()
	{
		if(!isValideTurn(toggle))
		{
			System.out.println("<<< No era tu turno >>>");
			return false;
		}
		
		if(isMoveHorizontal())
		{
			if(!moveToRigth())
			{
				return getLeftReturnColumns() <= MaxColumnasToLeft;
			}
			
			else
			{
				return getRightAdvanceColumns() <= MaxColumnasToRight;
			}
			
		}
		
		else
		{
			if(moveDown())
			{
				return getDownFilas() <= MaxFilasToDown;
			}
				
			else
			{
				return getUpFilas() <= MaxFilasToUp;
			}
		}
	}
	
	
}
