package Unidad6;

class Registro{
	
	int noCtrl;
	String nombre;
	int edad;
	
	public Registro(int n, String name, int age)
	{
		noCtrl = n;
		nombre = name;
		edad = age;
	}
	
	@Override
	public String toString()
	{
		return noCtrl+" "+nombre+" "+edad; 
	}
	
	public void llenar(String nom, int e)
	{
		nombre = nom;
		edad = e;
	}
}

public class BsHash
{

	int cvhash[];
	int cvH[][];
	Registro datos[];
	
	public BsHash()
	{
		cvhash = new int[]{16062,17565,17533,17571,17117,17107,17591,17607,90736,15420};
		
		cvH = new int[cvhash.length][2];
		
		datos = new Registro[cvhash.length];
		
	}

	
	public int modulo(int num)
	{
		int pos = num%7;//cvhash.length; 7 numero primo mas cercacabo a vec.lengt=10
				
		return pos;
	}
	
	public void asingaPosicion()
	{
		for(int i=0; i<cvhash.length; i++)
		{
			int pos = 
					//modulo(cvhash[i]);
					cuadrada(cvhash[i]);
			
			asignar(cvhash[i], pos);
		}
		
	}
	
	public int cuadrada(int num)
	{
		int res = (int) Math.pow(num, 2);
		String cad = res+"";
		int mitad = cad.length()/2;
		
		int x = Integer.parseInt(cad.charAt(mitad)+"");
		
		return x;
	}
	
	public void asignar(int cve, int pos)
	{
		if(cvH[pos][0]==0)
		{
			cvH[pos][0] = cve;
			cvH[pos][1] = pos;
		}else{
			
			while(true)
			{
				pos++;
				
				if(pos==cvhash.length)
					pos=0;
				
				if(cvH[pos][0] == 0)
				{
					cvH[pos][0] = cve;
					cvH[pos][1] = pos;
					return;
				}
			}
		}
		
	}
	
	public void inicilizar()
	{
		for(int x=0; x<datos.length; x++)
		{
			datos[x] = new Registro(cvH[x][0], "", 0);
			System.out.println(datos[x]);
		}
		
	}
	
	public Registro busqueda(int num)
	{
		int pos = cuadrada(num);
		Registro reg=null;
		
		
		if(cvH[pos][0] == num)
		{
			reg = datos[pos];
			
			return reg; 
		}
		else{
			
			int x = 1;
			
			do
			{
				pos++;
				x++;
				
				if(pos == cvhash.length)
					pos = 0;
				
				if(cvH[pos][0]==num)
				{
					reg = datos[pos];
					return reg;
				}
			}
			while(x!=cvhash.length);
		}
		
		return reg;
	}
	
	public void llenarDatos()
	{
		datos[0].llenar("Adrian", 19);
		datos[1].llenar("Bryan", 19);
		datos[2].llenar("Luis", 19);
		datos[3].llenar("Othoniel", 45);
		datos[4].llenar("Edgar", 19);
		datos[5].llenar("Juan", 19);
		datos[6].llenar("Vicente", 19);
		datos[7].llenar("Megan Fox", 39);
		datos[8].llenar("Allison", 34);
		datos[9].llenar("Adrian 2", 19);
		
		for(Registro reg : datos)
			System.out.println(reg);
	}
			
	
	public static void main(String[] args)
	{
		BsHash bs = new BsHash();
				
		bs.asingaPosicion();
		bs.inicilizar();
		bs.llenarDatos();
		
		System.out.println("\n"+bs.busqueda(16062));
	}
}
