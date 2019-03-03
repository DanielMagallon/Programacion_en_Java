package C12GUI;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CheckBoxFrame extends JFrame
{
	private JTextField txt; 
	private JCheckBox bold;
	private JCheckBox italic;
	
	public CheckBoxFrame()
	{
		super( "JCheckBox Test" );
		setLayout( new FlowLayout() ); 
	    txt = new JTextField( "Watch the font style change", 20 );
	    txt.setFont(new Font( "Serif", Font.PLAIN, 14 ));
	    add( txt );
	    
	    bold = new JCheckBox("Bold");
	    italic = new JCheckBox("Italic");
		add( bold ); 
		add( italic); 
		
		CheckBoxHandler handler = new CheckBoxHandler();
		bold.addItemListener(handler);
		italic.addItemListener(handler);
		
	}
	
	private class CheckBoxHandler implements ItemListener
	{

		@Override
		public void itemStateChanged(ItemEvent arg0)
		{
			Font font=null;
			
			if(bold.isSelected() && italic.isSelected())
				font=new Font( "Serif", Font.BOLD + Font.ITALIC, 14 );
			
			else
			  if(bold.isSelected())
				  font = new Font( "Serif", Font.BOLD, 14 );
			
			else
			  if(italic.isSelected()) 
				  font = new Font( "Serif", Font.ITALIC, 14 );
			
			  else
				font = new Font( "Serif", Font.PLAIN, 14 );
				
			txt.setFont( font );
		}
		
	}
}