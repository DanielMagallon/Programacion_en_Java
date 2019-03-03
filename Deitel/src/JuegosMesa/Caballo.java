package JuegosMesa;

import static JuegosMesa.AjedrezToggle.filaActual;
import static JuegosMesa.AjedrezToggle.toggle;
import static JuegosMesa.AjedrezToggle.columnaActual;
import static JuegosMesa.AjedrezToggle.ficha;

public class Caballo extends Position implements ValorOfAll, Get<Caballo>
{
	private int columTocheck, filaTocheck;
	public Is isHorse1, isHorse2;
	
	public Caballo()
	{
		isHorse1 = () -> ficha.contains("horse1.png");
		isHorse2 = () -> ficha.contains("horse2.png");
	}
	
	public void walkHorse()
	{
		System.out.println("\n\n*************************");
		deletePositions();
		downRigth();
		downLeft();
		
		rigthDown();
		rigthUp();
		
		upRight();
		upLeft();
		
		leftDown();
		leftUp();
		System.out.println("Posciones a tomar: "+position);
		System.out.println("*************************");
	}
	
	public boolean madeMoveValidHorse()
	{
		if(!isValideTurn(toggle))
			return false;
		
		return comparePositions();
	}
	
	private void downRigth() 
	{
		filaTocheck = filaActual + 2;
		columTocheck = columnaActual + 1;
		
		if(canMove())
			System.out.println("Me puedo menear 2 abajo 1 derecha");
	}
	
	private void downLeft() 
	{
		filaTocheck = filaActual + 2;
		columTocheck = columnaActual - 1;
		
		if (canMove())
			System.out.println("Me puedo menear 2 abajo 1 izquierda");
	}
	
	private void rigthDown() 
	{
		columTocheck = columnaActual + 2;
		filaTocheck = filaActual + 1;
		
		if (canMove())
			System.out.println("Me puedo menear 2 dercha 1 abajo");
	}
	
	private void rigthUp() 
	{
		columTocheck = columnaActual + 2;
		filaTocheck = filaActual - 1;
		
		if (canMove())
			System.out.println("Me puedo menear 2 dercha 1 arriba");
	}
	
	private void upRight()
	{
		filaTocheck = filaActual - 2;
		columTocheck = columnaActual + 1;
		
		if (canMove())
			System.out.println("Me puedo menear 2 arriba 1 derecha");
	}
	
	private void upLeft() 
	{
		filaTocheck = filaActual - 2;
		columTocheck = columnaActual - 1;
		
		if (canMove())
			System.out.println("Me puedo menear 2 arriba 1 izquierda");
	}
	
	private void leftDown() 
	{
		columTocheck = columnaActual - 2;
		filaTocheck = filaActual + 1;
		
		if (canMove())
			System.out.println("Me puedo menear 2 izquiedda 1 abajo");
	}
	
	private void leftUp() 
	{
		columTocheck = columnaActual - 2;
		filaTocheck = filaActual - 1;
		
		if (canMove())
			System.out.println("Me puedo menear 2 izquiedda 1 arriba");
	}
	
	private boolean canMove() 
	{
		try
		{
			if(isUnfriend(filaTocheck, columTocheck) || !hasIcon(filaTocheck, columTocheck))
			{
				addPosition(filaTocheck+""+columTocheck);
				return true;
			}
			return false;
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{
			return false;
		}
	}

	public boolean isHorse()
	{
		return isHorse1.check() || isHorse2.check();
	}
	
	@Override
	public Caballo getPiece()
	{
		ficha = getRouteIconOld();
		return this;
	}
}
