package C3Evaluacion;

public class SalidatabularN 
{
	public static void main(String[] args) 
		{
			int cont=1;
		
			System.out.println ("N\t  10*N\t  100*N\t  1000*N");
			System.out.println();
			
			while (cont<=5)
				{
					System.out.printf ("%d\t  %d\t  %d\t  %d\t\n",cont, cont*10,cont*100,cont*1000);
					cont++;
				}
		}
}
