package Simulacion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.LinkedHashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import static Simulacion.MathData.valoresXi;

public class PruebaChi2 extends JTable implements Prueba
{
	private static final long serialVersionUID = 2332440439036009794L;

	DefaultTableModel modelo = new DefaultTableModel();
	
	private BigDecimal m,n,sumatoria;
	private String tablaResultados[][];
	private int frecuencias[],i;
	private LinkedHashMap<BigDecimal, Integer> claveFrecuencias;
	
	public PruebaChi2()
	{
		modelo.addColumn("Intervalos");
		modelo.addColumn("Oi");
		modelo.addColumn("Ei"); 
		modelo.addColumn("X²o");
		setModel(modelo);
	}
	
	public void generar()
	{
		int val;
		
		modelo.setRowCount(0);
		n = new BigDecimal(valoresXi.length);
		val = (int)Math.round(Math.sqrt(valoresXi.length));
		m = new BigDecimal(val);
		
		tablaResultados= new String[m.intValue()][4];

		frecuencias = new int[m.intValue()];
		claveFrecuencias = new LinkedHashMap<BigDecimal, Integer>();
		
		sumatoria = new BigDecimal(0);
		
		BigDecimal rango = new BigDecimal(BigInteger.ONE).divide(m,5,RoundingMode.HALF_UP);
		BigDecimal v = rango, Ei;
		Ei = n.divide(m,5,RoundingMode.HALF_EVEN);
		
		for(i=0;i<tablaResultados.length; i++)
		{
			if(i==tablaResultados.length-1)
				tablaResultados[i][0] = "<=1.00000";
			
			else tablaResultados[i][0] = "<="+rango;
			claveFrecuencias.put(rango, i);
			tablaResultados[i][2] = Ei+"";
			rango = rango.add(v);
		}
		
		frecuencia();
		
		for(int i=0; i<frecuencias.length; i++)
		{
			tablaResultados[i][1] = frecuencias[i]+"";
			v = (Ei.subtract(new BigDecimal(frecuencias[i]))).pow(2).divide(Ei,5,RoundingMode.DOWN);
			sumatoria = sumatoria.add(v);
			
			tablaResultados[i][3] = v+"";
			actualizar(tablaResultados[i]);
		}
		
		modelo.addRow(new Object[] {"","","Σ:",sumatoria});
		
	}
	
	private void frecuencia()
	{
		
		for(int i=0; i<valoresXi.length; i++)
		{
			for(BigDecimal key : claveFrecuencias.keySet())
			{
				if(valoresXi[i].compareTo(key)<=-1)
				{
					frecuencias[claveFrecuencias.get(key)]++;
					break;
				}
			}
		}
	}
	
	private void actualizar(Object[] v)
	{
		modelo.addRow(v);
	}
	
}
