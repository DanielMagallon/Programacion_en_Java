package Reflection_Annotation;

public class Ordenador
{

	private String id;
	private String descripcion;
	private int potencia;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public int getPotencia()
	{
		return potencia;
	}

	public void setPotencia(int potencia)
	{
		this.potencia = potencia;
	}

	public Ordenador(String id, String descripcion, int potencia)
	{
		this.id = id;
		this.descripcion = descripcion;
		this.potencia = potencia;
	}

}