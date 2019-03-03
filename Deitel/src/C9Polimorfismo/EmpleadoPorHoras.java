package C9Polimorfismo;

public class EmpleadoPorHoras extends Empleado
{
	private double sueldo;
	private double horas;
	
	public EmpleadoPorHoras (String nombre,String apellido,String nss,
			double sueldoPorHoras,double horasTrabajadas)
	{
		super(nombre,apellido,nss);
		establecerSueldo(sueldoPorHoras);
		establecerHoras(horasTrabajadas);
	}
	
	public void establecerSueldo(double sueldoPorHoras)
	{
		if (sueldoPorHoras>=0.0)
			sueldo=sueldoPorHoras;
		
		else
			throw new IllegalArgumentException(
					"El sueldo por horas debe ser >=0.0");
	}
	
	public double obtenerSueldo()
	{
		return sueldo;
	}
	
	public void establecerHoras(double horasTrabajadas)
	{
		if ((horasTrabajadas>=0.0) && (horasTrabajadas<=168.00))
			horas=horasTrabajadas;
		
		else
			throw new IllegalArgumentException(
					"Las horas trabajadas deben ser >= 0.0 y <= 168.00");
	}

	public double obtenerHoras()
	{
		return horas;
	}
	
	@Override
	public double ingresos()
	{
		if (obtenerHoras()<=40)
			return obtenerSueldo() * obtenerHoras();
		
		else
			return 40 * obtenerSueldo() + (obtenerHoras()-40) * obtenerSueldo() * 1.5;
	}
	
	@Override
	public String toString()
	{
		return String.format("empleado por horas: %s\n%s: $%,.2f; %s: %,.2f",
				super.toString(),"sueldo por hora",obtenerSueldo(),
				"horas trabajadas",obtenerHoras());
	}
}
