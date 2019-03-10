package Simulacion;

public abstract class AbstractCalculo 
{
	public String resultado[][];
	
	public abstract void calcular(String...valores);
	
	public void initRest()
	{
		for(int i=0; i<resultado.length; i++)
		{
			for(int j=0; j<resultado[i].length; j++)
			{
				resultado[i][j]="0";
			}
		}
	}
}
