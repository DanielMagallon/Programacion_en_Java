package C12GUI;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxFrame extends JFrame
{
	private JComboBox imagesCB;
	private JLabel label;
	
	private static final String[] names=
		{"business133.png","camera3.png","commands.png","notepad22.png"};
	
	private Icon icons[] = 
		{new ImageIcon(getClass().getResource(names[0])),
		 new ImageIcon(getClass().getResource(names[1])),
		 new ImageIcon(getClass().getResource(names[2])),
		 new ImageIcon(getClass().getResource(names[3]))};
	
	public ComboBoxFrame()
	{
		super("Testing JComboBox");
		setLayout(new FlowLayout());
		
		imagesCB=new JComboBox(names);
		imagesCB.setMaximumRowCount(3);
		
		imagesCB.addItemListener(new ItemListener()
		{
			
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				if (e.getStateChange()==ItemEvent.SELECTED)
					label.setIcon(icons[imagesCB.getSelectedIndex()]);
			}
		});
		
		add(imagesCB);
		label=new JLabel(icons[0]);
		add(label);
	}
}
