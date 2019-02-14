package Practica1;

import java.awt.SystemColor;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaAleatoria extends JTable
{

	private static final long serialVersionUID = -976808600340477325L;
	
	public DefaultTableModel model;
	
	public TablaAleatoria()
	{
		model = new DefaultTableModel()
		{
			private static final long serialVersionUID = -1701864529069782261L;
			
			@Override
			public boolean isCellEditable(int row, int column) 
			{
				return column!=0;
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return Integer.class;
			}
		};
		
		getTableHeader().setReorderingAllowed(false);
		
		
		model.addColumn("#");
		model.addColumn("Lanzamiento de un dado");
		model.addColumn("Suma del lanzamiento de dos dados");
		
		setModel(model);
		
		getColumnModel().getColumn(0).setMaxWidth(30);
		getColumnModel().getColumn(0).setCellRenderer(Ejecutable.conf);
		getColumnModel().getColumn(1).setCellRenderer(Ejecutable.conf);
		getColumnModel().getColumn(2).setCellRenderer(Ejecutable.conf);
	}
	
	public int index=1;
	
	public void agregaFila(int rnd1,int rnd2)
	{
		model.addRow(new Object[]{index++,rnd1,rnd2});
	}
	
	public void reset()
	{
		model.setRowCount(0);
		index=1;
	}
	
	public int getValIndexOf(int column,int index)
	{
		return (int) model.getValueAt(index, column);
	}
	
	
	
}
