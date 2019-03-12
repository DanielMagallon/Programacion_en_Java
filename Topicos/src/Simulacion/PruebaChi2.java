package Simulacion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

import static Simulacion.MathData.valoresXi;

public class PruebaChi2 
{
	private BigDecimal m;
	
	public void generar()
	{
		m = new BigDecimal(12).sqrt(new MathContext(1, RoundingMode.HALF_UP));

		String res[] = new String[m.intValue()];

		BigDecimal rango = new BigDecimal(BigInteger.ONE).divide(m,1,RoundingMode.HALF_UP);
		
		BigDecimal val = rango;
		
		for(int i=0;i<res.length; i++)
		{
			if(i==0)
				res[i] = (val.subtract(val))+"-"+(val);
			
			else 
				res[i] = ((val.subtract(rango)).add(new BigDecimal(".01")))+"-"+(val);
			
			val = val.add(rango);
		}
		
		for(String s : res)
			System.out.println(s);
		
	}
	
	public static void main(String[] args) {
		new PruebaChi2().generar();
	}
	
}
