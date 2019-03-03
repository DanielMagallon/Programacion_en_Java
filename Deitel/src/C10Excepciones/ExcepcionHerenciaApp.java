package C10Excepciones;

public class ExcepcionHerenciaApp
{
	public static void main(String[] args)
	{ExcepcionB obj = new ExcepcionB();
		try
		{
			ExcepcionA ob = new ExcepcionA();
			ob.setNumero1(5);
			ob.setNumero2(10);
			
			obj.dividir();
			
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println(obj.dividir());
	}
}
