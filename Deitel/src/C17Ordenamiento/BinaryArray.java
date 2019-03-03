package C17Ordenamiento;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinaryArray
{
	private int[] data;
	private static final Random lb = new Random();
	
	public BinaryArray(int size)
	{
		data = new int [size];
		
		for (int i=0; i<size; i++)
			data[i] = 10 + lb.nextInt(90);

		Arrays.sort(data);
	}
	
	public int binarySearch(int element)
	{
		int low=0;
		int high = data.length - 1;
		int middle = (low + high + 1) / 2;
		int location=-1;
		int itero=0;
		
		do
		{
			println(remainingElements(low, high), false);
			
			for (int i=0; i<middle; i++)
			println("  ", false);
				
			
			println(" * ", true);
			
			if(element==data[middle])
				location=middle;

			else if (element < data[middle])
				high=middle-1;
			
			else 
				low = middle +1;
			
			itero++;
			
			middle = (low + high + 1) / 2;
				
		}while((low <= high) && (location == -1));
		
		println("Itere: "+itero+" veces", true);;
		return location;
	}
	
	public String remainingElements(int low, int high)
	{
		StringBuilder temporary = new StringBuilder();
		
		for (int i=0; i < low; i++)
			temporary.append("  ");
		
		for (int i=low; i<=high; i++)
			temporary.append(data[i]+" ");
		
		temporary.append("\n");
		return temporary.toString();
	}
	
	public String toString()
	{
		return remainingElements(0, data.length-1);
	}
	
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		int search, position;
		long inicio, end;
		
		BinaryArray b = new BinaryArray(15);
		
		println(b, true);
		
		println("Please enter an Integer value (-1 to quit): ", false);
		search=lc.nextInt();
		System.out.println();
		
		while(search!=-1)
		{
			
			inicio = System.currentTimeMillis();
			position = b.binarySearch(search);
			//end = System.currentTimeMillis();
			println("Tiempo tardado: "+ (System.currentTimeMillis()-inicio), true);
			
			
			if(position==-1)
				println("The Integer "+search+" was not found.\n", true);
			else
				println("The Integer "+search+" was found in position: "
						+position+".\n",true);
			
			println("Please enter an Integer value (-1 to quit): ", false);
			search=lc.nextInt();
			System.out.println();
		}
	}
	
	static void println(Object x, boolean salto)
	{
		if(salto)
			System.out.println(x);

		else
			System.out.print(x);
	}
}
