package C9Polimorfismo;

public class EmpleadoBaseMasComision extends EmpleadoPorComision
{
	private double salarioBase;
	
	public EmpleadoBaseMasComision (String nom,String app,String nss,
			double ventas,double tarifa,double salario)
	{
		super (nom,app,nss,ventas,tarifa);
		establecerSalario(salario);
	}

	public void establecerSalario(double salario)
	{
		if (salario >= 0.0)
			salarioBase=salario;
		
		else
			throw new IllegalArgumentException(
					"El salario base debe ser >= 0.0");
	}
	
	public double obtenerSalario ()
	{
		return salarioBase;
	}
	
	@Override
	public double ingresos()
	{
		return obtenerSalario() + super.ingresos();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s; %s: $%,.2f",
				"con salario base",super.toString(),
				"salario base",obtenerSalario());
	}
}
