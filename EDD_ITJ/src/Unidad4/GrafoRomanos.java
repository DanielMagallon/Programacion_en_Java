package Unidad4;

import java.util.Scanner;

public class GrafoRomanos
{
	public static int matrizEstados[][];
	public static String lenguaje[];
	
	private static int ind=0;
	
	static Scanner lc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		matrizEstados = new int[][]
			{
					{1,6,8,12,4},
					{2,5,5, 4,4},
					{3,4,4, 4,4},
					{4,4,4, 4,4},
					{4,4,4, 4,4},
					{4,4,4, 4,4},
					{7,4,4, 4,4},
					{2,4,4, 4,4},
					{1,6,9,11,11},
					{1,6,10, 4,4},
					{1,6, 4, 4,4},
					{1,6, 4, 4,4},
					{1,6, 13, 4,4},
					{1,6, 9, 4,4},
			};
			
		lenguaje = new String[]{"I","V","X","L","C"};
		
		/*
		 * int eestadoFinales[] = {1,2,3,5,6,7,8,9,10,11,12,13};
		 * evaluar(numero,tabla,leng,estFin)
		 */
		
		while(true)
			validar();
	}
	
	/*
	 * static boolean Evaluar(........)
	 * {
	 * 		
	 * }
	 */
	
	public static void validar()
	{
		String cad="";
		 
		while(cad.equals(""))
		{
			System.out.println("Numero romano: ");
			cad = lc.nextLine().trim();
		}
		
		ind = 0;
		int val;
		
		for(int i=0; i<cad.length(); i++)
		{
			val = getPosition(cad.charAt(i)+"");
			
			if(val==-1)
			{
				System.out.println("Cadena invalida (Error en el lenguaje)");
				return;
			}
			
			else
			{
				ind = matrizEstados[ind][val];
				
				if(ind == 4)
				{
					System.out.println("Numero no valido");
					return;
				}
			}
		}
		
		System.out.println("Numero valido");
	}
	
	private static int getPosition(String cad)
	{
		for(int i=0; i<lenguaje.length; i++)
		{
			if(lenguaje[i].equals(cad))
				return i;
		}
		return -1;
	}
}
