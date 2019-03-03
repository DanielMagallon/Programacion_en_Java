package C2Evaluacion;

public class FrecuenciasCardiacas 
{

	private String nom, apell;
	private int dia, mes, anio,edad,frcrmax;
	private double  fresp;
	public FrecuenciasCardiacas (String nombre,String apei, int diaa, int mess, int anio)
	{
		
		nom = nombre;
		apell = apei;
		dia = diaa;
		mes = mess;
		anio = anio;
		
	}
	
	public void Establecernombre (String nombre)
	{
		
		nom = nombre;
		
	}
	
	public void Establecerapei (String apei)
	{
		
		apell = apei;
		
	}
	
	public void Establecerdia (int diaa)
	{
		if (diaa>=1 && diaa<=31)
		dia = diaa;
		
	}
	
	public void Establecermes (int mess)
	{
		if (mess>=1 && mess<=12)
		mes = mess;
		
	}
	
	public void Estableceranio (int anio)
	{
		
		anio = anio;
		
	}
	
	public String Obtenernombre ()
	{
		
		return nom;
		
	}
	
	public String Obtenerapellido()
	{
		
		return apell;
		
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
		
		System.out.printf("%d/%d/%d", Obtenerdia(),Obtenermes(),Obteneranio());
		
	}
	
	public int Obteneredad ()
	{
		
		edad = 2015- anio ;
		return edad;
		
	}
	
	public int Obtenerfrecuenciacmx ()
	{
		
		frcrmax = 220 - edad;
		return frcrmax;
		
	}
	
	public double Obtnerfrecesperada ()
	{
		
		fresp = frcrmax * .5;
		return fresp;
		
	}
	
	public double Obtnerfrecesperada2 ()
	{
		
		fresp = frcrmax * .85;
		return fresp;
		
	}
	
	public void MostarBMI ()
	{
		System.out.println(" Valores de BMI\n Bajo peso: Menos de 18.5\n Normal: Entre 18.5 y 24.9\n Sobrepeso: Entre 25 y 29.9\n Obeso: 30 o mnis");
		System.out.println();
	}
}
