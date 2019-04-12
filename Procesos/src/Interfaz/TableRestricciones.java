package Interfaz;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Perfomance.PuntoFallo;

import static Interfaz.TablaPCB.Alinear;

public class TableRestricciones extends JTable 
{
	private static final long serialVersionUID = -1825227213226453418L;

	private DefaultTableModel modelo;
	
	public TableRestricciones() 
	{
		getTableHeader().setReorderingAllowed(false);
		
		modelo = new DefaultTableModel()
		{
			private static final long serialVersionUID = 6343202736376072760L;
			
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return (column!=0);
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex)
			{
				if(columnIndex==0)
					return String.class;
				
				if(columnIndex==1)
					return Boolean.class;
				
				else
					return Double.class;
				
			}
			
			
		};

		Object columnas[] = {"Procesos","PF al inicio","Tiempo de ejecucion",
							"PF a los _Q","Tiempo de ejecucion"};
		
		for(int i=0; i<columnas.length; i++)
		{
			modelo.addColumn(columnas[i]);
			
		}
		
		modelo.addRow(new Object[]{"Proceso General",false});
		
		setModel(modelo);
		
		this.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		this.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		this.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		this.getColumnModel().getColumn(3).setCellRenderer(Alinear);
		this.getColumnModel().getColumn(4).setCellRenderer(Alinear);
	}
	
	public void getPuntoFalloGeneral()
	{
		double duracion,n;
		
		if((boolean) modelo.getValueAt(0, 1))
		{
			if(modelo.getValueAt(0, 2)==null)
				duracion = 0;
			
			else duracion = (double) modelo.getValueAt(0, 2);
			
			ProcesFrame.monoP.pFalloInicio = new PuntoFallo(duracion);
		}
		else ProcesFrame.monoP.pFalloInicio = null;
		
		if(modelo.getValueAt(0, 3) != null && (double) modelo.getValueAt(0, 3) != 0)
		{
			n = (double) modelo.getValueAt(0, 3);
			
			if(modelo.getValueAt(0, 4)==null)
				duracion = 0;
			
			else duracion = (double) modelo.getValueAt(0, 4);
			
			ProcesFrame.monoP.pFalloAfter = new PuntoFallo(duracion, n);
		}
		else ProcesFrame.monoP.pFalloAfter = null;
	}
}
