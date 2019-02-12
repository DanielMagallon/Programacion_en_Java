package Unidad3;

public class ColaVector
{
	String filaPersonas[];
	int pos;
			
	public ColaVector(int tamaño)
	{
		filaPersonas = new String[tamaño];
		pos=-1;
	}
	
	public boolean estaVacia()
	{
		return pos==-1;
	}
	
	public void push(String name)
	{
		try
		{
			filaPersonas[++pos] = name;
			System.out.println("Se formo: "+name);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Fila esta llena");
			pos--;
		}
	}
	
	@Override
	public String toString()
	{
		String x="[";
		
		for(int i=0; i<=pos; i++)
			x+=filaPersonas[i]+",";
		
		x+="]\n";
		
		return x;
	}
	
	public String atender()
	{
		if(!estaVacia())
		{
			String p = filaPersonas[0];
			
			for(int i=1; i<=pos; i++)
				filaPersonas[i-1] = filaPersonas[i];
			
			pos--;
			return p;
		}
		
		return "";
	}
	
	public int buscarPersona(String name)
	{
		if(!estaVacia())
		{
			for(int i=0; i<=pos; i++)
			{
				if(filaPersonas[i].equalsIgnoreCase(name))
					return i;
			}
		}
		
		return -1;
	}
	
	public boolean salirFila(String name)
	{
		if(!estaVacia())
		{
			int index = buscarPersona(name);
			
			if(index!=-1)
			{
				for(int i=index+1; i<=pos; i++)
				{
					filaPersonas[i-1] = filaPersonas[i];
				}

				pos--;
				
				return true;
			}
			else{
				System.out.println("No esta formada esa persona");
			}
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{
		ColaVector cola = new ColaVector(5);
		
		cola.push("Mariana");
		cola.push("Daniel");
		cola.push("Pollo");
		cola.push("Yeo");
		cola.push("Luis");

		System.out.println(cola.atender());
		System.out.println("Personas formadas: "+cola);
		
		
		System.out.println("Me falta para que me atiendad: "+cola.buscarPersona("Yeo"));
		
		
	}
}
