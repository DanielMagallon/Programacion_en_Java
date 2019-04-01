package Simulacion;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MathData 
{
	public static BigDecimal valoresXi[];
	
	public static void asingarXis(BigDecimal val, int i)
	{
		valoresXi[i] = val;
	}
	
	public static BigDecimal getN()
	{
		return new BigDecimal(valoresXi.length);
	}
	
	public static int getSqrtN()
	{
		return (int)Math.round(Math.sqrt(valoresXi.length));
	}
	
	public static int[][] getMultiplos(int n)
	{
		int[][] multiplos;
		ArrayList<Integer> elemenst = new ArrayList<Integer>();
		
		int to = (int) Math.round(Math.sqrt(n));
		
		for(int from=2; from<=to; from++)
		{
			if(n%from==0)
			{
				elemenst.add(from);
				elemenst.add(n/from);
			}
		}
		
		multiplos = new int[elemenst.size()/2][2];
		
		for(int i=0,ind=0; ind<multiplos.length; ind++,i+=2)
		{
			multiplos[ind][0] = elemenst.get(i);
			multiplos[ind][1] = elemenst.get(i+1);
		}
		
		return multiplos;
	}
}
