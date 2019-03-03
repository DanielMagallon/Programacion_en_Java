package C8Herencia;

public class EmpleadoBaseMasComisionHerencia extends EmpleadosPorComision
{
	private double salarioBase;
	
	public EmpleadoBaseMasComisionHerencia (String nombre,String apellido,String nss,
			  double ventas,double tarifa,double salario) 
	 {
		// la llamada implicita al construcotor de la superClase emleadosporcomison
		super (nombre,apellido,nss,ventas,tarifa);
		
		establecerSalarioBase(salario);
	}
	
	public void establecerSalarioBase (double  salario)
	{
		if (salario >= 0.0)
			salarioBase=salario;
		
		else
			throw new IllegalArgumentException(
					"El salario debe ser >= 0.0");
	}
	
	public double obtenerSalarioBase ()
	{
		return salarioBase;
	}
	
	@Override
	public double ingresos()
	{
		// no esta permitido tarifa y ventas, son privados en la superclase // Yase peromiten
		return salarioBase + (tarifaComision * ventasBrutas);
	}
	
	@Override // indica que este metodo sobreescribe el metodo de una superclase
	public String toString ()
	{
		return String.format("%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f\n%s: %s",
				"empleado por comision",primerNombre,apellidoPaterno,
				"numero de seguro social",numeroSeguroSocial,
				"ventas brutas",ventasBrutas,
				"tarifa de comision",tarifaComision,
				"salario Base",salarioBase);
	}
}
