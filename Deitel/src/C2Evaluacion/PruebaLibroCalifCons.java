package C2Evaluacion;

import java.util.Scanner;


public class PruebaLibroCalifCons 
	{
	
		public static void main (String[] args) 
		{
Scanner input=new Scanner (System.in);
			
			LibroCalifConstruc lc = new LibroCalifConstruc("Diseño de Bases de Datos", "Edgar Magallon");
					
					System.out.println ("Cusro: "+ lc.ObtenerNombreCurso());
					System.out.println ("Instructor: " + lc.ObtenerNombreIns());
					System.out.println();
					lc.Mostrarmensaje();
					System.out.println();
					
					System.out.println("-----------------------------------------------------------------------");
					
					LibroCalifConstruc lc1 = new LibroCalifConstruc("", "");		
			
					String nc,nis;
					
					System.out.println("Dame el nombre del cusro: ");
					nc=input.nextLine();
					lc1.establecerNombreCurso(nc);
					System.out.println();
					
					System.out.println("Dame el nombre del instructor: ");
					nis=input.nextLine();
					lc1.establecerNombreIns(nis);
					System.out.println();
			
					System.out.println ("Cusro: "+ lc1.ObtenerNombreCurso());
					System.out.println ("Instructor: " + lc1.ObtenerNombreIns());
					System.out.println();
					
					lc1.Mostrarmensaje();
		} 
	} 
