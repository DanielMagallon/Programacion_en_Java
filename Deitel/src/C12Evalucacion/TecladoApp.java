package C12Evalucacion;

import C12GUI.Inicialitation;

public class TecladoApp extends  Inicialitation
{
	static Teclado tl = new Teclado();
	
	public TecladoApp()
	{
		super(tl,450,400,2);
	}
	
	public static void main(String[] args)
	{
		 new TecladoApp();
	}
}
