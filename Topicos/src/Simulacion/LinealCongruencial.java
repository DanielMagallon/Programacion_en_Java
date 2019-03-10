package Simulacion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class LinealCongruencial extends  AbstractCalculo
{
	
	@Override
	public void calcular(String...valores) 
	{
		if(valores.length==5)
			calcularD(
						valores[0],
						valores[1], 
						valores[2],
						valores[3],
						Integer.parseInt(valores[4])
					);
		else
			calcularD(
					valores[0],
					valores[1], 
					"0",
					valores[2],
					Integer.parseInt(valores[3])
				);
		
	}
	
	
	public  void calcularD(String a, String x, String c,String mod, int num_sem)
	{
		
		resultado = new String[num_sem][6];
		initRest();
		
		BigDecimal decA = new BigDecimal(a);
		BigDecimal decX = new BigDecimal(x);
		BigDecimal decC = new BigDecimal(c);
		BigDecimal decMod = new BigDecimal(mod);
		BigDecimal decXind,decMult,decDiv,decRes;
		float decRi;
		String cad;
		
		try
		{
			for(int i=0; i<num_sem; i++)
			{
				resultado[i][0] = (i+1)+"";
				
				resultado[i][1] = decX+"";
				
				decMult = decA.multiply(decX).add(decC);
				
				resultado[i][2] = decMult.toString();
	
				decDiv = decMult.divide(decMod,2, RoundingMode.HALF_DOWN);
				
				
				cad = (decDiv.toString()).substring(0,decDiv.toString().indexOf('.'));
				
				decRes = decDiv.subtract(new BigDecimal(cad));
				
				resultado[i][3] = decRes.toString();
				
				decXind = decRes.multiply(decMod);
						
				resultado[i][4] = decXind.toString();
				
				decRi = decXind.floatValue()/(decMod.floatValue()-1);
				
				resultado[i][5] = decRi+"";
				
				decX = decXind;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Los valores dados generan valores nulos",
					"Atencion",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
