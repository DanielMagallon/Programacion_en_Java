package Simulacion;

import static Simulacion.MathData.valoresXi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Vector;

import static Simulacion.App.writer;

public abstract class AbstractCalculo 
{
	public ArrayList<BigDecimal> listaValores = new ArrayList<BigDecimal>();
	public Vector<Vector<String>> resultados = new Vector<Vector<String>>();
	
	public void calcular(String...valores)
	{
		writer.modelo.clear();
		for(int i=0; i<valoresXi.length; i++)
		{
			writer.modelo.addElement(valoresXi[i]);
		}
	}
	
	public void agregaSemillas()
	{
		MathData.valoresXi = new BigDecimal[listaValores.size()];
		
		for(int i=0; i<listaValores.size(); i++)
		{
			MathData.asingarXis(listaValores.get(i), i);
		}
	}
	
	public void agrega(String da)
	{
		listaValores.add(new BigDecimal(da));
	}
	
	public  boolean estaEnLaLista(String b)
	{
		return listaValores.contains(new BigDecimal(b));
	}
	
	public boolean esCero(String val)
	{
		return  Double.parseDouble(val)==0;
	}
	
	public void initRest()
	{
		resultados.clear();
		listaValores.clear();
	}
}
