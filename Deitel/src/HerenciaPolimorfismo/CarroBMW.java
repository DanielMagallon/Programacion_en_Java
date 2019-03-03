package HerenciaPolimorfismo;

public class CarroBMW extends Carro_herencia
{
	public CarroBMW ()
	{
		modelo="BMW";
	}
	
	public void informacion()
	{
		System.out.printf ("Este es un carro %s del año 2015",modelo);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s",super.toString(),modelo);
	}
	
	public void turbo()
	{
		System.out.println("Acaba de viajar a 100 millas por hora¡");
	}
}
