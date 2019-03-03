package C8Herencia;

public class Humano
{
	protected String nombre;
	protected String apellido;
	
	public Humano (String nombre,String apellido)
	{
		this.nombre=nombre;
		this.apellido=apellido;
	}
	
	public String nombreCompleto ()
	{
		return this.apellido + " " + this.nombre; 
	}
	
	public String identificacion ()
	{
		return this.nombreCompleto();
	}
}

class Ciudadano extends Humano 
{
	protected String documento;
	
	public Ciudadano (String nombre,String apellido,String documento)
	{
		super(nombre,apellido);
		this.documento=documento;
	}
	
	public String identificacion ()
	{
		return super.identificacion() + ", documento: " + this.documento;
	}
	
}

