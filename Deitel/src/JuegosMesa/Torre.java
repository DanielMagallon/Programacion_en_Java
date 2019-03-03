package JuegosMesa;

import static JuegosMesa.AjedrezToggle.ficha;

public class Torre extends Shared implements ValorOfAll, Get<Torre>
{
	private Is isTorre1, isTorre2;
	
	public Torre()
	{
		isTorre1 = () -> ficha.contains("torre1.png");
		isTorre2 = () -> ficha.contains("torre2.png");
	}
	
	public void walkTorre()
	{
		System.out.println("**************--Torre--********************");
		moveDURL();
		System.out.println("**********************************\n\n");
	}

	public boolean madeMovValidTorre()
	{
		if(!isMoveNoDURL())
		{
			return validMoveDURL();
		}
		
		return false;
	}

	public boolean isTower()
	{
		return isTorre1.check() || isTorre2.check();
	}

	@Override
	public Torre getPiece()
	{
		ficha = getRouteIconOld();
		return this;
	}
}
