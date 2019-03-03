package C9Polimorfismo;

public class EmpleadoAsalariado extends Empleado
{
	private double salarioSemanal;
	
	public EmpleadoAsalariado(String nombre,String apellido,String nss,double salario)
	{
		super(nombre,apellido,nss);
		establecerSalarioSemanal(salario);
	}

	public void establecerSalarioSemanal(double salario)
	{
		if (salario>=0.0)
			salarioSemanal=salario;
		
		else
			throw new IllegalArgumentException(
					"El salario semanal debe ser >= 0.0");
	}
	
	public double obtenerSalarioSemanal()
	{
		return salarioSemanal;
	}
	
	// calcula los ingresos; sobrescribe el metodo abstracto ingresos de Empleado
	@Override
	public double ingresos()
	{
		return obtenerSalarioSemanal();
	}
	
	// devuelve la representacion String de un objeto empleadoAsalriado
	@Override
	public String toString()
	{
		return String.format("empleado asalariado: %s\n%s: $%,.2f",super.toString(),
				"salario semanal",obtenerSalarioSemanal());
	}
}
