package Simulacion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

public class CuadradosMedios extends Calculo
{
	
	@Override
	public void calcular(String...valores) 
	{
		calcularCM(valores[0], Integer.parseInt(valores[1]));
		super.calcular(null);
	}
	
	public void calcularCM(String valor,int cantSemillas)
	{
		BigInteger val;
		String medio;
		cant = valor.length();

		initRest();
		
		try
		{
			for(int i=0; i<cantSemillas; i++)
			{
				valor = borrar0_s(valor);
				
				val = new BigInteger(valor);
				
				resultados.add(new Vector<String>());
				resultados.get(i).add((i+1)+"");
				resultados.get(i).add(valor);
				resultados.get(i).add(val.multiply(val).toString());
				medio = obtenerMedio(val.multiply(val).toString());
				resultados.get(i).add(medio);
				resultados.get(i).add("0."+medio);

				if(!estaEnLaLista(resultados.get(i).get(4)))
				{
					agrega(resultados.get(i).get(4));
				}
				else {
					JOptionPane.showMessageDialog(null, 
							String.format("El numero %s se repite en la semilla %d, por lo que la ejecucion de"
						+ "\nlas demas semillas es inecesaria",resultados.get(i).get(4),i+1),
							"Ejecucion Finalizada",
							JOptionPane.INFORMATION_MESSAGE);
					resultados.remove(resultados.size()-1);
					break;
				}
				
				
				valor = medio;
				
				if(esCero(valor))
				{
					JOptionPane.showMessageDialog(null,String.format
				("La semilla %s crea una semilla de 0\n"
						+ "por lo que la demas ejecucion es innecesaria", 
							valor),
							"Ejecucion Finalizada",
							JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		agregaSemillas();
	}
}
