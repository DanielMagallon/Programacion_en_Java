package SimpleTron;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Intrucciones
{
	final static int LEE = 10;
	final static int ESCRIBE = 11;
	
	final static int CARGA = 20;
	final static int ALMACENA = 21;
	
	final static int SUMA = 30;
	final static int RESTA = 31;
	final static int DIVIDE = 32;
	final static int MULTIPLICA = 33;
	
	final static int BIFURCA = 40;
	final static int BIFURCANEG = 41;
	final static int BIFURCACERO = 42;
	final static int ALTO = 43;
	
	private static List<Integer> operando = new ArrayList<>();
	private static List<Integer> ubicacion = new ArrayList<>(); 
	private static String[]arreglo;
	private static int ind;
	private static StringBuffer err;
	private static boolean errorLength=false;
	
	public static void Compilar(String flujo, int index)
	{		
		ind=index;
		arreglo = flujo.trim().replaceAll("[\n\r]", "").split("[;]");
		 
		if(noError())
		for (String vec : arreglo) 
			addToArray(vec);

		arreglo=null;
		err=null;
	}
	
	private static boolean noError()
	{
		err = new StringBuffer();
		
		for (String vc : arreglo)
		{
			if(vc.length()!=4)
			{
				errorLength=true;
				err.append("Error en el numero: "+vc+", el tamanio de cada numero debe ser de 4\n");
			}
		}
		
		
		LMS.principal.get(ind).consola.setText( (errorLength) ? err.toString() : "");
		
		return !errorLength;
	}

	
	
	private static void addToArray(String cad)
	{
		int codigo = Integer.parseInt(cad);
		
		operando.add(codigo/100);
		ubicacion.add(codigo%100);
	}
	
	public static void Ejecutar()
	{
		
	}
}
