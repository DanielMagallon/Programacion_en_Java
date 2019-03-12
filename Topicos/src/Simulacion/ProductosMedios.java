package Simulacion;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.swing.JOptionPane;

public class ProductosMedios extends Calculo
{
	@Override
	public void calcular(String...valores) 
	{
		calcularCM(valores[0], valores[1], Integer.parseInt(valores[2]));
	}

	public void calcularCM(String valor,String valor2,int cantSemillas)
	{
		BigInteger val,val2;
		String medio;
		
		resultado = new String[cantSemillas][6];
		
		MathData.valoresXi = new BigDecimal[cantSemillas];
		
		initRest();
		cant = valor.length();
		
		try
		{
			for(int i=0; i<resultado.length; i++)
			{
				valor = borrar0_s(valor);
				valor2 = borrar0_s(valor2);
				
				
				val = new BigInteger(valor);
				val2 = new BigInteger(valor2);
				
				resultado[i][0] = (i+1)+"";
				resultado[i][1] = valor;
				resultado[i][2] = valor2;
				resultado[i][3] = val.multiply(val2).toString();
				resultado[i][4] = medio = obtenerMedio(resultado[i][3]);
				resultado[i][5] = "."+medio;
				MathData.asingarXis(resultado[i][5], i);
				
				valor = valor2;
				valor2 = medio;
			}
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Las semillas intoducidas generan valore nulos");
			
		}
	}
}
