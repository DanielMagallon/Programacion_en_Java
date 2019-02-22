package Hilos;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class InterfazHilo extends JFrame 
{
	private static final long serialVersionUID = -1065512281664707123L;

	JButton btnPlay;
	boolean pinta;
	
	public InterfazHilo() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLocationRelativeTo(null);
		
		
		btnPlay = new JButton("Play");
		JPanel up = new JPanel();
		
		btnPlay.addActionListener(
				
				(e) -> 
				{
					pinta = true;
					repaint();
				}
				
				);
		
		add(up,"North");
		up.add(btnPlay);
		
	}
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		if(pinta)
		{
			
			int x=10;
			
			for(int i=0; i<=getWidth()/60; i++)
			{
				System.out.println("i: "+i);
				g.fillRect(x, 150, 50, 50);
				x+=60;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			@Override
			public void run() 
			{
				new InterfazHilo().setVisible(true);
			}
		});
	}
}
