package HerenciaPolimorfismo;

public class CarroApp
{
	public static void main(String[] args)
	{
		CarroBMW c;
		c = new CarroBMW();
		
		System.out.println(c);
		c.apagar();
		c.encender();
		c.turbo();
		
	}
}
