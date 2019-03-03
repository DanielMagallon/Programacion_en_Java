package C12Evalucacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ColorSelect extends JFrame
{
	private JComboBox combo;
	
	private final static String colors[]=
		{"RED","BLUE","GREEN","GRAY",
		 "BLACK","MAGENTA","DARK GRAY","CYAN"};
	
	private Color[] colores=
		{Color.RED, Color.BLUE, Color.GREEN, Color.GRAY,
		 Color.BLACK, Color.MAGENTA, Color.DARK_GRAY, Color.CYAN}; 
	
	private JPanel panel;
	private JTextArea texto;
	private JButton btnYes,btnCancel;
	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private FlowLayout layout;
	
	public ColorSelect()
	{
		super("Color Select Demo");
		layout=new FlowLayout();
		
		combo=new JComboBox (colors);
		combo.setMaximumRowCount(3);
		
		btnYes=new JButton("Ok");
		btnCancel=new JButton("Cancel");
		
		panel=new JPanel();
		panel.setLayout(layout);
		
		checkBox1=new JCheckBox("Background");
		checkBox2=new JCheckBox("Foreground");
		
		panel.add(checkBox1);
		panel.add(checkBox2);
		
		panel.add(btnYes);
		panel.add(btnCancel);

		String demo="This is a demo string to\n"
				+ "illustrate color text\nfrom combo and \n"
				+ "checkBox";
		
		texto=new JTextArea(demo,5,10);
		panel.add(texto);
		
		setTextColor();
		
		add(combo,BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
	}
	
	private void setTextColor()
	{
		btnYes.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int indice=combo.getSelectedIndex();
				
				if (checkBox1.isSelected())
				texto.setBackground(colores[indice]);
				
				if (checkBox2.isSelected())
					texto.setForeground(colores[indice]);
			}
		});
	}
}
