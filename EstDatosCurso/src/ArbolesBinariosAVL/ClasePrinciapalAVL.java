package ArbolesBinariosAVL;

public class ClasePrinciapalAVL
{
	public static void main(String[] args)
	{
		ArbolAVL arbol = new ArbolAVL();
		
		arbol.insertarNodo(10);
		arbol.insertarNodo(5);
		arbol.insertarNodo(13);
		arbol.insertarNodo(1);
		arbol.insertarNodo(6);
		arbol.insertarNodo(17);
		arbol.insertarNodo(16);
		arbol.preOrden(arbol.getRaiz());
		System.out.println("\nRaiz: "+arbol.getRaiz().dato);
	}
}
