package Simulacion;

public abstract class Calculo extends AbstractCalculo
{
	protected int cant;
	
	protected String obtenerMedio(String val) throws Exception
	{
		StringBuilder var = new StringBuilder(val);
		int digitosSacar;
		
		if(val.length()<(cant*2-1))
		{
			int agregar = cant-val.length();
			
			if(agregar>=0)
			{
				for(int i=1; i<=agregar; i++)
				{
					var.insert(0, "0");
				}
				
				return var.toString();
			}
			else
			{
				if(cant%2==0)
				{
					//Formula: D = x-y-((x-y)/2)
					//F.S: D = 0.5 * x - 0.5 * y;
//					digitosSacar = (val.length()-cant) - ((val.length()-cant)/2);
					//Forma simplificada:
					
					digitosSacar = (int)(0.5 * val.length()) - (int)(0.5*cant);
					
					if(val.length()%2!=0)
					{
						var.insert(0, "0");
						digitosSacar++;
					}
					
				}
				else
				{
					digitosSacar = (int)(0.5 * val.length()) - (int)(0.5*cant);
					
					if(var.length()%2==0)//Ag,saca
					{
						var.insert(0, "0");
//						digitosSacar++;
					}
				}
				
				
			}
		}
		
		else
		{
		
			boolean agregar;
			int cant2;
			
			
			if(cant%2==0)
			{
				agregar = !((cant2 = var.length())%2==0);
				digitosSacar = cant/2;
				
			}
			else
			{
				
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

	protected static String borrar0_s(String val)
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
}
