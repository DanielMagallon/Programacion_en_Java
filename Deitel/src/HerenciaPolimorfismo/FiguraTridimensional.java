package HerenciaPolimorfismo;

public abstract class FiguraTridimensional extends Figura
{

	private double profundo;
	
	public FiguraTridimensional(double base, double h,double profundidad)
	{
		super(base, h);
		profundo=profundidad;
	}

	public void establecerProfundidad(double profundo)
	{
		this.profundo=profundo;
	}
	
	public double obtenerProfundidad()
	{
		return profundo;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s / %s ",super.toString(),"Volumen del");
	}
	
	public abstract double volumen();
}
