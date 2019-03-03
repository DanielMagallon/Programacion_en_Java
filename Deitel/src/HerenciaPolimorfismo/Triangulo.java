package HerenciaPolimorfismo;

public class Triangulo extends Figura
{

	private double b;
	private double h;
	
	public Triangulo(double b,double h)
	{
		super(b,h);
		
	}
	
	@Override
	public double area()
	{
		b=super.obtenerBase();
		h=super.obtenerAltura();
		
		return (b*h)/2;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s triangulo:",super.toString());
	}
}
