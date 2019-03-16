package Simulacion;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class UpDownMedia
{
	int Co,N0s,N1s;
	boolean cero;
	BigDecimal MCo,VarianzaCo,Zo;
	
	public void generar(Double[] valoresXi)
	{
		Co=1;
		N0s = N1s = 0;
		for(int i=0; i<valoresXi.length; i++)
		{
			if(valoresXi[i].compareTo(0.5)<=0)
			{
				if(!cero)
					Co++;
				
				N0s++;
				cero=true;
			}
			else
			{
				if(cero)
				{
					Co++;
				}
				N1s++;
				cero=false;
			}
			
		}

		BigDecimal n = new BigDecimal(valoresXi.length);

		int v = 2 * N0s * N1s;
		BigDecimal numer = new BigDecimal(v);
		
		MCo = numer.divide(n,5,RoundingMode.DOWN).add(new BigDecimal(0.5));
		
		VarianzaCo = numer.multiply(numer.subtract(n)).divide(n.pow(2).multiply
				(n.subtract(BigDecimal.ONE)),4,RoundingMode.DOWN);
		
		Zo = new BigDecimal(Co).subtract(MCo).divide(VarianzaCo.sqrt(new MathContext(4)),
				4, RoundingMode.HALF_EVEN);
		
	}

	public static void main(String[] args)
	{
		new UpDownMedia().generar(new Double[]
				{
						.63,.85,.08,.86,.91,.26,
						.32,.73,.17,.01,.5164,.02,
						.15,.5100,
						.49
				}
				);
	}
}
