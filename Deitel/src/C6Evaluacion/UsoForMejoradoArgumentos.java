package C6Evaluacion;

public class UsoForMejoradoArgumentos
{
	public static void main(String[] args)
	{
		int cont=0;
		
		 for (int i=0; i<args.length; i++)
			 cont++;
		 
		 //System.out.println(cont);
		 
		 double total=0;
		 
		double [] tamanoArreglo = new double [cont];
		 
		 for (int argumento=0;argumento<tamanoArreglo.length; argumento++)
		 {
				 tamanoArreglo [argumento] = Double.parseDouble(args[argumento]);
				 total += tamanoArreglo[argumento];
		 }
		 
		 for (double argumento : tamanoArreglo)
			 		System.out.printf ("%5.2f\n",argumento);
		 
		 
		 System.out.printf ("\nEl total de la suma de los elementos de la linea de comandos es: %.2f",total);
	}
}
