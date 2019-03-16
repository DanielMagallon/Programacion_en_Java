package Simulacion;

import static Simulacion.MathData.valoresXi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CorridaUp_Down
{
	int Co;
	boolean cero;
	BigDecimal MCo,VarianzaCo,Zo;
	
	public void generar()
	{
		Co=1;
		for(int i=1; i<valoresXi.length; i++)
		{
			if(valoresXi[i-1].compareTo(valoresXi[i])<=0)
			{
				if(!cero)
					Co++;
				
				cero=true;
			}
			else
			{
				if(cero)
				{
					Co++;
				}
				cero=false;
			}
			
		}
		
		int numer = 2*valoresXi.length-1;
		
		MCo = new BigDecimal(numer).divide(new BigDecimal(3),5,RoundingMode.DOWN);
		
		numer = 16*valoresXi.length-29;
		
		VarianzaCo = new BigDecimal(numer).divide(new BigDecimal(90),5,RoundingMode.DOWN);
		
		Zo = new BigDecimal(Co).subtract(MCo).divide(VarianzaCo.sqrt(new MathContext(4)),
									4, RoundingMode.HALF_EVEN);
		
		
	}
	
	public static void main(String[] args)
	{
		/*.63,.85,.08,.86,.91,.26,
						.32,.73,.17,.01,.51,.02,
						.49*/
		
//		new CorridaUp_Down().generar(new Double[] 
//				{
//						.4864,
//						.3709,
//						.3839,
//						.5931,
//						.2072,
//						 .5659,
//						 .7391,
//						 .7199,
//						 .3844,
//						 .7015,
//						 .0728,
//						 .2528,
//						 .3506,
//						 .0338,
//						 .8164
//				});
	}
}
