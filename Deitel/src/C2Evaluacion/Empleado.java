package C2Evaluacion;

public class Empleado 
{

		private String nombre,apellpat;
		private double salario,salan;
		
	public Empleado (String nom, String appat, double salmen)
	{
		
		nombre = nom;
		apellpat = appat;
		salario = salmen;	
	}
	
	public void Establecernombre (String nom)
	{
		
		nombre = nom;
		
	}
	
	public String Obtenernombre ()
	{
		
		return nombre;
		
	}
	
	public void Establecerapellido (String appat)
	{
		
		apellpat = appat;
		
	}
	
	public String Obtenerapellido ()
	{
		
		return apellpat;
		
	}
	
	public void Establecersalario (double salmen)
	{
		
		salario = salmen;
		
	}

	public double Obtenersalario ()
	{
		
		return salario; 
		
	}
	
	public  double Obtenersalarioanual ()
	{
		
		salan=salario*12;
		return salan;
		
	}
	
	public  double Obtenersalarioanualinc ()
	{
		
		salan=salan+salan*.10; 
		return salan;
		
	}
}
