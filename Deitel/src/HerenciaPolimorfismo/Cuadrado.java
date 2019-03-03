package HerenciaPolimorfismo;

public class Cuadrado extends Figura
{
	private double lado;
	
	public Cuadrado (double l)
	{
		super(l);
	}
	
	@Override
	public double area()
	{
		lado=super.obtenerLado_Radio_Cuadrado_Circulo();
		
		return (lado*lado);
	}
	
	@Override
	public String toString()
	{
		return String.format("\n%s cuadrado:",super.toString());
	}
}
