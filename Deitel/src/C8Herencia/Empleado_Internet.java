package C8Herencia;

public class Empleado_Internet
{
	String nombre;
	String cedula;
	int edad;
	boolean casado;
	double salario;
	
	public Empleado_Internet()
	{	
		
	}
	
	Empleado_Internet (String nombre,String cedula,int edad,boolean casado,
			double salario)
	{
		this.nombre=nombre;
		this.cedula=cedula;
		this.edad=edad;
		this.casado=casado;
		this.salario=salario;
	}
	
	String clasificacion ()
	{
		if (edad <= 21)
			return "Principante";
		
		else
			if (edad>=22 && edad>=35)
				return "Intermedio";
			
		else
			return "Senior";
	}
	
	void imprimirEmpleado ()
	{
		System.out.println(this.nombre);
		System.out.println(this.cedula);
		System.out.println(this.edad);
		
		if (casado)
		{
			System.out.println("Casado");
		}
		
		else
			System.out.println("Soltero");
		
		System.out.println(this.salario);
	}
	
	void aumentarSalario (double incremento)
	{
		salario *= (1+incremento);
	}
	
	
}
