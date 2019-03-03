package C9Polimorfismo;

public class EmpleadoPorComision extends Empleado
{
	private double ventasBrutas;
	private double tarifaComision;
	
	public EmpleadoPorComision (String nombre,String app,String nss,
			double ventas,double tarifa)
	{
		super(nombre,app,nss);
		establecerVentas(ventas);
		establecerTarifa(tarifa);
	}

	public void establecerTarifa(double tarifa)
	{
		if (tarifa>0.0 && tarifa < 1.0)
			tarifaComision=tarifa;
		
		else
			throw new IllegalArgumentException(
					"La tarifa de comision debe ser > 0.0 y < 1.0");
	}
	
	public double obtnerTarifa()
	{
		return tarifaComision;
	}

	public void establecerVentas(double ventas)
	{
		if (ventas>=0.0)
			ventasBrutas=ventas;
		
		else
			throw new IllegalArgumentException(
					"Las ventas deben ser >= 0.0");
	}
	
	public double obtnerVentas()
	{
		return ventasBrutas;
	}
	
	@Override
	public double ingresos ()
	{
		return obtnerTarifa() * obtnerVentas();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s: %s\n%s: $%,.2f; %s: %.2f",
				"empleado por comision",super.toString(),
				"ventas brutas",obtnerVentas(),
				"tarifa de comision",obtnerTarifa());
	}
}
