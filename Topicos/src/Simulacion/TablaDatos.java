package Simulacion;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaDatos extends JTable 
{
	DefaultTableModel modelo;
	
	
	public TablaDatos()
	{
		modelo  = new DefaultTableModel() 
		{
			@Override
			public boolean isCellEditable(int row, int column) 
			{
				return row == 0 && column == 1;
			}
		};
		
		setModel(modelo);
	
//		setAutoResizeMode(AUTO_RESIZE_SUBSEQUENT_COLUMNS);
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
