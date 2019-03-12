package Simulacion;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CuadradosMedios extends Calculo
{
	
	@Override
	public void calcular(String...valores) 
	{
		calcularCM(valores[0], Integer.parseInt(valores[1]));
	}
	
	public void calcularCM(String valor,int cantSemillas)
	{
		BigInteger val;
		String medio;
		cant = valor.length();

		MathData.valoresXi = new BigDecimal[cantSemillas];
			
		resultado = new String[cantSemillas][5];
		initRest();
		
		try
		{
			for(int i=0; i<resultado.length; i++)
			{
				valor = borrar0_s(valor);
				val = new BigInteger(valor);
				resultado[i][0] = (i+1)+"";
				resultado[i][1] = valor;
				resultado[i][2] = val.multiply(val).toString();
				resultado[i][3] = medio = obtenerMedio(resultado[i][2]);
				resultado[i][4] = "0."+medio;
				MathData.asingarXis(resultado[i][4], i);
				
				valor = medio;
			}
		}catch(Exception e) {}
	}
}
