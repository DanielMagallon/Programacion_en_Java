package C7Evalucion;

public class HoraSegundosPrueba
{
	public static void main(String[] args)
	{
		HoraEnSegundos t1 = new HoraEnSegundos(); // 00:00:00
		HoraEnSegundos t2 = new HoraEnSegundos(2); // 02:00:00
		HoraEnSegundos t3 = new HoraEnSegundos(21,34); // 21:34:00 
		HoraEnSegundos t4 = new HoraEnSegundos(15,47,8); 
		HoraEnSegundos t5 = new HoraEnSegundos(3,47,8); 
		
		System.out.println("Se contruyo con:\n");
		System.out.println("t1: todos los argumentos predeterminados");
		System.out.printf("   %s\n",t1.aStringUniversal());
		System.out.printf("   %s\n",t1.toString());
		t1.mostrarSegundosTranscurridos();
		
		System.out.println("\nSe contruyo con:\n");
		System.out.println("t2: Se establecio hora, m y s predeterminados");
		System.out.printf("   %s\n",t2.aStringUniversal());
		System.out.printf("   %s\n",t2.toString());
		t2.mostrarSegundosTranscurridos();
		
		System.out.println("\nSe contruyo con:\n");
		System.out.println("t3: Se establecio hora y m, s predeterminados");
		System.out.printf("   %s\n",t3.aStringUniversal());
		System.out.printf("   %s\n",t3.toString());
		t3.mostrarSegundosTranscurridos();
		
		System.out.println("\nSe contruyo con:\n");
		System.out.println("t4: Se establecio hora,min y seg con valores PM (15:00 o 3:00 PM)");
		System.out.printf("   %s\n",t4.aStringUniversal());
		System.out.printf("   %s\n",t4.toString());
		t4.mostrarSegundosTranscurridos();
		
		System.out.println("\nSe contruyo con:\n");
		System.out.println("t5: Se establecio hora,min y seg con valores AM (3:00 AM)");
		System.out.printf("   %s\n",t5.aStringUniversal());
		System.out.printf("   %s\n",t5.toString());
		t5.mostrarSegundosTranscurridos();
		
		try 
		{
			HoraEnSegundos t6 = new HoraEnSegundos(27,74,99);
		}
		
		catch (IllegalArgumentException e)
		{
			System.out.printf ("\nExcepcion: IllegalArgumentException al inicializar t6 \n%s\n",e.getMessage());
		}
	}
}
