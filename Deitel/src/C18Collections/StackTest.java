package C18Collections;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Vector;

public class StackTest 
{
	public static void main(String[] args)
	{
		Stack<Number> stack = new Stack <Number> ();
		
		stack.push(12L);
		System.out.println("Pushed 12L");
		printStack(stack);
		stack.push(34567);
		System.out.println( "Pushed 34567" );
		printStack( stack );
		System.out.println( "Pushed 1.0F" );
		printStack( stack );
		stack.push( 1.0F ); // push float value 1.0F
		System.out.println( "Pushed 1234.5678 " );
		printStack( stack );
		stack.push( 1234.5678 ); // push double value 1234.5678
		
		try
		{
			Number removedObject = null;
			
			while(true)
			{
				removedObject = stack.pop();
				System.out.printf( "Popped %s\n", removedObject );
				printStack( stack );
			}
		}
		catch (EmptyStackException emp)
		{
			emp.printStackTrace();
		}
	}
	
	private static void printStack(Stack<Number> stack)
	{
		if (stack.isEmpty())
			System.out.println( "stack is empty\n" ); // the stack is emp
		else // stack is not empty
		System.out.printf( "stack contains: %s (top)\n", stack );
	}
}
