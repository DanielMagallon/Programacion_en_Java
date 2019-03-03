package HelpClass;

public class TestEnum
{
	public static void main(String[] args)
	{
	
		TipoDeMadera miTipoMadera = TipoDeMadera.CAOBA; 
		
		System.out.println("Los posibles tipos de madera son: ");
		
		for (TipoDeMadera tmp : miTipoMadera.values ())
		{
			System.out.print (tmp.toString()+"\t");
		}
	}
}
