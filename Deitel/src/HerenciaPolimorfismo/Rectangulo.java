package HerenciaPolimorfismo;

public class Rectangulo extends Figura
{
	private double base;
	private double altura;
	
	public Rectangulo (double b,double h)
	{
		super(b,h);
	}
	
	@Override
	public double area()
	{
		base=super.obtenerBase();
		altura=super.obtenerAltura();
		
		return (base*altura);
	}
	
	@Override
	public String toString()
	{
		return String.format("\n%s rectangulo:",super.toString());
	}
}
