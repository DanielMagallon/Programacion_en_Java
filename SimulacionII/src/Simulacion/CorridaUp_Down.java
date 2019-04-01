package Simulacion;

import static Simulacion.MathData.valoresXi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


public class CorridaUp_Down extends CorridasPanel 
{
	private static final long serialVersionUID = -5435035469501826893L;
	int Co;
	boolean cero;
	
	
	public void generar()
	{
		Co=1;
		cero= false;
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
		
		if(Zo.doubleValue()<0)
			Zo = Zo.multiply(new BigDecimal("-1"));
		
		super.generar();
	}

}
