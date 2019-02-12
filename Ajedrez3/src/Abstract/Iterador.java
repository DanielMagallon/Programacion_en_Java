package Abstract;

public abstract class Iterador 
{
	private static int index;
	static VoidMethod voidmet;
	public static boolean breaked;
	
	public static void iterar(int asignacion, VoidMethod metodo, int numero_cond)
	{
		index=asignacion;
		
		for (;index<numero_cond;index++)
		{
			metodo.method();
		}
	}
	
//	public static void iterarConditional(int asignacion, VoidMethod metodo, int numero_cond)
//	{
//		index=asignacion;
//		breaked=false;
//		
//			for (;index<numero_cond;index++)
//			{
//				metodo.method();
//				
//				if(breaked)
//					break;
//			}
//	}
	
	public static int getIndex()
	{
		return index;
	}
}
