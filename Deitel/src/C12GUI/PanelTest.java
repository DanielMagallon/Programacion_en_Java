package C12GUI;

public class PanelTest extends Inicialitation
{
	static PanelFrame pf = new PanelFrame();
	
	public PanelTest()
	{
		super(pf,450,200,2);	 
	}
	
	public static void main(String[] args)
	{
		new PanelTest();
	}
}
