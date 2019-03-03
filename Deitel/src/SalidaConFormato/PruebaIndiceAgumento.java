package SalidaConFormato;

public class PruebaIndiceAgumento
{
	public static void main(String[] args)
	{
		System.out.printf ("Listas de parametros sin reordenar: %s %s %s %s\n",
				"primero","segundo","tercero","cuarto");
		
		System.out.printf ("Listas de parametros despues de reordenar: %4$s %3$s %2$s %1$s\n",
				"primero","segundo","tercero","cuarto");
	}
}
