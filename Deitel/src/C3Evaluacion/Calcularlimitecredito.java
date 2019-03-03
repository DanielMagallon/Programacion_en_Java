package C3Evaluacion;

import java.util.Scanner;

public class Calcularlimitecredito 
{
		public static void determinarLimite ()
			{
		
				Scanner input = new Scanner(System.in);
			
			  int numcu,saldoinicial,cargos,creditos,nvosaldo,limitecred;
			
			  
			  System.out.print (" Numero de cuenta: ");
			  numcu=input.nextInt();
			  System.out.println();
			  System.out.print (" Saldo inicial: ");
			  saldoinicial=input.nextInt();
			  System.out.println();
			  System.out.print (" Articulos cargados por el cliente en el mes: ");
			  cargos=input.nextInt();
			  System.out.println();
			  System.out.print (" Creditos aplicados a la cuenta del cliente en el mes: ");
			  creditos=input.nextInt();
			  System.out.println();
			  System.out.print (" El limite de credito perimitido es de: ");
			  limitecred=input.nextInt();
			  System.out.println();
			  nvosaldo = saldoinicial + cargos - creditos;
			  System.out.printf (" Su nuevo saldo es de: %d\n",nvosaldo);
			 
			  
			  if (limitecred<nvosaldo)
				  System.out.println(" Se excedió el limite de su crédito");
			}
		
		public static void main(String[] args) 
			{
				determinarLimite();
				determinarLimite();
			}
}
