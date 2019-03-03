package C2Evaluacion;

public class PerfilMedico 
{

	private String nom, apell,sexo;
	private int dia,mes,anio,edad,frecmax;
	private double altura, peso, mascorp,frecesp;
	
	public PerfilMedico (String nombre, String apei, String sex,int d, int m, int anio,double alt, double ps)
	{
		
		nom = nombre;
		apell = apei;
		sexo = sex;
		dia = d;
		mes = m;
		anio = anio;
		altura = alt;
		peso = ps;
		
	}
	
	public void Establecernom (String nombre)
	{
		
		nom = nombre;
		
	}
	
	public String Obtenernom()
	{
		
		return nom;
		
	}
	
	public void Establecerapell (String apei)
	{
		
		apell = apei;
		
	}
	
	public String Obtenerapell ()
	{
		
		return apell;
		
	}
	
	public void Establecersexo (String sex)
	{
		
		sexo = sex;
		
	}
	
	public String  Obtenersexo ()
	{
		
		return sexo;
		
	}
	
	public void Establecerdia (int d)
	{
		
		dia = d;
		
	}
	
	public int Obtenerdia ()
	{
		
		return dia;
		
	}
	
	public void Establcermes (int m)
	{
		
		mes = m;
		
	}
	
	public int Obtenermes ()
	{
		
		return mes;
		
	}
	
	public void Estableceranio (int anio)
	{
		
		anio = anio;
		
	}
	
	public int Obteneranio ()
	{
		
		return anio;
		
	}
	
	public void Estableceraltura (double alt)
	{
		altura = alt;
		
	}
	
	public double Obteneraltura ()
	{
		
		return altura;
		
	}
	
	public void Establecerpeso (double ps)
	{
		
		peso = ps;
		
	}
	
	public double Obtenerpeso ()
	{
		
		return peso;
		
	}
	
	public void Mostrarfecha ()
	{
		
		System.out.printf ("%d/%d/%d", Obtenerdia(), Obtenermes(), Obteneranio());
		
	}
	
	public int Obteneredad ()
	{
		edad = 2015 - anio;
		return edad;
	}
	
	public double Obtenermasacoroporal ()
	{
		altura=altura/100;
		mascorp = (peso)/(altura*altura);
		return mascorp;
	}
	
	public int Obtenerfrecmax ()
	{
		frecmax = 220 - edad;
		return frecmax;
	}
	
	public double Obtenerfrecespe ()
	{
		frecesp = frecmax * .5;
		return frecesp;
	}
	
	public double Obtenerfrecespe2 ()
	{
		frecesp = frecmax * .85;
		return frecesp;
	}
	public void MostrarBMI ()
	{
		System.out.println(" Valores de BMI\n Bajo peso: Menos de 18.5\n Normal: Entre 18.5 y 24.9\n Sobrepeso: Entre 25 y 29.9\n Obeso: 30 o mnis");
		System.out.println();
	}
}
