package C6Evaluacion;

import java.util.Scanner;
import java.util.Random;

public class OchoReinasAyuda

{        // Abre clase Ocho_Reinas
Scanner entrada = new Scanner(System.in);
Random aleatorio = new Random();
private int Tamano;
// Cambiar la variable Tamano para resolver el problema de las
// n reinas
private int Fracasos_Requeridos = 1000;
// Cambiar tambien esta variable ajustandola segun un buen criterio
// para un Tamano grande
private int dado1;
private int dado2;
private int contador_reinas = 0;

///////////////////////////////////////////////////////////
// Metodo Principal
///////////////////////////////////////////////////////////

public void Principal()
{    // Abre metodo Principal
int accesibilidad;

System.out.println("\nEste programa resuelve el problema de las ocho reinas.");
System.out.print("\nPor favor introduzca el numero de casillas del tablero.\n");
Tamano = entrada.nextInt();
int fracasos = 0;
int A[][] = new int[Tamano + 1][Tamano + 1];

while ( Tamano > contador_reinas && fracasos < Fracasos_Requeridos)
{
Genera_Casilla(); 
accesibilidad =  Verifica_Posicion(A);
if ( 0 == accesibilidad )
fracasos++;
else
A[dado1][dado2] = ++contador_reinas;
}

if ( Tamano != contador_reinas)
System.out.printf("\nLo siento. Solo se colocaron %d reinas\n", contador_reinas);
else
System.out.printf("\nSE COLOCARON LAS %d REINAS!\n", Tamano);

// Se invoca al metodo Imprime
Imprime(A);

}    // Cierra metodo Principal

///////////////////////////////////////////////////////////////
// Metodo Genera_Casilla
///////////////////////////////////////////////////////////////

public void Genera_Casilla()
{         // Abre metodo Genera_Casilla
dado1 = aleatorio.nextInt(Tamano) + 1;
dado2 = aleatorio.nextInt(Tamano) + 1;
}        // Cierra metodo Genera_Casilla

////////////////////////////////////////////////////////////
// Metodo Verifica_Posicion
////////////////////////////////////////////////////////////  

public int Verifica_Posicion(int B[][] )
{         // Abre metodo Verifica_Posicion
int estatus = 1;
// Al principio se supone que la casilla es valida
// y se descartara en el siguiente if si no cumple
// con ciertas condiciones

if ( 0 == B[dado1][dado2] )
// Si la casilla generada esta vacia
{          // Abre if  
for ( int i = 1; i <= Tamano; i++ )
for ( int j = 1; j <= Tamano; j++ )
{  // Abre for
// Si la casilla tiene una reina
if ( 0 != B[i][j] )
{       // Abre if
// Si la reina ataca la misma fila o columna
if ((( dado1 == i) || (dado2 == j ))  || (Math.abs(dado1 - i) == Math.abs(dado2 - j )) )
// Retorna Negativo
{
estatus = 0;
break;
}
}       // Cierra if 
}   // Cierra for  

}       // Cierra if
else
// Si la casilla generada no esta vacia, evidentemente
// no es viable
estatus = 0;

return estatus;
// Se retorna el estatus de la casilla
// 1: valida, 0: invalida
}         // Cierra metodo Verifica_Posicion

/////////////////////////////////////////////////////////////
// Metodo Imprime
/////////////////////////////////////////////////////////////

public void Imprime(int C[][])
{      // Abre Imprime

for ( int k = 1; k <= Tamano; k++ )
{
for ( int j = 1; j <= Tamano; j++)
{
System.out.printf("%5d", C[k][j]);
} 
System.out.println("\n");
}
}     // Cierra imprime
public static void main(String[] args)
{
	OchoReinasAyuda oc = new OchoReinasAyuda();
	
	oc.Principal();
}
} // Ci
