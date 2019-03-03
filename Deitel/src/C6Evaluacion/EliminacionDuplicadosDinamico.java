package C6Evaluacion;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class EliminacionDuplicadosDinamico
{
	public static void main(String[] args)
	{
		Scanner lc = new Scanner(System.in);
		
		ArrayList<Integer> numeros = new ArrayList<>();
		int opcion;
		int cont=0;
		
		do
		{
			do
			{
			numeros.add(Integer.parseInt
                    (JOptionPane.showInputDialog(null, 
                     (cont+1)+". Introduce un entero: ")));
			
			}while(yaSeIntrodujo(numeros,cont));

            opcion=JOptionPane.showConfirmDialog(null, "Introducir mas numeros?",
                    "Mesnaje", JOptionPane.YES_NO_OPTION);
            
            cont++;
		}
		while(opcion==0);
		
		for(Integer n : numeros)
			System.out.printf ("%d ",n);
		
	}
	
	public static boolean yaSeIntrodujo(ArrayList<Integer> n,int cont)
	{
		boolean equal=false;
		
		for (int j=0; j<n.size()-1; j++)
		{
			if (n.get(j)==n.get(n.size()-1))
			{
				equal=true;
				JOptionPane.showMessageDialog(null, 
						"Ya se ha introducido ese numero",
						"Numero Repetido",
						JOptionPane.WARNING_MESSAGE);
				n.remove(cont);
				break;
			}
		}
	
		return equal;
	}
}
