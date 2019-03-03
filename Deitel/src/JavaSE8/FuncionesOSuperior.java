package JavaSE8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class FuncionesOSuperior
{
	public static void main(String[] args)
	{
		//Orden Superior
		// es una funcion -> funcion como argumento o, regresar una funcion
		List<Integer> numeros = Arrays.asList(5,-5,2,-2,7,-7,4,0,12,-24,32,-64,128);
		
		BiFunction<
				  List<Integer>,
				  Predicate<Integer>,
				  List<Integer>
				  > filtrar;
		
		filtrar = (list,predicado) -> {
			List<Integer> result = new ArrayList<>();
			
			for (Integer i : list)
				if(predicado.test(i))
					result.add(i);
			return result;
		};

		System.out.println(filtrar.apply(numeros, 
				x -> x<0)
				);
	}
}
