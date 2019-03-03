package C4InstruccionControl2;

/*	El especificador de formato %20s se uso para mostrar en pantalla el objeto String "Monto en deposito" 
 *	El entero 20 despues del % y el caracter de conversion 's' indican que el valor a imprimir debe 
 *	mostrarse con anchura de campo de 20; esto es, printf debe mostrar el valor con al menos 20 posiciones
 *	de caracteres.
 *
 * 	Si el valor a imprimir tiene una anchura menor a 20 posiciones de caracteres (en este ejemplo son 17) el valor
 * 	se 'justifica a la derecha' en el campo de manera prederteminada.
 * 
 * 	Para indicar que los valores deben imprimirse justificados a la izquierda , solo hay que anteponer a la anchura
 * 	del campo la bandera de formato negativo (-) (ejemplo: '%-20s').
 * 
 * 	
 * 	El año se imprime en una anchura de campo de 4 caracteres ('%4d').
 * 
 * 	El monto se imprime como un numero de punto flotante con el especificador de formato '%,20.2f'.
 * 	La bandera de formato coma (',') indica que el valor de punto flotante debe imprimirse con un
 * 	separador de agrupamineto. El separador que se utiliza realmente es especifico de la configuracion
 * 	regional del usuario, osea el pais. Por ejemplo en EE.UU. el numero se imprimira usando comas
 * 	para separar cada 3 digitos, y un punto decimal para la parte fraccionaria del numero, como en 1,234.45
 * 	El numero 20 en la especificacion del formato indica que el valor debe imprimirse justificado a la derecha , con una
 * 	anchura de campo de 20 caracteres.
 * 	El .2 especifica la precision del numero con formato; en este caso,el numero se redondea a la centesima 
 * 	mas cercana y se imprime con dos digitos a la derecha del punto decimal.
 */



public class Interes 
{
	public static void main(String[] args) 
	{
		double monto; // monto depositado al final de cada año
		double principal = 1000.0; // monto inicial antes del interes
		double tasa = 0.05; // tasa de interes
		
		// muestra los encabezados
		 System.out.printf ("%s%20s\n", "Anio", "Monto en deposito");
		 
		 // calcula el monto en deposito para cada uno de los diez años
		 
		 for (int anio = 1; anio <= 10; anio++)
		 {
			 // calcula el nuevo monto para el año especificado 
			 	monto = principal * Math.pow( 1.0 + tasa,anio );
			 	
			 // muestra el año y el monto
			 	System.out.printf ("%4d%,20.2f\n",anio,monto);
		 }
	}
}
