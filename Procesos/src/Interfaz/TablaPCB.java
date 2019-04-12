package Interfaz;

import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Perfomance.Proceso;

public class TablaPCB extends JTable implements KeyListener
{
	private static final long serialVersionUID = 522113172875889132L;

	private DefaultTableModel modelo;
	
	public static DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
	
	static
	{
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public TablaPCB() 
	{
		addKeyListener(this);
		
		modelo = new DefaultTableModel(){

			private static final long serialVersionUID = 6570265265797043945L;

			@Override
			public boolean isCellEditable(int row, int column)
			{
				return (column==1);
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex)
			{
				if(columnIndex==0)
					return String.class;
				
				if(columnIndex==2)
					return Float.class;
				
				return Double.class;
			}
			
		};
		
		getTableHeader().setReorderingAllowed(false);
		
		getTableHeader().setBackground(SystemColor.white);
		modelo.addColumn("Proceso");
		modelo.addColumn("Quatums");
		modelo.addColumn("Contador");
		
		
		this.setModel(modelo);
		getModel().addTableModelListener(this);
		
		this.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		this.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		this.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		
	}

	public ArrayList<Proceso> getProcesos()
	{
		ArrayList<Proceso> list = new ArrayList<>();
		String name;
		double q;
		
		for(int i=0; i<modelo.getRowCount(); i++)
		{
			name = modelo.getValueAt(i, 0).toString();
			
			 if(modelo.getValueAt(i, 1)==null)
				 q=0;
			 
			 else q = (double)modelo.getValueAt(i, 1);
			 
			list.add(new Proceso(name, q,i));
		}
		
		return list;
	}
	
	public void borrarContador()
	{
		for(int i=0; i<getRowCount(); i++)
		{
			modelo.setValueAt(null, i, 2);
		}
	}
	
	public void agregarProceso(double val)
	{
//		ProcesFrame.btnGuardarProcesos.setText("* Guardar Procesos");
//		ProcesFrame.btnEjecutarProcesos.setEnabled(false);
		modelo.addRow(new Object[]{Proceso.getProcessCount(),val});
		Proceso.contProc++;
	}
	
	private double vectorValores[];
	
	public void borrarProcesos()
	{
		int rows[] = getSelectedRows();
		
		if(rows.length!=0)
		{
//			ProcesFrame.btnGuardarProcesos.setText("* Guardar Procesos");
//			ProcesFrame.btnEjecutarProcesos.setEnabled(false);
			for(int i=0; i<rows.length; i++)
				modelo.removeRow(rows[i]-i);
		
			vectorValores = new double[getRowCount()];
			
			for(int i=0; i<getRowCount(); i++)
			{
				if(modelo.getValueAt(i, 1) == null)
					vectorValores[i] = 0;
				
				else vectorValores[i] = (double) modelo.getValueAt(i, 1);
			}
			
			modelo.setRowCount(0);
			
			Proceso.contProc=1;
			
			for(int i=0; i<vectorValores.length; i++)
			{
				agregarProceso(vectorValores[i]);
			}
			
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_DELETE)
			borrarProcesos();
		
		else if(e.getKeyCode() == KeyEvent.VK_PLUS)
			agregarProceso(1);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		super.tableChanged(e);
		try
		{
			ProcesFrame.btnGuardarProcesos.setText("* Guardar Procesos");
			ProcesFrame.btnEjecutarProcesos.setEnabled(false);
		}catch(NullPointerException ex){
			
		}
	}
	
}
