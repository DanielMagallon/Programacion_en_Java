package Practica2;

import java.util.Random;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import static Practica2.ValorTablas.*;

public class TablaSimulada extends JTable
{
	int tiempoTotalInhbil;
	
	DefaultTableModel modelo = new DefaultTableModel() {
		
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
	
	public TablaSimulada() 
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
	
	public void agregarCliente()
	{
		cont++;
		modelo.addRow(new Object[] {cont+1});
	}
	
	public void agregarAleatorios()
	{
		for(int i=0; i<=cont; i++)
		{
			modelo.setValueAt(generarAleatorio(), i, 1);
			modelo.setValueAt(generarAleatorio(), i, 4);
		}
	}
	
	public void reset()
	{
		modelo.setRowCount(0);
		cont=-1;
	}
	
	public int matrizResultado[][];
	
	public int tiempoFinAble,tiempoFinBecker;
	
	public void ejecutar()
	{
		matrizResultado = new int[cont+1][11];
		tiempoFinBecker = tiempoTotalInhbil = 0;
		
		int val,tEspera=0;
		
		val = (int) modelo.getValueAt(0, 4);
		matrizResultado[0][3] = val;
		matrizResultado[0][5] = matrizResultado[0][6] = tiempoFinAble = tiempoServicioAble(val);
		
		
		
		int refTpoIniSer,refTpoSer,refTpoFin;
		
		//Asigna valores a la matriz
		for(int i=1; i<=cont; i++)
		{
			val = (int) modelo.getValueAt(i, 1);
			matrizResultado[i][0] = val; 
			matrizResultado[i][1] = obtenerTiempoLlegada(val);		
			matrizResultado[i][2] = matrizResultado[i][1] + matrizResultado[i-1][2];
			
			val = (int) modelo.getValueAt(i, 4);
			matrizResultado[i][3] = val;
			
			//si se cumple se va con Abel
			if(matrizResultado[i][2]>=tiempoFinAble)
			{
				refTpoIniSer = 4;
				refTpoSer = 5;
				refTpoFin = 6;
				tEspera = 0;
				val =  tiempoServicioAble((int)modelo.getValueAt(i, 4));
			}
			//
			else if(matrizResultado[i][2]>=tiempoFinBecker){
			
				refTpoIniSer = 7;
				refTpoSer = 8;
				refTpoFin = 9;
				tEspera = 0;
				val =  tiempoServicioBecker((int)modelo.getValueAt(i, 4));
			}
			
			else {
				
				if(tiempoFinAble<=tiempoFinBecker)
				{
					refTpoIniSer = 4;
					refTpoSer = 5;
					refTpoFin = 6;
					tEspera = tiempoFinAble - matrizResultado[i][2];
					val =  tiempoServicioAble((int)modelo.getValueAt(i, 4));
					
				}
				else {
					refTpoIniSer = 7;
					refTpoSer = 8;
					refTpoFin = 9;
					tEspera = tiempoFinBecker - matrizResultado[i][2];
					val =  tiempoServicioBecker((int)modelo.getValueAt(i, 4));
				}
			}
			
			matrizResultado[i][refTpoIniSer] = matrizResultado[i][2] + tEspera;
			matrizResultado[i][refTpoSer] = val;
			matrizResultado[i][refTpoFin] = matrizResultado[i][refTpoIniSer]+val;
			
			matrizResultado[i][10] = tEspera;
			tiempoTotalInhbil+=tEspera;
			
			if(refTpoSer==5)
				tiempoFinAble = matrizResultado[i][6];
			else 
				tiempoFinBecker = matrizResultado[i][9];
			
		}
		
		
		
		
		
		pasarDatos();
	}
	
	public String obtenMedidas()
	{
		String x="";

		float tpoProSistemma = (tiempoFinAble>=tiempoFinBecker) ? tiempoFinAble : tiempoFinBecker;
		float promedioSistema = tpoProSistemma / (cont+1);  
		
		
		x = "Tiempo promedio en el sistema: "+promedioSistema+"\n";
		
		//float porcentajeTpoInh =  
		
		return x;
	}
	
	
	public void pasarDatos()
	{
		for(int i=0; i<matrizResultado.length; i++)
		{
			for(int j=0; j<matrizResultado[i].length; j++)
			{
				modelo.setValueAt(matrizResultado[i][j], i, j+1);
			}
		}
	}
}
