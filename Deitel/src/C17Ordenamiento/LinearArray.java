package C17Ordenamiento;

import java.awt.im.InputContext;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class LinearArray
{
	private int[] data;
	private static final Random generator = new Random();
	
	public LinearArray(int size)
	{
		data = new int [size];
		
		for (int i=0; i<size; i++)
			data[i] = 10 + generator.nextInt(90);
	}
	
	public int linearSearch(int searchKey)
	{
		for (int index = 0; index < data.length; index++)
			if(data[index] == searchKey)
				return index;
		
		return -1;
	}
	
	@Override
	public String toString()
	{
		return Arrays.toString(data);
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		LinearArray x = new LinearArray(10);
		println(x + "\n");
		
		int search,position;
		
		println("Please enter an integer value (-1 to quit)");
		search = input.nextInt();
		
		while(search != -1)
		{
			position = x.linearSearch(search);
			
			if(position == -1)
				println("The Integer "+search+" was not found.\n");
			
			else
				println("The Integer "+search+" was found in position "
						+position+".\n");
			
			println("Please enter an integer value (-1 to quit)");
			search = input.nextInt();
		}
	}

	static void println(String va)
	{
		System.out.println(va);
	}
}
