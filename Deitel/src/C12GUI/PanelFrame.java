package C12GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelFrame extends JFrame 
{
	private JPanel panel;
	private JButton[] buttons;
	
	public PanelFrame()
	{	
		super("Panel Demo");
		buttons=new JButton[5];
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, buttons.length));
		
		for(int i=0; i<buttons.length; i++)
		{
			buttons[i] = new JButton("Button " + (i+1));
			panel.add(buttons[i]);
		}
		
		add(panel,BorderLayout.SOUTH);
		
	}
}
