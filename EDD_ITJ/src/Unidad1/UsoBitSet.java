package Unidad1;

import java.util.BitSet;
import java.util.StringTokenizer;

//..../sites/view/estdatjiq
public class UsoBitSet 
{
	public static void main(String[] args) 
	{
		BitSet b = new BitSet(8); // Representar el 25
		//16   8   4   2   1
		
//25-->   1	   1   0   0   1 (binario)
//8--->   0    1   0   0   0
		//------------------
//and     0    1   0   0   0
//or   // 1    1   0   0   1		
		//
	
	  /**32   16   8   4   2   1*/
//        1    0   0   0   1   1   -> 35 
//        1    1   0   1   1   0   -> 54
//and =   1    0   0   0   1   0    -> 34
//or =    1    1   0   1   1   1    -> 55

		BitSet b35 = new BitSet();
		
		b35.set(0);
		b35.set(1);
		b35.set(5);
		b35.set(6);
		
		BitSet b54 = new BitSet();
		
		b54.set(1);
		b54.set(2);
		b54.set(4);
		b54.set(5);
		
		b35.or(b54);
		System.out.println("B35 or b54: "+b35);
		
		b.set(1);
		b.set(2);
		b.set(5);
		System.out.println(b);
		// 1 1 0 0 1
		
		BitSet c = new BitSet(); // 8
		c.set(2);
		System.out.println("C: "+c);
		BitSet copiaB = (BitSet) b.clone();
		
		//b.and(c);
		
		//System.out.println(b);
		
		copiaB.and(c);
		
		System.out.println("Resultado de and: "+copiaB);
		
		copiaB = (BitSet) b.clone();
		
		copiaB.or(c);
		
		System.out.println("Resultados de or: "+copiaB);
		
		StringTokenizer  st = new StringTokenizer("{a,b,1,3,f}","{, }");
		
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}
	}
}
