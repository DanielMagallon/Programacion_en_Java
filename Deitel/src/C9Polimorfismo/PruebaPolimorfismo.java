package C9Polimorfismo;

import C8Herencia.EmpleadoBaseMasComision2;
import C8Herencia.EmpleadoPorComision2;

public class PruebaPolimorfismo
{
	public static void main(String[] args)
	{
		//asigna la referencia a la superclase a una variable de la subclase
		EmpleadoPorComision2 miEmpleadoA = new EmpleadoPorComision2
				("Sue", "Jones","222-22-2222",1000,.06);
		
		//asigna la referencia a la subclase a una variable de la superclase
				EmpleadoBaseMasComision2 miEmpleadoB = new EmpleadoBaseMasComision2
						("Bob", "Lewis","333-33-3333",5000,.04,300);
				
		// invoca a toString en un objeto de la superclase, usando na variable de la
				//superclase
		System.out.printf ("%s %s:\n\n%s\n\n",
				"Llamada a toString de EmpleadoPorComision2 con referencia de superclase",
				"a un objeto de la superclase",miEmpleadoA.toString());
		
		// invoca a toString en un objeto de la subclase, usando na variable de la
		//subclase
		System.out.printf ("%s %s:\n\n%s\n\n",
		"Llamada a toString de EmpleadoBaseMasComision2 con referencia de subclase",
		"a un objeto de la subclase",miEmpleadoB.toString());
		
		// invoca a toString en un objeto de la subclase, usando na variable de la
				//superclase
		
		EmpleadoPorComision2 miEmpleadoA2 = miEmpleadoB;
		
		System.out.printf ("%s %s:\n\n%s\n\n",
				"Llamada a toString de EmpleadoBaseMasComision2 con referencia de superclase",
				"a un objeto de la subclase",miEmpleadoA2.toString());
	}
}
