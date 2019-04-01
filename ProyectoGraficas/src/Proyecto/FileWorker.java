package Proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;

public class FileWorker
{
	private static boolean elimated;
	private static String carpetaRecurso; 
	public static void moveDelete(File sourceLocation, File targetLocation,String mk)
	{
			{
				elimated = 
					(JOptionPane.showConfirmDialog(null, String.format
					("La carpeta del directorio %s sera copiado a la ruta\n%s\n"
					+ "Desea que se elimen los archivos y carpetas del directorio %s?", 
					sourceLocation.getPath(),carpetaRecurso,sourceLocation.getPath()),	"Copiando archivos", 
					JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE)) == JOptionPane.OK_OPTION ;
				
				try
				{
					copy(sourceLocation, targetLocation, mk);
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(elimated)
					sourceLocation.delete();
			}
	}

	
	public static boolean mkdirRecursos(File rutaName)
	{
		System.out.println("Creando carpeta: "+rutaName);
		if(!rutaName.exists())
		{
			carpetaRecurso = rutaName.getPath();
			rutaName.mkdir();
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "La carpeta tal ya existe");
			return false;
		}
	}
	
	private static void copy(File sourceLocation, File targetLocation,String mk) throws IOException 
	{
		System.out.println("Copiando: "+sourceLocation.getPath());
		
		    if (sourceLocation.isDirectory()) 
		    {
		        copyDirectory(sourceLocation, targetLocation,mk);
		    } else {
		        copyFile(sourceLocation, targetLocation);
		    }
	}
		
	private static void copyDirectory(File source, File target, String mk) throws IOException
	{
		File carpeta = new File(target.getPath() + "/" + mk + "/");
		carpeta.mkdir();
		
		System.out.println("Creando carpeta: "+carpeta.getPath());

		for (String f : source.list())
		{
			copy(new File(source, f), new File(carpeta, f), mk);
		}

	}
	
	private static void copyFile(File source, File target) throws IOException {        
	    try (
	            InputStream in = new FileInputStream(source);
	            OutputStream out = new FileOutputStream(target)
	    ) {
	        byte[] buf = new byte[1024];
	        int length;
	        while ((length = in.read(buf)) > 0) {
	            out.write(buf, 0, length);
	        }
	        if(elimated)
	        	source.delete();
	        out.close();
	        in.close();
	    }
	}

}

