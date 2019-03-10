package Simulacion;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TablaDatos extends JPanel
{
	DefaultTableModel modelo;
	JTable table;
	JPanel panelConf,panelUp;
	JLabel[] lbls;
	public JTextField txtFs[];
	public Validar valid;
	
	public TablaDatos()
	{
		setLayout(new BorderLayout());
		
		modelo  = new DefaultTableModel() 
		{
			@Override
			public boolean isCellEditable(int row, int column) 
			{
				return row == 0 && column == 1;
			}
		};
		
		table = new JTable();
		JScrollPane sc = new JScrollPane(table);
		
		table.setModel(modelo);
	
		panelConf = new JPanel();
		
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
				
				panelUp.add(lbls[i]);
				panelUp.add(txtFs[i]);
			}
			
			add(panelUp,"North");
		}
		
	}
	
	public void setRestrictions(Validar v)
	{
		valid = v;
	}
	
	private int x;
	
	public void habilitar(String...comps)
	{
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
	
	public String[] getDatos(boolean inSize) throws MiExcepcion, NumberFormatException
	{
		String x[] = new String[this.x];
		int y[] = new int[this.x];
		
		for(int i=0; i<this.x; i++)
		{
			x[i] = txtFs[i].getText();
			
			if(inSize)
			y[i] = txtFs[i].getText().length();
			
			else
				y[i] = Integer.parseInt(txtFs[i].getText());
		}
		
		y[this.x-1] = Integer.parseInt(txtFs[this.x-1].getText());
		
		valid.validar(y);
			
		return x;
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
