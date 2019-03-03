package JuegosMesa;

import static JuegosMesa.AjedrezToggle.ficha;
import static JuegosMesa.AjedrezToggle.respTogle;

public class Alfil extends Shared implements ValorOfAll, Get<Alfil>
{
	public Is isAlfil1,isAlfil2;
	
	public Alfil()
	{
		isAlfil1 = () -> getRouteIconOld().contains("alfil1.png");
		isAlfil2 = () -> getRouteIconOld().contains("alfil2.png");
	}
	
	public void walkAlfil()
	{
		System.out.println("**************--Alfil--********************");
		moveDiagonal();
		System.out.println("**********************************\n\n");
		
	}
	
	public boolean madeMoveValidAlfil()
	{
		if(!isValideTurn(respTogle))
		{
			System.out.println("No era tu turno");
			return false;
		}
		
		return true;
	}
	
	public boolean isAlfil()
	{
		return isAlfil1.check() || isAlfil2.check();
	}
	
	@Override
	public Alfil getPiece()
	{
		ficha = getRouteIconOld();
		return this;
	}
}

