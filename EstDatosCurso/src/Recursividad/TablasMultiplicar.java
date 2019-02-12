package Recursividad;

public class TablasMultiplicar
{
	static int numero2=1;
	
	public static void main(String[] args)
	{
		multiplicar(5,10);
	}
	
	public static void multiplicar(int iTabla, int iNumero)
	{
		 
		if (iNumero>1)
			multiplicar(iTabla,iNumero-1);
		
		System.out.println(iTabla + "x" + iNumero + "=" + iTabla*iNumero);
	}
}
