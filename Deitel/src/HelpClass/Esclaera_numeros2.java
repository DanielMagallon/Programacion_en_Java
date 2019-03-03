package HelpClass;

import javax.swing.JOptionPane;

public class Esclaera_numeros2 
{
		public static void main(String[] args) 
		{
	        String texto=JOptionPane.showInputDialog("Escribe una altura");
	        int altura=Integer.parseInt(texto);
	        dibujaEscaleraNumeros(altura);
	    }   
	 
	    public static void dibujaEscaleraNumeros (int altura)
	    {
	        for (int numero=1;numero<=altura;numero++)
	        {
	            //Este bucle muestra los numeros en cada fila
	            for(int i=1;i<=numero;i++)
	            {
	                System.out.print(i);
	            }
	            //Saltamos de linea
	            System.out.println("");
	        }
	    }
}
