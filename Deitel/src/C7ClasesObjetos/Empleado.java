package C7ClasesObjetos;

public class Empleado
{
	private String primerNombre;
	private String apellidoPaterno;
	private Fecha fechaNacimiento;
	private Fecha fechaContratacion;
	
	// consructor para inicializar nombre,fecha de nac, y fecha de contratacion
	public Empleado (String nombre,String apellido,Fecha fechaDeNacimiento,Fecha fechaDeContratacion)
	{
		primerNombre=nombre;
		apellidoPaterno=apellido;
		fechaNacimiento=fechaDeNacimiento;
		fechaContratacion=fechaDeContratacion;
	}
	
	// convierte Empleado a formato String 
	public String toString ()
	{
		return String.format("%s, %s Contratado: %s Cumpleanios: %s",apellidoPaterno,primerNombre,
				fechaContratacion,fechaNacimiento);
	}
}
