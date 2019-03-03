package ClaseString;

public class MetodoCompareTo
{
	public static void main(String[] args)
	{
		String c1="Universo Java";
        String c2="Universo Visual J";
        int i;
        i=         c1.compareTo(c2);
        if (c1.compareTo(c2)<0){
                    System.out.println(c2);
        }
        else
        {
                    System.out.println(c1);
        }
        System.out.println("El valor de i = "+i);
        //Otros Casos
        System.out. println("Compara Windows con Waterloo  :"+"Windows".compareTo("Waterloo"));
        System.out.println("Windows es mayor que Waterloo");
	}
}
