package JuegosMesa;
import static JuegosMesa.AjedrezToggle.ficha;

public class Queen extends Shared implements ValorOfAll, Get<Queen>
{
	public Is isQueen1,isQueen2;
	
	public Queen()
	{
		isQueen1 = () -> ficha.contains("queen1.png");
		isQueen2 = () -> ficha.contains("queen2.png");
	}
	
	public void walkQueen()
	{
		System.out.println("**************--Queen--********************");
			moveDiagonal();
			moveDURL();
		System.out.println("**********************************\n\n");
	}
	
	public boolean madeMoveValidQueen()
	{
		if(!isMoveNoDURL())
			return validMoveDURL();
		
		else
		    return validMoveDiagonal();
	}
	
	public boolean isQueen()
	{
		return isQueen1.check() || isQueen2.check();
	}
	
	@Override
	public Queen getPiece()
	{
		ficha = getRouteIconOld();
		return this;
	}
}
