package HerenciaPolimorfismo;

public class Circulo extends Figura
{
	private double radio;
	
	public Circulo (double r)
	{
		super(r);
	}
	
	@Override
	public double area()
	{
		radio=super.obtenerLado_Radio_Cuadrado_Circulo();
		
		return (Math.PI * (radio*radio));
	}
	
	@Override
	public String toString()
	{
		return String.format("\n%s circulo:",super.toString());
	}
}
