package Simulacion;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import static Simulacion.MathData.valoresXi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class PruebaKol_Smirov extends JTable implements Prueba
{
	DefaultTableModel modelo = new DefaultTableModel();
	BigDecimal DM,Dm,DR;
	JTextField txtd, txtD,  txtMD;
	
	public PruebaKol_Smirov()
	{
		setModel(modelo);
		modelo.addColumn("i");
		modelo.addColumn("i/n");
		modelo.addColumn("ri");
		modelo.addColumn("(i-1)/n");
		modelo.addColumn("(i/n)-ri");
		modelo.addColumn("ri - (i-1)/n");
		modelo.addColumn("n");
	}
	
	public void generar()
	{
		modelo.setRowCount(0);
		BigDecimal i_n,i_1_n,resta,resta2,n = new BigDecimal(valoresXi.length) ;
		BigDecimal vals[] = valoresXi.clone();
		Arrays.sort(vals);
		DM = null;
		Dm = null;
		
		
		for(int i=0; i<vals.length; i++)
		{
			i_n = new BigDecimal(i+1).divide(n,5,RoundingMode.DOWN);
			i_1_n = new BigDecimal(i).divide(n,5,RoundingMode.DOWN);
			
			resta = i_n.subtract(vals[i]);
			resta2 = vals[i].subtract(i_1_n);

			if(DM==null)
			{
				DM = resta;
				Dm = resta2;
			}
			
			else
			{
				if(resta.compareTo(DM)==1)
					DM = resta;
				
				if(resta2.compareTo(Dm)==1)
					Dm = resta2;
			}
			
			modelo.addRow(new Object[]
						{
							(i+1),
							i_n,
							vals[i],
							i_1_n,
							resta,
							resta2,
							n.intValue()
						}
					);
		}

		DR = DM.compareTo(Dm)>=0 ? DM : Dm;
		
		txtd.setText(Dm.toString());
		txtD.setText(DM.toString());
		txtMD.setText(DR.toString());
	}
}
