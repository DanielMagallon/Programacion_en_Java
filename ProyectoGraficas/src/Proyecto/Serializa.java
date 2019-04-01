package Proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializa 
{
	public static void saveObject(Object obj, File name)
	{
		try 
		{
			  ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(name));
		      salida.writeObject(obj);
		      salida.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	}
	
	@SuppressWarnings("resource")
	public static Object writeObject(File file) throws FileNotFoundException, IOException, 
							ClassNotFoundException
	{
		    ObjectInputStream entrada=new ObjectInputStream(new FileInputStream(file));
			return entrada.readObject();
			
	}
}
