package C6Evaluacion;

import java.util.Scanner;

public class EliminacionDeDuplicados
{
	public static void main(String[] args)
	{
		int [] numero = new int [5];
		
		Scanner lc = new Scanner(System.in);
		
		for (int i=0; i<numero.length; i++)
		{
			do
			{
			System.out.print ((i+1) + ". Introduzca un numero: ");
			numero[i]=lc.nextInt();
			
				if (yaSeIntrodujo(i,numero))
				{
					System.out.println("\n Ya se introdujo ese numero\n");
				}
			}
			while(yaSeIntrodujo(i,numero));
		}
		
	}
	
	public static boolean yaSeIntrodujo(int i,int []v)
	{
		boolean equal=false;
		
		for(int j=0; j<i; j++)
		{
			if (v[j]==v[i])
			{
				equal=true;
				break;
			}
		}
	
		return equal;
	}
}
