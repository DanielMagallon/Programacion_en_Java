package C9Polimorfismo;

public class Factura implements PorPagar
{
	private String numeroPieza;
	private String descripcionPieza;
	private int cantidad;
	private double precioPorArticulo;
	
	public Factura(String pieza,String descripcion,int cuenta,
			double precio)
		{
			numeroPieza=pieza;
			descripcionPieza=descripcion;
			establecerCantidad(cuenta);
			establecerPrecioPorArticulo(precio);
		}

	public void establecerNumeroPieza(String pieza)
	{
		numeroPieza=pieza;
	}
	
	public String obtenerNumeroPieza()
	{
		return numeroPieza;
	}
	
	public void establecerDescripcionPieza(String descripcion)
	{
		descripcionPieza=descripcion;
	}
	
	public String obtenerDescripcionPieza()
	{
		return descripcionPieza;
	}
	
	public void establecerCantidad(int cuenta)
	{
		if (cuenta >= 0)
			cantidad=cuenta;   
			
		else
			throw new IllegalArgumentException("Cantidad debe ser >= 0");
	}
	
	public int obtenerCantidad()
	{
		return cantidad;
	}
	
	public void establecerPrecioPorArticulo(double precio)
	{
		if (precio>= 0.0)
			precioPorArticulo=precio;
		
		else
			throw new IllegalArgumentException("El precio por Articulo debe ser >= 0.0");
	}

	public double obtnerPrecioPorArticulo()
	{
		return  precioPorArticulo;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s: \n%s: %s (%s) \n%s: %d \n%s: $%,.2f",
				"factura","numero de pieza",obtenerNumeroPieza(),obtenerDescripcionPieza(),
				"cantidad",obtenerCantidad(),"precio por articulo",obtnerPrecioPorArticulo());
	}
	
	@Override
	public double obtenerMontoPago()
	{
		return obtenerCantidad()*obtnerPrecioPorArticulo();
	}
}
