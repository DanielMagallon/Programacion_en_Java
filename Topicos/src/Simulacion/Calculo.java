package Simulacion;

public abstract class Calculo extends AbstractCalculo
{
	
	protected String obtenerMedio(String val, int cant)
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
	
	protected String borrar0_s(String val)
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
