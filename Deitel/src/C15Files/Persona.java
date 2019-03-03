 package C15Files;

import java.io.Serializable;


public class Persona implements Serializable
{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String nombre,apellido;
	private int edad = 0;
	
	public Persona(String name, String apell, int age)
	{
		nombre=name;
		apellido=apell;
		edad=age;
	}
	
	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}
	
	public String getApellido()
	{
		return apellido;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setEdad(int edad)
	{
		this.edad = edad;
	}
	
	public int getEdad()
	{
		return edad;
	}
}
