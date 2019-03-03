package C7ClasesObjetos;

public class PruebaTiempo2
{
	public static void main(String[] args)
	{
		HoraEnSegundos t1 = new HoraEnSegundos(); // 00:00:00
		HoraEnSegundos t2 = new HoraEnSegundos(2); // 02:00:00
		HoraEnSegundos t3 = new HoraEnSegundos(21,34); // 21:34:00 
		HoraEnSegundos t4 = new HoraEnSegundos(12,25,42); // 12:25:42
		HoraEnSegundos t5 = new HoraEnSegundos(t4); // 12:25:42
		
		System.out.println("Se contruyo con:");
		System.out.println("t1: todos los argumentos predeterminados");
		System.out.printf("   %s\n",t1.aStringUniversal());
		System.out.printf("   %s\n",t1.toString());
		
		System.out.println("t2: se especifico hora,minuto y segundo predeterminados");
		System.out.printf("   %s\n",t2.aStringUniversal());
		System.out.printf("   %s\n",t2.toString());
		
		System.out.println("t3: se especifico hora y minuto,segundo predeterminados");
		System.out.printf("   %s\n",t3.aStringUniversal());
		System.out.printf("   %s\n",t3.toString());
		
		System.out.println("t4: se especificaron hora, minuto y segundo");
		System.out.printf("   %s\n",t4.aStringUniversal());
		System.out.printf("   %s\n",t4.toString());
		
		System.out.println("t5: se especifico el objeto Tiempo2 llamdo t4");
		System.out.printf("   %s\n",t5.aStringUniversal());
		System.out.printf("   %s\n",t5.toString());
		
		try 
		{
			HoraEnSegundos t6 = new HoraEnSegundos(27,74,99);
		}
		
		catch (IllegalArgumentException e)
		{
			System.out.printf ("\nExcepcion al inicializar t6: %s\n",e.getMessage());
		}
	}
}
