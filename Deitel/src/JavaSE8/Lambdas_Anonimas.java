package JavaSE8;

public class Lambdas_Anonimas
{
	@FunctionalInterface
	interface Suma
	{
		public Integer sumarDosNumeros(Integer a, Integer b);
	}
	
	public static void main(String[] args)
	{
		//Thread hilo = new Thread(new Hilo());
		/*Thread hilo = new Thread(new Runnable() //Clase anonima
		{
			@Override
			public void run()
			{
				System.out.println("Hola otra vez..."); 
			}
		});*/ 
		
	    
		//hilo.start();
		
		/*Suma su = new Suma()
		{
			@Override
			public Integer sumarDosNumeros(Integer a, Integer b)
			{
				// TODO Auto-generated method stub
				return null;
			}
		};*/
		
		Suma suma = (a,b)  ->  a+b; // {return a+b;} <-- Esto esta implicito
		System.out.printf("La suma es: "+suma.sumarDosNumeros(10, 5));
	}
	
	private static void d()
	{
		
	}
	
	private static void bh()
	{
		
	}
}
