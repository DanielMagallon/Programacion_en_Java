package C9Polimorfismo;

public class EmpleadoAsalariado_Implements extends Empleado_Implements
{
private double salarioSemanal;
	
	public EmpleadoAsalariado_Implements(String nombre,String apellido,String nss,double salario)
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
	
	// calcula los ingresos; implementa el metodo de la interfaz PPagar
	// que era absatratcto en la superClase Emeplado_Imple..
	
	@Override
	public double obtenerMontoPago()
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
