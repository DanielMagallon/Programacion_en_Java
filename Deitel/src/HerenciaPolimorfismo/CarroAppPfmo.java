package HerenciaPolimorfismo;

public class CarroAppPfmo
{
	public static void main(String[] args)
	{
		Carro_herencia c;
		c = new CarroBMW();
		
		System.out.println("Polimorfismo usando la clase CarroBMW: ");
		c.informacion();
		
		Carro_herencia car = new Carro_herencia(); 
		System.out.println("\n\nPolimorfismo usando la clase Carro_herencia: ");
		car.informacion();
	}
}
