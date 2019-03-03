package SalidaConFormato;

public class PruebaBanderaMenos
{
	public static void main(String[] args)
	{
		System.out.println("Columnas:");
		System.out.println("0123456789012345678901234567890123456789\n");
		System.out.printf ("%10s%10d%10c%10f\n\n","hola", 7, 'a', 1.23);
		System.out.printf (
				"%-10s%-10d%-10c%-10f\n\n","hola", 7, 'a', 1.23);
	}
}
