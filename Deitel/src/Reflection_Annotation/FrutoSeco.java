package Reflection_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @Target: el objetivo de nuestra anotación, es decir dónde vamos a permitir que se coloque: 
 * variable, clase, método, constructor, etc. No todas las anotaciones sirven para anotar todas las 
 * cosas, algunas puede que varias, otras solo una. 
 * Esta anotación se le puede pasar una tipo de elemento (ElementType) o varios en un array
 *  (como por ejemplo si queremos que solo se pueda utilizar en variables globales y métodos 
 *  pondríamos: “@Target({ElementType.FIELD, ElementType.METHOD})”). El enumerado ElementType consta de:
	-ANNOTATION_TYPE: anotación.
	
	-CONSTRUCTOR: constructor.
	
	-FIELD: variable global (variable dentro de una clase, pero fuera de los métodos).
	
	-LOCAL_VARIABLE: variable local (variable dentro de un método).
	
	-METHOD: método.
	
	-PACKAGE: paquete (la primera línea de cualquier fichero “.java” aparece “package”).
	
	-PARAMETER: parámetro de un método.
	
	-TYPE_USE: tipos (los tipos de objetos, como: String, int, Object, MiObjeto, etc; e incluso
	 de declaración de arrays, es decir, delante de los corchetes “[]”)
	
	-TYPE_PARAMETER: parámetro de tipo (para los parámetros de los tipos genéricos; es decir, 
	para anotar los parámetros del siguiente ejemplo: “<parametroDeTipoA, parametroDeTipoB>” )
	
	-TYPE: cualquier elemento (sí, es un comodín para que funcione con todo: clases, método, variables, etc)

@Retention: Indica cómo se va a guardar la anotación usad. Tenemos que escoger entre un solo valor 
			enumerado de RetentionPolicy:
-SOURCE: La anotación se retiene solo a nivel de código fuente; es decir, se descarta la anotación
 			durante la compilación (no se escribirá en el bytecode de tu programa, por lo que no se podrá ejecutarse).

-CLASS: Se retiene la anotación por el compilador en tiempo de compilación, pero la Máquina Virtual de Java la ignora.

-RUNTIME: Se retiene por la Máquina Virtual de Java, por lo que puede ser utilizada en tiempo 
			de ejecución. Por lo que la anotación estará disponible en tiempo de ejecución mediante Reflection.

Entonces, si queremos que sea solo para variables globales “@Target(ElementType.FIELD)” 
		y que podamos leerla en tiempo de ejecución “@Retention(RetentionPolicy.RUNTIME)”. Obtendremos lo siguiente:
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FrutoSeco
{
	boolean tieneVitaminaE() default false;
	
	int calorias();
	
	String arbolQueDaEsteFruto() default "";
}
