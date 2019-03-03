package C4Evaluacion;

public class Interes_enteros 
{
	public static void main(String[] args) 
	{
		int monto; // monto depositado al final de cada a�o
		int principal = 1000; // monto inicial antes del interes
		int tasa = 5; // tasa de interes
		
		// muestra los encabezados
		 System.out.printf ("%s%20s\n", "Anio", "Monto en deposito");
		 
		 // calcula el monto en deposito para cada uno de los diez a�os
		 
		 for (int anio = 1; anio <= 10; anio++)
		 {
			 // calcula el nuevo monto para el a�o especificado 
			 	monto = principal * (int)Math.pow( (1.0 + tasa/100),anio );
			 	
			 // muestra el a�o y el monto
			 	System.out.printf ("%4d%20d\n",anio,monto);
		 }
	}
}
