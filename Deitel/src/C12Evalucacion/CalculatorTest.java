package C12Evalucacion;

import C12GUI.Inicialitation;

public class CalculatorTest extends Inicialitation
{
	static Calculator c = new Calculator();
	
	public CalculatorTest()
	{
		super(c, 250, 200,2);
	}
	
	public static void main(String[] args)
	{
		new CalculatorTest();
	}
}
