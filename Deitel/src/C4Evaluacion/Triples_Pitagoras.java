package C4Evaluacion;

public class Triples_Pitagoras
{
	
	public static int Tamano=500;
	
	public static void main(String[] args) 
	{
		
		System.out.printf ("%13s%15s%18s\n", " Cateto a", " Cateto b", " Hipotenusa");
		
		for (int catetoa=1; catetoa<=499;)
		{
			for (int catetob=2; catetob<=500; catetob++ )
			{
				System.out.printf ("%8d %15d%20.4f\n",catetoa,catetob,Math.sqrt((Math.pow(catetoa,2) + (Math.pow(catetob,2)))));
				catetoa++;
			}
		}
		
		System.out.println("\n");
		
		System.out.print("\nEste programa prueba e imprime todas las ternas");
		System.out.printf(" pitagoricas para numeros no mayores que %d ", Tamano);
		System.out.print(" mediante la fuerza bruta.\n");

		for ( int i = 1; i <= Tamano; i++ )
		for ( int j = 1; j <= Tamano; j++ )
		for ( int k = 1; k <= Tamano; k++ )
		{       
		if ( i*i == j*j + k*k )
		System.out.printf("%3d\t%3d\t%3d\n", i, j, k);
		}      

		} 
		
}
