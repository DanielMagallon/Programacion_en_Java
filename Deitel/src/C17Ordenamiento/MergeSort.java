package C17Ordenamiento;

import java.util.Random;

public class MergeSort
{
	private int[] data;
	private static final Random lb = new Random();
	
	public MergeSort(int size)
	{
			data = new int[size];
			
			for (int i=0; i<size; i++)
				data[i]= 10 + lb.nextInt(90);
	}
	
	public void sort()
	{
		sortArray(0, data.length-1);
	}
	
	private void sortArray(int low, int high)
	{
		if( (high - low ) >=1 )
		{
			int middle1 = ( low + high ) / 2;
			int middle2 = middle1 + 1;
			
			System.out.println( "split: " + subarray( low, high ) );
			System.out.println( ""+ subarray( low, middle1 ) );
			System.out.println( ""+ subarray( middle2, high ) );
			System.out.println();
			
			sortArray(low, middle1);
			sortArray(middle2, high);
			
			merge (low, middle1, middle2, high);
		}
	}
	
	private void merge(int left, int middle1, int middle2, int right)
	{
		int leftIndex = left;
		int righIndex = middle2;
		int combinedIndex = left;
		int combined[] = new int [data.length];
		
		System.out.println( "merge: " + subarray( left, middle1 ) );
		System.out.println( ""+ subarray( middle2, right ) );
		
			while(leftIndex <= middle1 && righIndex <= right)
			{
				if ( data[ leftIndex ] <= data[ righIndex ] )
					combined[ combinedIndex++ ] = data[ leftIndex++ ];
				else
					combined[ combinedIndex++ ] = data[ righIndex++ ];
			} 
			
			if ( leftIndex == middle2 )// copy in rest of right array
			while ( righIndex <= right )
			combined[ combinedIndex++ ] = data[ righIndex++ ];
			
			else // right array is empty
			// copy in rest of left array
			while ( leftIndex <= middle1 )
			combined[ combinedIndex++ ] = data[ leftIndex++ ];
			
			for ( int i = left; i <= right; i++ )
				data[ i ] = combined[ i ];
			
			System.out.println( ""+ subarray( left, right ) );
			System.out.println();
	}
	
	public String subarray( int low, int high )
	{
		StringBuilder temporary = new StringBuilder();
		
		for ( int i = 0; i < low; i++ )
		temporary.append( "  " );

		for ( int i = low; i <= high; i++ )
		temporary.append( " "+ data[ i ] );
		
		return temporary.toString();
	} 
	
	public String toString()
	{
		return subarray( 0, data.length - 1 );
	} 
	
	
	public static void main(String[] args)
	{
		MergeSort merge = new MergeSort(10);
		
		System.out.println( "Unsorted:" + merge+ "\n" );
		merge.sort(); 
		
		System.out.println( "Sorted: " + merge );
	}
}
