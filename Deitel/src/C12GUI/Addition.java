package C12GUI;

import javax.swing.JOptionPane;

public class Addition
{
	public static void main(String[] args)
	{
		String firstNumber = 
				JOptionPane.showInputDialog("Enter the fist integer");
		
		String secondNumber = 
				JOptionPane.showInputDialog("Enter the second integer");
		
		int n1 = Integer.parseInt(firstNumber);
		int n2 = Integer.parseInt(secondNumber);
		
		JOptionPane.showMessageDialog(null, "The sum is " + (n1+n2),
				"Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
	}
}
