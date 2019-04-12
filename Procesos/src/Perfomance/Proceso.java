package Perfomance;

//import java.util.ArrayList;

public class Proceso 
{
	private String nombreProceso;
	private double quantums;
	
	public double contQuantums;
	
	public static int contProc=1;
	
	public int posTable;
	
	public PuntoFallo pFInicio,PFDespuesDe;
	
	public Proceso(String nombre, double quantum, int posTable)
	{
		this.posTable = posTable;
		nombreProceso =  nombre;
		quantums = quantum;
	}
	
	public String getNombreProceso()
	{
		return nombreProceso;
	}
	
	public double getQuantums()
	{
		return quantums;
	}
	
	public static String getProcessCount()
	{
		return "P"+contProc;
	}
	
	@Override
	public String toString() 
	{
		return String.format("%4s%7s\n",nombreProceso,quantums);
	}
}
