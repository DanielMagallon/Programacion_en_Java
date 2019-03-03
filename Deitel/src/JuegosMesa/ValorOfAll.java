package JuegosMesa;

import static JuegosMesa.AjedrezToggle.columnaActual;
import static JuegosMesa.AjedrezToggle.cuadros;
import static JuegosMesa.AjedrezToggle.filaActual;
import static JuegosMesa.AjedrezToggle.isPlayer1;
import static JuegosMesa.AjedrezToggle.maxDownLeft;
import static JuegosMesa.AjedrezToggle.maxDownRigth;
import static JuegosMesa.AjedrezToggle.maxUpLeft;
import static JuegosMesa.AjedrezToggle.maxUpRigth;
import static JuegosMesa.AjedrezToggle.toggle;
import static JuegosMesa.AjedrezToggle.togNew;
import static JuegosMesa.AjedrezToggle.respTogle;


import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public interface ValorOfAll
{
	default int getFilaOfToogle(JToggleButton to)
	{
		return Integer.parseInt(to.getName())/10;
	}
	
	default int getColumnOfToogle(JToggleButton to)
	{
		return Integer.parseInt(to.getName())%10;
	}
	
	default boolean isOfPlayer1(JToggleButton tog)
	{
		if(tog.getIcon() == null)
			return false;
		
		String icon = tog.getIcon().toString();
		
		for (String p : AjedrezToggle.piezasPrinc )
		{
			if(icon.contains(p+"1.png") || icon.contains("peon0.png"))
				return true;
		}
		
		return false;
	}
	
	default boolean isOfPlayer2(JToggleButton tog)
	{
		if(tog.getIcon() == null)
			return false;
		
		String icon = tog.getIcon().toString();
		
		for (String p :AjedrezToggle.piezasPrinc )
		{
			if(icon.contains(p+"2.png") || icon.contains("peonYell0.png"))
				return true;
		}
		return false;
	}
	
	default String getRouteIcon()
	{
	  return AjedrezToggle.togNew.getIcon().toString();
	}
	
	default String getRouteIconOld()
	{
		 return AjedrezToggle.respTogle.getIcon().toString(); //Aqui era respTogle
	}
	
	default boolean isPeon1()
	{
		return getRouteOldIcon().contains("peon0.png");
	}
	
	default boolean isPeon2()
	{
		return getRouteOldIcon().contains("peonYell0.png");
	}
	
	default boolean hizoMovimientoValido()
	{
		return getFilaOfToogle(AjedrezToggle.togNew) == AjedrezToggle.indiceFila1 
				&&  getColumnOfToogle(AjedrezToggle.togNew) == AjedrezToggle.indiceColumna1 
			   || getFilaOfToogle(AjedrezToggle.togNew) == AjedrezToggle.indiceFila2 && 
				getColumnOfToogle(AjedrezToggle.togNew) == AjedrezToggle.indiceColumna2;
	}
	
	default int getNewFila()
	{
		return Integer.parseInt(AjedrezToggle.togNew.getName())/10;
	}
	
	default int getNewCol()
	{
		return Integer.parseInt(AjedrezToggle.togNew.getName())%10;
	}
	
	default String getRouteOldIcon()
	{
	  return AjedrezToggle.toggle.getIcon().toString();
	}
	
	default int maxColumnsRight()
	{
		int j;
		
		
		for (j = columnaActual+1; j<=7; j++)
		{
			
			if(cuadros[filaActual][j].getIcon()!=null)
			{
				if(isPlayer1)
				{
					if(isOfPlayer1(cuadros[filaActual][j]))
						return j-columnaActual-1;
					else
						return j-columnaActual;
				}
				else
				{
					if(isOfPlayer2(cuadros[filaActual][j]))
						return j-columnaActual-1;
					else
						return j-columnaActual;
				}
			}
		}
		
			return j-columnaActual-1;
	}
	
	default int maxColumnsLeft()
	{
		int j;
		for (j = columnaActual-1; j>=0; j--)
		{
			
			if(cuadros[filaActual][j].getIcon()!=null)
			{
				if (isPlayer1)
				{
					if(isOfPlayer1(cuadros[filaActual][j]))
						return columnaActual-j-1;
					else 
						return columnaActual-j;
				}
				else
				{
					if(isOfPlayer2(cuadros[filaActual][j]))
						return columnaActual-j-1;
					else 
						return columnaActual-j;
				}
			}
		}
		return columnaActual-j-1;
	}
	
	default int maxFilasDown()
	{
		int i;
		
		for (i = filaActual+1; i<=7; i++)
		{
			
			if(cuadros[i][columnaActual].getIcon()!=null)
			{
				if(isPlayer1)
				{
					if (isOfPlayer1(cuadros[i][columnaActual]))
						return i - filaActual -1;
					else 
						return i - filaActual;
				}
				else
				{
					if (isOfPlayer2(cuadros[i][columnaActual]))
						return i - filaActual -1;
					else 
						return i - filaActual;
				}
			}
		}
		return i - filaActual -1;
	}
	
	default int maxFilasUp()
	{
		int i;
		for (i = filaActual-1; i>=0; i--)
		{
			if(cuadros[i][columnaActual].getIcon()!=null)
			{
				if(isPlayer1)
				{
					if(isOfPlayer1(cuadros[i][columnaActual]))
						return filaActual - i-1;
					else 
						return filaActual - i;
				}
				else
				{
					if(isOfPlayer2(cuadros[i][columnaActual]))
						return filaActual - i-1;
					else 
						return filaActual - i;
				}
			}
		}
		return filaActual - i-1;
	}
	
	default void returnLastState()
	{
		
		AjedrezToggle.respTogle.setIcon(AjedrezToggle.togNew.getIcon());
		
		if(AjedrezToggle.togNew.getIcon() != null)
			AjedrezToggle.togNew.setIcon(AjedrezToggle.respTogle.getIcon());
		else
			AjedrezToggle.togNew.setIcon(null);
		
		AjedrezToggle.togNew.setSelected(false);
		AjedrezToggle.respTogle.setSelected(true);
	}
	
	default boolean isMoveHorizontal()
	{
		if(getFilaOfToogle(AjedrezToggle.toggle) == getNewFila())
			return true;
		
		return false;
	}
	
	default int getLeftReturnColumns()
	{
		return getColumnOfToogle(AjedrezToggle.toggle) - getNewCol();
		
	}
	
	default int getRightAdvanceColumns()
	{
		//if(moveToRigth())
		return getNewCol() - getColumnOfToogle(AjedrezToggle.toggle);
		
		//return 0;
	}
	
	default int getUpFilas()
	{
		if(!moveDown())
		return getFilaOfToogle(AjedrezToggle.toggle) - getNewFila();
		
		return 0;
	}
	
	default int getDownFilas()
	{
		if(moveDown())
		return getNewFila() - getFilaOfToogle(AjedrezToggle.toggle);

		return 0;
	}
	
	default boolean moveToRigth()
	{
		return getNewCol() >= getColumnOfToogle(AjedrezToggle.toggle);
	}
	
	default boolean moveDown()
	{
		return getNewFila() >= getFilaOfToogle(AjedrezToggle.toggle);
	}
	
	default boolean isMoveNoDURL()
	{
		return getNewFila() != getFilaOfToogle(AjedrezToggle.toggle)
			   && getNewCol() != getColumnOfToogle(AjedrezToggle.toggle);
	}
	
	default void moveDownRight(int fila, int columna, int auxFC)
	{
		if(auxFC!=7) 
		{
			if(!hasIcon(fila+1, columna+1))
			{
				maxDownRigth++;
				moveDownRight(fila+1, columna+1, auxFC+1);
			}
			else
			{
				if(isUnfriend(fila+1, columna+1))
					maxDownRigth++;
			}
		}
	}
	
	default void moveUpLeft(int fila, int columna,int auxFC)
	{
		if(auxFC!=0)
		{
			if(!hasIcon(fila-1, columna-1))
			{
				maxUpLeft++;
				moveUpLeft(fila-1, columna-1, auxFC-1);
			}
			
			else
			{
				if(isUnfriend(fila-1, columna-1))
				{
					maxUpLeft++;
				}
			}
		}
	}
	
	default void moveDownLeftDecrement(int fila, int columna)
	{
		if(columna != 0)
		{
			if(!hasIcon(fila+1, columna-1))
			{
			maxDownLeft++;
			moveDownLeftDecrement(fila+1, columna-1);
			}
			
			else
			{
				if(isUnfriend(fila+1, columna-1))
				{
					maxDownLeft++;
				}
			}
		}
	}
	
	default void moveDownLeftIncrement(int fila, int columna)
	{
		if(fila != 7)
		{
			if(!hasIcon(fila+1, columna-1))
			{
			maxDownLeft++;
			moveDownLeftIncrement(fila+1, columna-1);
			}
			
			else
			{
				if(isUnfriend(fila+1, columna-1))
				{
					maxDownLeft++;
				}
			}
		}
	}
	
	default void moveUpRightDecrement(int fila, int columna)
	{
		if(fila != 0)
		{
			
			if(!hasIcon(fila-1, columna+1))
			{
				maxUpRigth++;
				moveUpRightDecrement(fila-1, columna+1);
			}
			else
			{
				if(isUnfriend(fila-1, columna+1))
				{
					maxUpRigth++;
				}
			}
		}
	}
	
	default void moveUpRightIncrement(int fila, int columna)
	{
		if(columna != 7)
		{
			if(!hasIcon(fila-1, columna+1))
			{
				maxUpRigth++;
				moveUpRightIncrement(fila-1, columna+1);
			}
			else
			{
				if(isUnfriend(fila-1, columna+1))
				{
					maxUpRigth++;
				}
			}
		}
		
	}
	
	default boolean isDownLeft()
	{
		return columnaActual < filaActual;
	}
	
	default boolean isUpLeft()
	{
		return	columnaActual < 7 - filaActual;
	}
	
	default void showMessage(String mes,String tittle, Object...args)
	{
		JOptionPane.showMessageDialog(null,String.format(mes, args),tittle,
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	default String getStringPosition()
	{
		return togNew.getName();
	}
	
	default void WhoAteWho()
	{
		WichIs.find();
	}
	
	default boolean isPeonP2()
	{
		return getRouteIcon().contains("peonYell0.png") ;
	}
	
	default boolean isPeonP1()
	{
		return getRouteIcon().contains("peon0.png");
	}
	
	
	default boolean hasIcon(int i, int j)
	{
		return cuadros[i][j].getIcon()!=null;
	}
	
	default boolean isValideTurn(JToggleButton tog)
	{
		System.out.printf ("Es turno del %s\n" , (AjedrezToggle.isTurnP1) ? "1" : "2");
		
		System.out.println(tog.getIcon());
		
		if (AjedrezToggle.isTurnP1)
		{
			
			if (isOfPlayer2(tog)) // era toogle
			{
				tog=null;
				return false;
			}
			
			tog=null;
			return true;
		}
		
		else
		{
			if (isOfPlayer1(tog))
			{
				tog=null;
				return false;
			}
			
			tog=null;
			return true;
		}
		
	}

	default boolean isUnfriend(int i,int j)
	{
		if(isPlayer1)
		{
			if(isOfPlayer2(cuadros[i][j]))
			{
				return true;
			}
			return false;
		}
		
		else
		{
			if(isOfPlayer1(cuadros[i][j]))
			{
				return true;
			}
			return false;
		}
	}
}
