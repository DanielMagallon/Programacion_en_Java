package Simulacion;

import java.math.BigInteger;

public class CuadradosMedios 
{
	public String resultado[][];
	
	public void calcularCM(String valor,int cantSemillas)
	{
		BigInteger val;
		String medio;
		
		resultado = new String[cantSemillas][5];
		
		for(int i=0; i<resultado.length; i++)
		{
			valor = borrar0_s(valor);
			val = new BigInteger(valor);
			resultado[i][0] = (i+1)+"";
			resultado[i][1] = valor;
			resultado[i][2] = val.multiply(val).toString();
			resultado[i][3] = medio = obtenerMedio(valor);
			resultado[i][4] = "."+medio;
			
			valor = medio;
		}
	}
	
	private String borrar0_s(String val)
	{
		StringBuilder var = new StringBuilder(val);
		
		for(int i=0; i<var.length(); i++)
		{
			if(var.charAt(0) == '0')
			{
				var.deleteCharAt(0);
			}
			else break;
			
		}
		
		return var.toString();
	}
	
	public String obtenerMedio(String val)
	{
		StringBuilder var;
		var = new StringBuilder(val);
		
		BigInteger num;
		
		boolean agregar;
		
		num = new BigInteger(var.toString());
		
		
		int cant = var.length(),cant2;
		
		
		BigInteger r = num.multiply(num);
		
		var = new StringBuilder(r+"");
		int digitosSacar;
		
		if(cant%2==0)
		{
			agregar = !((cant2 = (r+"").length())%2==0);
			digitosSacar = cant/2;
			
		}
		else {
			
			agregar = ((cant2 = (r+"").length())%2==0);
			
			if(cant2%2==0)
			{
				digitosSacar= (cant/2)+1;
				
			}
			else digitosSacar = cant/2;
		}
		
		if(agregar)
		{
			var.insert(0, "0");
		}
		
		
		int k=var.length()-1;
		for(int j=0; j<digitosSacar; j++,k--)
		{
			var.deleteCharAt(k);
			k=var.length();
		}
		
		
		for(int j=0; j<digitosSacar; j++)
		{
			var.deleteCharAt(0);
			
		}
		
		return var.toString();
	}
}
