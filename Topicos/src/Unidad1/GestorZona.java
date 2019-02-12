package Unidad1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class GestorZona extends Applet implements ActionListener
{

	ActionListener actList[] = 
		{
			
			(e) -> 	JOptionPane.showMessageDialog(GestorZona.this, "Apreto el centro"),
					
			(e) -> JOptionPane.showMessageDialog(GestorZona.this, "Apreto el este"),
			
			new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(GestorZona.this, "Apreto el oeste");
					
				}
			},
			
			new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(GestorZona.this, "Apreto el sur");
					
				}
			},
		};
	
	String position[] = {BorderLayout.CENTER,BorderLayout.EAST,BorderLayout.WEST,BorderLayout.SOUTH
			,BorderLayout.NORTH};
	
	Button btns[] = new Button[6];
	
	Panel panel = new Panel();
	
	Color cols[] = {Color.white,Color.gray,Color.cyan,Color.pink,Color.blue};
	
	@Override
	public void init() 
	{
		setLayout(new BorderLayout());
		
		for(int i=0; i<btns.length-2; i++)
		{
			btns[i] = new Button(position[i]);
			btns[i].setBackground(cols[i]);
			btns[i].addActionListener(actList[i]);
			add(btns[i],position[i]);
		}
		
		
		add(panel,BorderLayout.NORTH);
		
		panel.add(btns[4] = new Button("Norte1"));
		panel.add(btns[5] = new Button("Norte2"));
		btns[4].addActionListener(this);
		//btns[5].addActionListener(this);
		btns[5].addMouseListener(new Click());
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Norte1"))
		{
			JOptionPane.showMessageDialog(this, "Apreto el norte1");
		}
		else if(e.getSource() == btns[5])
		{
			JOptionPane.showMessageDialog(this, "Apreto el norte2");
		}
	}
	
	class Click extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getClickCount());
		}
	}
}
