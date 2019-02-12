package Unidad3;

public class ExpresionPila //Evaluar parentesis
{
	String exp;
	
	public ExpresionPila(String expresion)
	{
		exp = expresion;
	}
	
	public boolean evaluar()
	{
		int size = exp.length();
		
		PilaVector pvc = new PilaVector(size);
		
		char c;
		
		try
		{
		for(int i=0; i<exp.length(); i++)
		{
			c = exp.charAt(i);
			
			if(c == '(')
				pvc.push(1);
			
			else if(c == ')')
				pvc.pop();
		}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return false;
		}
		
		return (pvc.isEmpty() || pvc.size() == 1);
			
		
//		Stack<Integer> pila = new Stack<>();
//		char c;
//		
//		for(int i=0; i<exp.length(); i++)
//		{
//			c = exp.charAt(i);
//			
//			if(c == '(')
//				pila.push(1);
//			
//			else if(c == ')')
//				pila.pop();
//		}
//		
//		System.out.println("Pila: "+pila);
	}
	
	public static void main(String[] args)
	{
		System.out.println(new ExpresionPila("((a+b)*(a-d)").evaluar());
	}
}
