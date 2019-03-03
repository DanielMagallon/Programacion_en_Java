package HelpClass;

import javax.swing.JOptionPane;

public class Escalera_numeros 
{
	
	    public static void main(String[] args) {
	        String texto=JOptionPane.showInputDialog("Escribe una altura");
	        int altura=Integer.parseInt(texto);
	        dibujaEscaleraNumeros(altura);
	    }
	 
	    public static void dibujaEscaleraNumeros (int altura){
	        for (int numero=1;numero<=altura;numero++){
	            //Este bucle muestra los numeros en cada fila
	            for(int i=0;i<numero;i++){
	                System.out.print(numero);
	            }
	            //Saltamos de linea
	            System.out.println("");
	        }
	    }
}
