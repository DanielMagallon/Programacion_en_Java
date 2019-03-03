package C7Evalucion;

import java.util.Scanner;

public class TresEnRaya
{
	private Object gato [][] = new Object [3][3];
	private static enum Celda {X,O,V};
	static Scanner lc = new Scanner(System.in);
	private int contTurnos=1;
	Celda tres;
	int f=0,c=0;
	private boolean [][]celdasOcupdas = new boolean [3][3];
	
	public TresEnRaya ()
	{
		
		for (int i=0; i<gato.length; i++)
		{
			for (int j=0; j<gato[i].length; j++)
			{
				gato[i][j]=Celda.V;
			}
		}
	}
	
	public boolean capturarExcepcion ()
	{
		boolean captura=true;
		
		if (f>=gato.length || c >=gato.length)
		{
			captura=false;
			throw new ArrayIndexOutOfBoundsException(
					"Se salio del arreglo. No existe tal posicion\n");
			
		}
		
		return captura;
	}
	
	public void mostrarGato ()
	{
		String mensaje="";
		
		boolean gameOver=false;
		
		System.out.println("\n");
		
		System.out.println ("\t\t      |\t      |");
		
		for (int i=0; i<gato.length; i++)
		{
			System.out.print ("\t\t");
			
			for (int j=0; j<gato[i].length; j++)
			{
				if (gato[i][j]==Celda.V)
				{
				gato[i][j]=" ";
				}
				
				System.out.printf ("  "+gato[i][j] + "%5s", (j!=2) ? " | " : "");
				
			}
			System.out.println("\n\t\t______|_______|_______\n\t\t      |\t      |");
		}
		
		/*for (int i=0; i<celdasOcupdas.length; i++)
		{
			for (int a=0; a<celdasOcupdas[i].length; a++)
			{
				if (celdasOcupdas[i][a]==true)
				{
					gameOver=false;
				}
					
				else
					break;
				
			}
		}
		System.out.printf ("Game over: %b\n",gameOver);*/
		
		if (celdasOcupdas[0][0]==true && celdasOcupdas[0][1]==true  && celdasOcupdas[0][2]==true  &&
			celdasOcupdas[1][0]==true  && celdasOcupdas[1][1]==true  && celdasOcupdas[1][2]==true  &&
			celdasOcupdas[2][0]==true  && celdasOcupdas[2][1]==true  && celdasOcupdas[2][2]==true)
		{
			gameOver=true;
			mensaje="Han perdido ambos jugadores";
		}

		else
			if (gato[0][0]==Celda.O && gato[1][1]==Celda.O && gato[2][2]==Celda.O
				|| gato[0][2]==Celda.O && gato[1][1]==Celda.O && gato[2][0]==Celda.O
				|| gato[0][0]==Celda.O && gato[0][1]==Celda.O && gato[0][2]==Celda.O
				|| gato[0][0]==Celda.O && gato[1][0]==Celda.O && gato[2][0]==Celda.O
				|| gato[0][2]==Celda.O && gato[1][2]==Celda.O && gato[2][2]==Celda.O
				|| gato[2][0]==Celda.O && gato[2][1]==Celda.O && gato[2][2]==Celda.O
				|| gato[0][1]==Celda.O && gato[1][1]==Celda.O && gato[2][1]==Celda.O)
			{
				gameOver=true;
				mensaje="Ha ganado el jugador 1";
			}
		
		else
			if (gato[0][0]==Celda.X && gato[1][1]==Celda.X && gato[2][2]==Celda.X
				|| gato[0][2]==Celda.X && gato[1][1]==Celda.X && gato[2][0]==Celda.X
				|| gato[0][0]==Celda.X && gato[0][1]==Celda.X && gato[0][2]==Celda.X
				|| gato[0][0]==Celda.X && gato[1][0]==Celda.X && gato[2][0]==Celda.X
				|| gato[0][2]==Celda.X && gato[1][2]==Celda.X && gato[2][2]==Celda.X
				|| gato[2][0]==Celda.X && gato[2][1]==Celda.X && gato[2][2]==Celda.X
				|| gato[0][1]==Celda.X && gato[1][1]==Celda.X && gato[2][1]==Celda.X)
				{
					gameOver=true;
					mensaje="Ha ganado el jugador 2";
				}
		
		while (gameOver==false)
		{
			jugarGato();
			System.exit(0);
		}
		
		System.out.println("\n" + mensaje);
	}
	
	public void jugarGato ()
	{
	
		boolean error=false;
		
		do
		{
		try
		{
			do
			{
			System.out.print ("\nIntroduzca la posicion en que desea colocarse: ");
			f=lc.nextInt();
			c=lc.nextInt();
			
			if (celdasOcupdas[f][c]==true)
				System.out.println("\nEsa posicion ya esta ocupada");
			
			else
				error=capturarExcepcion();
			}
			while (celdasOcupdas[f][c]==true);
			
		}

		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.printf ("\nExcepcion: ArrayIndexOutOfBoundsException\nSe salio del arreglo."
					+ "No existe esa posicion\nError numero: %s\n",e.getMessage());
			lc.nextLine();
		}
		}
		while (error==false);
		
		celdasOcupdas[f][c]=true;
		
		if (contTurnos%2==0)
		{
		tres=Celda.X;
		}
		
		else
			tres=Celda.O;
		
		for (int i=0; i<gato.length; i++)
		{
			for (int j=0; j<gato[i].length; j++)
			{
				gato[f][c]=tres;
			}
		}
		contTurnos++;
		mostrarGato();
	}
	
	public static void main(String[] args)
	{
		TresEnRaya gato = new TresEnRaya();
		
		gato.mostrarGato();
	}
}	
