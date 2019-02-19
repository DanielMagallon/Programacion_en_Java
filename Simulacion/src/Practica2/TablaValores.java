package Practica2;

import java.util.Random;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class TablaValores extends JTable
{
	private static final long serialVersionUID = -505198413980669787L;

	public int tablaSim[][],totalInhabil,servicioFinalAbel,servicioFinalBecker;
	
	int clientesEsperaron;
	float valores[] = new float[5];
	
	String reporte[]   =
		{
				"Tiempo promedio en el sistema: ",
				"% de tiempo inhabil: ",
				"Promedio de tiempo de espera por cliente: ",
				"Fraccion que tuvo que esperar: ",
				"Promedio tiempo de esperar clientes en espera: "
		};

	DefaultTableModel modelo = new DefaultTableModel() 
	{
		
		private static final long serialVersionUID = -5275840651333936584L;

		@Override
		public boolean isCellEditable(int row, int column) 
		{
			return column==4 || column == 1;
		}
		
		@Override
		public Class<?> getColumnClass(int column) 
		{
			return Integer.class;
		}
		
	};
	
	
	
	public DefaultTableCellRenderer conf = new DefaultTableCellRenderer();
	
	int cont=-1;
	
	public TablaValores() 
	{
		
		conf.setHorizontalAlignment(SwingConstants.CENTER);
		
		modelo.addColumn("# Cliente");
		modelo.addColumn("Aleatorios arribos");
		modelo.addColumn("Tiempo entre arribos");
		modelo.addColumn("Tiempo de llegada");
		modelo.addColumn("Aleatorios servicio");
		
		modelo.addColumn("Tiempo de inicio");
		modelo.addColumn("Tiemppo de servicio");
		modelo.addColumn("Tiemppo fin");
		
		modelo.addColumn("Tiempo de inicio servicio");
		modelo.addColumn("Tiemppo de servicio");
		modelo.addColumn("Tiemppo fin de servicio");
		
		modelo.addColumn("Tiempo en la fila");
		
		setModel(modelo);
		
		getColumnModel().getColumn(0).setMaxWidth(100);
		
		for(int i=0; i<modelo.getColumnCount(); i++)
		{
			getColumnModel().getColumn(i).setCellRenderer(conf);
		}
		
		
	}
	
	public void nuevoCliente()
	{
		cont++;
		modelo.addRow(new Object[] {cont+1});
	}
	
	public void tablaAleatorios()
	{
		for(int i=0; i<=cont; i++)
		{
			modelo.setValueAt(Aleatorio(), i, 1);
			modelo.setValueAt(Aleatorio(), i, 4);
		}
	}
	
	public void reset()
	{
		modelo.setRowCount(0);
		cont=-1;
	}
	
	public void ejecutar()
	{
		servicioFinalBecker  = clientesEsperaron = 0;
		totalInhabil = 0;
		
		int valorInd,tiempo_Espera=0;
		
		valorInd = (int) modelo.getValueAt(0, 4);
		tablaSim = new int[cont+1][11];
		tablaSim[0][3] = valorInd;
		servicioFinalAbel = tiempos_SerAble(valorInd);
		tablaSim[0][5] = tablaSim[0][6] = servicioFinalAbel;
		
		
		
		int tpoIniSer,tpoServicio,tpoFinServ;
		
		//Asigna valores a la matriz
		for(int i=1; i<=cont; i++)
		{
			valorInd = (int) modelo.getValueAt(i, 1);
			tablaSim[i][0] = valorInd; 
			tablaSim[i][1] = tiempos_Llegada(valorInd);		
			tablaSim[i][2] = tablaSim[i][1] + tablaSim[i-1][2];
			
			valorInd = (int) modelo.getValueAt(i, 4);
			tablaSim[i][3] = valorInd;
			
			//si se cumple se va con Abel
			if(tablaSim[i][2]>=servicioFinalAbel)
			{
				tpoIniSer = 4;
				tpoServicio = 5;
				tpoFinServ = 6;
				tiempo_Espera = 0;
				valorInd =  tiempos_SerAble((int)modelo.getValueAt(i, 4));
			}
			//
			else if(tablaSim[i][2]>=servicioFinalBecker){
			
				tpoIniSer = 7;
				tpoServicio = 8;
				tpoFinServ = 9;
				tiempo_Espera = 0;
				valorInd =  tiempos_ServBecker((int)modelo.getValueAt(i, 4));
			}
			
			else {
				
				if(servicioFinalAbel<=servicioFinalBecker)
				{
					tpoIniSer = 4;
					tpoServicio = 5;
					tpoFinServ = 6;
					tiempo_Espera = servicioFinalAbel - tablaSim[i][2];
					valorInd =  tiempos_SerAble((int)modelo.getValueAt(i, 4));
					
				}
				else {
					tpoIniSer = 7;
					tpoServicio = 8;
					tpoFinServ = 9;
					tiempo_Espera = servicioFinalBecker - tablaSim[i][2];
					valorInd =  tiempos_ServBecker((int)modelo.getValueAt(i, 4));
				}
				
				clientesEsperaron++;
				totalInhabil+=tiempo_Espera;
			}
			
			tablaSim[i][tpoIniSer] = tablaSim[i][2] + tiempo_Espera;
			tablaSim[i][tpoServicio] = valorInd;
			tablaSim[i][tpoFinServ] = tablaSim[i][tpoIniSer]+valorInd;
			
			tablaSim[i][10] = tiempo_Espera;
			
			if(tpoServicio==5)
				servicioFinalAbel = tablaSim[i][6];
			else 
				servicioFinalBecker = tablaSim[i][9];
			
		}
		
		copiar();
		reporte();
		
	}
	
	public void reporte()
	{

		float tpoTotSistemma = (servicioFinalAbel>=servicioFinalBecker) ? servicioFinalAbel : servicioFinalBecker;
		valores[0] = tpoTotSistemma / (cont+1);
	
		valores[1] = (totalInhabil/tpoTotSistemma)*100;
		
		valores[2] = (float) ((float)totalInhabil/(cont+1));
		
		valores[3] = (float) ((float)clientesEsperaron/(cont+1));
		 
		valores[4] = (float)totalInhabil/ (float)clientesEsperaron;
	}		 
	
	public void copiar()
	{
		for(int i=0; i<tablaSim.length; i++)
		{
			for(int j=0; j<tablaSim[i].length; j++)
			{
				modelo.setValueAt(tablaSim[i][j], i, j+1);
			}
		}
	}
	
	public  int tiempos_Llegada(int random)
	{
			if(random<=30)
				return 1;
			
			if(random<=70)
				return 2;
			
			if(random<=85)
				return 3;
			
			
			return 4;
	}
	
	public  int tiempos_SerAble(int random)
	{
			if(random<=30)
				return 2;
			
			if(random<=58)
				return 3;
			
			if(random<=83)
				return 4;
			
			return 5;
	}
	
	public  int tiempos_ServBecker(int random)
	{
			if(random<=35)
				return 3;
			
			if(random<=60)
				return 4;
			
			if(random<=80)
				return 5;
			
			return 6;
	}

	Random lb = new Random();
	public  int Aleatorio()
	{
		return lb.nextInt(100)+1;
	}
}

