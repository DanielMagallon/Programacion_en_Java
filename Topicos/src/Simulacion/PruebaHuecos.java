package Simulacion;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import static Simulacion.MathData.valoresXi;

public class PruebaHuecos extends JTable implements Prueba
{
	private static final long serialVersionUID = -7616880364963141961L;
	
	public BigDecimal alfa,beta,Ei,X2o,difAB,val;
	private int h,cont;
	private int frecHuecos[] = new int[6];
	private boolean is,first;
	
	DefaultTableModel modelo = new DefaultTableModel();
	
	public PruebaHuecos()
	{
		setModel(modelo);
		
		modelo.addColumn("Tamaño del hueco");
		modelo.addColumn("Oi");
		modelo.addColumn("Ei");
		modelo.addColumn("X²o");
		
		modelo.addRow(new Object[] {"0"});
		modelo.addRow(new Object[] {"1"});
		modelo.addRow(new Object[] {"2"});
		modelo.addRow(new Object[] {"3"});
		modelo.addRow(new Object[] {"4"});
		modelo.addRow(new Object[] {">=5"});
		modelo.addRow(new Object[] {"","","Σ:"});
	}
	
	public void establecerParametros(String alfa, String beta)
	{
		this.alfa = new BigDecimal(alfa);
		this.beta = new BigDecimal(beta);
		
		difAB = this.beta.subtract(this.alfa);
	}
	
	@Override
	public void generar()
	{
		if(alfa==null || beta == null)
		{
			JOptionPane.showMessageDialog(this, "Debe especificar el intervalo (Alfa-Beta)",
					"Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		cont = h = 0;
		first = !(is = false);
		
		
		for(int i=0; i<valoresXi.length; i++)
		{
			if(isOnInterval(valoresXi[i]))
			{
				if(!is)
				{
					if(!first)
						frecHuecos[cont>=5 ? 5 : cont]++;
					
					cont=0;
				}
				else 
				{
					frecHuecos[0]++;
				}
				
				if(!first)
					h++;
				
				if(first)
					first = false;
				
				is = true;
			}
			else
			{
				if(!first)
					cont++;
				
				is = false;
			}
		}
		
		if(h!=0)
			updateTable();
		
		else JOptionPane.showMessageDialog(null, 
		"Las condicions generadas  en el conjunto ri\n y/o en los valores de  Alfa/Beta "
		+ "generan un hueco de 0\n por lo queno es posible hacer los calculos",
		"ERROR ",JOptionPane.ERROR_MESSAGE);
	}

	private void updateTable()
	{
		X2o = BigDecimal.ZERO;
		
		for(int i=0; i<frecHuecos.length; i++)
		{
			
			if(i==frecHuecos.length-1)
			{
				Ei =  (BigDecimal.ONE.subtract(difAB).pow(i)).multiply(new BigDecimal(h));
				
			}
			
			else
			{
				Ei =  (BigDecimal.ONE.subtract(difAB).pow(i)).multiply
						(difAB).multiply(new BigDecimal(h));
			}
			
					
			val = Ei.subtract(new BigDecimal(frecHuecos[i])).pow(2).divide
					(Ei,5,RoundingMode.DOWN);
			
			X2o = X2o.add(val);
			
			modelo.setValueAt(frecHuecos[i], i, 1);
			modelo.setValueAt(Ei, i, 2);
			modelo.setValueAt(val, i, 3);
		}
		
		modelo.setValueAt(X2o,6,3);
	}
	
	private boolean isOnInterval(BigDecimal valor)
	{
		return valor.compareTo(alfa)>=0 && valor.compareTo(beta)<=0;
	}
	
}

