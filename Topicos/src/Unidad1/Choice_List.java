package Unidad1;

import java.applet.Applet;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JColorChooser;

public class Choice_List extends Applet 
{
	Choice  choice;
	List lista;
	
	@Override
	public void init() 
	{
		setSize(800,600);
		choice = new Choice();
		choice.add("<====OS>=====>");
		choice.add("Windows");
		choice.add("Linux Fedora");
		choice.add("Mac Os");
		choice.add("Chrome Os");
		choice.add("Solaris");

		choice.setFont(font);
		lista = new List(5);
//		lista.setEnabled(false);
		
		lista.add("<====Browers====>");
		lista.add("Chrome");
		lista.add("Opera");
		lista.add("Safari");
		lista.add("Mozilla Firefox");
		lista.add("Edge");
		
		add(choice);
		add(lista);
		
		choice.select(1);
		lista.select(5);
		
		choice.addItemListener(new ItemListener() 
		{
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				
				switch(choice.getSelectedIndex())
				{
					case 1:
						lista.select(5);
						break;
						
					case 2:
						lista.select(4);
						break;
					
					case 3:
						lista.select(3);
						break;
					
					case 4:
						lista.select(1);
						break;
					
					case 5:
						lista.select(2);
						break;
						
					default:
						return;
						
				}
				repaint();
				
			}
		});
		
		lista.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				switch(lista.getSelectedIndex())
				{
					case 1:
						choice.select(4);
						break;
						
					case 2:
						choice.select(5);
						break;
					
					case 3:
						choice.select(3);
						break;
					
					case 4:
						choice.select(2);
						break;
					
					case 5:
						choice.select(1);
						break;
						
					default:
						return;
						
				}
				repaint();
				
			}
		});
	}
	Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 18);
	String resp;
	
	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		
		super.paint(arg0);
		
		resp = "Al Sistema Operativo "+choice.getSelectedItem()+" le corresponde "
				+lista.getSelectedItem();
		
		arg0.setFont(font);
		arg0.drawString(resp, 100, 300);
	}
}	

