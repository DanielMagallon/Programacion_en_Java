package C10Excepciones;

public class ExcepcionesLimpiamientoPila
{
	public static void main(String[] args)
	{
		try
		{
			metodo1();
		} 
		catch (Exception e)
		{
			System.err.printf("%s\n\n",e.getMessage());
			e.printStackTrace(); // imprime el rastreo de la pila de la excepcion
			
			// obtiene la informacion del rastreo de la pila
			StackTraceElement [] elementosRastreo = e.getStackTrace();
			
			System.out.println("\nRastreo de la pilade getStackTrace:");
			System.out.println("Clase\t\t\t\t\t\t\t\tArchivo\t\t\t\t\tLinea\tMetodo");
			
			// itera a traves de elemntoRas para obtner la descripcion de la excepcion
			
			for (StackTraceElement elemento : elementosRastreo)
			{
				System.out.printf ("%s\t",elemento.getClassName());
				System.out.printf ("%s\t",elemento.getFileName());
				System.out.printf ("%s\t",elemento.getLineNumber());
				System.out.printf ("%s\n",elemento.getMethodName());
			}
		}
	
	}
	
	
	static void metodo1() throws Exception
	{
		metodo2();
	}
	
	static void metodo2() throws Exception
	{
		metodo3();
	}
	
	static void metodo3() throws Exception
	{
		throw new Exception("La excepcion se lanzo en metodo3");
	}
}
