package C5Metodos;

// demostrar los alcances de los campos y las variables locales.

public class Alcance 
{
	// campo accsesible para todos los metodos de esta clase 
	private static int x = 1;
	
	// el metodo main crea e inicializa la variable local x
	// y llama a los metodos usarVariableLocal y usarCampo
	
	public static void main(String[] args) 
	{
		int x = 5; // la variable local x del metodo oculta el campo x
		
		System.out.printf ("La x local de main es %d\n",x);
		
		usarVariableLocal (); // tiene la x local
		usarCampo (); // usa el campo x de la clase alcance
		usarVariableLocal (); // reinicia a la x local
		usarCampo (); // el campo x de la clase Alcance retiene su valor
		
		System.out.printf ("\nLa x local en main es %d\n",x);
	}
	
			// crea e inicializa la variable local x durante la llamada
		public static void usarVariableLocal ()
		{
			int x = 25; // se inicializa cada vez que se llama este metodo
			
			System.out.printf ("\nLa x local al entrar al metodo usarVariableLocal es %d\n",x);
			++x; // modifica la varibale x local de este metodo
			
			System.out.printf ("La x local antes de salir del metodo usarVariableLocal es %d\n",x);
			
		}
		
		public static void usarCampo ()
		{
			System.out.printf ("\nEl campo x al entrar al metodo usarCampo es %d\n",x);
			x *= 10; // modifica el campo x de la clase Alcance
			
			System.out.printf ("El campo x antes de salir del metodo usarCampo es %d\n",x);
		}
}
