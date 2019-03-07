package Simulacion;

import java.math.BigInteger;

public class ProductosMedios 
{

	public String resultado[][];
	
	public void calcularCM(String valor,String valor2,int cantSemillas)
	{
		BigInteger val,val2;
		String medio;
		
		resultado = new String[cantSemillas][6];
		
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
			resultado[i][4] = medio = obtenerMedio(resultado[i][3],valor.length());
			resultado[i][5] = "."+medio;
			valor = valor2;
			valor2 = medio;
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
	
	public String obtenerMedio(String val, int cant)
	{
		
		StringBuilder var;
		
		
		boolean agregar;
		
		
		int cant2;
		
		var = new StringBuilder(val);
		int digitosSacar;
		
		if(cant%2==0)
		{
			agregar = !((cant2 = var.length())%2==0);
			digitosSacar = cant/2;
			
		}
		else {
			
			agregar = ((cant2 =  var.length())%2==0);
			
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
