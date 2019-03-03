package C12Evalucacion;


import C12GUI.Inicialitation;

public class ColorSelectTest extends Inicialitation
{
	static ColorSelect cs = new ColorSelect();
	
	public ColorSelectTest()
	{
		super(cs, 250, 200,2);
	}
	
	public static void main(String[] args)
	{
		new ColorSelectTest();
	}
}
