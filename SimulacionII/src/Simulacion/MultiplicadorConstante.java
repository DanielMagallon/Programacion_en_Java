package Simulacion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Vector;

import javax.swing.JOptionPane;

public class MultiplicadorConstante extends Calculo
{
	@Override
	public void calcular(String...valores) 
	{
		calcularCM(valores[0], valores[1], 
				Integer.parseInt(valores[2]));
		
		super.calcular(null);
	}
	
	public void calcularCM(String constant,String valor2,int cantSemillas)
	{
		BigInteger val,val2;
		String medio;

		initRest();
		constant = borrar0_s(constant);
		val = new BigInteger(constant);
		cant = constant.length();
		
		try
		{
		for(int i=0; i<cantSemillas; i++)
		{
			
			valor2 = borrar0_s(valor2);
			
			val2 = new BigInteger(valor2);
			
			resultados.add(new Vector<String>());
			resultados.get(i).add((i+1)+"");
			
			resultados.get(i).add(constant);
			
			resultados.get(i).add(valor2);
			
			resultados.get(i).add(val.multiply(val2).toString());
			
			medio = obtenerMedio(val.multiply(val2).toString());
			resultados.get(i).add(medio);
			
			resultados.get(i).add("."+medio);
			
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
			
			valor2 = medio;
			
			if(esCero(valor2))
			{
				JOptionPane.showMessageDialog(null,String.format
			("La semilla %s crea una semilla de 0\n"
					+ "por lo que la demas ejecucion es innecesaria", 
						valor2),
						"Ejecucion Finalizada",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Las semillas introducidas generan rapidamente valores nulos");
		}
		
		agregaSemillas();
	}
}
