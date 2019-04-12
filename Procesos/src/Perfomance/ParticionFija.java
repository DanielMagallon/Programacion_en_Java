package Perfomance;

import java.util.ArrayList;

public class ParticionFija {

	private int tamanoParticiones[];
	private int tamanoTareas[];
	private int cont, particionMayor, inidiceTareas;
	
	public String tablaValores[][];
	
	public ParticionFija(int particiones[], int tareas[]) 
	{
		tamanoParticiones = particiones;
		tamanoTareas = tareas;
		tablaValores = new String[particiones.length][4];
		llenarTablaDef();
		particionMayor();
	}
	
	private void llenarTablaDef()
	{
		for(int i=0; i<tablaValores.length; i++)
		{
			tablaValores[i][0] = "P"+(i+1);
			tablaValores[i][1] = tamanoParticiones[i]+"";
			tablaValores[i][2] = " - ";
			tablaValores[i][3] = "Libre";
		}
		
		mostrarTablaValores();
	}
	
	public void mostrarTablaValores()
	{
		for(String x[] : tablaValores)
		{
			for(String y : x)
				System.out.print(y+" ");
			
			System.out.println();
		}
	}
	
	public ParticionFija setSizeParticion(int particiones[])
	{
		tamanoParticiones = particiones;
		return this;
	}
	
	public ParticionFija setSizeTareas(int tareas[])
	{
		tamanoTareas = tareas;
		return this;
	}

	private void particionMayor()
	{
		inidiceTareas=0;
		particionMayor = tamanoParticiones[0];
		
		for(int i=1; i<tamanoParticiones.length; i++)
		{
			if(particionMayor<tamanoParticiones[i])
			{
				particionMayor = tamanoParticiones[i];
			}
		}

		rechazarTareas();
	}
	
	private void rechazarTareas()
	{
//		int cont=0, i,arr[];
		int i;
		
		for(i=0; i<tamanoTareas.length; i++)
		{
//			if(tamanoTareas[i]<=0)
//				cont++;
			
			if(tamanoTareas[i]>particionMayor)
			{
				tamanoTareas[i]=0;
//				cont++;
			}
		}
		
//		arr = new int[tamanoTareas.length-cont];
//		
//		for(i=0, cont=0; cont<arr.length; i++)
//		{
//			if(tamanoTareas[i]>0)
//			{
//				arr[cont++] = tamanoTareas[i];
//			}
//		}
//		
//		tamanoTareas = arr;
//		arr=null;
//		
//		System.out.println("Las tareas que quedaron son: ");
//		for(int t : tamanoTareas)
//			System.out.println("- "+t);
			
	}
	
	private ArrayList<String> colaEspera = new ArrayList<>();
	
	public void proceso()
	{
		boolean asig;
		
		while(inidiceTareas<tamanoTareas.length)
		{
			asig = false;
			cont=0;
			
			if(tamanoTareas[inidiceTareas]>0)
			{
				while(cont<tamanoParticiones.length)
				{
					if(tamanoTareas[inidiceTareas]>tamanoParticiones[cont])
					{
						cont++;
					}
					else if(tablaValores[cont][3].equalsIgnoreCase("Libre"))
					{
						tablaValores[cont][2] = "T"+(inidiceTareas+1);
						tablaValores[cont][3] = "Ocupado";
						asig=true;
						break;
					}
					else cont++;
				}
				
				if(!asig)
				{
					colaEspera.add("T"+(inidiceTareas+1));
				}
				
			}
			inidiceTareas++;
		}
	}
	
	public void mostrarColaEspera()
	{
		System.out.print("Tareas en cola de espera: "+colaEspera);
	}
	
	public static void main(String[] args) {
		
		ParticionFija p = new ParticionFija(new int[]{100,25,25,50,30,40}, new int[]{/*10,25,200,100*/80,90,30,25,25,40});
		System.out.println("----");
		p.proceso();
		p.mostrarTablaValores();
		p.mostrarColaEspera();
	}
}
