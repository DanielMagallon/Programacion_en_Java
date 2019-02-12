package ExamenU2;

public class Ppilanombre
{
	public static void main(String[] args)
	{
		Pilanombre p = new Pilanombre();
		
		
		System.out.println("La pila esta vacia? "+p.pilaVacia());
		
		System.out.println("La pila esta llena? "+p.pilallena());
		
		p.agregarNombre();
		p.agregarNombre();
		p.agregarNombre();
		p.agregarNombre();
		
		
		System.out.println("La pila esta llena? "+p.pilallena());
		
		System.out.println(p.sacarNombre());
		
		p.sacarTodo();
		
		p.agregarNombre();
		
		System.out.println(p.sacarNombre());
	}
}

