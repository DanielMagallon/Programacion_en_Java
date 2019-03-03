package C12GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TextFieldName extends JFrame
{
	private JTextField t1,t2,t3;
	private JPasswordField pass;
	
	public TextFieldName()
	{
		super("Testing JTextField and JPasswordField");
		setLayout(new FlowLayout());
		
		//Constructor field with 10 columns
		t1=new JTextField(10);
		add(t1);
		
		t2=new JTextField("Enter text here");
		add(t2);
		
		t3=new JTextField("Uneditable text field", 21 );
		t3.setEditable( false );
		add(t3);
		
		pass=new JPasswordField("Hidden Text");
		add(pass);
		
		TextFieldHandler handler = new TextFieldHandler();
		t1.addActionListener(handler);
		t2.addActionListener(handler);
		t3.addActionListener(handler);
		pass.addActionListener(handler);
	}
	
	private class TextFieldHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String s="";
			
			if(e.getSource() == t1)
				s=String.format("textField1: %s",e.getActionCommand());
			
			else
			 if(e.getSource() == t2)
				s=String.format("textField2: %s",e.getActionCommand());
			
			 else
			  if(e.getSource() == t3)
					s=String.format("textField3: %s",e.getActionCommand());
			
			  else
				if(e.getSource() == pass)
					s=String.format("passwordField: %s",e.getActionCommand());
			
			JOptionPane.showMessageDialog(null, s);
			
		}
	}
}
