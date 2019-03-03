package C9Polimorfismo;

public class PruebaSistemaNomina
{
	public static void main(String[] args)
	{
		EmpleadoAsalariado empleadoAsalariado = new 
				EmpleadoAsalariado("John","Smith","111-11-1111",800.0);
		
		EmpleadoPorHoras empleadoPorHoras = new
				EmpleadoPorHoras("Karen","Price","222-22-2222",16.75,40);
		
		EmpleadoPorComision empleadoPComision = new
				EmpleadoPorComision("Sue","Jones","333-33-3333",10000,.06);
		
		EmpleadoBaseMasComision empleadoBaseComision = new 
				EmpleadoBaseMasComision("Bob","Lewis","444-44-4444",5000,.04,300);
		
		System.out.println("Empleados procesados por separado:\n");
		
		System.out.printf("%s\n%s: $%,.2f\n\n",
				empleadoAsalariado,"ingresos",empleadoAsalariado.ingresos());
		
		System.out.printf("%s\n%s: $%,.2f\n\n",
				empleadoPorHoras,"ingresos",empleadoPorHoras.ingresos());
		
		System.out.printf("%s\n%s: $%,.2f\n\n",
				empleadoPComision,"ingresos",empleadoPComision.ingresos());
		
		System.out.printf("%s\n%s: $%,.2f\n\n",
				empleadoBaseComision,"ingresos",empleadoBaseComision.ingresos());
		
		Empleado[]empleados = new Empleado[4];
		
		empleados[0]=empleadoAsalariado;
		empleados[1]=empleadoPorHoras;
		empleados[2]=empleadoPComision;
		empleados[3]=empleadoBaseComision;
		
		System.out.println("Empleados procesados en forma polimorfica:\n");
		
		// procesa en forma generica a cada elemneto del arreglo empleados
		for (Empleado empleadoActual : empleados)
		{
			System.out.println(empleadoActual);
			
			// determina si el elemnto es un empeladoBasemasComision
			if (empleadoActual instanceof EmpleadoBaseMasComision)
			{
				// conversion descendente a la refrencia de Empleado
				// a una referencia de empleadoBaseMasComison
				
				EmpleadoBaseMasComision empleado = 
						(EmpleadoBaseMasComision) empleadoActual;
				
				empleado.establecerSalario(1.10 * empleado.obtenerSalario());
				
				System.out.printf ("el nuevo salario base con 10%% de aumento es : $%,.2f\n",
						empleado.obtenerSalario());
			}
			
			System.out.printf ("ingresos  $%,.2f\n\n",empleadoActual.ingresos());
		}
		
		// obtiene  el nombre del tipo de cada objeto en el arreglo de empleados
		for (int j=0; j<empleados.length; j++)
		{
			System.out.printf ("El empleado %d es un %s\n",j,
					empleados[j].getClass().getName());
		}
		
	}
}
