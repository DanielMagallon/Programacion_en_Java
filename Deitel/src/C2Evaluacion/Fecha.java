package C2Evaluacion;

public class Fecha 
{

	private int dia, mes,anio;
	
	public Fecha (int d, int m, int anio)
	{
		
		dia=d;
		mes=m;
		this.anio=anio;
	}
	
	public void Establecerdia (int d)
	{
		
		if (d>=1 && d<=31)
				dia=d;
		
	}
	
	public void Establecermes (int m)
	{
		if (m>=1 && m<=12)
		mes=m;
		
	}
	
	public void Estableceranio (int anio)
	{
		if (anio>=1920 && anio<=2015)
		this.anio=anio;
		
	}
	
	public int Obtenerdia()
	{
		
		return dia;
		
	}
	
	public int Obtenermes ()
	{
		
		return mes;
		
	}
	
	public int Obteneranio ()
	{
		
		return anio;
		
	}
	
	public void Mostrarfecha ()
	{
		
		System.out.printf ("%d/%d/%d", Obtenerdia(),Obtenermes(),Obteneranio());
		
	}
	
}
