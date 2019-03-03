package HelpClass;

import javax.swing.JOptionPane;

public class Piramide_Asteriscos_reves 
{
	public static void main(String[] args) 
	{
        String texto=JOptionPane.showInputDialog("Introduce una altura");
        int altura=Integer.parseInt(texto);
        piramideInvertida(altura);
    }   
 
    public static void piramideInvertida(int altura)
    {
        for (int numeroespacios=0, numeroasteriscos=(altura*2)-1; numeroasteriscos>0;numeroespacios++, numeroasteriscos-=2)
        {
 
            for (int i=0; i<numeroespacios;i++)
            {
                System.out.print(" ");
            }
 
            for (int j=numeroasteriscos; j!=0;j--)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}

