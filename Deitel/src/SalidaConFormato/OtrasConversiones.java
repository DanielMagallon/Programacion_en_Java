package SalidaConFormato;

public class OtrasConversiones
{
	public static void main(String[] args)
	{
		Object prueba = null;
		
		System.out.printf ("%b\n",false);
		System.out.printf ("%b\n",false);
		System.out.printf ("%b\n","Prueba");
		System.out.printf ("%B\n",prueba);
		
		System.out.printf ("El codigo hash de \"hola\" es %h\n","hola");
		System.out.printf ("El codigo hash de \"Hola\" es %h\n","Hola");
		System.out.printf ("El codigo hash de null es %H\n",prueba);
		System.out.printf ("Impresion de un %% en una cadena de formato\n");
		System.out.printf ("Impresion de una nueva linea %nla siguiente linea empieza aqui");
		
	}
}
