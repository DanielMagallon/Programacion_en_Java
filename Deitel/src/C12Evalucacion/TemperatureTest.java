package C12Evalucacion;

import C12GUI.Inicialitation;

public class TemperatureTest extends Inicialitation
{
	static TemperatureConvertion tc = new TemperatureConvertion();
	
	public TemperatureTest()
	{
		super(tc,250,150,2);
	}
	
	public static void main(String[] args)
	{
		new TemperatureTest();
	}
}
