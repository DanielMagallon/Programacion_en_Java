package Simulacion;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TablaDatos extends JPanel
{
	private static final long serialVersionUID = -4656933219233483570L;
	private DefaultTableModel modelo;
	private JTable table;
	private JPanel panelConf,panelUp;
	private JLabel[] lbls;
	public JTextField txtFs[];
	private int x,i;
	private boolean validaciones[];
	private Color color;
	
	public TablaDatos()
	{
		setLayout(new BorderLayout());
		
		modelo  = new DefaultTableModel();
		
		table = new JTable();
		JScrollPane sc = new JScrollPane(table);
		
		table.setModel(modelo);
	
		panelConf = new JPanel();
		color = Color.yellow;
		
		add(panelConf,"North");
		add(sc,"Center");
		
		panelUp = new JPanel();
		{
		
			lbls = new JLabel[5];
			txtFs = new JTextField[5];
			
			for(int i=0; i<lbls.length; i++)
			{
				lbls[i] = new JLabel();
				txtFs[i] = new JTextField(10);
				txtFs[i].setVisible(false);
				txtFs[i].setSelectionColor(color);
				panelUp.add(lbls[i]);
				panelUp.add(txtFs[i]);
			}
			
			add(panelUp,"North");
		}
		//r=184,g=207,b=229
		
	}
	
	public void habilitar(boolean []vals,String...comps)
	{
		validaciones = vals;
		x = comps.length;
		
		for(int i=0; i<lbls.length; i++)
		{
			if(i<comps.length)
			{
				lbls[i].setText(comps[i]);
				txtFs[i].setVisible(true);
			}
			else 
			{
				lbls[i].setText("");
				txtFs[i].setVisible(false);
			}
		}
	}
	
	public String[] getDatos() throws MiExcepcion, NumberFormatException
	{
		String x[] = new String[this.x];
		int y[] = new int[this.x];
		
		for(i=0; i<this.x; i++)
		{
			
			if(validaciones[i])
			{
				x[i] = Calculo.borrar0_s(txtFs[i].getText().trim()).replace("+", "")
						.replace("-", "");
				y[i] = Integer.parseInt(x[i]);
				
				y[i] = x[i].length();
				
				if(i>0)
				{
					if(y[i]!=y[i-1])
					{
						selecError();
						throw new MiExcepcion("Las semillas deben tener la misma cantidad de digitos");
					}
				}
				
				else if(y[i]<=3)
				{
					selecError();
					throw new MiExcepcion("Las semillas deben ser mayores a 4 digitos");
				}
			}
			else 
			{
				x[i] = txtFs[i].getText();
				y[i] = Integer.parseInt(x[i]);
				
				if(y[i]<=0)
				{
					selecError();
					throw new MiExcepcion("Los valores deben ser mayores a 0");
				}
				
			}
				
		}
		
		
		return x;
	}
	
	public void selecError()
	{
		txtFs[i].requestFocus();
		txtFs[i].setSelectionColor(Color.red);
		txtFs[i].selectAll();
	}
	
	public void backSelection()
	{
		txtFs[i].setSelectionColor(color);
	}
	
	public void crearColumnas(String...cols)
	{
		modelo.setColumnCount(0);
		
		for(int i=0; i<cols.length; i++)
		{
			modelo.addColumn(cols[i]);
		}
	}
	
	public void agregaReng(String val[][])
	{
		modelo.setRowCount(0);
		for(int i=0; i<val.length; i++)
		{
			modelo.addRow(val[i]);
		}
	}
	
}
