package HelpClass;

import java.util.Scanner;
public class ValorPI{
    public static void main(String argv[]){
      
        double divisor = 1,pi=0;
       

        System.out.print("Terminos?: ");
        Scanner teclado = new Scanner(System.in);

        int terminos = teclado.nextInt();
        
        
        System.out.print("SUCESION = ");
        for(int i=1; i<=terminos; i++)
        {
            if(i%2==0)
            { //los terminos en posiciones pares se restan
                pi-= 4/divisor;
                System.out.print(" -4/"+(int)divisor);
            }
            
            else
            { //los terminos en posiciones impares se suman
                pi+= 4/divisor;
                System.out.print(" +4/"+(int)divisor);
            }
            divisor+=2; //el divisor aumenta en 2 para cada nuevo termino de la sucesion
        }
    System.out.println("\n\nTOTAL: "+pi);
    }
}
