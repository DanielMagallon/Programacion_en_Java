package C9Polimorfismo;

public class InterfazPorPagarApp
{
	public static void main(String[] args)
	{
		PorPagar[] objetosPorPagar = new PorPagar[4];
		
		objetosPorPagar[0] = new Factura("01234","asiento",2,375.00);
		objetosPorPagar[1] = new Factura("56789","llanta",4,79.95);
		
		objetosPorPagar[2] = new EmpleadoAsalariado_Implements
				("John","Smith","111-11-1111", 800.00);
		
		objetosPorPagar[3] = new EmpleadoAsalariado_Implements
				("Lisa","Barnes","888-88-8888", 1200.00);
		
		System.out.println(
				"Facturas y Empleados procesados en forma poliformica:\n");
		
		// procesa en forma generica cada elemento del arreglo 
		for (PorPagar porPagarActual : objetosPorPagar)
		{
			System.out.printf ("%s \n%s: $%,.2f\n\n",porPagarActual.toString(),
					"pago vencido",porPagarActual.obtenerMontoPago());
		}
	}
}
