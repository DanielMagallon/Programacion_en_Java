package C4Evaluacion;

public class Doce_dias_Navidad 
{
	private int dia;
	private String letra;
	
	public void Cancion ()
	{
		for (dia=1; dia<=12;dia++)
		{
			obtenerVerso(dia);
			
			
		}
	}
	
	private void obtenerVerso (int dia)
	{
		
		String dias = " day of Christmas my true love sent to me";
		
		System.out.println();
		
		
		switch (dia)
		{
		case 1: 
			System.out.printf (" %s%s\n","On the First ",dias);
			letra ="a Partridge in a Pear Tree.";
			System.out.println();
			System.out.printf ("%s\n",letra);
			
			break;
			
		case 2: 
			System.out.println();
			System.out.printf (" %s%s\n","On the Second ",dias);
			letra ="Two Turtle Doves and\n" + letra;
			System.out.println();
			System.out.printf ("%s\n",letra);
			break;
			
		case 3: 
			System.out.printf (" %s%s\n","On the Third ",dias);
			letra = "Three French Hens,\n" + letra;
			System.out.println();
			System.out.printf ("%s\n",letra);
			break;
		
		case 4: 
			System.out.printf (" %s%s\n","On the Fourth ",dias);
			letra = "Four calling birds,\n" + letra;
			System.out.println();
			System.out.printf ("%s\n",letra);
			break;
			
		case 5: 
			System.out.printf (" %s%s\n","On the Fifth ",dias);
			letra = "Five golden rings,\n" + letra;
			System.out.println();
			System.out.printf ("%s\n",letra);
			break;
		
		case 6: 
			System.out.printf (" %s%s\n","On the Sixth ",dias);
			letra = "Six geese a-laying,\n" + letra;
			System.out.println();
			System.out.printf ("%s\n",letra);
			break;
		
		case 7: 
			System.out.printf (" %s%s\n","On the Seventh ",dias);
			letra = "Seven swans a-swimming,\n" + letra;
			System.out.println();
			System.out.printf ("%s\n",letra);
			break;
			
		case 8: 
			System.out.printf (" %s%s\n","On the Eighth ",dias);
			letra = "Eight maids a-milking,\n" + letra;
			System.out.println();
			System.out.printf ("%s\n",letra);
			break;
			
		case 9: 
			System.out.printf (" %s%s\n","On the Nineth ",dias);
			letra = "Nine ladies dancing,\n" + letra;
			System.out.println();
			System.out.printf ("%s\n",letra);
			break;
			
		case 10: 
			System.out.printf (" %s%s\n","On the Tenth ",dias);
			letra = "Ten lords a-leaping,\n" + letra;
			System.out.println();
			System.out.printf ("%s\n",letra);
			break;
			
		case 11: 
			System.out.printf (" %s%s\n","On the Eleventh ",dias);
			letra = "Eleven pipers piping,\n" + letra;
			System.out.println();
			System.out.printf ("%s\n",letra);
			break;
			
		case 12: 
			System.out.printf (" %s%s\n","On the Twelfth ",dias);
			letra = "Twelve drummers drumming,\n" + letra;
			System.out.println();
			System.out.printf ("%s\n",letra);
			break;
		}
	}
	
	public static void main(String[] args) 
	{
		Doce_dias_Navidad dn = new Doce_dias_Navidad();
		
		dn.Cancion();
	}
}
