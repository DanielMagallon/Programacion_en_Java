package C3Evaluacion;

public class Misterio2 
{
	public static void main(String[] args) 
	{
		int cuenta = 1;
		
			while (cuenta<=10)
				{
					System.out.println( cuenta % 2 == 1 ? "****" : "+++++++");
					++cuenta;
				}
	
				System.out.println("");
				System.out.println("----------------------------------");
				System.out.println();
				
				int fila=10;
				int columna;
				
				while (fila>=1)
				{
					columna=1;
					
					while (columna<=10)
					{
						System.out.print (fila % 2 == 1 ? ">" : "<");
						++columna;
					}
					
					--fila;
					System.out.println();
				}
	}
}
