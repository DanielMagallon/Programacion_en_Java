package C5Evaluacion;

public class ClaseMath 
{
	public static void main(String[] args) 
	{
		System.out.printf ("%20s%25s","Metodo","Descripcion\n");
		System.out.printf ("\n%20s%30s","abs(x)","Valor absoluto de x\n");
		System.out.printf ("\n %20s%55s","ceil(x)","Redeondea x al entero mas pequeño que no sea x\n");
		System.out.printf ("\n%20s%50s","cos(x)","Coseno trigonometrico de x (en radianes)\n");
		System.out.printf ("\n%20s%35s","exp(x)","Metodo exponencial de e*\n");
		System.out.printf ("\n  %20s%63s","floor(x)","Redondea x al entero mas grande que no sea mayor de x\n");
		System.out.printf ("\n%20s%43s","log(x)","Logaritmo natural de x (base e)\n");
		System.out.printf ("\n   %20s%35s","max (x,y)","El valor mas grande de x,y\n");
		System.out.printf ("\n%20s%39s","min (x,y)","El valor mas pequeño de x,y\n");
		System.out.printf ("\n%20s%39s","pow (x,y)","x elevado a la potencia de y\n");
		System.out.printf ("\n%20s%35s","sin (x)","Seno trigonometrico de x\n");
		System.out.printf ("\n%20s%30s","sqrt (x)","Raiz cuadrada de x\n");
		System.out.printf ("\n%20s%40s","tan (x)","Tangente trigonometrica de x\n");
		System.out.printf ("\n %20s%55s","round (x)","Redeondea x hacia el natural mas cercano por arriba o por debajo\n");
		
	
		System.out.printf ("\n");
		
		System.out.printf ("\n Math.abs (23.7) = %f\n",Math.abs(23.7));
		System.out.printf (" Math.abs (0.0) = %f\n",Math.abs(0.0));
		System.out.printf (" Math.abs (-23.7) = %f\n",Math.abs(-23.7));
		
		System.out.printf ("\n Math.ceil (9.2) = %f\n",Math.ceil(9.2));
		System.out.printf (" Math.ceil (-9.8) = %f\n",Math.ceil(-9.8));
		
		System.out.printf ("\n Math.cos (0.0) = %f\n",Math.cos(0.0));
		
		System.out.printf ("\n Math.exp (1.0) = %f\n",Math.exp(1.0));
		System.out.printf (" Math.exp (2.0) = %f\n",Math.exp(2.0));
		
		System.out.printf ("\n Math.floor (9.2) = %f\n",Math.floor(9.2));
		System.out.printf (" Math.floor (-9.8) = %f\n",Math.floor(-9.8));
		
		System.out.printf ("\n Math.log (Math.E) = %f\n",Math.log(Math.E));
		System.out.printf (" Math.log (Math.E * Math.E) = %f\n",Math.log(Math.E*Math.E));
		
		System.out.printf("\n Math.max (2.3,12.7) = %f\n",Math.max (2.3,12.7));
		System.out.printf(" Math.max (-2.3,-12.7) = %f\n",Math.max (-2.3,-12.7));
		
		System.out.printf("\n Math.min (2.3,12.7) = %f\n",Math.min (2.3,12.7));
		System.out.printf(" Math.min (-2.3,-12.7) = %f\n",Math.min (-2.3,-12.7));
		
		System.out.printf("\n Math.pow (2.0,7.0) = %f\n", Math.pow (2.0,7.0));
		System.out.printf(" Math.pow (9.0,0.5) = %f\n", Math.pow (9.0,0.5));
		
		System.out.printf ("\n Math.sin (0.0) = %f\n", Math.sin (0.0));
		
		System.out.printf ("\n Math.sqrt (900.0) = %f\n",Math.sqrt (900.0));
		
		System.out.printf ("\n Math.tan (0.0) = %f\n", Math.tan (0.0));
		
		System.out.printf ("\n Math.round (5.7) = %d\n", Math.round (5.7));
		System.out.printf (" Math.round (5.4) = %d\n", Math.round (5.4));
	}
}
