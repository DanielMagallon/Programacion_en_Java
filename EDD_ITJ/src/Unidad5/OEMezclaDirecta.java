
package Unidad5;

import java.io.File;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class OEMezclaDirecta
{
	
	public FileInteger archivoOriginal, arch1,arch2;
	
	public OEMezclaDirecta(String archivo)
	{
		String ruta = System.getProperty("user.dir")+"/src/";
		archivoOriginal = new FileInteger(ruta+archivo);
		arch1 = new FileInteger(ruta+"Files/arch1.data");
		arch2 = new FileInteger(ruta+"Files/arch2.data");
	}
	
	public void cerrarTodo()
	{
		archivoOriginal.close();
		arch1.close();
		arch2.close();
	}
	
	public void agregarValores(int val)
	{
		
		archivoOriginal.grabar(val,archivoOriginal.getNumeroElementos());
	}
	
	
	public void aleatorios(int tam)
	{
		Random lb = new Random();
		int num;
		archivoOriginal.borrar();
		for(int i=0; i<tam; i++)
		{
			num = 1+lb.nextInt(300);
			archivoOriginal.grabar(num);
		}
	}
	
	public void mezcla()
	{
		int tamPart = 1;
		archivoOriginal.reporte();
		
		do
		{
			repartir(tamPart);
			System.out.println("======="+tamPart+"=======");
			arch1.reporte();
			arch2.reporte();
			fusion(tamPart);
			System.out.println("=======Archvio Original========");
			archivoOriginal.reporte();
			tamPart*=2;
		}
		while(tamPart<archivoOriginal.getNumeroElementos());
	}
	
	public void repartir(int tam)
	{
		arch1.borrar();
		arch2.borrar();
		archivoOriginal.reset();
		
		int num = archivoOriginal.leer();
		int i,pos=1;
		
		while(num!=-1)
		{
			
			for(i=0; i<tam; i++)
			{
				arch1.grabar(num);
				num = archivoOriginal.leer(pos++);
			}
			
			for(i=0; i<tam; i++)
			{
				if(num!=-1)
				{
					arch2.grabar(num);
					num = archivoOriginal.leer(pos++);
				}
			}
		}
	}
	
	public void fusion(int tam)
	{
		archivoOriginal.borrar();
		arch1.reset();
		arch2.reset();
		
		int num1 = arch1.leer();
		int num2 = arch2.leer();
		
		int tp1=0,tp2=0, posN1=1,posN2=1;
		
		do
		{
			while(num1!=-1 && tp1<tam && num2!=-1 && tp2<tam)
			{
				if(num1<num2)
				{
					if(num1!=-1)
					{
						archivoOriginal.grabar(num1);
						num1 = arch1.leer(posN1++);
						tp1++;
					}
				}else{
					if(num2!=-1)
					{
						archivoOriginal.grabar(num2);
						num2 = arch2.leer(posN2++);
						tp2++;
					}
				}
				
			}
			
			if(tp1==tam && num2!=-1)
			{
				do{
					archivoOriginal.grabar(num2);
					num2 = arch2.leer(posN2++);
					tp2++;
				}
				while(tp2<tam && num2!=-1);
			}
			else if(tp2==tam && num1!=-1)
			{
				do{
					archivoOriginal.grabar(num1);
					num1 = arch1.leer(posN1++);
					tp1++;
				}
				while(tp1<tam && num1!=-1);
			}
			
			tp1=0;
			tp2=0;
			
		}
		while(num1!=-1 && num2!=-1);
		
		if(num1!=-1)
		{
			do{
				archivoOriginal.grabar(num1);
				num1 = arch1.leer(posN1++);
				
			}while(num1!=-1);
		}
		
		if(num2!=-1)
		{
			do{
				archivoOriginal.grabar(num2);
				num2 = arch2.leer(posN2++);
				
			}while(num2!=-1);
		}
	}
	
	public static void main(String[] args)
	{
		
		OEMezclaDirecta oe = new OEMezclaDirecta("/Files/ArchivoOriginal.data");
		
		oe.aleatorios(100);
		oe.mezcla();
		
		oe.cerrarTodo();
	}
	
	
	/*
	 * Mezcla directa,natural-> Intercalacion directa
	 */
	
	/**
	 * Intercalacion directa:
	 *
	 * TamañoPart = 1; //Que un numero lo pone en el primero y otro en el segundo, siguiendo asi la secuencia
	 * 
	 * ArchO = 80 17 65 48 250 43 115 17 33 73
	 * 
	 * Arch1: 80 | 65 | 250 | 115 | 33
	 * Arch2: 17 | 48 | 43  |  17 |73 
	 * 
	 * Borramos el contenido del ArhcO;
	 * 
	 * De acuerdo al tamaño de particion ordenas los archivos
	 * 
	 * Como tamaño part = 1; ordena el primer elemneto de Arch1, y el primer elemento de Arch2, y los pone de
	 * menor a mayor;
	 * 
	 * Los ordenamos en el ArchO = 17 80 48 65 43 250 17 115 33 73
	 * 
	 * Tamaño de Part = 2
	 * Arch1: 17  80 | 43 250 | 33 73
 	 * Arch2: 48  65 | 17 115 |
 	 * 
 	 * ArchO = 17 48 65 80  17 43 115 250 33 73
 	 * 
 	 * Tamaño de part = 4;
 	 * Arch1: 17 48 65 80  | 33 73
 	 * Arch2 17 43 115 250 |
 	 * 
 	 * ArchO = 17 17 43 48 65 80 115 250 - 33 73
 	 * 
 	 * TamañoPart = 8;
 	 * 
 	 * Arch1: 17 17 43 48 65 80 115 250
 	 * Arch2: 33 73
 	 * ArchO = 17 17 33 43 48 65 73 80 115 250 (Listo) 
 	 * 
 	 * Hcaer esto mientras tamañoPart <=  numero de elementos
 	 */
}
