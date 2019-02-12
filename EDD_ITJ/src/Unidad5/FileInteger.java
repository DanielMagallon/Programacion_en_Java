package Unidad5;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileInteger
{
	RandomAccessFile archivo;
	
	public FileInteger()
	{
		archivo = null;
	}
	
	public FileInteger(String ruta)
	{
		open(ruta);
	}
	
	public void open(String ruta)
	{
		try
		{
			archivo = new RandomAccessFile(ruta, "rw");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("No se encontro");
		}
	}
	
	public void grabar(int num)
	{
		try
		{
			archivo.seek(archivo.length());
			archivo.writeInt(num);
			
		} 
		catch (IOException e)
		{
			System.out.println("Error de lectura");
		}
	}
	
	public void grabar(int num, long pos)
	{
		
		try
		{
			archivo.seek(pos*4); // Salta por bytes, cada numero ocupa 4 bytes
			archivo.writeInt(num);
			
		} 
		catch (IOException e)
		{
			System.out.println("Error de lectura");
		}
	}
	
	public void close()
	{
		try
		{
			archivo.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int leer()
	{
		int num=0;
		reset();
		
		try
		{
			num = archivo.readInt();
		}
		catch(EOFException e){
			num=-1;
		}
		catch(IOException e){
			num=-2;
		}
		
		return num;
	}
	
	public int leer(int pos)
	{
		int num;
		
		try
		{
			archivo.seek(pos*4);
			num = archivo.readInt();
			
		}
		catch(EOFException e){
			num=-1;
		}
		catch(IOException e){
			num=-2;
		}
		
		return num;
	}
	
	public void reset()
	{
		try
		{
			archivo.seek(0L);
		}
		catch(IOException e){
			
		}
	}
	
	public void borrar()
	{
		try
		{
			archivo.setLength(0L);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public long getNumeroElementos()
	{
		long n=0;

		
			try
			{
				n = archivo.length()/4;
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			} 
		
		return n;
	}
	
	public void reporte()
	{
		reset();
		int num = 0, pos=0;
		
		do
		{
			num = leer(pos++);
			
			if(num!=-1)
				System.out.print(num+" ");
			
		}
		while(num!=-1);
		
		System.out.println();
	}
	
	public void reporteChar()
	{
		reset();
		int num = 0, pos=0;
		
		do
		{
			num = leer(pos++);
			
			if(num!=-1)
				System.out.print((char)num+" ");
			
		}
		while(num!=-1);
		
		System.out.println();
	}
}

