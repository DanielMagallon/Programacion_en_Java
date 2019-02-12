package ExamenU2;

public class Pilanombre
{

	Datos obd = new Datos();
	String nombres[];
	int pos=0, val;
	
	public Pilanombre()
	{
		System.out.println("La pila esta vacia? "+pilaVacia());
		
		val = obd.Entero("Dame el numero de personas que tendra");
		nombres = new String[val];
		
		nombres[pos] = obd.Cadena("Dame el primer nombre del registro: ");
		pos++;
	}

	public boolean pilaVacia()
	{
		return pos==0;
	}
	
	public boolean pilallena()
	{
		return pos == nombres.length;
	}
	
	public void agregarNombre()
	{
		if(!pilallena())
		{
		nombres[pos] = obd.Cadena("Dame el nomnbre del registro: ");
		pos++;
		}else System.out.println("La pila esta llena, no se puede agregar mas");
	}
	
	public String sacarNombre()
	{
		if(!pilaVacia())
		{
			pos--;
		String cad = nombres[pos];
		nombres[pos]="";
		
		
		return "Se saco a: "+cad;
		}else return "La pila esta vacia, no se pueden sacar elementos";
	}
	
	public void sacarTodo()
	{
		System.out.println("SE sacaran todos los registros....");
		while(pos!=0)
		{
			pos--;
			System.out.println("Sacando a "+nombres[pos]);
			nombres[pos]="";
			
		}
		
}
}