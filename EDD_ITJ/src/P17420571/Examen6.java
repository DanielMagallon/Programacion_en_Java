package P17420571;

public class Examen6
{
	/**
	 * Edgar Daniel Magallon Villanueva
	 */
	
	public String vectorCadenas[];

	public Integer vector1[] = {18,25,33,35,37,42,44,45};
	public Integer vector2[] = {17,19,23,33,36,39,43,48};
	public Integer vectorRes[] = new Integer[vector1.length+vector2.length];
	
	public Examen6()
	{
		vectorCadenas = new String[]{
					"Othoniel","Juan","Daniela","Fernanda","Gabriel",
					"Raul","Gerardo"
				};
	}
	
	
	public void ordenarNombres()
	{
		mostrar("Nombres desordenados: ",vectorCadenas);
		
		quickSort(0, vectorCadenas.length-1);
		
		mostrar("\nNombres ordenados: ",vectorCadenas);
		
	}
	
	
	private void quickSort(int ini, int fin)
	{
		int posPivote = (ini+fin)/2;
		String pivote = vectorCadenas[posPivote];
		int izq = ini; int der = fin;
		
		
		while(izq<=der)
		{
			while(vectorCadenas[izq].compareToIgnoreCase(pivote)<0)izq++;
			
			while(vectorCadenas[der].compareToIgnoreCase(pivote)>0) der--;
			
			
			if(izq<=der)
			{
				String temp = vectorCadenas[izq];
				vectorCadenas[izq] = vectorCadenas[der];
				vectorCadenas[der] = temp;
				
				izq++; der--;
			}
		}
		
		
		if(ini<der)
			quickSort(ini, der);
		
		if(izq<fin)
			quickSort(izq, fin);
	}
	
	public void ordenarVectores()
	{
		System.out.println("\nORDENAMIENTO DE LOS DOS VECTORES POR FUSION");
		mostrar("\nVector 1:", vector1);
		mostrar("\nVector 2:", vector2);
		
		fusion();
		mostrar("\nElementos ordenados: ", vectorRes);
	}
	
	private <T> void mostrar(String msg, T arr[])
	{
		System.out.println(msg);
		
		for(Object s : arr)
			System.out.print(s+" ");
		
		System.out.println();
	}
	
	private void fusion()
	{
		int pos1=0, pos2=0, posO=0, num1,num2;
		
		
		num1 = vector1[pos1++];
		num2 = vector2[pos2++];
		

		try
		{
			
			while(true)
			{
				System.out.println("Num1: "+num1);
				System.out.println("Num2: "+num2);
				if(num1<num2)
				{
					vectorRes[posO++] = num1;
//					if(pos1!=vector1.length)
					num1 = vector1[pos1++];
				}
				else{
					vectorRes[posO++] = num2;
//					if(pos2!=vector2.length)
					num2 = vector2[pos2++];
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException e){}

	}
	
	
	public static void main(String[] args)
	{
		Examen6 ex = new Examen6();
		
//		ex.ordenarNombres();
		ex.ordenarVectores();
	}
}

