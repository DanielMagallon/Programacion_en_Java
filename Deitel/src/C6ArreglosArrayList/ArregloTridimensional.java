package C6ArreglosArrayList;

import java.io.*;

public class ArregloTridimensional
{

	public static void main(String[] args) throws IOException {
	BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));


	System.out.println("introduzca el numero de columnas");
	int col=Integer.parseInt(leer.readLine());
	System.out.println("introduzca el numero de filas");
	int fil=Integer.parseInt(leer.readLine());
	System.out.println("introduzca el numero de la tercera dimension:");
	int prof=Integer.parseInt(leer.readLine());
	int matriz[][][]=new int[fil][col][prof];
	//recorrido con tres for
	for(int i=0; i<fil;i++){
	for(int j=0;j<col;j++){
	for(int z=0;z<prof;z++){
	System.out.println ("Introduzca el valor de matriz en la posicion:"+i +j +z);
	matriz[i][j][z]=Integer.parseInt(leer.readLine());

	}

	}
	}



	for(int i=0; i<fil;i++){
	for(int j=0;j<col;j++){
	for(int z=0;z<prof;z++){
	System.out.println("la matriz esta compuesta por:"+matriz[i][j][z]);

	}

	}
	}

	}

	} 

