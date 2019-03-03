package C8Herencia;

public class PruebaEmpleadoComision
{
	public static void main(String[] args)
	{
		// crea instancia de EmpleadoComision
		EmpleadosPorComision empleado = new EmpleadosPorComision(
				"Sue", "Jones","222-22-2222",10000,.06);
		
		// obtiene los datos del empleadoPorComision
		System.out.println(
				"Informacion del empleado obtenida por los metodos establecer: \n");
		
		System.out.printf ("%s %s\n","El primer nombre es",empleado.obtenerPrimerNombre());
		System.out.printf ("%s %s\n", "El apellido paterno es",empleado.obtenerApellidoPaterno());
		System.out.printf ("%s %s\n","El numero del seguro social es",empleado.obtenerNumeroSeguroSocial());
		System.out.printf ("%s %.2f\n","Las ventas brutas son",empleado.obtenerVentasBrutas());
		System.out.printf ("%s %.2f\n","La tarifa de comision es",empleado.obtenerTarifaComision());
		
		empleado.establecerVentasBrutas(500);
		empleado.establecerTarifaComision(.1);
		
		System.out.printf ("\n%s :\n\n%s\n","Informacion actualizada del empleado,"
				+ " obtenida mediante toString",empleado);
		
		System.out.println("\nCaptura de excepcion, donde tarifa es mayor que 1:");
		
		try
		{
		empleado.establecerVentasBrutas(500);
		empleado.establecerTarifaComision(2);
		}
		catch (IllegalArgumentException e)
		{
			System.out.printf ("Excepcion: IllegalArgumentException\n%s",e.getMessage());
		}
		//System.out.printf ("\n%s :\n\n%s\n","Informacion actualizada del empleado,"
			//	+ " obtenida mediante toString",empleado);
	}
	
}
