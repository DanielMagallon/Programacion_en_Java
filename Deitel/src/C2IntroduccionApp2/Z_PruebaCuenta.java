package C2IntroduccionApp2;

// entrada y salida de numeros de punto flotante con objetos Cuenta
// El .2 entre % y f representa el número de lugares decimales (2) que deben imprimirse a la derecha del punto decimal en  
// el número de punto flotante; 


import java.util.Scanner;

public class Z_PruebaCuenta 
	{

		
		public static void main(String[] args) 
			{
			
			 Z_Cuenta cuenta1 = new  Z_Cuenta (50.00); //   Crea un
			 Z_Cuenta cuenta2 = new  Z_Cuenta (-7.53); // Objeto Cuenta
			
			 
			// muestra el saldo inicial de cada objeto 
			 
			System.out.printf("Saldo de cuenta1: $%.2f\n", cuenta1.obtenerSaldo());
			System.out.printf("Saldo de cuenta2: $%.2f\n", cuenta2.obtenerSaldo());
			
			// crea objeto Scanner para obtener la entrada de la ventana de comandos 
				Scanner input=new Scanner(System.in);
				
			double montoDeposito; // Variable...deposita el monto escrito por el usuario 
			
			System.out.print ("Escriba el monto a depsitar en cuenta1: "); //indicador
			montoDeposito = input.nextDouble(); // obtiene entrada del usuario
			System.out.printf("\nSumando %.2f al saldo de la cuenta1\n\n ",montoDeposito );
			cuenta1.abonar (montoDeposito); // suma al saldo de cuenta1
			
			//muestra los saldos	
			System.out.printf("Saldo de cuenta1: $%.2f\n", cuenta1.obtenerSaldo());
			System.out.printf("Saldo de cuenta2: $%.2f\n", cuenta2.obtenerSaldo());
			
			System.out.print ("Escriba el monto a depsitar en cuenta2: "); //indicador
			montoDeposito = input.nextDouble(); // obtiene entrada del usuario
			System.out.printf("\nSumando %.2f al saldo de la cuenta2\n\n ",montoDeposito );
			cuenta2.abonar (montoDeposito); // suma al saldo de cuenta1
			
			//muestra los saldos
			System.out.printf("Saldo de cuenta1: $%.2f\n", cuenta1.obtenerSaldo());
			System.out.printf("Saldo de cuenta2: $%.2f\n", cuenta2.obtenerSaldo());
			
			}	// fin del main
	} // fin de la clase.
