package Unidad5;

import java.util.Random;

public class OEMezclaNatural
{
	
	public FileInteger archivoOriginal, arch1,arch2;
	
	public OEMezclaNatural(String archivo)
	{
		String ruta = System.getProperty("user.dir")+"/src/";
		archivoOriginal = new FileInteger(ruta+archivo);
		arch1 = new FileInteger(ruta+"Files/arch1.data");
		arch2 = new FileInteger(ruta+"Files/arch2.data");
	}
	
	public void aleatorios(int tam)
	{
		archivoOriginal.borrar();
		Random lb = new Random();
		int num;
		archivoOriginal.borrar();
		for(int i=0; i<tam; i++)
		{
			num = 1+lb.nextInt(300);
			archivoOriginal.grabar(num);
		}
	}
	
	public  void mezcla()
	{
		
		System.out.print("ArchO: "); archivoOriginal.reporte();
		do
		{
			repartir();
			
			System.out.print("Arch1: "); arch1.reporte();
			System.out.print("Arch2: "); arch2.reporte();
			
			if(arch2.getNumeroElementos()!=0)
				fusion();

			System.out.print("ArchO: "); archivoOriginal.reporte();
			
//			try
//			{
//				Thread.sleep(1000);
//			} catch (InterruptedException e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		}
		while(arch2.getNumeroElementos()!=0);
	}
	
	public void mezclaProgramada()
	{
		
		//Este proceso asingna letras el archivo (los guuarda como enteros, por su ascii)
		// y para mostrarlos como letras se usa el metodo reporteChar();
		
/*		char vec1[] = {'a','m','c','b','c','f','w','g','e','h','i','j','a','p','q','r','s'};
		
		archivoOriginal.borrar();
		
		for(int i=0; i<vec1.length; i++)
			archivoOriginal.grabar(vec1[i]);

		System.out.print("ArchO: "); archivoOriginal.reporteChar();
	*/
		
		int vec1[] = {15,24,22,27,13,45,12,37,33};
		
		archivoOriginal.borrar();
		
		for(int i=0; i<vec1.length; i++)
			archivoOriginal.grabar(vec1[i]);
		
		System.out.print("ArchO: "); archivoOriginal.reporte();
		repartir();
		
		System.out.print("Arch1: "); arch1.reporte();
		System.out.print("Arch2: "); arch2.reporte();
	}
	
	public  void repartir()
	{
		archivoOriginal.reset();
		arch1.borrar();
		arch2.borrar();
		int pos=0;
		int num = archivoOriginal.leer(pos++);
		int ant = 0;
		boolean a1=true;
		
		while(num!=-1)
		{
			if(num>=ant)
			{
				if(a1)
				{
					a1 = true; 
				}
				else
				{
					a1=false; 
				}
			}
			else{
				
				if(a1)
				{
					a1=false;
				}
				else{
					a1 = true;
				}
			
			}
			
			if(a1)
			{
				arch1.grabar(num);
				ant = num;
				num = archivoOriginal.leer(pos++);
			}
			else{
				arch2.grabar(num);
				ant = num;
				num = archivoOriginal.leer(pos++);
			}
			
		}
	}
	
	public  void fusion()
	{
		arch1.reset();
		arch2.reset();
		
		int pos1=0, pos2=0;
		
		int num1 = arch1.leer(pos1++);
		int num2 = arch2.leer(pos2++);
		
		archivoOriginal.borrar();
		
		do
		{
			
			if(num1<num2)
			{
				archivoOriginal.grabar(num1);
				num1 = arch1.leer(pos1++);
			}
			else{
//				if(num2!=-1)
				{
				archivoOriginal.grabar(num2);
				num2 = arch2.leer(pos2++);
				}
			}
			
		}
		while(num1!=-1 && num2!=-1);
		
		
		if(num1!=-1)
		{
			do
			{
				archivoOriginal.grabar(num1);
				num1 = arch1.leer(pos1++);
				
			}while(num1!=-1);
		}
		
		if(num2!=-1)
		{
			do
			{
				archivoOriginal.grabar(num2);
				num2 = arch2.leer(pos2++);
				
			}while(num2!=-1);
		}
		
	}
	
	public void cerrarTodo()
	{
		archivoOriginal.close();
		arch1.close();
		arch2.close();
	}

	public static void main(String[] args)
	{
		OEMezclaNatural oe = new OEMezclaNatural("/Files/ArchivoOriginal.data");
		
//		oe.aleatorios(40);
//		oe.mezcla();
		oe.mezclaProgramada();
		oe.cerrarTodo();
	}
}
