package Unidad1;

import java.util.BitSet;
import java.util.StringTokenizer;

class Conjunto{
	
	private BitSet bit;
	int asci;
	
	public Conjunto(String st) 
	{
		bit = new BitSet();
		
		StringTokenizer tk = new StringTokenizer(st, "{, }");
		
		while(tk.hasMoreTokens())
		{
			asci = tk.nextToken().charAt(0);
			
			bit.set(asci);
		}
		
	}

	public Conjunto()
	{
		bit = new BitSet();
	}
	
	public void mostrar(String mens)
	{
		System.out.print(mens + "{");
		
		StringTokenizer st = new StringTokenizer(bit.toString(),"{, }");
		
		int nTokens = st.countTokens();
		String  ncad;
		int num;
		
		for(int i=0; i<nTokens; i++)
		{
			ncad = st.nextToken();
			num = Integer.parseInt(ncad);
			System.out.print((char)num);
			
			if(i<nTokens-1)
				System.out.print(",");
		}
		
		System.out.println("}");
	}
	
	public void union(Conjunto cj)
	{
		bit.or(cj.bit);
	}
	
	public void interseccion(Conjunto cj)
	{
		bit.and(cj.bit);
	}  
	
	public void diferencia(Conjunto cj)
	{
		bit.andNot(cj.bit);
	}
	
	public Conjunto clona()
	{
		Conjunto cop = new Conjunto();
		
		cop.bit = (BitSet) bit.clone();
		
		return cop;
	}
}

public class OperacionConjuntos {

	public static void main(String[] args) 
	{
		Conjunto A = new Conjunto("{a,b,c,1,2}");
		Conjunto B = new Conjunto("{a,e,f,2,3}");
	
		A.mostrar("Conjunto A: ");
		B.mostrar("Conjunto B: ");
		
		Conjunto clon = A.clona();
		
		clon.union(B);
		clon.mostrar("A U B = ");
		

		clon = A.clona();
		clon.interseccion(B);
		clon.mostrar("A x B = ");
		
		clon = A.clona();
		clon.diferencia(B);
		
		clon.mostrar("A - B: ");
	}
	
}
