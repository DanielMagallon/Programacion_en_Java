package HerenciaPolimorfismo;

public class OperadorInstanceOf
{
	//@SuppressWarnings("null")
	public static void main(String[] args)
	{
		String s = new String ("Hola menso,esto solo es un ejemplo");
		
		if (s instanceof String)
		{
			System.out.println("Efectivamente s pertenece a la clase String");
		}
		
		Perro a = new Perro();
		
		a.Es_un();
		
		Gato b = new Gato();
		b.Es_un();
		
	}
}
class Animal {}

class AnimalMamifero extends Animal{}

class AnimalViviparo  extends Animal{}

class Perro extends AnimalMamifero{
	
	public void Es_un()
	{
		Perro toby = new Perro();
		
		if (toby instanceof Animal)
		{
			System.out.println("\nToby es un perro y tambien un animal\n"
					+ "Tamien toby es una instancia de la clase Animal");
		}
		
	}
}

class Carro {}

class Gato extends AnimalViviparo
{
	public void Es_un()
	{
		Gato felix = new Gato();
		
		if (felix instanceof AnimalViviparo)
		{
			System.out.println("\nFelix es un gato y tambien un animal\n"
					+ "Tamien Felix  es una instancia de la clase Animal/Animal Viviparo");
		}
		
		
	}
}