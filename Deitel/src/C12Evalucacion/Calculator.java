package C12Evalucacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame
{
	private JButton[] buttons;
	private static final String caract []=
		{"7\nd","8","9","/",
		 "4","5","6","*",
		 "1","2","3","-",
		 "0",".","=","+"};
	private JTextField txt;
	private JPanel panel;
	private GridLayout gridL1;
	
	public Calculator()
	{
		super("Calculator Demo");
		gridL1 = new GridLayout(4,4,5,5);
		
		panel=new JPanel();
		panel.setLayout(gridL1);
		
		txt=new JTextField();
		buttons=new JButton[caract.length];
		
		for (int i=0; i<caract.length; i++)
		{
			buttons[i]=new JButton(caract[i]);
			panel.add(buttons[i]);
		}
	
		add(txt,BorderLayout.NORTH);
		
		add(panel,BorderLayout.CENTER);
	}
}
