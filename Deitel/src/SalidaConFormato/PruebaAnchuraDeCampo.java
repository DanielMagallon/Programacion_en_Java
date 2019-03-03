package SalidaConFormato;

public class PruebaAnchuraDeCampo
{
	public static void main(String[] args)
	{
		System.out.printf ("%4d\n",1);
		System.out.printf ("%4d\n",12);
		System.out.printf ("%4d\n",123);
		System.out.printf ("%4d\n",1234);
		System.out.printf ("%4d\n\n",12345); // datos demasiados extensos
		
		System.out.printf ("%4d\n",-1);
		System.out.printf ("%4d\n",-12);
		System.out.printf ("%4d\n",-123);
		System.out.printf ("%4d\n",-1234); // datos demasiados extensos
		System.out.printf ("%4d\n\n",-12345); // datos demasiados extensos
	}
}
