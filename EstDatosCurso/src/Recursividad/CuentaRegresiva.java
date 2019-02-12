package Recursividad;

public class CuentaRegresiva
{
	public static void main(String[] args)
	{
		cuentaRegresiva(10);
	}
	
	static void cuentaRegresiva(int nFinal)
	{
		if (nFinal>=0)
		{
			try
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf ("Cuenta Regresiva: %d\n",nFinal);
			cuentaRegresiva(nFinal-1);
		}
	}
}
