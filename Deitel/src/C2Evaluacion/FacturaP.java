package C2Evaluacion;

import java.util.Scanner;

public class FacturaP 
{
		public static void main(String[] args) 
		
		{
			
				Factura lc1 = new Factura ("69", "Desarmador",5,15);
				
			
				System.out.printf ("Numero de pieza: %s\n", lc1.Obtenernumpiz());
				System.out.printf ("Descripcion de la pieza: %s\n", lc1.Obtenerdescpz());
				System.out.printf ("Cantidad de articulos vendidos: %d\n", lc1.Obtenercant());
				System.out.printf ("Precio del articulo vendido: %.2f\n",lc1.Obtener$());
				System.out.printf ("Monto a pagar: %.2f\n", lc1.Obtenermontofactura());
				System.out.println();
				
				
				Scanner lc2 = new Scanner(System.in);
				Factura lc3 = new Factura ("","",0,0);
				String np,desc;
				int cant;
				double precio, monto;
				
				
				System.out.println("Escriba el numero de la pieza: ");
				np=lc2.nextLine();
				System.out.println();
				lc3.Establecernumpiz(np);
				
				
				System.out.println("Descripcion de la pieza: ");
				desc=lc2.nextLine();
				System.out.println();
				lc3.Establecerdespz(desc);
				
				
				System.out.println("Cantidad de articulos: ");
				cant=lc2.nextInt();
				System.out.println();
				lc3.Establecercant(cant);
				
				
				System.out.println("Precio de la pieza: ");
				precio=lc2.nextDouble();
				System.out.println();
				lc3.Establecer$(precio);
				
				System.out.printf ("Numero de pieza: %s\n", lc3.Obtenernumpiz());
				System.out.printf ("Descripcion de la pieza: %s\n", lc3.Obtenerdescpz());
				System.out.printf ("Cantidad de articulos: %d\n", lc3.Obtenercant());
				System.out.printf ("Precio del articulo: $%.2f\n",lc3.Obtener$());
				System.out.printf ("Monto a pagar: $%.2f\n", lc3.Obtenermontofactura());
				System.out.println();
				
				
		}
	
	
	
	
}
