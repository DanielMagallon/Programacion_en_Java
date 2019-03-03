package C12GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame
{
	private JButton plain;
	private JButton fancy;
	
	public ButtonFrame()
	{
		super ("Testing Buttons");
		setLayout(new FlowLayout());
		
		plain = new JButton("Plain Button");
		add(plain);
		
		Icon bug1 = new ImageIcon(getClass().getResource("camera3.png"));
		Icon bug2 = new ImageIcon(getClass().getResource("business133.png"));
		
		fancy = new JButton("Fancy Button",bug1);
		fancy.setRolloverIcon(bug2);
		add(fancy);
		
		ButtonHandler handler = new ButtonHandler();
		fancy.addActionListener( handler );
		plain.addActionListener( handler );
		
	}
	
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(ButtonFrame.this, 
					String.format("You presed %s",e.getActionCommand()));
		}
		
	}
}
