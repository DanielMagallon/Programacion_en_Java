package Unidad3;

import javax.swing.JOptionPane;

public class BiCola<E>
{
	int fin;
	

	Object cola[];
			
	public BiCola(int tamanio)
	{
		cola = new Object[tamanio];
		fin=-1;
	}
	
	public boolean estaVacia()
	{
		return fin==-1;
	}
	
	public boolean isFull()
	{
		return fin == cola.length-1;
	}
	
	public void push(E name, int prioridad)
	{
		if(prioridad==1)
		{
			if(!isFull())
				pushStart(name);
			else
				JOptionPane.showMessageDialog(null, "La cola esta llena");
		}
		else
		{
			push(name);
		}
			
	}
	
	//Inserta al final
	public void push(E name)
	{
		if(!isFull())
		{
			if(estaVacia())
			{
				fin = 0;
				cola[0] = name;
			}
			else
			{
				fin++;
				
				cola[fin] = name;
			}
		}
		else JOptionPane.showMessageDialog(null, "La cola esta llena");
	}

	//Inserta al inicio
	private void pushStart(E dato)
	{
		if(estaVacia())
		{
			fin = 0;
			cola[0] = dato;
		}
		else
		{
			
//			for(int i=fin; i>=0; i--)
//			{
//				filaPersonas[i+1] = filaPersonas[i];
//			}
			fin++;
			System.arraycopy(cola, 0, cola, 1, fin);
			cola[0] = dato;
		}
	}
	
	public E pop(int prior) 
	{
		if(prior==1)
		{
			if(!estaVacia())
				return popEnd();
			else
			{
				return (E) "La cola esta vacia";
			}
		}
		else
		{
			return pop();
		}
	}
	
	public E pop() 
	{
		if(!estaVacia())
		{
			E val = (E) cola[0];
			
			for(int i=1; i<=fin; i++)
			{
				cola[i-1] = cola[i];
			}
			
			fin--;
			
			return val;
		}
		else
		{
			return (E) "La cola esta vacia";
		}
	}
	
	private E popEnd()
	{
		E val = (E) cola[fin];
		fin--;
		return val;
	}
	
	public void show()
	{
		System.out.println("Elementos de la cola: ");
		
		for(int i=0; i<=fin; i++)
		{
			System.out.print(cola[i]+"-");
		}
		
		System.out.println();
	}
	
	private int buscarPersona(E name)
	{
		if(!estaVacia())
		{
			for(int i=0; i<=fin; i++)
			{
				if(cola[i] == name)
					return i;
			}
		}
		
		return -1;
	}
	
	public boolean salirFila(E name)
	{
		if(!estaVacia())
		{
			int index = buscarPersona(name);
			
			if(index!=-1)
			{
				for(int i=index+1; i<=fin; i++)
				{
					cola[i-1] = cola[i];
				}

				fin--;
				
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
		BiCola<Integer> bi = new BiCola<>(5);
		
		int addElementsPrio[][] = 
			{
				{1, 1},
				{2,2},
				{3,1},
				{4,1},
				{5,2},
				{6,1}
			};
		
		/*
		 * C B C A B C
		 */
		
		int popElementsPrio[] = {1,2,2};
		
		for(int i=0; i<addElementsPrio.length; i++)
		{
			bi.push(addElementsPrio[i][0], addElementsPrio[i][1]);
		}
		bi.show();
		
		for(int v : popElementsPrio)
			bi.pop(v);
		
		bi.show();
		
		for(int i=0; i<addElementsPrio.length-2; i++)
		{
			bi.push(addElementsPrio[i][0], addElementsPrio[i][1]);
		}
		bi.show();
		
		
	}
}
