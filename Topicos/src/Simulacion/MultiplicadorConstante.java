package Simulacion;

import java.math.BigInteger;

import javax.swing.JOptionPane;

public class MultiplicadorConstante extends Calculo
{
	@Override
	public void calcular(String...valores) 
	{
		calcularCM(valores[0], valores[1], 
				Integer.parseInt(valores[2]));
	}
	
	public void calcularCM(String constant,String valor2,int cantSemillas)
	{
		BigInteger val,val2;
		String medio;
		
		resultado = new String[cantSemillas][6];
		initRest();
		constant = borrar0_s(constant);
		val = new BigInteger(constant);
		
		try
		{
		for(int i=0; i<resultado.length; i++)
		{
			
			valor2 = borrar0_s(valor2);
			
			val2 = new BigInteger(valor2);
			
			resultado[i][0] = (i+1)+"";
			resultado[i][1] = constant;
			resultado[i][2] = valor2;
			resultado[i][3] = val.multiply(val2).toString();
			resultado[i][4] = medio = obtenerMedio(resultado[i][3],constant.length());
			resultado[i][5] = "."+medio;
			
			valor2 = medio;
		}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Las semillas introducidas generan rapidamente valores nulos");
		}
	}
}
