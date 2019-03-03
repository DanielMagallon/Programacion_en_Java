package C8Herencia;

public class FacturaApp 
{
	public static void main(String[] args)
	{
		Factura_HijoPrecio f=new Factura_HijoPrecio();
		f.cliente=12345;
		f.setEuros(1000);
		f.imprimirFactura();
	}
}
