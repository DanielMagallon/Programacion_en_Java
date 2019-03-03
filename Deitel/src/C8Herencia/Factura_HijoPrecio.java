package C8Herencia;

public class Factura_HijoPrecio extends Precio
{
	int cliente;
	final String emisor="ALMACENES ACME S.A";
	
	void imprimirFactura ()
	{
		System.out.println("");
		System.out.println("Emisor: " + emisor);
		System.out.println("------------------");
		System.out.println("Cliente: " + cliente);
		System.out.printf ("Total: %d euros",euros);
	}
}
