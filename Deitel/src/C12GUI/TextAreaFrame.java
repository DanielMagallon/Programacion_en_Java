package C12GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextAreaFrame extends JFrame
{
	private JTextArea txt1,txt2;
	private JButton copyB;
	
	public TextAreaFrame()
	{	
		super("Text Area Demo");
		Box box = Box.createHorizontalBox();
		String demo="This is a demo string to\n"
				+ "illustrate copying text\nfrom one textarea to \n"
				+ "another textarea using an\nexternal event\n";
		
		txt1=new JTextArea(demo,10,15);
		box.add(new JScrollPane(txt1));
		
		copyB=new JButton("Copy >>>");
		box.add(copyB);
		copyB.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				txt2.setText(txt1.getSelectedText());
			}
		});
		
		txt2 = new JTextArea(10,15);
		txt2.setEditable(false);
		box.add(new JScrollPane(txt2));
		
		add(box);
	}
}
