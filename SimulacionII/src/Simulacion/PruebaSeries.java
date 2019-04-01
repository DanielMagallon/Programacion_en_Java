package Simulacion;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.LinkedHashMap;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import static Simulacion.MathData.valoresXi;
import static Simulacion.MathData.getSqrtN;
import static Simulacion.MathData.getN;

public class PruebaSeries extends JDialog
{
	BigDecimal rangoX,vX,rangoY,vY,tablaIntervalos[][];
	private int[] claveFrecuencias;
	JTable tabla;
	DefaultTableModel modelo;
	int i,j;
	
	public PruebaSeries()
	{
		setModal(true);
		setSize(600, 400);
		setLocationRelativeTo(null);

		tabla = new JTable(modelo = new DefaultTableModel());
		
		JPanel p = new JPanel();
		add(p,"North");
		p.add(new JLabel("INFORME"));
		
		JScrollPane sc = new JScrollPane(tabla);
		add(sc,"Center");
		
		modelo.addColumn("Divisiones");
		modelo.addColumn("Oi");
		modelo.addColumn("Ei");
		modelo.addColumn("X²o");
		
		tabla.getColumnModel().getColumn(0).setMinWidth(200);
	}
	
	public void generar(int divsX,int divsY)
	{
		modelo.setRowCount(0);
		String rangosX[] = new String[divsX];
		String rangosY[] = new String[divsY];
		
		claveFrecuencias = new int[divsX*divsY];
		
		rangoX = BigDecimal.ONE.divide(new BigDecimal(divsX),5,RoundingMode.HALF_UP);
		vX = rangoX;
		
		rangoY = BigDecimal.ONE.divide(new BigDecimal(divsY),5,RoundingMode.HALF_UP);
		vY = rangoY;
		
		for(i=1; i<=divsX*divsY; i++)
		{
			modelo.addRow(new Object[] {});
		}
		
		MathContext prec = new MathContext(1);
		
		for(i=0; i<divsX; i++)
		{
			if(vX.round(prec).compareTo(BigDecimal.ONE)==0)
					rangosX[i] = "1.00000";
							
			else rangosX[i] = vX.toString();
			
			vX = vX.add(rangoX);
		}
		
		for(i=0; i<divsY; i++)
		{
			if(vY.round(prec).compareTo(BigDecimal.ONE)==0)
				rangosY[i] = "1.00000";
			
			else rangosY[i] = vY.toString();
			vY = vY.add(rangoY);
		}
		
		int pos=0;
		String cad,cad2;
		tablaIntervalos = new BigDecimal[divsX*divsY][2];
		
		for(i=0; i<divsY; i++)
		{
			for( j=0; j<divsX; j++)
			{
				cad = "[x: <= "+rangosX[j]+"]";
				cad2 = "[y: <= "+rangosY[i]+"]";
				
				modelo.setValueAt(cad+"--"+cad2, pos, 0);
				tablaIntervalos[pos][0] = new BigDecimal(rangosX[j]);
				tablaIntervalos[pos][1] = new BigDecimal(rangosY[i]);
				pos++;
			}
		}
		
		
		frecuencias();
	}
	
	
	private void frecuencias()
	{
		BigDecimal Ei,X2,Sum = BigDecimal.ZERO,Oi, m = new BigDecimal(getSqrtN());
		
		for(i=0; i<valoresXi.length-1; i++)
		{
			for(j=0;j<tablaIntervalos.length; j++)
			{
				if(valoresXi[i].compareTo(tablaIntervalos[j][0])<=0 &&
				   valoresXi[i+1].compareTo(tablaIntervalos[j][1])<=0)
				{
					claveFrecuencias[j]++;
					break;
				}
			}
		}
		
		Ei = getN().subtract(BigDecimal.ONE).divide(m,4,RoundingMode.HALF_EVEN);
		
		for(i=0; i<claveFrecuencias.length; i++)
		{
			modelo.setValueAt(claveFrecuencias[i], i, 1);
			modelo.setValueAt(Ei, i, 2);
			Oi = new BigDecimal(claveFrecuencias[i]);
			
			X2 = Ei.subtract(Oi).pow(2).divide(Ei,5,RoundingMode.DOWN);
			modelo.setValueAt(X2, i, 3);
			
			Sum = Sum.add(X2);
		}
		
		modelo.addRow(new Object[] {"","","Σ:",Sum});
	}
}
