package C9Polimorfismo;

public abstract class Empleado 
{
	private String primerNombre;
	private String apellidoPaterno;
	private String numeroSeguroSocial;
	
	// constructor con 3 argumentos
	public Empleado (String nombre,String apellido,String nss)
	{
		primerNombre=nombre;
		apellidoPaterno=apellido;
		numeroSeguroSocial=nss;
	}
	
	public void establecerPrimerNombre (String nombre)
	{
		primerNombre=nombre;
	}
	
	public String obtenerNombre ()
	{
		return primerNombre;
	}
	
	public void establecerApellidoPaterno(String apellido)
	{
		apellidoPaterno=apellido;
	}
	
	public String obtenerApellidoPaterno()
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
	
	@Override
	public String toString ()
	{
		return String.format("%s %s\nnumero seguro social: %s",obtenerNombre(),obtenerApellidoPaterno(),
				obtenerNumeroSeguroSocial());
	}
	
	// metodo abstracto sobrescrito para las subclases concretas
	public abstract double ingresos(); // aqui no hay implemnetacion
	
	
}