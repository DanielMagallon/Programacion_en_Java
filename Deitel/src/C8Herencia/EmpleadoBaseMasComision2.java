package C8Herencia;

public class EmpleadoBaseMasComision2 extends EmpleadoPorComision2
{
	private double salarioBase;
	
	public EmpleadoBaseMasComision2(String nombre,String apellido,String nss,
			double ventas,double tarifa,double salario)
	{
		super (nombre,apellido,nss,ventas,tarifa);
		establecerSalarioBase(salario);
		
	}
	
	public void establecerSalarioBase (double salario)
	{
		if (salario>=0.0)
		{
			salarioBase=salario;
		}
		
		else
		{
			throw new IllegalArgumentException(
					"El salario base debe ser >= 0.0");
		}
	}
	
	public double obtenerSalrioBase ()
	{
		return salarioBase;
	}
	
	@Override
	public double ingresos()
	{
		return obtenerSalrioBase() + super.ingresos();
	}
	
	@Override
	public String toString ()
	{
		return String.format("%s %s\n%s: %.2f","con sueldo base",super.toString(),"sueldo base",
				obtenerSalrioBase());
	}
}
