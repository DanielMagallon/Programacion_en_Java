package Simulacion;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static Simulacion.MathData.valoresXi;

public class UpDownMedia extends CorridasPanel
{
	private static final long serialVersionUID = 3195977913809006680L;
	
	int Co,N0s,N1s;
	boolean cero;

	public void generar()
	{
		Co=1;
		N0s = N1s = 0;
		cero = false;
		
		for(int i=0; i<valoresXi.length; i++)
		{
			if(valoresXi[i].compareTo(new BigDecimal(0.5))<=0)
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
		
		super.generar();
	}

}
