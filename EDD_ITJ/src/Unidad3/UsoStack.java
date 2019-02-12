package Unidad3;

import java.util.Stack;

public class UsoStack
{
	public static void main(String[] args)
	{
		//<> moddle
		Stack<Integer> pila = new Stack<>();
		
		if(pila.empty())
			System.out.println("Pila vacia");
		
		
		pila.push(33);
		pila.push(15);
		pila.push(17);
		pila.push(90);

		System.out.println(pila);
		
		System.out.println("Elemento de la cima: "+pila.peek());
		System.out.println("Numero de pops para 15: "+pila.search(15));
		
		String exp1 = "((a+b)^2*(c-b))";
		String exp2 = "((a*b)-c+(a*b)))";
		String exp3 = "(((c*d-b)^3)))";
		
		System.out.println(exp1+": "+expresion(exp1));
		System.out.println(exp2+": "+expresion(exp2));
		System.out.println(exp3+": "+expresion(exp3));
	}
	
	static boolean expresion(String exp)
	{
		Stack<Integer> pila = new Stack<>();
 		//

		for(int i=0; i<exp.length(); i++)
		{
			if(exp.charAt(i)=='(')
				pila.push(1);
			else if(exp.charAt(i) == ')')
			{
				if(pila.empty())
					return false;
				
				pila.pop();
			}
		}
		
		return pila.empty();
	}
}
