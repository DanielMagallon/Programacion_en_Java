package HelpClass;

import java.util.Random;
import java.util.Scanner;

public class Bidimensional
{
	int vec[][]=new int [5][5];
	Scanner entrada=new Scanner(System.in);
	Random obr=new Random();
	int num, b, i, j;
	
	public void Llenar()
	{
		for(int i=0; i<vec.length; i++)
		{
			for(int j=0; j<vec[i].length; j++)
			{
				vec[i][j]=obr.nextInt(100);
			}
		}
	}
	
	public void Mostrar()
	{
		for(int i=0; i<vec.length; i++)
		{
			for(int j=0; j<vec[i].length; j++)
			{
				System.out.print(vec[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public void Encontrar()
	{
		System.out.print("\n\nIntroduce el numero a buscar: ");
		num=entrada.nextInt();
		for(i=0; i<vec.length; i++)
			for(j=0; j<vec[i].length; j++)
				if(vec[i][j]==num)
					b=1;
		if(b==1)
			System.out.printf("El numero se encuentra en la posicion [%d][%d]", i, j);
		else
			System.out.println("No esta");
	}
	
	public static void main(String[] args)
	{
		Bidimensional b=new Bidimensional();
		b.Llenar();
		b.Mostrar();
		b.Encontrar();
	}
}
