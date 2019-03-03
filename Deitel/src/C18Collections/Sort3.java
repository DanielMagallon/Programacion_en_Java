package C18Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import C7ClasesObjetos.HoraEnSegundos;

public class Sort3
{
	public static void main(String[] args)
	{
		List <HoraEnSegundos> list = new ArrayList<HoraEnSegundos>();
		
		list.add(new HoraEnSegundos(6,24,34));
		list.add( new HoraEnSegundos( 18, 14, 58 ));
		list.add( new HoraEnSegundos( 6, 05, 34 ));
		list.add( new HoraEnSegundos( 12, 14, 58 ));
		list.add( new HoraEnSegundos( 6, 24, 22 ));
		
		System.out.printf( "Unsorted array elements:\n%s\n",list);
		
		Collections.sort(list, new TimeComparator());
		
		System.out.printf( "Sorted list elements:\n%s\n", list );
	}
}
