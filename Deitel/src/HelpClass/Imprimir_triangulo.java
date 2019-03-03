package HelpClass;

import javax.swing.JOptionPane;

public class Imprimir_triangulo  
{
    public static void main(String[] args) 
    {
        String texto=JOptionPane.showInputDialog("Escribe una altura");
        int altura=Integer.parseInt(texto);
        dibujaEscalera(altura);
    }   
 
    public static void dibujaEscalera (int altura){
        for (int numeroasteriscos=1;numeroasteriscos<=altura;numeroasteriscos++){
            //Este bucle pinta los asteriscos en cada fila
            for(int i=0;i<numeroasteriscos;i++){
                System.out.print("*");
            }
            //Saltamos de linea
            System.out.println("");
        }
    } 
}
