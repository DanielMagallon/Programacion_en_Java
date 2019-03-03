package HerenciaPolimorfismo;

public class Cubo extends FiguraTridimensional
{

	private double volumen;
	private double area;
	
	public Cubo(double base, double h,double prof)
	{
		super(base, h, prof);
		
	}

	@Override
	public double volumen()
	{
		volumen=super.obtenerLado_Radio_Cuadrado_Circulo();
		
		return(Math.pow(volumen,3));
	}

	@Override
	public double area()
	{
		area=super.obtenerLado_Radio_Cuadrado_Circulo();
		
		return (6*(area*area));
	}
	
	@Override
	public String toString()
	{
		return String.format("%s cubo",super.toString());
	}
}
