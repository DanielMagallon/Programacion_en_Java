package C7ClasesObjetos;

public class PruebaEmpleado
{
	public static void main(String[] args)
	{
		Fecha nacimiento = new Fecha(2,31,1949);
		Fecha contratacion = new Fecha(3,12,1988);
		Empleado empleado = new Empleado("Bob","Blue",nacimiento,contratacion);
		
		System.out.println(empleado);
		
	}
}
