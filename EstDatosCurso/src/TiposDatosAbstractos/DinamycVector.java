package TiposDatosAbstractos;

import java.util.Collection;

public class DinamycVector <T>
{
	private Object[] original;
	private Object[] remplazo;
	private int sizeInitial=0;
	
	public DinamycVector()
	{
		original = new Object[sizeInitial];
		remplazo  = new Object[sizeInitial];
	}
	
	public void insert(T element) 
	{
		sizeInitial++;
		original = new Object[sizeInitial];
		original[sizeInitial-1]=element;
		
		if(sizeInitial==1)
			remplazo = new Object[sizeInitial];
		
		if(sizeInitial==1)
		original[0]=element;
		else
		{
			addToOriginal();

		original[sizeInitial-1]=element;
		}
		
		if(sizeInitial==1)
		remplazo[0]=element;
		else
		{
			remplazo = new Object[sizeInitial];
			addToReplace();
			remplazo[sizeInitial-1]=element;
		}
		
		
	}
	
	private void remove()
	{
		original[0]=null;
	}
	
	private void addToOriginal()
	{
		for (int i=0; i<remplazo.length; i++)
			original[i]=remplazo[i];
		
	}

	private void addToReplace()
	{
		for (int i=0; i<remplazo.length; i++)
			remplazo[i]=original[i];
	}
	
	public int size()
	{
		return original.length;
	}
	
	public void get(int index)
	{
		System.out.println(original[index]);
	}
	
	public void getAll()
	{
		//StringBuffer array = new StringBuffer();
		
		for (Object vec : original)
			if(vec!=null)
			System.out.print("[".concat(vec.toString()).concat("], "));
			//System.out.print("["+vec+"]-->");
		
		System.out.println();
	}
	
	private void deleteAll()
	{
		
	}  
	
	private void deleteElementOf (int index)
	{
		sizeInitial--;
		
	}
	
	public void prinnt(int ind){
		for (int i=ind; i>=0; i--)
			System.out.print(i+ " -->\n");
	}
	
	public void prinntRec(int ind){
		
		if(ind==0)
			System.out.print(ind);
		
		else{
		System.out.print(ind+" -->\n ");
		prinntRec(ind-1);
		}
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		DinamycVector<String> lista = new DinamycVector<>();

		lista.insert("Daniel");
		lista.insert("Alfonso");
		lista.insert("Claudia");
		lista.insert("Carmen");
	
		long i = System.currentTimeMillis();
		lista.prinntRec(20);
		long f = System.currentTimeMillis();
		System.out.println("Tiemppo: "+(f-i));
		
	}
}
