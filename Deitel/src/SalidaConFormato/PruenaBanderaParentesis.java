package SalidaConFormato;

public class PruenaBanderaParentesis
{
	public static void main(String[] args)
	{
		System.out.printf ("%(d\n",50);
		System.out.printf ("%(d\n",-50);
		System.out.printf ("%(.1e\n",-50.0);
	}
}
