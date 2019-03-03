package C18Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordTypeCount
{
	public static void main(String[] args)
	{
		Map<String, Integer> myMap = new HashMap<>();
		
		createMap(myMap);
		showMap(myMap);
	}
	
	private static void createMap(Map<String, Integer> map)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a String: ");
		String input = in.nextLine();
		
		String[] tokens = input.split(" ");
		
		for (String token : tokens )
		{
			String word = token.toLowerCase();
			
			if(map.containsKey(word))
			{
				int count = map.get(word);
				map.put(word, count + 1);
			}
			else
				map.put(word, 1);
		}
	}
	
	private static void showMap(Map< String, Integer > map )
	{
		Set< String > keys = map.keySet(); // get keys
		
		TreeSet< String > sortedKeys = new TreeSet< String >( keys );
		
		System.out.println( "\nMap contains:\nKey\t\tValue" );
		
		for ( String key : sortedKeys )
			System.out.printf( "%-10s%10s\n", key,map.get( key ));
		
		System.out.printf("\nsize: %d\nisEmpty: %b\n",
				map.size(), map.isEmpty());
	}
}
