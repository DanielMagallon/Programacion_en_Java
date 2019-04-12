package Perfomance;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import Interfaz.ProcesFrame;

import static Interfaz.TablaPCB.Alinear;

public class MonoProceso extends JTable
{
	private static final long serialVersionUID = -5556145121142915813L;
	
	public ArrayList<Proceso> procesosListos = new ArrayList<>();
	
	protected int indexBloqueo=0, indexListos, indexEjecucion;
	public PuntoFallo pFalloInicio,pFalloAfter;
	
	
	public double quantumEjecucion, contQuantumEje;
	
	protected DefaultTableModel modelo;
	
	private ProcesFrame frame;
	
	public MonoProceso(ProcesFrame pf) 
	{
		frame = pf;
		getTableHeader().setReorderingAllowed(false);
		
		modelo = new DefaultTableModel(){


			private static final long serialVersionUID = 1665629567438060503L;

			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		
		modelo.addColumn("Listo");
		modelo.addColumn("Ejecucion");
		modelo.addColumn("Bloqueado");
		
		getTableHeader().setBackground(Color.white);
		
		this.setModel(modelo);
		
		this.getColumnModel().getColumn(0).setCellRenderer(Alinear);
		this.getColumnModel().getColumn(1).setCellRenderer(Alinear);
		this.getColumnModel().getColumn(2).setCellRenderer(Alinear);
		
	}
	
	public static final int COLUMN_LISTOS = 0, COLUMN_EJECUCION=1, COLUMN_BLOQUEADO = 2;
	
	public void crearTabla(double quantumEje, ArrayList<Proceso> psPCB)
	{
		modelo.setRowCount(0);
		
		
		this.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Ejecucion ("+quantumEje+"Q)");
		this.getTableHeader().repaint();
		
		quantumEjecucion = quantumEje;
		procesosListos = psPCB;
		
		procesoListos();
		
		
	}
	
	private void procesoListos()
	{
		String name;
		
		for(int i=0; i<procesosListos.size(); i++)
		{
			name = procesosListos.get(i).getNombreProceso();
			modelo.addRow(new Object[]{name});
		}
		
	}

	Proceso pAux;
	public int row;
	
	public void ejecutar()
	{
		row = 0;
		frame.setCursor(ProcesFrame.waitCursor);
		timerProceso.start();
	}
	
	public Timer timerProceso = new Timer(1000, new ActionListener() 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			proceso();
		}
	});
	
	private boolean seguir=true;
	
	int x = 2;
	
	private void proceso()
	{
		if(seguir())
		{
			if(pFalloInicio!=null)
			{
				puntoFalloInicio();
				return;
			}
			
			if(pFalloAfter!=null)
			{
				if(puntoFalloDespuesDe())
					return;
			}
			
			pasarEjecucion();
			contQuantumEje+=quantumEjecucion;
			continued();
		}
		else reset();
	}
	
	private boolean puntoFalloDespuesDe()
	{
		if(contQuantumEje+quantumEjecucion>pFalloAfter.nQuantum)
		{
			
			bloquearProcesos();
			
			if(pFalloAfter.duracion<=0)
			{
				modelo.setValueAt("PF(Ciclado)", indexEjecucion++, COLUMN_EJECUCION);
				timerProceso.stop();
				reset();
			}
			else
			{
				modelo.setValueAt("PF", indexEjecucion++, COLUMN_EJECUCION);
				contQuantumEje+=pFalloAfter.duracion;
				pFalloAfter=null;
				//contQuantumEje+=quantumEjecucion;
				continued();
			}
			
			return true;
		}
		
		return false;
	}
	
	private void puntoFalloInicio()
	{
		
		bloquearProcesos();
		
		if(pFalloInicio.duracion<=0)
		{
			modelo.setValueAt("PF(Ciclado)", indexEjecucion++, COLUMN_EJECUCION);
			timerProceso.stop();
			reset();
		}
		
		else 
		{
			modelo.setValueAt("PF", indexEjecucion++, COLUMN_EJECUCION);
			contQuantumEje+=pFalloInicio.duracion;
			pFalloInicio=null;
			continued();
		}
	}
	
	
	
	private void continued()
	{
		timerProceso.stop();
		timerProceso.start();
	}

	private void pasarEjecucion()
	{
		pAux = procesosListos.remove(0);
	
		pAux.contQuantums +=quantumEjecucion;
		frame.tablePCB.setValueAt((float)pAux.contQuantums, pAux.posTable, 2);
		if(pAux.getQuantums()>pAux.contQuantums)
		{
			procesosListos.add(pAux);
			modelo.addRow(new Object[]{pAux.getNombreProceso()});
			modelo.setValueAt(pAux.getNombreProceso()+"/", indexEjecucion, COLUMN_EJECUCION);
		}
		else
		{
			modelo.setValueAt(pAux.getNombreProceso()+" (Ejecutado) ", indexEjecucion, COLUMN_EJECUCION);
		}
		
		modelo.setValueAt(modelo.getValueAt(indexListos, COLUMN_LISTOS)+"/", indexListos, COLUMN_LISTOS);
		indexListos++;
		indexEjecucion++;
	}
	
	private void reset()
	{
		indexEjecucion=indexBloqueo=indexListos=0;
		contQuantumEje=0;
		timerProceso.stop();
		frame.setCursor(null);
		frame.habilitar(true);
		frame.tablePCB.setEnabled(true);
	}
	
	public void bloquearProcesos()
	{
		for(int i=0; i<procesosListos.size(); i++)
		{
			modelo.setValueAt(procesosListos.get(i).getNombreProceso()+"/", 
					indexBloqueo++, COLUMN_BLOQUEADO);
		
			modelo.setValueAt(modelo.getValueAt(indexListos, COLUMN_LISTOS)+"/", indexListos, COLUMN_LISTOS);
			
			modelo.addRow(new Object[]{procesosListos.get(i).getNombreProceso()});
			indexListos++;
		}
		
	}
	
	public boolean seguir()
	{
		return !procesosListos.isEmpty() && seguir;
	}
}
