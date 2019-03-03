package C6Evaluacion;

import java.util.Random;

public class Arreglo4mensional
{
	public static void main(String[] args)
	{
		Random lb = new Random();
		
		int vCuatroD [][][][] = new int [4][4][4][4];
		
		for (int i=0; i<vCuatroD.length; i++)
		{
			for (int j=0; j<vCuatroD[i].length; j++)
			{
				for (int k=0; k<vCuatroD[i][j].length; k++)
				{
					for (int l=0; l<vCuatroD[i][j][k].length; l++)
						vCuatroD[i][j][k][l]=lb.nextInt(20) + 1;
				}
			}
		}
		
		for (int i=0; i<vCuatroD.length; i++)
		{
			for (int j=0; j<vCuatroD[i].length; j++)
			{
				for (int k=0; k<vCuatroD[i][j].length; k++)
				{
					for (int l=0; l<vCuatroD[i][j][k].length; l++)
					{
						System.out.printf ("%3d ",vCuatroD[i][j][k][l]);
					}
					System.out.println();
				}
				System.out.println();
			}
			System.out.println();
		}
		
		for (int i=0; i<vCuatroD.length; i++)
		{
			for (int j=0; j<vCuatroD[i].length; j++)
			{
				for (int k=0; k<vCuatroD[i][j].length; k++)
				{
					for (int l=0; l<vCuatroD[i][j][k].length; l++)
					{
						System.out.printf ("arreglo [%d][%d][%d][%d]=%2d ",i,j,k,l,vCuatroD[i][j][k][l]);
					}
					System.out.println();
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	
}
