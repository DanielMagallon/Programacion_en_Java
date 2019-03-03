package C12GUI;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RadioButtonFrame extends JFrame
{
	private JTextField txt;
	private Font plain,bold,italic,boldItalic;
	private JRadioButton plainR,boldR,italicR,boldItalicR;
	private ButtonGroup radioGroup;
	
	public RadioButtonFrame()
	{
		super("RadioButton Test");
		setLayout(new FlowLayout());
		
		txt=new JTextField("Watch the font style change", 25);
		add(txt);
		
		plainR=new JRadioButton("Plain",true);
		boldR=new JRadioButton("Bold",false);
		italicR=new JRadioButton("Italic",false);
		boldItalicR=new JRadioButton("Bold/Italic",false);
		add(plainR);
		add(boldR);
		add(italicR);
		add(boldItalicR);
		
		radioGroup = new ButtonGroup();
		radioGroup.add(plainR);
		radioGroup.add(boldR);
		radioGroup.add(italicR);
		radioGroup.add(boldItalicR);
		
		plain = new Font( "Serif", Font.PLAIN, 14 );
		bold = new Font( "Serif", Font.BOLD, 14 );
		italic = new Font( "Serif", Font.ITALIC, 14 );
		boldItalic = new Font( "Serif", Font.BOLD + Font.ITALIC, 14 );
		txt.setFont( plain );
		
		plainR.addItemListener(new RadioButtonHandler(plain));
		boldR.addItemListener(new RadioButtonHandler(bold));
		italicR.addItemListener(new RadioButtonHandler(italic));
		boldItalicR.addItemListener(new RadioButtonHandler(boldItalic));
	}
	
	private class RadioButtonHandler implements ItemListener
	{
		private Font font;
		
		public RadioButtonHandler(Font f)
		{
			font=f;
		}

		@Override
		public void itemStateChanged(ItemEvent arg0)
		{
			txt.setFont(font);
		}
	}
}
