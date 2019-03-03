package C8Herencia;

public class PruebaOperaciones extends OperacionPadre
{
	public static void main(String[] args)
	{
		Suma suma = new Suma();
		suma.cargar1();
		suma.cargar2();
		suma.sumar();
		System.out.printf ("El resultado de la suma es: %d\n\n",suma.mostrarResulatdo());
		
		Resta resta = new Resta();
		resta.cargar1();
		resta.cargar2();
		resta.restar();
		System.out.printf ("El resultado de la resta es: %d\n\n",resta.mostrarResulatdo());
		
		Multiplicar multi = new Multiplicar();
		multi.cargar1();
		multi.cargar2();
		multi.multiplicar();
		System.out.printf ("El resultado del producto  es: %d\n\n",multi.mostrarResulatdo());
		
		Dividir div = new Dividir();
		div.cargar1();
		div.cargar2();
		div.dividir();
		System.out.printf ("El resultado de la division es: %d\n\n",div.mostrarResulatdo());
	}
}
