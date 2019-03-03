package Unidad1P2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class Toggle extends JFrame implements ActionListener
{
	JButton b4,b5;
	JToggleButton tog1,tog2,tog3;
	
	int num;
	
	Color color;
	
	JFileChooser  fileC;
	
	
	public Toggle() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		fileC = new JFileChooser();
		fileC.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		color = Color.red;
		
		b4 = new JButton("Selecciona un color");
		b4.addActionListener(
				
					(a)-> 
					{
						color = getC();
						repaint();
					}
				
				);
		
		b5 = new JButton("Archivo");
		b5.addActionListener(
				
					(a)->{
						
						File res = getArch();
					}
				
				);
		
		JPanel arriba = new JPanel();
		{
			arriba.add(tog1 = new JToggleButton("Circulo",true));
			arriba.add(tog2 = new JToggleButton("Rectangulo"));
			arriba.add(tog3 = new JToggleButton("Rectangulo redondeado"));
			
			add(arriba,"North");
			
			arriba.add(b4);
			arriba.add(b5);
		
			tog1.addActionListener(this);
			tog2.addActionListener(this);
			tog3.addActionListener(this);
		
			ButtonGroup bt = new ButtonGroup();
			bt.add(tog1);
			bt.add(tog2);bt.add(tog3);
		}
		
		addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) 
			{
				if(e.isPopupTrigger())
//				if(e.getButton() == e.BUTTON3)
				{
					JPopupMenu pop = new JPopupMenu("Colores");
					
					JMenuItem it1 = new JMenuItem("Rojo");
					
					it1.addActionListener(
							
								(a) -> {
									color = Color.red;
									repaint();
								}
							
							);
					
					JMenuItem it2 = new JMenuItem("Azul");
					it2.addActionListener(
							
							(a) -> {
								color = Color.blue;
								repaint();
							}
							
							);
					
					JMenuItem it3 = new JMenuItem("Verde");
					it3.addActionListener(
							
							(a) -> {
								color = Color.green;
								repaint();
							}
							
							);
					
					
					
					pop.add(it1);
					pop.add(it2);
					pop.add(it3);
					
					pop.show(Toggle.this, e.getX(), e.getY());
				}
			}
		});
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	
	public File getArch()
	{
		int r = fileC.showOpenDialog(this);
		
		if(r == JFileChooser.APPROVE_OPTION)
				return fileC.getSelectedFile();
		
		return null;
	}
	
	public Color getC()
	{
		return JColorChooser.showDialog(this, "Selecciona un color", color);
	}
	
	@Override
	public void paint(Graphics g) 
	{	
		super.paint(g);
		

		if(tog1.isSelected())
		{
			g.setColor(color);
			g.fillOval(100, 100, 100, 100);
		}		
		
		if(tog2.isSelected()) 
		{
				g.setColor(color);
				g.fillOval(300, 100, 150, 100);
		}
		
		if(tog3.isSelected()) {
				g.setColor(color);
				g.fillRoundRect(200, 250, 150, 100, 45, 45);
		}
	}
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(
				
					()->
					{
						new Toggle().setVisible(true);
					}				
				);
	}
}
