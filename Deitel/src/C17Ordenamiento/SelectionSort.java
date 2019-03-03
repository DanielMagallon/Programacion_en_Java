package C17Ordenamiento;

import java.util.Arrays;
import java.util.Random;

import myjava.ScannerRead;

public class SelectionSort
{
	private int[] data;
	private static final Random lb = new Random();
	
	public SelectionSort(int size)
	{
		data = new int [size];
		
		for (int i=0; i<size; i++)
			data[i] = 10 + lb.nextInt(90);
	}

	public void sort()
	{
		int smallest;
		
		for (int i=0; i<data.length; i++)
		{
			smallest=i;
			
			for (int index = i + 1; index<data.length; index++)
				if(data[index] < data[smallest])
					smallest=index;
			
			swap(i,smallest);
			printPass(i+1, smallest);
		}
	}
	
	public void swap(int first, int second)
	{
		int aux = data[first];
		data[first] = data[second];
		data[second] = aux;
		
	}
	
	public void printPass(int pass, int index)
	{
		System.out.print(String.format("after pass %2d: ", pass));
		
		for (int i=0; i<index; i++)
			System.out.print(data[i] + " ");
		
		System.out.print(data[index]+"* ");
		
		for ( int i = index + 1; i < data.length; i++ )
			 System.out.print( data[ i ] + " " );
			
		System.out.print( "\n " ); 
	
		for ( int j = 0; j < pass; j++ )
			System.out.print( "-- " );
			
		System.out.println( "\n" ); 
			
	}
	
	public String toString()
	{
		return Arrays.toString( data );
	}
	
	public static void main(String[] args)
	{
		SelectionSort sort = new SelectionSort(10);
		
		System.out.println( "Unsorted array:" );
		System.out.println( sort + "\n" ); 
		
		sort.sort(); 
		
		System.out.println( "Sorted array:" );
		System.out.println( sort );
	}
}
