package C2IntroduccionApp2;

// Programa que muestra la suma de dos numeros enrteros, usando los graficos de GUI.
// Para convertir a double se usa: Double.parseDouble.

import java.util.Scanner;

import javax.swing.JOptionPane; 

public class Dialogo_Suma 
	{

		public static void main(String[] args) 
			{
			
			String n1 =JOptionPane.showInputDialog("Introduce el primer numero");
			int num1=Integer.parseInt(n1);
			String n2 =JOptionPane.showInputDialog("Introduce el segundo numero");
			int num2=Integer.parseInt(n2);
			int res=num1+num2;
			String mensaje = String.format("La suma de %d + %d = %d " ,num1,num2,res);
			JOptionPane.showMessageDialog(null,mensaje);
			}
	
	}
