package C7Evalucion;

public class CuentaAhorros
{
	static double tasaInteresAnual;
	private double saldoAhorros;
	static int taza=4;
	
	public CuentaAhorros (double saldo)
	{
		saldoAhorros=saldo;
	}
	
	public void establecerSaldo1 (double saldo)
	{
		saldoAhorros=saldo;
	}
	
	public double obtenerSaldo1 ()
	{
		return saldoAhorros;
	}
	
	public double calcularInteresMensual ()
	{
		double interesMensual = (saldoAhorros * tasaInteresAnual) / 12;
		
		return saldoAhorros += interesMensual;
	}
	
	public static void modificarTasaDeInteres (double tasa)
	{
		tasaInteresAnual=tasa;
	}
	
	public void mostrarNuevosSaldos ()
	{
		int n=1;
		
		System.out.printf ("  Mes:    Saldo nuevo($)-Tasa %d%%\n\n",taza);
		while (n<=12)
		{
			System.out.printf ("%4d",n);
			System.out.printf ("\t%15.2f\n\n",calcularInteresMensual());
			n++;
		}
	}
	
	
	public static void main(String[] args)
	{
		CuentaAhorros ahorrador1 = new CuentaAhorros(2000.00);
		CuentaAhorros.modificarTasaDeInteres(.04);
		
		System.out.print ("Empleado 1:\n");
		System.out.printf ("Saldo Inicial: $%.2f\n\n",ahorrador1.obtenerSaldo1());
		ahorrador1.mostrarNuevosSaldos();
		
		CuentaAhorros ahorrador2 = new CuentaAhorros(3000.00);
		
		System.out.print ("\nEmpleado 2:\n");
		System.out.printf ("Saldo Inicial: $%.2f\n\n",ahorrador2.obtenerSaldo1());
		ahorrador2.mostrarNuevosSaldos();
		
		CuentaAhorros.modificarTasaDeInteres(.05);
		CuentaAhorros.taza++;
		
		ahorrador1.saldoAhorros=2000;
		System.out.print ("Empleado 1:\n");
		System.out.printf ("Saldo Inicial: $%.2f\n\n",ahorrador1.obtenerSaldo1());
		ahorrador1.mostrarNuevosSaldos();
		
		ahorrador2.saldoAhorros=3000;
		System.out.print ("\nEmpleado 2:\n");
		System.out.printf ("Saldo Inicial: $%.2f\n\n",ahorrador2.obtenerSaldo1());
		ahorrador2.mostrarNuevosSaldos();
	}
}
