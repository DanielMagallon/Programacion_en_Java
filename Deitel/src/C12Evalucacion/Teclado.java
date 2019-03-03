package C12Evalucacion;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Teclado extends JFrame
{
	String keyBoard[] = {"°|¬","1","2","3","4","5","6","7","8","9","0","?","¿","<----","incio",
						   "|<-- -->|","Q","W","E","R","T","Y","U","I","O","P","¨","*","Enter",
						   "bloq mayus","A","S","D","F","G","H","J","K","L","{","}"};
	
	JButton botones[];
	
	public Teclado()
	{
		botones = new JButton[keyBoard.length];
		setLayout(new GridLayout(4,15,7,7));
		
		for (int i=0; i<botones.length; i++)
		{
				botones[i]=new JButton(keyBoard[i]);
				add(botones[i]);
		}
	}
}
