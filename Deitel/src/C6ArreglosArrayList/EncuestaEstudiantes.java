package C6ArreglosArrayList;

public class EncuestaEstudiantes
{
	public static void main(String[] args)
	{
		// arreglo de respuestas de estudiantes (lo mas comun es que se introduzcan en tiempo de ejecucion)
		
		int [] respuestas = {1,2,5,4,3,5,2,1,3,3,1,4,3,3,3,2,3,3,2,14};
		
		int [] frecuencia = new int [6];
		
		// para cada respuesta, selecciona el elemento de respuestas y usa ese valor 
		// como indice de frecuencia para determinar el elemnto a incrementar
		
		for (int respuesta=0; respuesta < respuestas.length; respuesta++)
		{
			
			try 
			{
				++ frecuencia [respuestas[respuesta]];
			} // fin de try
			
			catch (ArrayIndexOutOfBoundsException e)
			{
				
				System.out.println(e);
				System.out.printf ("   respuestas [%d] = %d\n\n",
						respuesta,respuestas[respuesta]);
				
			} // fin de catch 
		}
		
		System.out.printf (" %s %10s\n", "Calificacion", "Frecuencia");
		
		// imprime el valor de cada elemnto del arreglo
		
		for (int calificacion=1; calificacion < frecuencia.length; calificacion++)
			System.out.printf ("%6d %10d\n",calificacion,frecuencia[calificacion]);
	}
}
