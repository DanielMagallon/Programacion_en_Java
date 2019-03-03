package C6ArreglosArrayList;

public class GraficoBarras
{
	public static void main(String[] args)
	{
		int [] arreglo = {0,0,0,0,0,0,1,2,4,2,1};
		
		System.out.println(" Distribucion de calificaciones:");
		
		// para cada elemnto del arreglo, imprime una barra del grafico
		
		for (int contador=0; contador < arreglo.length; contador++)
		{
			if (contador==10)
				System.out.printf ("%5d: ", 100);
			
			else
				System.out.printf ("%02d-%02d: ",contador*10,contador*10+9);
			
			// imprime la barra de asteriscos
			for (int estrellas = 0; estrellas < arreglo[contador]; estrellas++)
				System.out.print ("*");
			
			System.out.println();
		}
 	}
}
