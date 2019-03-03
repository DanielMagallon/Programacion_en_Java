package C3Evaluacion;


public class Patron_damas_astericos 
{
		public static void main(String[] args) 
		{
		
			System.out.println("Patron de damas de  8x8");
			System.out.println();
			
			int fila=8;
			int columna;
			
			int linea=1;
			int n1=1,n2=2;
			int l,l2;
			
		while (linea<=64)
		{
			if (linea==n1)
			{
				l=1;
				
				while (l<=8)
				{
				System.out.print ("* ");
				l++;
				n1 += 2;
				if (l>8)
				{
					System.out.println();
				}
				}
			}
			
			
			if (linea==n2)
			{
				l2=1;
				while (l2<=8)
				{
				System.out.print (" *");
				l2++;
				n2 += 2;
				if (l2>8)
				{
					System.out.println();
				}
				}
			}
		
			linea++;
		}
		
		System.out.println();
		System.out.println();
		
			 while (fila>=1)
			{
				columna=1;
				
				while (columna<=8)
				{
					System.out.print (fila % 2 == 1 ? "* " : " *");
					++columna;
				}
				
				--fila;
				System.out.println();
			} 
			
			
		}
}
