package C12Evalucacion;

import C12GUI.Inicialitation;

public class NumberGameTest extends Inicialitation
{
	static NumberGame ng = new NumberGame();
	
	public NumberGameTest()
	{
		super(ng,400,300,2);
	}
	
	public static void main(String[] args)
	{
		new NumberGameTest();
	}
}
