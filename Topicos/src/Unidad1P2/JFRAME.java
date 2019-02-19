package Unidad1P2;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class JFRAME extends JFrame 
{
	private static final long serialVersionUID = 2482645071465852278L;
	
	public JFRAME() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(600, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Que onda prro");
		
		
		setVisible(true);
	}
	

	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		g.drawString("Hola", 50, 50);
	}
	
	public static void main(String[] args) 
	{
//		new JFRAME();
//		SwingUtilities.invokeLater(new Runnable() 
//		{
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				new JFRAME();
//			}
//		});
	}
}
