package HerenciaPolimorfismo;

public abstract class Persona
{
	String nombre;
	int edad;
	
	public Persona(String name,int age)
	{
		nombre=name;
		edad=age;
	}
	
	public abstract void verDatos();
}
