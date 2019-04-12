package Proyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

public class FileSerGetter
{
	public static int categoriasNum[];
	public static String nombreCat[];
	public static BigDecimal porcentajes[];
	
	public static Object[][] getFormatTable(File ruta, boolean showExce)
	{
		try
		{
			return (Object[][]) Serializa.writeObject(ruta);
		}
		catch(ClassNotFoundException | ClassCastException ex)
		{
			if(showExce)
			JOptionPane.showMessageDialog(null,"Formato de archivo no valido\n"
					+ "El archivo debe estar compilado en formato .table" , 
					"No se pudo abrir el archivo", JOptionPane.ERROR_MESSAGE);

		}
		catch(FileNotFoundException ex)
		{
			if(showExce)
			JOptionPane.showMessageDialog(null,"No existe tal archivo" , 
					"No se pudo abrir el archivo", JOptionPane.ERROR_MESSAGE);
		}
		
		catch(IOException ex)
		{
			if(showExce)
			JOptionPane.showMessageDialog(null,"Archivo corrupto" , 
					"No se pudo abrir el archivo", JOptionPane.ERROR_MESSAGE);
		}
		
		return null;
	}
	
	public static String getFormatText(File ruta,boolean showExce)
	{
		try
		{
			return (String) Serializa.writeObject(ruta);
		}
		catch(ClassNotFoundException | ClassCastException ex)
		{
			if(showExce)
			JOptionPane.showMessageDialog(null,"Formato de archivo no valido\n"
					+ "El archivo debe estar compilado en formato .list" , 
					"No se pudo abrir el archivo", JOptionPane.ERROR_MESSAGE);

		}
		catch(FileNotFoundException ex)
		{
			if(showExce)
			JOptionPane.showMessageDialog(null,"No existe tal archivo" , 
					"No se pudo abrir el archivo", JOptionPane.ERROR_MESSAGE);
		}
		
		catch(IOException ex)
		{
			if(showExce)
			JOptionPane.showMessageDialog(null,"Archivo corrupto" , 
					"No se pudo abrir el archivo", JOptionPane.ERROR_MESSAGE);
		}
		
		return null;
	}
	
	public static boolean determinarDatosTable(Object datos[][])
	{
		
		boolean byPorcentaje = datos[0][1]==null;
		
		int n = datos.length;

		nombreCat = new String[n];
		
		if(byPorcentaje)
		{
			porcentajes = new BigDecimal[n];
		}
		
		else {
			categoriasNum = new int[n];
		}
		
		int i=0;
		
			for(i=0; i<n; i++)
			{
				nombreCat[i] = datos[i][0].toString();
				
				if(nombreCat[i].trim().length()==0)
					throw new NullPointerException();
				
				if(byPorcentaje)
					porcentajes[i] = new BigDecimal(datos[i][2].toString());
					
				else categoriasNum[i] = Integer.parseInt(datos[i][1].toString());
			}
			
			return byPorcentaje;
	}
	
	public static  void determinarDatosLista(String text)
	{
		LinkedHashMap<String, Integer> datos = new LinkedHashMap<String, Integer>();
		
		String cat[] = text.split("-");
		
		for(String key: cat)
		{
			if(!key.equals("-"))
			if(datos.containsKey(key))
			{
				datos.replace(key, datos.get(key)+1);
			}
			else datos.put(key, 1);
		}
		
		nombreCat = new String[datos.size()];
		categoriasNum = new int[datos.size()];
		
		int i=0;
		
		for(String k : datos.keySet())
		{
			nombreCat[i] = k;
			categoriasNum[i] = datos.get(k);
			i++;
		}
	}
	
}
