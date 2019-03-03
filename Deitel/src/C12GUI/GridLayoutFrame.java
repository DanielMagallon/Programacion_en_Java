package C12GUI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutFrame extends JFrame implements ActionListener
{
	private JButton buttons[];
	private static final String[] names =
		{"one","two","three","four","five","six"};
	private boolean toggle=true;
	private Container container;
	private GridLayout gridL1;
	private GridLayout gridL2;
	
	public GridLayoutFrame()
	{
		super("GridLayout Demo");
		
		gridL1 = new GridLayout(2,3,5,5);
		gridL2 = new GridLayout(3,2);
		container=getContentPane();
		setLayout(gridL1);
		buttons=new JButton[names.length];
		
		for (int i=0; i<names.length; i++)
		{
			buttons[i] = new JButton(names[i]);
			buttons[i].addActionListener(this);
			add(buttons[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(toggle)
			container.setLayout(gridL2);
		else
			container.setLayout(gridL1);
		
		toggle = !toggle;
		container.validate();
	}
}

