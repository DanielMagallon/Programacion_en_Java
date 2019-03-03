package HelpClass;

import javax.swing.JOptionPane;

public class Piramide_Asteriscos 
{
	
	    public static void main(String[] args) 
	    {
	        String texto=JOptionPane.showInputDialog("Introduce una altura");
	        int altura=Integer.parseInt(texto);
	        piramideNormal(altura);
	    }   
	 
	    public static void piramideNormal (int altura)
	    {
	  for (int numeroespacios=altura, numeroasteriscos=1; numeroasteriscos<=(altura*2)-1;numeroespacios--, numeroasteriscos+=2)
	  {
	            //Espacios
	            for (int i=0; i<numeroespacios;i++)
	            {
	                System.out.print(" ");
	            }
	            //Asteriscos
	            for (int j=numeroasteriscos; j!=0;j--)
	            {
	                System.out.print("*");
	            }
	            System.out.println("");
	   }
	   }
}
