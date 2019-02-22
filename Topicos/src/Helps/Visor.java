package Helps;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Visor extends JFrame 
{
	JButton next,before;
	int x  = 200, y = 200,inc;
	boolean avanzar;
	int x2;
	
	Image img1 = new ImageIcon(getClass().getResource("/Unidad1P2/mexico.png")).getImage();
	Image img2 = new ImageIcon(getClass().getResource("/Unidad1P2/canada.png")).getImage();
	
	Timer timer = new Timer(20, 
			
			 (a)-> 
			{
				 x+=inc;
				 
				 if(x2>=getWidth()/2)
				 {
					 x2+=inc;
				 }
				 repaint();
				 
				 if(x+img1.getWidth(this)<=0)
					 parar();
			 }
			
			);
	
	void parar()
	{
		timer.stop();
	}
	
	public Visor() 
	{
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		x2 = getWidth(); 
		setLocationRelativeTo(null);
		
		next = new JButton("->");
		before = new JButton("<-");
		
		JPanel p = new JPanel();
		
		add(p,"South");
		p.add(before);
		p.add(next);
		
		next.addActionListener(
				
				
					(a)-> {
						inc = -100;
						avanzar = true;
						timer.start();
					}
				
				);
		
		before.addActionListener(
				
				(a)->{
					
				}
				
				);
	}
	
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		
		g.drawImage(img1, x, y, this);
		
		if(avanzar)
		{
			g.drawImage(img2, x2, y, this);
		}
	}
	
	public static void main(String[] args) {
		new Visor().setVisible(true);
	}
	
}
