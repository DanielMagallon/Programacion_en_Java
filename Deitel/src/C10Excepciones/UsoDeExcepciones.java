package C10Excepciones;

public class UsoDeExcepciones
{
	public static void main(String[] args)
	{
		try
		{
			lanzaExcepcion();
		}
		catch (Exception e)
		{
			System.err.println("La excepcion se manejo en main");
		}
		
		noLanzaExcepcion();
	}
	
	static void lanzaExcepcion () throws Exception
	{
		try // lanza una excepcion y la atraa de inmediato
		{
			System.out.println("Metodo lanzaExcepcion");
			throw new Exception(); // genera la excepcion
		}
		
		catch (Exception e)
		{
			System.err.println("La excepcion se manejo en el metodo lanzaExcepcion");
			throw e; // vuelve a laznar para procesar mas adelnate
			
			// no se llegaria al codigo que se coloque aqui, se producirian errores de compilacion
		}
		finally // se ejecuta sib importar lo que ocurra en oos bloques try,catch
		{
			System.err.println("Se ejecuto finally en lanzaExcepcion");
			// no se llegaria al codigo que se coloque aqui, se producirian errores de compilacion
		}
	}
	
	static void noLanzaExcepcion ()
	{
		try // el bloque try no lanza una excepion
		{
			System.out.println("Metodo noLanzaExcepcion");
		}
		
		catch(Exception e) // no se ejecuta
		{
			System.err.println(e);
		}
		finally // se ejecuta sib importar lo que ocurra en oos bloques try,catch
		{
			System.err.println("Se ejecuto finally en noLanzaExcepcion");
			// no se llegaria al codigo que se coloque aqui, se producirian errores de compilacion
		}
		
		System.out.println("Fin del metodo noLanzaExcepcion");
	}
}
