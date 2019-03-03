package C7Evalucion;

public class ClaseRectangulo
{
	private static double longitud=1;
	private static double anchura=1;
	
	public  static boolean establecerLongitud (double altura) 
	{
		boolean exc=true;
		
		if (altura>=0.0 && altura <= 20.0)
			longitud=altura;
		
		else
		{
			exc=false;
			throw new IllegalArgumentException(
					"La longitud debe ser mayor 0.0 y menor que 20.0\n\n");
		}
		
		return exc;
	}
	
	public static double obtenerLongitud ()
	{
		return longitud;
	}
	
	public  static boolean establecerAnchura (double base) 
	{
		boolean exc=true;
		
		if (base>0.0 && base < 20.0)
			anchura=base;
		
		else
		{
			exc=false;
			throw new IllegalArgumentException(
					"La anchura debe ser mayor 0.0 y menor que 20.0\n\n");
		}
		
		return exc;
	}
	
	public static double obtenerAnchura ()
	{
		return anchura;
	}
	
	private double determinarPerimetro ()
	{
		
		return (anchura*2)+(longitud*2);
	}
	
	private double determinarArea ()
	{
		return anchura*longitud;
	}
	
	public String toString ()
	{
		return String.format("Perimetro del rectangulo: %.2f"
				+ "\nArea del rectangulo: %.2f",determinarPerimetro(),determinarArea());
	}
}
