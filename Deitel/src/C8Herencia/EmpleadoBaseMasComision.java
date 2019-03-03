package C8Herencia;

public class EmpleadoBaseMasComision
{
	private String primerNombre;
	private String apellidoPaterno;
	private String numeroSeguroSocial;
	private double ventasBrutas; //  ventas semanales totales
	private double tarifaComision; // porcentaje por comision
	private double salarioBase; // salario base por semana
	
	// constructor con seis argumentos
	
	public EmpleadoBaseMasComision (String nombre,String apellido,String nss,
			 double ventas,double tarifa,double salario) 
	{
		// la llamada implicita al construcotor de Object ocurre aqui
		
				primerNombre=nombre;
				apellidoPaterno=apellido;
				numeroSeguroSocial=nss;
				establecerVentasBrutas (ventas);
				establecerTarifaComision (tarifa);
				establecerSalarioBase (salario);
	}
	
	public void establecerPrimerNombre (String nombre)
	{
		primerNombre=nombre; // deberia validar
	}
	
	public String obtenerPrimerNombre()
	{
		return primerNombre;
	}
	
	public void establecerApellidoPaterno (String apellido)
	{
		apellidoPaterno=apellido;
	}
	
	public String obtenerApellidoPaterno ()
	{
		return apellidoPaterno;
	}
	
	public void establecerNumeroSeguroSocial (String nss)
	{
		numeroSeguroSocial=nss;
	}
	
	public String obtenerNumeroSeguroSocial ()
	{
		return numeroSeguroSocial;
	}
	
	public void establecerVentasBrutas (double ventas) 
	{
		if (ventas >= 0.0)
			ventasBrutas=ventas;
		
		else
			throw new IllegalArgumentException(
					"Las ventas brutas deben ser mayor de 0");
	}
	
	public double obtenerVentasBrutas ()
	{
		return ventasBrutas;
	}
	
	public void establecerTarifaComision (double  tarifa) 
	{
		if (tarifa > 0.0 && tarifa < 1.0)
			tarifaComision=tarifa;
		
		else
			throw new IllegalArgumentException(
					"Las tarifa debe ser > 0.0 && < 1.0");
	}
	
	public double obtenerTarifaComision ()
	{
		return tarifaComision;
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
	
	public double ingresos ()
	{
		return salarioBase + (tarifaComision * ventasBrutas);
	}
	
	// devuelve la representacion String del objeto EmpleadoComision
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
