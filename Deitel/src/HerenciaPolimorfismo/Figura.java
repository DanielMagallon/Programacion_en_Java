package HerenciaPolimorfismo;

public abstract class Figura
{
	private double ancho;
	private double alto;
	private double lado_radio;
	
	public Figura(double lado)
	{
		System.out.println("Llamada al cons");
		this.lado_radio=lado;
	}
	
	public Figura(double base,double h)
	{
		ancho=base;
		alto=h;
	}
	
	public void establecerLado_Radio_Cuadrado_Circulo(double lado)
	{
		this.lado_radio=lado;
	}
	
	public double obtenerLado_Radio_Cuadrado_Circulo()
	{
		return lado_radio;
	}
	
	public void establecerBase(double base)
	{
		ancho=base;
	}
	
	public double obtenerBase()
	{
		return ancho;
	}
	
	public void establecerAltura(double altura)
	{
		alto=altura;
	}
	
	public double obtenerAltura()
	{
		return alto;
	}
	
	@Override
	public String toString()
	{
		return String.format("Area del");
	}
	
	public abstract double area();
}
