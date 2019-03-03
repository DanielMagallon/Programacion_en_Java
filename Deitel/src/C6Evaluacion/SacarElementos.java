package C6Evaluacion;

public class SacarElementos
{
	static int v[];
	
	static int vectorPila[];
	static int cima;
	
	public SacarElementos(int tamanio)
	{
		vectorPila=new int[tamanio];
		cima=-1;
	}
	
	//Metodo push (empujar un elemento en la pila)
	public void push (int dato)
	{
		cima++;
		vectorPila[cima]=dato;
	}
	
	//Metodo pop (sacar un objeto/numero)
	public int pop()
	{
		int fuera=vectorPila[cima];
		cima--;
		
		return fuera;
	}
	
	public void mostrar()
	{
		for (int i=0; i<vectorPila.length; i++)
		{
			System.out.println(vectorPila[i]);
		}
	}
	
	public static void main(String[] args)
	{
		SacarElementos s = new SacarElementos(5);
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
	
		s.mostrar();
		s.pop();
		System.out.println("\n");
		s.mostrar();
	}
}
