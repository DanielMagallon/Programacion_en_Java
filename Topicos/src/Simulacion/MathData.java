package Simulacion;

import java.math.BigDecimal;

public class MathData 
{
	public static BigDecimal valoresXi[];
	
	public static void asingarXis(String val, int i)
	{
		valoresXi[i] = new BigDecimal(val);
	}
}
