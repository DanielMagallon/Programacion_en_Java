package HelpClass;

import java.util.Scanner;

public class Primos
{
	 public static void main(String[] args) {
		 
		 
		 Scanner sc = new Scanner(System.in);  
		        int a=0,i2,n;  
		          System.out.println("Ingrese numero");  
		          n=sc.nextInt();  
		         for(i2=1;i2<(n+1);i2++){  
		          if(n%i2==0){  
		              a++;  
		            }  
		          if(a!=2){  
		               System.out.println("No es Primo");  
		             }else{  
		                 System.out.println("Si es Primo");  
		          }  
		         }
		 
		 
		 
		 
	        for (int i=1;i<=100;i++)
	        {
	            //Hacemos un casting para que nos devuelva un numero entero
	            int raiz=(int)Math.sqrt(i);
	            int contador=0;
	 
	            //Hacemos otro bucle para contar los divisibles
	            for (int j=raiz;j>1;j--)
	            {
	                if (i%j==0){
	                    contador++;
	                }
	            }
	 
	            /*Segun el numero de divisibles, sabemos si es primo o no
	             * Si es primo el contador sera 0
	             */
	 
	            if (contador<1){
	                System.out.println(i);
	            }
	 
	        }
	    }
}