package C8Herencia;

public class PruebaEmpleadoBaseHerencia
{
	public static void main(String[] args) 
	{
		EmpleadoBaseMasComisionHerencia empleado = new EmpleadoBaseMasComisionHerencia(
				"Bob","Lewis","333-33-3333",5000,.04,300);
		
		System.out.println(
				"Informacion del empleado obtenida por los metodos establecer: \n");
		
		System.out.printf ("%s %s\n","El primer nombre es",empleado.obtenerPrimerNombre());
		System.out.printf ("%s %s\n", "El apellido paterno es",empleado.obtenerApellidoPaterno());
		System.out.printf ("%s %s\n","El numero del seguro social es",empleado.obtenerNumeroSeguroSocial());
		System.out.printf ("%s %.2f\n","Las ventas brutas son",empleado.obtenerVentasBrutas());
		System.out.printf ("%s %.2f\n","La tarifa de comision es",empleado.obtenerTarifaComision());
		System.out.printf ("%s %.2f\n","El salario base es",empleado.obtenerSalarioBase());
		
		empleado.establecerSalarioBase(1000);
		
		System.out.printf ("\n%s :\n\n%s\n","Informacion actualizada del empleado,"
				+ " obtenida mediante toString",empleado.toString());
	}
}
