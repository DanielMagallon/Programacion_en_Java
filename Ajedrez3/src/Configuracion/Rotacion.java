package Configuracion;

public class Rotacion 
{
	public String original[][] = 
		{
				{"TN", "CN", "AN", "DN", "RN", "AN", "CN", "TN"}, 
				{"PN", "PN", "PN", "--", "PN", "PN", "PN", "PN"},
				{"--", "--", "--", "--", "--", "--", "--", "--"}, 
				{"--", "--", "--", "PN", "--", "--", "--", "--"},
				{"--", "--", "--", "--", "--", "--", "--", "--"}, 
				{"--", "--", "CB", "--", "--", "--", "--", "--"}, 
				{"PB", "PB", "PB", "PB", "PB", "PB", "PB", "PB"}, 
				{"TB", "--", "AB", "DB", "RB", "AB", "CB", "TB"}
//				{"TN", "CN", "AN", "--", "--", "--", "--", "TN"}, 
//				{"PN", "PN", "PN", "PN", "--", "--", "--", "PN"},
//				{"--", "--", "--", "--", "--", "--", "--", "AN"}, 
//				{"--", "--", "--", "--", "--", "--", "PN", "--"}, 
//				{"--", "--", "--", "--", "--", "--", "RN", "--"}, 
//				{"--", "--", "PB", "--", "--", "--", "--", "--"}, 
//				{"PB", "PB", "--", "--", "RB", "--", "PB", "PB"},
//				{"TB", "--", "AB", "--", "--", "--", "--", "--"}
		};
	
	public String auxiliar[][] = new String[original.length][original[0].length];
	
	public void rotarHorizontal()
	{
		for(int i=0,k=auxiliar.length-1; i<auxiliar.length; i++,k--)
		{
			for(int j=0, l=auxiliar[0].length-1; j<auxiliar[0].length; j++,l--)
			{
				auxiliar[i][j] = original[k][l];
			}
		}
	}
	
	public void mostrar(String[][] mat)
	{
		for(String y[] :  mat)
		{
			for(String x : y)
			{
				System.out.print (x+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		Rotacion rotacion = new Rotacion();
		
		rotacion.mostrar(rotacion.original);
		rotacion.rotarHorizontal();
		System.out.println();
		rotacion.mostrar(rotacion.auxiliar);
	}
}
