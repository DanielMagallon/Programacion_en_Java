package Reflection_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @Target: el objetivo de nuestra anotaci�n, es decir d�nde vamos a permitir que se coloque: 
 * variable, clase, m�todo, constructor, etc. No todas las anotaciones sirven para anotar todas las 
 * cosas, algunas puede que varias, otras solo una. 
 * Esta anotaci�n se le puede pasar una tipo de elemento (ElementType) o varios en un array
 *  (como por ejemplo si queremos que solo se pueda utilizar en variables globales y m�todos 
 *  pondr�amos: �@Target({ElementType.FIELD, ElementType.METHOD})�). El enumerado ElementType consta de:
	-ANNOTATION_TYPE: anotaci�n.
	
	-CONSTRUCTOR: constructor.
	
	-FIELD: variable global (variable dentro de una clase, pero fuera de los m�todos).
	
	-LOCAL_VARIABLE: variable local (variable dentro de un m�todo).
	
	-METHOD: m�todo.
	
	-PACKAGE: paquete (la primera l�nea de cualquier fichero �.java� aparece �package�).
	
	-PARAMETER: par�metro de un m�todo.
	
	-TYPE_USE: tipos (los tipos de objetos, como: String, int, Object, MiObjeto, etc; e incluso
	 de declaraci�n de arrays, es decir, delante de los corchetes �[]�)
	
	-TYPE_PARAMETER: par�metro de tipo (para los par�metros de los tipos gen�ricos; es decir, 
	para anotar los par�metros del siguiente ejemplo: �<parametroDeTipoA, parametroDeTipoB>� )
	
	-TYPE: cualquier elemento (s�, es un comod�n para que funcione con todo: clases, m�todo, variables, etc)

@Retention: Indica c�mo se va a guardar la anotaci�n usad. Tenemos que escoger entre un solo valor 
			enumerado de RetentionPolicy:
-SOURCE: La anotaci�n se retiene solo a nivel de c�digo fuente; es decir, se descarta la anotaci�n
 			durante la compilaci�n (no se escribir� en el bytecode de tu programa, por lo que no se podr� ejecutarse).

-CLASS: Se retiene la anotaci�n por el compilador en tiempo de compilaci�n, pero la M�quina Virtual de Java la ignora.

-RUNTIME: Se retiene por la M�quina Virtual de Java, por lo que puede ser utilizada en tiempo 
			de ejecuci�n. Por lo que la anotaci�n estar� disponible en tiempo de ejecuci�n mediante Reflection.

Entonces, si queremos que sea solo para variables globales �@Target(ElementType.FIELD)� 
		y que podamos leerla en tiempo de ejecuci�n �@Retention(RetentionPolicy.RUNTIME)�. Obtendremos lo siguiente:
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FrutoSeco
{
	boolean tieneVitaminaE() default false;
	
	int calorias();
	
	String arbolQueDaEsteFruto() default "";
}
