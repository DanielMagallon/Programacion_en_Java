package C8Herencia;

// La clase empleadosPorComison representa a un empleadoque recibe un porcentaje de las ventas brutas


public class EmpleadosPorComision extends Object
{
	protected String primerNombre;
	protected String apellidoPaterno;
	protected String numeroSeguroSocial;
	protected double ventasBrutas; //  ventas semanales totales
	protected double tarifaComision; // porcentaje por comision
	
	public EmpleadosPorComision (String nombre,String apellido,String nss,
								 double ventas,double tarifa)					 
	{
		// la llamada implicita al construcotor de Object ocurre aqui
		
		primerNombre=nombre;
		apellidoPaterno=apellido;
		numeroSeguroSocial=nss;
		establecerVentasBrutas (ventas);
		establecerTarifaComision (tarifa);
		
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
	
	// calcula los ingresos
	public double ingresos ()
	{
		return tarifaComision * ventasBrutas;
	}
	
	
	// devuelve la representacion String del objeto EmpleadoComision
	@Override // indica que este metodo sobreescribe el metodo de una superclase
	public String toString ()
	{
		return String.format("%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f",
				"empleado por comision",primerNombre,apellidoPaterno,
				"numero de seguro social",numeroSeguroSocial,
				"ventas brutas",ventasBrutas,
				"tarifa de comision",tarifaComision);
	}
}
