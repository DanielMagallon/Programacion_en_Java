package C3Evaluacion;

import java.util.Scanner;

public class Comisionventa 
{
	public  void determinarIngresos ()
		{
			Scanner input = new Scanner(System.in);
			
			double art1=239.99, art2=129.75, art3=99.95, art4=3450.89,total=0,newpago;
			int artven,salario=200;
			
			System.out.println (" Articulo\tValor");
			System.out.printf  ("    1\t        %.2f\n    2\t        %.2f\n    3\t        %.2f\n    4\t        %.2f\n",art1,art2,art3,art4);
			
			System.out.println();
			System.out.println (" Introduzca los articulos vendidos durante la semana o un -1\n para terminar con su venta de articulos ");
			System.out.println();
			
			System.out.print ("Articulos vendidos: ");
			artven=input.nextInt();
			
			while (artven != -1)
				{
					if (artven==1)
						{
							total += art1;
						}
					if (artven==2)
						{
							total += art2;
						}
					if (artven==3)
						{
						total += art3;
						}
					if (artven==4)
						{
						total += art4;
						}
					System.out.print ("Articulos vendidos: ");
					artven=input.nextInt();
				}
			newpago = salario + (total*9)/100;
			System.out.println();
			System.out.printf ("Su pago semanal es de: $%d\n",salario);
			System.out.println();
			System.out.printf ("El total de los articulos vendidos es de: $%.2f\n",total);
			System.out.println ();
			System.out.printf ("Su nuevo pago será de: $%.4f\n",newpago);
		}
}
