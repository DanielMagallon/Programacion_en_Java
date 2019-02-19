package Exe;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import DiseñoAjedrez.TableroAjedrez;

public class Ejecutable extends JFrame 
{
	private static final long serialVersionUID = 5092170439846255586L;
	
	private TableroAjedrez taj = new TableroAjedrez();
	private JMenuBar menuBar;
	private JMenu menuJuego;
	
	public Ejecutable() 
	{
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		
//		menuBar = new JMenuBar();
//		menuBar.add(menuJuego = new JMenu("Juego"));
//		
//		setJMenuBar(menuBar);
		
		add(taj,"Center");
	}
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() 
			{
				new Ejecutable().setVisible(true);
			}
		});
	}
}
