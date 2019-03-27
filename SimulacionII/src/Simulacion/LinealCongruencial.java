package Simulacion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Vector;

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
		
		super.calcular(null);
	}
	
	
	public  void calcularD(String a, String x, String c,String mod, int num_sem)
	{
		
		initRest();
		
		BigDecimal decA = new BigDecimal(a);
		BigDecimal decX = new BigDecimal(x);
		BigDecimal decC = new BigDecimal(c);
		BigDecimal decMod = new BigDecimal(mod);
		BigDecimal decXind,decMult,decDiv,decRes,decRi;
		String cad;
		
		try
		{
			for(int i=0; i<num_sem; i++)
			{
				resultados.add(new Vector<String>());
				
				resultados.get(i).add((i+1)+"");
				resultados.get(i).add(decX.toString());
				
				decMult = decA.multiply(decX).add(decC);
				resultados.get(i).add(decMult.toString());
				
	
				decDiv = decMult.divide(decMod,4, RoundingMode.HALF_DOWN);
				cad = (decDiv.toString()).substring(0,decDiv.toString().indexOf('.'));
				decRes = decDiv.subtract(new BigDecimal(cad));

				resultados.get(i).add(decRes.toString());
				
				
				decXind = decRes.multiply(decMod);
				decXind = decXind.divide(BigDecimal.ONE,0,RoundingMode.HALF_UP);
						
				resultados.get(i).add(decXind.toString());
				
				decRi = decXind.divide(decMod.subtract(BigDecimal.ONE),5, RoundingMode.HALF_DOWN);
				
				resultados.get(i).add(decRi+"");
				
				if(!estaEnLaLista(resultados.get(i).get(5)))
				{
					agrega(resultados.get(i).get(5));
				}
				else {
					JOptionPane.showMessageDialog(null, 
							String.format("El numero %s se repite en la semilla %d, por lo que la ejecucion de"
						+ "\nlas demas semillas es inecesaria",resultados.get(i).get(5),i+1),
							"Ejecucion Finalizada",
							JOptionPane.INFORMATION_MESSAGE);
					resultados.remove(resultados.size()-1);
					break;
				}
				
				decX = decXind;
				if(esCero(decX.toString()))
				{
					JOptionPane.showMessageDialog(null,String.format
							("La semilla %s crea una semilla de 0\n"
									+ "por lo que la demas ejecucion es innecesaria", 
										decX.toString()),
										"Ejecucion Finalizada",
										JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado",
					"Atencion",JOptionPane.INFORMATION_MESSAGE);
		}
		
		agregaSemillas();
	}
}
