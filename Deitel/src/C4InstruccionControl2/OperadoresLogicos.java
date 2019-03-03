package C4InstruccionControl2;

// Operadores logicos y tablas de verdad




public class OperadoresLogicos 
{
	public static void main(String[] args) 
	{
		// crea una tabla de verdad para el operador && (AND condicional)
		System.out.printf ( "%s\n%s: %b\n%s: %b\n%s: %b\n%s: %b\n\n ",
				"AND condicional (&&)", "false && false",( false && false ),
				"false && true",( false && true ),
				"true && false", ( true && false),
				"true && true", (true && true) );
		
		// crea una tabla de verdad para el operador || (OR condicional)
		System.out.printf ( "%s\n%s: %b\n%s: %b\n%s: %b\n%s: %b\n\n ",
				"OR condicional (||)", "false || false",( false || false ),
				"false || true",( false || true ),
				"true || false", ( true || false),
				"true || true", (true || true) );
		
		// crea una tabla de verdad para el operador & (AND logico booleano)
		System.out.printf ( "%s\n%s: %b\n%s: %b\n%s: %b\n%s: %b\n\n ",
				"AND logico booleano (&)", "false & false",( false & false ),
          		"false & true",( false & true ),
				"true & false", ( true & false),
				"true & true", (true & true) );
		
		// crea una tabla de verdad para el operador | (OR inclusivo logico booleano)
		System.out.printf ( "%s\n%s: %b\n%s: %b\n%s: %b\n%s: %b\n\n ",
				"OR inclusivo logico booleano (|)", "false | false",( false | false ),
		        "false | true",( false | true ),
				"true | false", ( true | false),
				"true | true", (true | true) );
		
		// crea una tabla de verdad para el operador ^ (OR exclusivo logico booleano)
		System.out.printf ( "%s\n%s: %b\n%s: %b\n%s: %b\n%s: %b\n\n ",
				"OR exclusivo logico booleano (^)", "false ^ false",( false ^ false ),
				"false ^ true",( false ^ true ),
				"true ^ false", ( true ^ false),
				"true ^ true", (true ^ true) );
		
		// crea una tabla de verdad para el operador negacion logica ! (negacion logica)
		System.out.printf ( "%s\n%s: %b\n%s: %b\n", "NOT logico (!)",
				"!false", (!false), "!true", (!true) );
	}
}
