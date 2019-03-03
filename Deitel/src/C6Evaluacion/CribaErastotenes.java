package C6Evaluacion;

public class CribaErastotenes
{
	public static void main(String[] args)
	{
		boolean [] arregloPrimo = new boolean [1000];
		
		for (int i=0; i<arregloPrimo.length; i++)
			arregloPrimo[i]=true;
		
		int cont=1;
		
		//for (int i=0; i<6; i++)
			//System.out.println(arregloPrimo[i]);;
		
		for (int indice=0; indice<arregloPrimo.length; indice++)
		{
			for (int n=2; n<indice; n++)
			{
			if (indice%n==0)
			{
				arregloPrimo[indice]=false;
			}
			}
		}
		
		System.out.println("\nNumero primos de 2 al 999\n");
		
		for (int i=2; i<arregloPrimo.length; i++)
		{
			if (arregloPrimo[i]==true)
			{
				System.out.printf ("%5d ",i);
				cont++;
				
				if (cont==10)
				{
					System.out.println();
					cont=1;
				}
				
			}
		
		}
	}
}
