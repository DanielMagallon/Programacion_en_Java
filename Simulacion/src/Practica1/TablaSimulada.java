package Practica1;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaSimulada extends JTable 
{
	private static final long serialVersionUID = -7419730008566484423L;

	public DefaultTableModel model;
	
	public TablaSimulada()
	{
		model = new DefaultTableModel()
		{
			private static final long serialVersionUID = 252359800186028802L;

			@Override
			public boolean isCellEditable(int row, int column) 
			{
				return false;
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return Integer.class;
			}
		};
		
		getTableHeader().setReorderingAllowed(false);
		
		
		model.addColumn("Cliente");
		model.addColumn("Tpo.  entre llegada");
		model.addColumn("Tpo. de llegada");
		model.addColumn("Tpo. de inicio");
		model.addColumn("Tpo. de servicio");
		model.addColumn("Tpo. fin de servicio");
		model.addColumn("Tpo. inhabil");
		model.addColumn("Tpo. en fila");
		
		setModel(model);
		
		for(int i=0; i<model.getColumnCount(); i++)
		{
			getColumnModel().getColumn(i).setCellRenderer(Ejecutable.conf);
		}
		
		getColumnModel().getColumn(0).setMaxWidth(50);
	}

	public int index=1;
	public void agregaClientes()
	{
		model.addRow(new Object[]{index++});
	}
	
	public void reset()
	{
		index=1;
		model.setRowCount(0);
	}
	
	public void agregaValores(int column, int row,int val)
	{
		model.setValueAt(val, row, column);
	}
	
	public int getValOf(int col, int row)
	{
		return (int) model.getValueAt(row, col);
	}
}
