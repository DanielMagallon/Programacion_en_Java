package C7ClasesObjetos;

public class PruebaEmpleadoStatic
{
	public static void main(String[] args)
	{
		// muestra que la cuenta es 0 antes de crear empleados
		System.out.printf("Empleados antes de instanciar: %d\n",EmpleadoStatic.obtenerCuenta());
		
		// crea dos empelados , la cuenta debe ser 2
		EmpleadoStatic e1 = new EmpleadoStatic("Susan","Baker");
		EmpleadoStatic e2 = new EmpleadoStatic("Bob","Blue");
		
		// muestra que la cuenta es 2 despues de crear dos empelados
		System.out.printf("\nEmpleados despues de instanciar: ");
		System.out.printf ("mediante e1.obtenerCuenta(): %d\n",e1.obtenerCuenta());
		System.out.printf ("mediante e2.obtenerCuenta(): %d\n",e2.obtenerCuenta());
		System.out.printf ("mediante EmpleadoStatic.obtenerCuenta(): %d\n",
				EmpleadoStatic.obtenerCuenta());
		
		// obtiene los nombres de le empleados
		System.out.printf ("\nEmpleado 1: %s %s\nEmpleado 2: %s %s\n\n",
				e1.obtenerNombre(),e1.obtenerApellido(),
				e2.obtenerNombre(),e2.obtenerApellido());
		
		// en este ejemplo solo hay una referencia a cada empleado,
		// por lo que las siguientes dos instrucciones indican que estos objetos 
		// son candidatos para la recoleccion de basura
		
		e1=null;
		e2=null;
	}
}
