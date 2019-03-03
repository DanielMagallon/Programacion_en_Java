package JavaSE8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

public class Funcional 
{
	static boolean isPar(Integer n){
		return n % 2 == 0;
	}
	
	public static void main(String[] args)
	{
		List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		List<Integer> resultados = new ArrayList<Integer>();
		
		//funcional, declarativo, que es lo que quiero hacer?
		resultados = numeros.stream()
					 //.filter(Funcional::isPar)
					 //.filter((Integer n) -> {return n % 2 == 0;})//lambda --> funcion (metodo) anonima
					 .filter(n -> n % 2 == 0)
					 .collect(Collectors.toList());
		
		
		//Imperativa, tradicional, como lo hare
		/*for(Integer i : numeros)
			if (i%2==0)
				resultados.add(i);*/
		
		System.out.println(resultados);
	}
}
