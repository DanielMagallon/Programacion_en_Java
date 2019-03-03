package C10Excepciones;

public class ExcepcionesEncadenadas
{
	public static void main(String[] args)
	{

		try
		{
			metodo1();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void metodo1() throws Exception
	{
		try
		{
			metodo2();
		}
		catch (Exception e)
		{
			throw new Exception("La excepcion se lanzo en metodo1",e);
		}
	}
	
	static void metodo2() throws Exception
	{
		try
		{
			metodo3();
		}
		catch (Exception e)
		{
			throw new Exception("La excepcion se lanzo en metodo2",e);
		}
	}
	
	static void metodo3() throws Exception
	{
		throw new Exception("La excepcion se lanzo en metodo3");
	}
}
