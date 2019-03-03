package C11ATM;

import java.util.Scanner;

// Keypad: Teclado

public class KeyPad
{
	private Scanner input;
	
	KeyPad()
	{
		input=new Scanner(System.in);
	}
	
	int getInput()
	{
		return input.nextInt();
	}
}
