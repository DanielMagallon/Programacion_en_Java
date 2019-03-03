package HerenciaPolimorfismo;

public class Carro_herencia
{
	double peso;
	double altura;
	double ancho;
	double largo;
	int numeroPuertas;
	boolean encendido=false;
	String modelo;
	
	public Carro_herencia()
	{
		peso = 1000;
		altura = 1.90;
		ancho = 4;
	}
	
	public double obtenerPeso()
	{
		return peso;
	}
	
	public void encender()
	{
		encendido=true;
		System.out.println("El carro esta encendido");
	}
	
	public void apagar()
	{
		encendido=false;
		System.out.println("El carro esta apagado");
	}
	
	public void estado()
	{
		if (encendido==true)
			System.out.println("El carro esta encendido");
		
		else
			System.out.println("El carro esta apagado");
	}
	
	public void informacion()
	{
		System.out.println("Este es un carro comun y corriente");
	}
	
	@Override
	public String toString()
	{
		return String.format("Modelo:");
	}
}

