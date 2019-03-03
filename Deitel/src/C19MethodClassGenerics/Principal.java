package C19MethodClassGenerics;

import java.util.ArrayList;
import java.util.List;

public class Principal 
{
	public static void main(String[] args)
	{

		List<Deportista> listaPersonas = new ArrayList<Deportista>();
		listaPersonas.add(new Deportista("futbol"));
		listaPersonas.add(new Deportista("tenis"));
		imprimir(listaPersonas);
	}

	public static void imprimir(List<? extends Persona> lista)
	{

		for (Persona p : lista)
		{

			System.out.println(p.getNombre());
		}

	}
	
	//Asi marca error al mandar a llamar el metodo
//	public static void imprimir(List<Persona> lista)
//	{
//
//		for (Persona p : lista)
//		{
//
//			System.out.println(p.getNombre());
//		}
//
//	}
}