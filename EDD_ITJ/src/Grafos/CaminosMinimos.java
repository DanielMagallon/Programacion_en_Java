package Grafos;

public class CaminosMinimos
{
	// Metodo para determinar todos los caminos Floyd
	public String algoritmoFloyd(long[][] mAdy)
	{
		int vertices = mAdy.length;
		long matrizAdyacencia[][] = mAdy;
		String caminos[][] = new String[vertices][vertices];
		String caminosAuxiliares[][] = new String[vertices][vertices];
		String caminoRecorrido = "";
		String cadena = "";
		String caminitos = "";
		int i, j, k;
		float temp1, temp2, temp3, temp4, minimo;

		// Inicalizando las matrices, caminos-auxiliares
		for (i = 0; i < vertices; i++)
		{
			for (j = 0; j < vertices; j++)
			{
				caminos[i][j] = "";
				caminosAuxiliares[i][j] = "";
			}
		}

		for (k = 0; k < vertices; k++)
		{
			for (i = 0; i < vertices; i++)
			{
				for (j = 0; j < vertices; j++)
				{
					temp1 = matrizAdyacencia[i][j];
					temp2 = matrizAdyacencia[i][k];
					temp3 = matrizAdyacencia[k][j];
					temp4 = temp2 + temp3;

					// Encontrando el minimo
					minimo = Math.min(temp1, temp4);
					if (temp1 != temp4)
					{
						if (minimo == temp4)
						{
							caminoRecorrido = "";
							caminosAuxiliares[i][j] = k + "";
							caminos[i][j] = caminosR(i, k, caminosAuxiliares, caminoRecorrido) + (k + 1);
						}
					}
					matrizAdyacencia[i][j] = (long) minimo;
				}
			}
		}

		// Agregando el camino minimo a Cadena
		for (i = 0; i < vertices; i++)
		{
			for (j = 0; j < vertices; j++)
			{
				cadena = cadena + "[" + matrizAdyacencia[i][j] + "]";
			}
			cadena += "\n";
		}

		//////////////////////////////////////////
		for (i = 0; i < vertices; i++)
		{
			for (j = 0; j < vertices; j++)
			{
				if (matrizAdyacencia[i][j] != 1000000000)
				{
					if (i != j)
					{
						if (caminos[i][j].equals(""))
						{
							caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") Irse Por...(" + (i + 1) + ", "
									+ (j + 1) + ")\n";
						} else
						{
							caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") Irse Por...(" + (i + 1) + ", "
									+ caminos[i][j] + ", " + (j + 1) + ")\n";
						}
					}
				}
			}
		}
		return "La Matriz de Caminos Mas Cortos Entre Los Diferentes Vertices es:\n"+cadena+
				"\nLos Diferentes Caminos Mas Cortos Entre Vertices son:\n"+caminitos;
	}
	
	static int cont;
	
	public String caminosR(int i, int k, String[][] caminosAux, String caminoRecorrido)
	{
		System.out.println("entre por "+(++cont)+" vez");
		
		if(caminosAux[i][k].equals(""))
		{
			return "";
		}
		else
		{
			//Recursividad al millon
			caminoRecorrido += 
			caminosR
			(i, Integer.parseInt(caminosAux[i][k]), 
			caminosAux, caminoRecorrido)+
			(Integer.parseInt(caminosAux[i][k].toString())+1)
			+", ";
			return caminoRecorrido;
		}
			
	}
}
