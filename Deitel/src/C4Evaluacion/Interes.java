package C4Evaluacion;

public class Interes 
{
	public static void main(String[] args) 
	{
		double monto;
		double principal = 1000.0;
		int tasa; 
		
		System.out.printf ( "%s%25s%20s\n", "Anio", "Tasa ('%')", "Monto en deposito" );
		System.out.println();
		
		for (int anio = 1; anio <=10; anio++)
		{
			for (tasa = 5; tasa <=10; tasa++)
			{
				monto = principal * Math.pow(1.0 +(double)tasa/100,anio);
				
				System.out.printf ("%4d%20d %,20.2f\n",anio,tasa,monto);
			}
		}
	}
}

