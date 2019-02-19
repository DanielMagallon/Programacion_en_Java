package Unidad4Hilos;

public class Hilo {

	static void imprimir(String mensaje){

         System.out.print("["+mensaje);

         try{

                    Thread.sleep(1000);

         }

         catch(InterruptedException e){

                    System.out.println(e);

         }

         System.out.print("]");

	}
	
	public static void main(String[] args) {
		imprimir("Hola");
	}
}
